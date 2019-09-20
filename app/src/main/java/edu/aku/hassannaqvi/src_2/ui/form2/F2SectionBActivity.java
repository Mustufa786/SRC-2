package edu.aku.hassannaqvi.src_2.ui.form2;

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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF2SectionBBinding;
import edu.aku.hassannaqvi.src_2.other.JsonUtils;
import edu.aku.hassannaqvi.src_2.ui.form3.F3SectionA01Activity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F2SectionBActivity extends AppCompatActivity {


    ActivityF2SectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section_b);
        bi.setCallback(this);

        setTitle(R.string.f2bHeading);

        setupViews();

    }

    private void setupViews() {

        bi.f2b02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f2b02b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp47, null);
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
                    startActivity(new Intent(getApplicationContext(), F3SectionA01Activity.class));
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
        f1.put("f2b01", bi.f2b01a.isChecked() ? "1" : bi.f2b01b.isChecked() ? "2" : "0");

        f1.put("f2b02", bi.f2b02a.isChecked() ? "1" : bi.f2b02b.isChecked() ? "2"
                : bi.f2b02c.isChecked() ? "3" : bi.f2b02d.isChecked() ? "4"
                : bi.f2b02e.isChecked() ? "5" : bi.f2b02f.isChecked() ? "6"
                : bi.f2b02g.isChecked() ? "7" : bi.f2b02h.isChecked() ? "8"
                : bi.f2b02i.isChecked() ? "9"
                : bi.f2b0296.isChecked() ? "96"
                : "0");
        f1.put("f2b0296x", bi.f2b0296x.getText().toString());
        f1.put("f2b03", bi.f2b03a.isChecked() ? "1" : bi.f2b03b.isChecked() ? "2" : bi.f2b0398.isChecked() ? "98" : "0");
        f1.put("f2b03rupees", bi.f2b03ax.getText().toString());
        f1.put("f2b04", bi.f2b04a.isChecked() ? "1" : bi.f2b04b.isChecked() ? "2" : bi.f2b0496.isChecked() ? "96" : "0");


        f1.put("f2b0496x", bi.f2b0496x.getText().toString());
        f1.put("f2b05", bi.f2b05a.isChecked() ? "1" : bi.f2b05b.isChecked() ? "2" : "0");
        f1.put("f2b06", bi.f2b06a.isChecked() ? "1" : bi.f2b06b.isChecked() ? "2" : "0");
        f1.put("f2b07", bi.f2b07a.isChecked() ? "1" : bi.f2b07b.isChecked() ? "2" : "0");

        f1.put("f2b08", bi.f2b08a.isChecked() ? "1" : bi.f2b08b.isChecked() ? "2"
                : bi.f2b08c.isChecked() ? "3" : bi.f2b08d.isChecked() ? "4"
                : bi.f2b08e.isChecked() ? "5" : bi.f2b08f.isChecked() ? "6"
                : bi.f2b08g.isChecked() ? "7" : bi.f2b08h.isChecked() ? "8"
                : bi.f2b08i.isChecked() ? "9"
                : bi.f2b0896.isChecked() ? "96"
                : "0");
        f1.put("f2b0896x", bi.f2b0896x.getText().toString());

        f1.put("f2b09a", bi.f2b09a.isChecked() ? "1" : "0");
        f1.put("f2b09b", bi.f2b09b.isChecked() ? "2" : "0");
        f1.put("f2b09c", bi.f2b09c.isChecked() ? "3" : "0");
        f1.put("f2b0996", bi.f2b0996.isChecked() ? "96" : "0");
        f1.put("f2b0996x", bi.f2b0996x.getText().toString());
        f1.put("f2c01", bi.f2c01a.isChecked() ? "1"
                : bi.f2c01b.isChecked() ? "2"
                : bi.f2c01c.isChecked() ? "3"
                : bi.f2c01d.isChecked() ? "4"
                : bi.f2c01e.isChecked() ? "5"
                : bi.f2c01f.isChecked() ? "6"
                : bi.f2c01g.isChecked() ? "7"
                : bi.f2c01h.isChecked() ? "8"
                : bi.f2c01i.isChecked() ? "9"
                : bi.f2c01j.isChecked() ? "10"
                : bi.f2c01k.isChecked() ? "11"
                : bi.f2c0196.isChecked() ? "96"
                : "0");

        f1.put("f2c0196x", bi.f2c0196x.getText().toString());

        f1.put("f2c02", bi.f2c02a.isChecked() ? "1" : bi.f2c02b.isChecked() ? "2" : "0");

        f1.put("f2c03", bi.f2c03.getText().toString());

        JSONObject merged = JsonUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getF2()), f1);
        MainApp.fc.setF2(String.valueOf(merged));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpf2b);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }

}
