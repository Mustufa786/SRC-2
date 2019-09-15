package edu.aku.hassannaqvi.src_2.ui.form9;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF9SectionBBinding;
import edu.aku.hassannaqvi.src_2.ui.EndingActivity;

public class F9SectionBActivity extends AppCompatActivity {

    ActivityF9SectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f9_section_b);
        bi.setCallback(this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(),
                            EndingActivity.class).putExtra("complete", true));
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
        f1.put("f9b01",bi.f9b01a.isChecked() ?"1" :bi.f9b01b.isChecked() ?"2" :"0");
        f1.put("f9b02", bi.f9b02.getText().toString());
        f1.put("f9b03",bi.f9b03a.isChecked() ?"1" :bi.f9b03b.isChecked() ?"2" :"0");
        f1.put("f9b04", bi.f9b04.getText().toString());
        f1.put("f9b05",bi.f9b05a.isChecked() ?"1" :bi.f9b05b.isChecked() ?"2" :"0");
        f1.put("f9b06", bi.f9b06.getText().toString());
        f1.put("f9b07",bi.f9b07a.isChecked() ?"1" :bi.f9b07b.isChecked() ?"2" :"0");
        f1.put("f9b08", bi.f9b08.getText().toString());
        f1.put("f9b09",bi.f9b09a.isChecked() ?"1" :bi.f9b09b.isChecked() ?"2" :"0");
        f1.put("f9b10", bi.f9b10.getText().toString());
        f1.put("f9b11",bi.f9b11a.isChecked() ?"1" :bi.f9b11b.isChecked() ?"2" :"0");
        f1.put("f9b12", bi.f9b12.getText().toString());

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
