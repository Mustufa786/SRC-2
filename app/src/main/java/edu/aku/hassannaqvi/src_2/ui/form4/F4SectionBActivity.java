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
import edu.aku.hassannaqvi.src_2.databinding.ActivityF4SectionBBinding;
import edu.aku.hassannaqvi.src_2.ui.form5.F5SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;

public class F4SectionBActivity extends AppCompatActivity {

    ActivityF4SectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f4_section_b);
        bi.setCallback(this);


        setupViews();
    }

    private void setupViews() {

        bi.f4c01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f4c01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp0203, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F5SectionAActivity.class));
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
        f1.put("f4b01", bi.f4b01a.isChecked() ? "1" : bi.f4b01b.isChecked() ? "2" : bi.f4b01c.isChecked() ? "3" : bi.f4b01d.isChecked() ? "4" : bi.f4b01e.isChecked() ? "5" : bi.f4b01f.isChecked() ? "6" : bi.f4b01g.isChecked() ? "7" : "0");
        f1.put("f4b0296x", bi.f4b0296x.getText().toString());
        f1.put("f4b02", bi.f4b02a.isChecked() ? "1" : bi.f4b02b.isChecked() ? "2" : bi.f4b02c.isChecked() ? "3" : bi.f4b02d.isChecked() ? "4" : bi.f4b02e.isChecked() ? "5" : bi.f4b02f.isChecked() ? "6" : bi.f4b0298.isChecked() ? "7" : bi.f4b0296.isChecked() ? "98" : "0");
        f1.put("f4b0396x", bi.f4b0396x.getText().toString());
        f1.put("f4b03", bi.f4b03a.isChecked() ? "1" : bi.f4b03b.isChecked() ? "2" : bi.f4b03c.isChecked() ? "3" : bi.f4b03d.isChecked() ? "4" : bi.f4b03e.isChecked() ? "5" : bi.f4b03f.isChecked() ? "6" : bi.f4b03g.isChecked() ? "7" : bi.f4b03h.isChecked() ? "8" : bi.f4b0396.isChecked() ? "9" : bi.f4c01a.isChecked() ? "1" : bi.f4c01b.isChecked() ? "2" : "0");
        f1.put("f4c02", bi.f4c02x.getText().toString());
        f1.put("f4c0298", bi.f4c0298.isChecked() ? "98" : "0");
        f1.put("f4c03a", bi.f4c03a.isChecked() ? "1" : "0");
        f1.put("f4c03b", bi.f4c03b.isChecked() ? "2" : "0");
        f1.put("f4c03c", bi.f4c03c.isChecked() ? "3" : "0");
        f1.put("f4c03d", bi.f4c03d.isChecked() ? "4" : "0");
        f1.put("f4c03e", bi.f4c03e.isChecked() ? "5" : "0");
        f1.put("f4c03f", bi.f4c03f.isChecked() ? "6" : "0");
        f1.put("f4c03g", bi.f4c03g.isChecked() ? "7" : "0");
        f1.put("f4c04", bi.f4c04a.isChecked() ? "1" : bi.f4c04b.isChecked() ? "2" : "0");
        f1.put("f4c05", bi.f4c05a.isChecked() ? "1" : bi.f4c05b.isChecked() ? "2" : "0");
        f1.put("f4c0696x", bi.f4c0696x.getText().toString());
        f1.put("f4c06", bi.f4c06a.isChecked() ? "1" : bi.f4c06b.isChecked() ? "2" : bi.f4c06c.isChecked() ? "3" : bi.f4c06d.isChecked() ? "4" : bi.f4c06e.isChecked() ? "5" : bi.f4c06f.isChecked() ? "6" : bi.f4c06g.isChecked() ? "7" : bi.f4c0696.isChecked() ? "96" : "0");


    }

    private boolean formValidation() {

        return true;
    }

    public void BtnEnd() {

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
