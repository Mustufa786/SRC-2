package edu.aku.hassannaqvi.src_2.ui.form8;

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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF8SectionABinding;
import edu.aku.hassannaqvi.src_2.ui.form9.F9SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F8SectionAActivity extends AppCompatActivity {

    ActivityF8SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f8_section_a);
        bi.setCallback(this);

        setTitle(R.string.f8Heading);

        setupViews();
    }

    private void setupViews() {

        bi.f8a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f8a0411.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf8a04a, null);
                }
            }
        });

        bi.f8a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f8a0402.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf8a05, null);
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
                    startActivity(new Intent(getApplicationContext(), F9SectionAActivity.class));
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
        int updcount = db.updatesF8();

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
        f1.put("f8a02a",bi.f8a02a.isChecked() ?"1" :"0");
        f1.put("f8a02b",bi.f8a02b.isChecked() ?"2" :"0");
        f1.put("f8a02c",bi.f8a02c.isChecked() ?"3" :"0");
        f1.put("f8a02d",bi.f8a02d.isChecked() ?"4" :"0");
        f1.put("f8a02e",bi.f8a02e.isChecked() ?"5" :"0");
        f1.put("f8a02f",bi.f8a02f.isChecked() ?"6" :"0");
        f1.put("f8a02g",bi.f8a02g.isChecked() ?"7" :"0");
        f1.put("f8a02h",bi.f8a02h.isChecked() ?"8" :"0");
        f1.put("f8a02i",bi.f8a02i.isChecked() ?"9" :"0");
        f1.put("f8a02j",bi.f8a02j.isChecked() ?"10" :"0");
        f1.put("f8a0296",bi.f8a0296.isChecked() ?"96" :"0");
        f1.put("f8a0296x", bi.f8a0296x.getText().toString());
        f1.put("f8a03",bi.f8a03a.isChecked() ?"1" :bi.f8a03b.isChecked() ?"2" :bi.f8a03c.isChecked() ?"3" :"0");
        f1.put("f8a04",bi.f8a0401.isChecked() ?"1" :bi.f8a0402.isChecked() ?"2" :bi.f8a0403.isChecked() ?"3" :bi.f8a0404.isChecked() ?"4" :bi.f8a0405.isChecked() ?"5" :bi.f8a0406.isChecked() ?"6" :bi.f8a0407.isChecked() ?"7" :bi.f8a0408.isChecked() ?"8" :bi.f8a0409.isChecked() ?"9" :bi.f8a0410.isChecked() ?"10" :bi.f8a0496.isChecked() ?"96" :bi.f8a0411.isChecked() ?"11" :"0");
        f1.put("f8a0496x", bi.f8a0496x.getText().toString());
        f1.put("f8a04a",bi.f8a04a01.isChecked() ?"1" :bi.f8a04a02.isChecked() ?"2" :"0");
        f1.put("f8a05",bi.f8a05a.isChecked() ?"1" :bi.f8a05b.isChecked() ?"2" :bi.f8a05c.isChecked() ?"3" :bi.f8a05d.isChecked() ?"4" :bi.f8a05e.isChecked() ?"5" :bi.f8a05f.isChecked() ?"6" :bi.f8a05g.isChecked() ?"7" :bi.f8a0596.isChecked() ?"96" :"0");
        f1.put("f8a0596x", bi.f8a0596x.getText().toString());
        f1.put("f8a06",bi.f8a06a.isChecked() ?"1" :bi.f8a06b.isChecked() ?"2" :bi.f8a06c.isChecked() ?"3" :bi.f8a06d.isChecked() ?"4" :bi.f8a06e.isChecked() ?"5" :bi.f8a06f.isChecked() ?"6" :bi.f8a06g.isChecked() ?"7" :bi.f8a06h.isChecked() ?"8" :bi.f8a06i.isChecked() ?"9" :bi.f8a06j.isChecked() ?"10"  :bi.f8a06k.isChecked() ?"11" :bi.f8a0696.isChecked() ?"96" :"0");
        f1.put("f8a0696x", bi.f8a0696x.getText().toString());
        f1.put("f8a07",bi.f8a07a.isChecked() ?"1" :bi.f8a07b.isChecked() ?"2" :bi.f8a07c.isChecked() ?"3" :bi.f8a07d.isChecked() ?"4" :bi.f8a07e.isChecked() ?"5" :bi.f8a07f.isChecked() ?"6" :"0");

        MainApp.fc.setF8(String.valueOf(f1));
    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF8);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
