package edu.aku.hassannaqvi.src_2.ui.form1;

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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF1SectionCBinding;
import edu.aku.hassannaqvi.src_2.other.JsonUtils;
import edu.aku.hassannaqvi.src_2.ui.form2.F2SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F1SectionCActivity extends AppCompatActivity {


    ActivityF1SectionCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_c);
        bi.setCallback(this);
        setTitle(R.string.f1cHeading);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), F2SectionAActivity.class));
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
        int updcount = db.updatesF1();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject f1c = new JSONObject();

        f1c.put("f1c01", bi.f1c01a.isChecked() ? "1"
                : bi.f1c01b.isChecked() ? "2"
                : bi.f1c01c.isChecked() ? "3"
                : "0");
        f1c.put("f1c02", bi.f1c02a.isChecked() ? "1"
                : bi.f1c02b.isChecked() ? "2"
                : "0");

        f1c.put("f1c03", bi.f1c03.getText().toString());
        f1c.put("f1c04", bi.f1c04.getText().toString());
        f1c.put("f1c05a", bi.f1c05a.isChecked() ? "1" : "0");
        f1c.put("f1c05b", bi.f1c05b.isChecked() ? "2" : "0");
        f1c.put("f1c05c", bi.f1c05c.isChecked() ? "3" : "0");
        f1c.put("f1c05d", bi.f1c05d.isChecked() ? "4" : "0");
        f1c.put("f1c05e", bi.f1c05e.isChecked() ? "5" : "0");
        f1c.put("f1c05f", bi.f1c05f.isChecked() ? "6" : "0");
        f1c.put("f1c05g", bi.f1c05g.isChecked() ? "7" : "0");
        f1c.put("f1c05h", bi.f1c05h.isChecked() ? "8" : "0");
        f1c.put("f1c05i", bi.f1c05i.isChecked() ? "9" : "0");
        f1c.put("f1c05j", bi.f1c05j.isChecked() ? "10" : "0");
        f1c.put("f1c05k", bi.f1c05k.isChecked() ? "11" : "0");
        f1c.put("f1c05l", bi.f1c05l.isChecked() ? "12" : "0");
        f1c.put("f1c05m", bi.f1c05m.isChecked() ? "13" : "0");
        f1c.put("f1c05n", bi.f1c05n.isChecked() ? "14" : "0");

        JSONObject merged = JsonUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getF1()), f1c);
        MainApp.fc.setF1(String.valueOf(merged));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSectionF1C);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

}
