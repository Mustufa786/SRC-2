package edu.aku.hassannaqvi.src_2.ui.form6;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF6SectionABinding;
import edu.aku.hassannaqvi.src_2.ui.form7.F7SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F6SectionAActivity extends AppCompatActivity {

    ActivityF6SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f6_section_a);
        bi.setCallback(this);

        setTitle(R.string.f6h1);

        setupViews();
    }

    private void setupViews() {
        bi.f6a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a01.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp0203, null);
                }
            }
        });

        bi.f6a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a02b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a03, null);
                }
            }
        });

        bi.f6a05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a05a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a06, null);
                }
            }
        });

        bi.f6a0998.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f6a09check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f6a09check, true);
                }
            }
        });

        bi.f6a10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f6a10b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a11, null);
                }
            }
        });

        bi.f6b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f6b01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6b02, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F7SectionAActivity.class));
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
        int updcount = db.updatesF6();

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


        f1.put("f6a01",bi.f6a01a.isChecked() ?"1" :bi.f6a01b.isChecked() ?"2" :bi.f6a0198.isChecked() ?"98" :"0");
        f1.put("f6a02c", bi.f6a02c.getText().toString());
        f1.put("f6a02",bi.f6a02a.isChecked() ?"1" :bi.f6a02b.isChecked() ?"2" :"0");
        f1.put("f6a03", bi.f6a03.getText().toString());
        f1.put("f6a04",bi.f6a04a.isChecked() ?"1" :bi.f6a04b.isChecked() ?"2" :bi.f6a04c.isChecked() ?"3" :bi.f6a04d.isChecked() ?"4" :bi.f6a04e.isChecked() ?"5" :bi.f6a0498.isChecked() ?"98" :"0");
        f1.put("f6a05",bi.f6a05a.isChecked() ?"1" :bi.f6a05b.isChecked() ?"2" :bi.f6a05c.isChecked() ?"98" :"0");
        f1.put("f6a06",bi.f6a06a.isChecked() ?"1" :bi.f6a06b.isChecked() ?"2" :bi.f6a06c.isChecked() ?"3" :bi.f6a06d.isChecked() ?"4" :"0");
        f1.put("f6a0796x", bi.f6a0796x.getText().toString());
        f1.put("f6a07",bi.f6a07a.isChecked() ?"1" :bi.f6a07b.isChecked() ?"2" :bi.f6a07c.isChecked() ?"3" :bi.f6a07d.isChecked() ?"4" :bi.f6a0796.isChecked() ?"96" :"0");
        f1.put("f6a08",bi.f6a08a.isChecked() ?"1" :bi.f6a08b.isChecked() ?"2" :bi.f6a08c.isChecked() ?"98" :"0");
        f1.put("f6a0996x", bi.f6a0996x.getText().toString());
        f1.put("f6a09",bi.f6a09a.isChecked() ?"1" :bi.f6a09b.isChecked() ?"2" :bi.f6a09c.isChecked() ?"3" :bi.f6a09d.isChecked() ?"4" :bi.f6a09e.isChecked() ?"5" :bi.f6a09f.isChecked() ?"6" :bi.f6a0996.isChecked() ?"96" :bi.f6a0998.isChecked() ?"98" :"0");
        f1.put("f6a10",bi.f6a10a.isChecked() ?"1" :bi.f6a10b.isChecked() ?"2" :bi.f6a1098.isChecked() ?"98" :"0");
        f1.put("f6a1196x", bi.f6a1196x.getText().toString());
        f1.put("f6a11",bi.f6a11a.isChecked() ?"1" :bi.f6a11b.isChecked() ?"2" :bi.f6a11c.isChecked() ?"3" :bi.f6a1198.isChecked() ?"98" :bi.f6a1196.isChecked() ?"96" :"0");
        f1.put("f6a12",bi.f6a12a.isChecked() ?"1" :bi.f6a12b.isChecked() ?"2" :bi.f6a1298.isChecked() ?"98" :"0");
        f1.put("f6a13bx", bi.f6a13bx.getText().toString());
        f1.put("f6a13cx", bi.f6a13cx.getText().toString());
        f1.put("f6a13",bi.f6a13a.isChecked() ?"1" :bi.f6a13b.isChecked() ?"2" :bi.f6a13c.isChecked() ?"3" :bi.f6a13d.isChecked() ?"4" :bi.f6a1398.isChecked() ?"98" :"0");
        f1.put("f6b01",bi.f6b01a.isChecked() ?"1" :bi.f6b01b.isChecked() ?"2" :bi.f6b0198.isChecked() ?"98" :"0");
        f1.put("f6b02",bi.f6b02a.isChecked() ?"1" :bi.f6b02b.isChecked() ?"2" :bi.f6b0298.isChecked() ?"98" :"0");

        MainApp.fc.setF6(String.valueOf(f1));
    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF6);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
