package edu.aku.hassannaqvi.src_2.ui.form4;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF4SectionABinding;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F4SectionAActivity extends AppCompatActivity {

    ActivityF4SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f4_section_a);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {
        bi.f4a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f4a01b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf4a02, null);
                } else {
                    ClearClass.ClearAllFields(bi.fldGrpMain, null);
                }
            }
        });

        bi.f4a08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f4a08a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp0910, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F4SectionBActivity.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1 = new JSONObject();

        f1.put("f4a01",bi.f4a01a.isChecked() ?"1" :bi.f4a01b.isChecked() ?"2" :"0");
        f1.put("f4a02a",bi.f4a02a.isChecked() ?"1" :"0");
        f1.put("f4a02b",bi.f4a02b.isChecked() ?"2" :"0");
        f1.put("f4a02c",bi.f4a02c.isChecked() ?"3" :"0");
        f1.put("f4a02d",bi.f4a02d.isChecked() ?"4" :"0");
        f1.put("f4a02e",bi.f4a02e.isChecked() ?"5" :"0");
        f1.put("f4a02f",bi.f4a02f.isChecked() ?"6" :"0");
        f1.put("f4a0296",bi.f4a0296.isChecked() ?"96" :"0");
        f1.put("f4a0296x", bi.f4a0296x.getText().toString());
        f1.put("f4a03x", bi.f4a03x.getText().toString());
        f1.put("f4a03",bi.f4a03.isChecked() ?"98" :"0");
        f1.put("f4a04",bi.f4a04a.isChecked() ?"1" :bi.f4a04b.isChecked() ?"2" :bi.f4a04c.isChecked() ?"3" :"0");
        f1.put("f4a0596x", bi.f4a0596x.getText().toString());
        f1.put("f4a05",bi.f4a05a.isChecked() ?"1" :bi.f4a05b.isChecked() ?"2" :bi.f4a05c.isChecked() ?"3" :bi.f4a05d.isChecked() ?"4" :bi.f4a05e.isChecked() ?"5" :bi.f4a05f.isChecked() ?"6" :bi.f4a05g.isChecked() ?"7" :bi.f4a0596.isChecked() ?"96" :"0");
        f1.put("f4a0696x", bi.f4a0696x.getText().toString());
        f1.put("f4a06",bi.f4a06a.isChecked() ?"1" :bi.f4a06b.isChecked() ?"2" :bi.f4a06c.isChecked() ?"3" :bi.f4a06d.isChecked() ?"4" :bi.f4a06e.isChecked() ?"5" :bi.f4a06f.isChecked() ?"6" :bi.f4a06g.isChecked() ?"7" :bi.f4a06h.isChecked() ?"8" :bi.f4a0698.isChecked() ?"98" :bi.f4a0696.isChecked() ?"96" :"0");
        f1.put("f4a07a",bi.f4a07a.isChecked() ?"1" :"0");
        f1.put("f4a07b",bi.f4a07b.isChecked() ?"2" :"0");
        f1.put("f4a07c",bi.f4a07c.isChecked() ?"3" :"0");
        f1.put("f4a07d",bi.f4a07d.isChecked() ?"4" :"0");
        f1.put("f4a07e",bi.f4a07e.isChecked() ?"5" :"0");
        f1.put("f4a07f",bi.f4a07f.isChecked() ?"6" :"0");
        f1.put("f4a07g",bi.f4a07g.isChecked() ?"7" :"0");
        f1.put("f4a07h",bi.f4a07h.isChecked() ?"8" :"0");
        f1.put("f4a07i",bi.f4a07i.isChecked() ?"9" :"0");
        f1.put("f4a07j",bi.f4a07j.isChecked() ?"10" :"0");
        f1.put("f4a0796",bi.f4a0796.isChecked() ?"96" :"0");
        f1.put("f4a0796x", bi.f4a0796x.getText().toString());
        f1.put("f4a08",bi.f4a08a.isChecked() ?"1" :bi.f4a08b.isChecked() ?"2" :"0");
        f1.put("f4a09",bi.f4a09a.isChecked() ?"1" :bi.f4a09b.isChecked() ?"2" :bi.f4a09c.isChecked() ?"3" :bi.f4a09d.isChecked() ?"4" :bi.f4a09e.isChecked() ?"5" :"0");
        f1.put("f4a10dd", bi.f4a10dd.getText().toString());
        f1.put("f4a10mm", bi.f4a10mm.getText().toString());
        f1.put("f4a1098",bi.f4a1098.isChecked() ?"98" :"0");
        f1.put("f4a11",bi.f4a11a.isChecked() ?"1" :bi.f4a11b.isChecked() ?"2" :"0");
        f1.put("f4a12",bi.f4a12a.isChecked() ?"1" :bi.f4a12b.isChecked() ?"2" :bi.f4a12c.isChecked() ?"3" :bi.f4a12d.isChecked() ?"4" :bi.f4a12e.isChecked() ?"5" :"0");
        f1.put("f4a13",bi.f4a13a.isChecked() ?"1" :bi.f4a13b.isChecked() ?"2" :"0");
        f1.put("f4a14",bi.f4a14a.isChecked() ?"1" :bi.f4a14b.isChecked() ?"2" :bi.f4a14c.isChecked() ?"3" :bi.f4a14d.isChecked() ?"4" :"0");
        f1.put("f4a15",bi.f4a15a.isChecked() ?"1" :bi.f4a15b.isChecked() ?"2" :bi.f4a1598.isChecked() ?"98" :"0");
        f1.put("f4a16", bi.f4a16.getText().toString());
        f1.put("f4a1698",bi.f4a1698.isChecked() ?"" :"0");

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF4A);
    }

    public void BtnEnd() {

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
