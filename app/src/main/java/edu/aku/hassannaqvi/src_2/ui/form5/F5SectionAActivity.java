package edu.aku.hassannaqvi.src_2.ui.form5;

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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF5SectionABinding;
import edu.aku.hassannaqvi.src_2.ui.form6.F6SectionAActivity;
import edu.aku.hassannaqvi.src_2.ui.form7.F7SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F5SectionAActivity extends AppCompatActivity {

    ActivityF5SectionABinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f5_section_a);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {

        bi.f5a03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f5a03a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpf5a04, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), (!MainApp.Respondent_is_UnMarried && MainApp.two_year_child) ?
                            F6SectionAActivity.class : F7SectionAActivity.class));
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
        int updcount = db.updatesF5();

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
        f1.put("f5a01", bi.f5a01a.isChecked() ? "1" : bi.f5a01b.isChecked() ? "2" : "0");
        f1.put("f5a02", bi.f5a02.getText().toString());
        f1.put("f5a03", bi.f5a03a.isChecked() ? "1" : bi.f5a03b.isChecked() ? "2" : "0");
        f1.put("f5a04", bi.f5a04.getText().toString());
        f1.put("f5a0501", bi.f5a0501a.isChecked() ? "1" : bi.f5a0501b.isChecked() ? "2" : "0");
        f1.put("f5a0502", bi.f5a0502a.isChecked() ? "1" : bi.f5a0502b.isChecked() ? "2" : "0");
        f1.put("f5a0503", bi.f5a0503a.isChecked() ? "1" : bi.f5a0503b.isChecked() ? "2" : "0");
        f1.put("f5a0504", bi.f5a0504a.isChecked() ? "1" : bi.f5a0504b.isChecked() ? "2" : "0");
        f1.put("f5a0505", bi.f5a0505a.isChecked() ? "1" : bi.f5a0505b.isChecked() ? "2" : "0");
        f1.put("f5a0506", bi.f5a0506a.isChecked() ? "1" : bi.f5a0506b.isChecked() ? "2" : "0");
        f1.put("f5a0507", bi.f5a0507a.isChecked() ? "1" : bi.f5a0507b.isChecked() ? "2" : "0");
        f1.put("f5a06", bi.f5a06a.isChecked() ? "1" : bi.f5a06b.isChecked() ? "2" : "0");
        f1.put("f5a07a", bi.f5a07a.isChecked() ? "1" : "0");
        f1.put("f5a07b", bi.f5a07b.isChecked() ? "2" : "0");
        f1.put("f5a07c", bi.f5a07c.isChecked() ? "3" : "0");
        f1.put("f5a07d", bi.f5a07d.isChecked() ? "4" : "0");
        f1.put("f5a07e", bi.f5a07e.isChecked() ? "5" : "0");
        f1.put("f5a07f", bi.f5a07f.isChecked() ? "6" : "0");
        f1.put("f5a07g", bi.f5a07g.isChecked() ? "7" : "0");
        f1.put("f5a07h", bi.f5a07h.isChecked() ? "8" : "0");
        f1.put("f5a07i", bi.f5a07i.isChecked() ? "9" : "0");
        f1.put("f5a07j", bi.f5a07j.isChecked() ? "10" : "0");
        f1.put("f5a07k", bi.f5a07k.isChecked() ? "11" : "0");
        f1.put("f5a07l", bi.f5a07l.isChecked() ? "12" : "0");
        f1.put("f5a07m", bi.f5a07m.isChecked() ? "13" : "0");
        f1.put("f5a07n", bi.f5a07n.isChecked() ? "14" : "0");
        f1.put("f5a0796", bi.f5a0796.isChecked() ? "96" : "0");
        f1.put("f5a0796x", bi.f5a0796x.getText().toString());
        f1.put("f5a08", bi.f5a08a.isChecked() ? "1" : bi.f5a08b.isChecked() ? "2" : "0");
        f1.put("f5b01", bi.f5b01a.isChecked() ? "1" : bi.f5b01b.isChecked() ? "2" : "0");
        f1.put("f5b02", bi.f5b02a.isChecked() ? "1" : bi.f5b02b.isChecked() ? "2" : "0");
        f1.put("f5b03", bi.f5b03a.isChecked() ? "1" : bi.f5b03b.isChecked() ? "2" : bi.f5b03c.isChecked() ? "3" : bi.f5b03d.isChecked() ? "4" : "0");
        f1.put("f5b04", bi.f5b04a.isChecked() ? "1" : bi.f5b04b.isChecked() ? "2" : "0");

        MainApp.fc.setF5(String.valueOf(f1));
    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpF5);
    }

    public void BtnEnd() {

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
