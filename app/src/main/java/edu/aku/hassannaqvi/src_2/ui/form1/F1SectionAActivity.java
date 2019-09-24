package edu.aku.hassannaqvi.src_2.ui.form1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract;
import edu.aku.hassannaqvi.src_2.contracts.UCsContract;
import edu.aku.hassannaqvi.src_2.contracts.VillagesContract;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF1SectionABinding;
import edu.aku.hassannaqvi.src_2.util.Util;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

import static edu.aku.hassannaqvi.src_2.core.MainApp.fc;

public class F1SectionAActivity extends AppCompatActivity {


    ActivityF1SectionABinding bi;
    Collection<UCsContract> ucsList;
    ArrayList<String> ucsName;
    HashMap<String, String> ucsMap;

    Collection<VillagesContract> villagesList;
    ArrayList<String> villagesNames;
    HashMap<String, String> villagesMap;

    int length = 0;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_a);
        bi.setCallback(this);
        setTitle(R.string.f1aHeading);

        setupViews();
    }

    private void setupViews() {

        db = new DatabaseHelper(this);

        ucsList = db.getUCsList();
        ucsName = new ArrayList<>();
        ucsMap = new HashMap<>();
        ucsName.add("-Select UCs -");
//        ucsName.add("Test UC");
//        ucsMap.put("Test UC ", "1");

        for (UCsContract dc : ucsList) {
            ucsName.add(dc.getUcsName());
            ucsMap.put(dc.getUcsName(), dc.getUccode());
        }

        bi.f1a01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ucsName));

        bi.f1a01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (bi.f1a01.getSelectedItemPosition() != 0) {

//                    districtCode = ucsMap.get(bi.districtSpinner.getSelectedItem().toString());
                    villagesList = db.getVillages(ucsMap.get(bi.f1a01.getSelectedItem().toString()));
                    villagesMap = new HashMap<>();
                    villagesNames = new ArrayList<>();
                    villagesNames.add("Select Village Name-");

                    for (VillagesContract hf : villagesList) {
                        villagesNames.add(hf.getVillageName());
                        villagesMap.put(hf.getVillageName(), hf.getVillageCode());
                    }

                    bi.f1a02.setAdapter(new ArrayAdapter<>(F1SectionAActivity.this, android.R.layout.simple_spinner_dropdown_item, villagesNames));

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.f1a04.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                length = s.toString().length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!bi.f1a04.getText().toString().isEmpty() && bi.f1a04.getText().toString().length() == 3) {
                    if (bi.f1a04.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 5) {
                            bi.f1a04.setText(bi.f1a04.getText().toString() + "-");
                            bi.f1a04.setSelection(bi.f1a04.getText().length());
                            bi.f1a04.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);

                        }

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), F1SectionBActivity.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean UpdateDB() {

        Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);
        rowId = db.addForm(fc);
        if (rowId > 0) {
            fc.set_ID(String.valueOf(rowId));
            fc.setUID((fc.getDeviceID() + fc.get_ID()));
            db.updateFormID(fc);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;

        }
    }

    private void SaveDraft() throws JSONException {

        fc = new FormsContract();
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        fc.setTagID(sharedPref.getString("tagName", null));
        fc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        fc.setDeviceID(MainApp.deviceId);
        fc.setUser(MainApp.userName);
        fc.setUc(ucsMap.get(bi.f1a01.getSelectedItem().toString()));
        fc.setVillage(villagesMap.get(bi.f1a02.getSelectedItem().toString()));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setHhNo(bi.f1a04.getText().toString());
        JSONObject f1 = new JSONObject();
        f1.put("f1a05", bi.f1a05a.isChecked() ? "1"
                : bi.f1a05b.isChecked() ? "2"
                : bi.f1a05c.isChecked() ? "3"
                : bi.f1a05d.isChecked() ? "4"
                : bi.f1a05e.isChecked() ? "5"
                : bi.f1a05f.isChecked() ? "6"
                : bi.f1a0596.isChecked() ? "96"
                : "0");
        f1.put("f1a0596x", bi.f1a0596x.getText().toString());
        Util.setGPS(this);

        fc.setF1(String.valueOf(f1));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSectionF1A);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }


}
