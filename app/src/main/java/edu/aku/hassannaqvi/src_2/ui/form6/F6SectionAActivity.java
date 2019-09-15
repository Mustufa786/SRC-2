package edu.aku.hassannaqvi.src_2.ui.form6;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF6SectionABinding;
import edu.aku.hassannaqvi.src_2.ui.form7.F7SectionAActivity;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;

public class F6SectionAActivity extends AppCompatActivity {

    ActivityF6SectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f6_section_a);
        bi.setCallback(this);

        setTitle(R.string.f6h1);

        setupViews();
    }

    private void setupViews() {
        bi.f6a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a01.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp0203, null);
                }
            }
        });

        bi.f6a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a02b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a03, null);
                }
            }
        });

        bi.f6a05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f6a05a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a06, null);
                }
            }
        });

        bi.f6a0998.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f6a09check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f6a09check, true);
                }
            }
        });

        bi.f6a10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f6a10b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6a11, null);
                }
            }
        });

        bi.f6b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != bi.f6b01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf6b02, null);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F7SectionAActivity.class));
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

    public void BtnEnd() {

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
