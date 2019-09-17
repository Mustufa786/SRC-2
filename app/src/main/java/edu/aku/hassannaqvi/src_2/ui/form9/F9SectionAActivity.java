package edu.aku.hassannaqvi.src_2.ui.form9;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF9SectionABinding;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F9SectionAActivity extends AppCompatActivity {

    ActivityF9SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f9_section_a);
        bi.setCallback(this);

        setTitle(R.string.f9aHeading);

        setupViews();
    }

    private void setupViews() {

        bi.f9a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f9a01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp2345, null);
                }
            }
        });

        bi.f9a03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.f9a03e.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf9a04, null);
                } else {
                    ClearClass.ClearAllFields(bi.fldGrpf9a05, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), F9SectionBActivity.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        // 2. UPDATE FORM ROWID
        int updcount = db.updatesF9();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {


        JSONObject f1 = new JSONObject();
        f1.put("f9a01",bi.f9a01a.isChecked() ?"1" :bi.f9a01b.isChecked() ?"2" :"0");
        f1.put("f9a02", bi.f9a02.getText().toString());

        f1.put("f9a03", bi.f9a03a.isChecked() ? "1" : bi.f9a03b.isChecked() ? "2" : bi.f9a03c.isChecked() ? "3"
                : bi.f9a03d.isChecked() ? "4" : bi.f9a03e.isChecked() ? "96" : "0");
        f1.put("f9a04", bi.f9a04a.isChecked() ? "1" : bi.f9a04b.isChecked() ? "2" : bi.f9a04c.isChecked() ? "3"
                : bi.f9a04d.isChecked() ? "4" : bi.f9a04e.isChecked() ? "5" : bi.f9a04f.isChecked() ? "6" : bi.f9a04g.isChecked() ? "7" : bi.f9a0496.isChecked() ? "96" : "0");
        f1.put("f9a0496x", bi.f9a0496x.getText().toString());
        f1.put("f9a05a",bi.f9a05a.isChecked() ?"1" :"0");
        f1.put("f9a05b",bi.f9a05b.isChecked() ?"2" :"0");
        f1.put("f9a05c",bi.f9a05c.isChecked() ?"3" :"0");
        f1.put("f9a0596",bi.f9a0596.isChecked() ?"96" :"0");
        f1.put("f9a0596x", bi.f9a0596x.getText().toString());

        MainApp.fc.setF9(String.valueOf(f1));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF9A);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
