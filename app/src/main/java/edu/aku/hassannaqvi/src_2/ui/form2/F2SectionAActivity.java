package edu.aku.hassannaqvi.src_2.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF2SectionABinding;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F2SectionAActivity extends AppCompatActivity {

    ActivityF2SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section_a);
        bi.setCallback(this);

        setTitle(R.string.f2Heading);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), F2SectionBActivity.class));
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
        int updcount = db.updatesF2();

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
        f1.put("f2a0196x", bi.f2a0196x.getText().toString());
        f1.put("f2a01", bi.f2a01a.isChecked() ? "1" : bi.f2a01b.isChecked() ? "2" : bi.f2a01c.isChecked() ? "3"
                : bi.f2a01d.isChecked() ? "4" : bi.f2a01e.isChecked() ? "5" : bi.f2a01f.isChecked() ? "6"
                : bi.f2a01g.isChecked() ? "7" : bi.f2a01h.isChecked() ? "8" : bi.f2a01i.isChecked() ? "9"
                : bi.f2a01j.isChecked() ? "10" : bi.f2a01k.isChecked() ? "11" : bi.f2a01l.isChecked() ? "12"
                : bi.f2a01m.isChecked() ? "13" : bi.f2a01n.isChecked() ? "14" : bi.f2a01o.isChecked() ? "15"
                : bi.f2a0196.isChecked() ? "96" : "0");
        f1.put("f2a02", bi.f2a02a.isChecked() ? "1" : bi.f2a02b.isChecked() ? "2" : "0");
        f1.put("f2a03", bi.f2a03.getText().toString());


        f1.put("f2a04", bi.f2a04a.isChecked() ? "1"
                : bi.f2a04b.isChecked() ? "2" : bi.f2a04c.isChecked() ? "3"
                : bi.f2a04d.isChecked() ? "4" : bi.f2a04e.isChecked() ? "5"
                : bi.f2a04f.isChecked() ? "6" : bi.f2a04g.isChecked() ? "7"
                : bi.f2a04h.isChecked() ? "8" : bi.f2a04i.isChecked() ? "9"
                : bi.f2a04j.isChecked() ? "10" : bi.f2a04k.isChecked() ? "11"
                : bi.f2a04l.isChecked() ? "12" : bi.f2a04m.isChecked() ? "13"
                : bi.f2a04n.isChecked() ? "14" : bi.f2a04o.isChecked() ? "15"
                : bi.f2a0496.isChecked() ? "96" : "0");
        f1.put("f2a0496x", bi.f2a0496x.getText().toString());
        f1.put("f2a05", bi.f2a05a.isChecked() ? "1" : bi.f2a05b.isChecked() ? "2" : bi.f2a0598.isChecked() ? "98" : "0");
        f1.put("f2a05min", bi.f2a05ax.getText().toString());


        MainApp.fc.setF2(String.valueOf(f1));


    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSectionF2A);
    }


    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }
}
