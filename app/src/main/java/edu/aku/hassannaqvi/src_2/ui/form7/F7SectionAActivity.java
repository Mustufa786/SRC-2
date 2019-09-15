package edu.aku.hassannaqvi.src_2.ui.form7;

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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF7SectionABinding;
import edu.aku.hassannaqvi.src_2.ui.form8.F8SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F7SectionAActivity extends AppCompatActivity {

    ActivityF7SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f7_section_a);
        bi.setCallback(this);

        setTitle(R.string.f7Form);

        setupViews();
    }

    private void setupViews() {

        bi.f7a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f7a04a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp5678, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F8SectionAActivity.class));
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
        int updcount = db.updatesF7();

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
//        f1.put("f7a01", bi.f7a01.getText().toString());
        f1.put("f7a02a", bi.f7a02a.getText().toString());
        f1.put("f7a02b", bi.f7a02b.getText().toString());
        f1.put("f7a02c", bi.f7a02c.getText().toString());
        f1.put("f7a03",bi.f7a03a.isChecked() ?"1" :bi.f7a03b.isChecked() ?"2" :"0");
        f1.put("f7a04",bi.f7a04a.isChecked() ?"1" :bi.f7a04b.isChecked() ?"2" :bi.f7a0498.isChecked() ?"98" :"0");
        f1.put("f7a05",bi.f7a05a.isChecked() ?"1" :bi.f7a05b.isChecked() ?"2" :bi.f7a0598.isChecked() ?"98" :"0");
        f1.put("f7a06",bi.f7a06a.isChecked() ?"1" :bi.f7a06b.isChecked() ?"2" :bi.f7a0698.isChecked() ?"98" :"0");
        f1.put("f7a0796x", bi.f7a0796x.getText().toString());
        f1.put("f7a07",bi.f7a07a.isChecked() ?"1" :bi.f7a07b.isChecked() ?"2" :bi.f7a07c.isChecked() ?"3" :bi.f7a07d.isChecked() ?"4" :bi.f7a07e.isChecked() ?"5" :bi.f7a07f.isChecked() ?"6" :bi.f7a07g.isChecked() ?"7" :bi.f7a07h.isChecked() ?"8" :bi.f7a07i.isChecked() ?"9" :bi.f7a07j.isChecked() ?"10"  :bi.f7a07k.isChecked() ?"11" :bi.f7a07l.isChecked() ?"12" :bi.f7a07m.isChecked() ?"13" :bi.f7a07n.isChecked() ?"14" :bi.f7a0796.isChecked() ?"96" :bi.f7a0798.isChecked() ?"98" :"0");

        f1.put("f7a0896x", bi.f7a0896x.getText().toString());
        f1.put("f7a08",bi.f7a08a.isChecked() ?"1" :bi.f7a08b.isChecked() ?"2" :bi.f7a0896.isChecked() ?"96" :"0");

        MainApp.fc.setF7(String.valueOf(f1));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF7);
    }

    public void BtnEnd() {

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
