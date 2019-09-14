package edu.aku.hassannaqvi.src_2.ui.form2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.src_2.R;

public class F2SectionAActivity extends AppCompatActivity {

    //F2ActivitySectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bi = DataBindingUtil.setContentView(this, R.layout.activity_f2_section_a);
      //  bi.setCallback(this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
//                    startActivity(new Intent(getApplicationContext(), Form02HHPart_1.class));
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
    }

    private boolean formValidation() {

        return true;
    }



    public void BtnEnd()
    {

    }
}
