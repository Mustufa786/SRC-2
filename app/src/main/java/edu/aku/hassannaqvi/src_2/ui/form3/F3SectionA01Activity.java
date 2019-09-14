package edu.aku.hassannaqvi.src_2.ui.form3;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF3SectionA01Binding;
import edu.aku.hassannaqvi.src_2.validation.ClearClass;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F3SectionA01Activity extends AppCompatActivity {


    ActivityF3SectionA01Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f3_section_a01);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {

        bi.f3a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.f3a01a.getId()) {
                    bi.fldGrpf3a02.setVisibility(View.GONE);
                    bi.fldGrpf3a03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrpf3a02, null);
                } else if (checkedId == bi.f3a0199.getId()) {
                    bi.fldGrpf3a02.setVisibility(View.VISIBLE);
                    bi.fldGrpf3a03.setVisibility(View.GONE);
                }
                if (checkedId != bi.f3a01a.getId() && checkedId != bi.f3a0199.getId()) {
                    bi.fldGrpf3a02.setVisibility(View.GONE);
                    bi.fldGrpf3a03.setVisibility(View.GONE);
                }
            }
        });

        bi.f3a03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.f3a03b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf3a04, null);
                }
            }
        });

        bi.f3a06b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {
                    ClearClass.ClearAllFields(bi.fldGrpf3a07, null);
                }
            }
        });

        bi.f3a0697.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a06check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a06check, true);
                }
            }
        });

        bi.f3a0699.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a06check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a06check, true);
                }
            }
        });
        bi.f3a0698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a06check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a06check, true);
                }
            }
        });
        bi.f3a0598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a05check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a05check, true);
                }
            }
        });
        bi.f3a0599.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a05check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a05check, true);
                }
            }
        });

        bi.f3a10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == bi.f3a10a.getId()
                        || checkedId == bi.f3a10b.getId()
                        || checkedId == bi.f3a10c.getId()
                        || checkedId == bi.f3a10d.getId()
                        || checkedId == bi.f3a10e.getId()
                        || checkedId == bi.f3a10f.getId()
                        || checkedId == bi.f3a10g.getId()) {
                    bi.fldGrp1016.setVisibility(View.VISIBLE);
                    bi.fldGrpf3a11.setVisibility(View.VISIBLE);
                }
                if (checkedId == bi.f3a10h.getId()
                        || checkedId == bi.f3a10i.getId()
                        || checkedId == bi.f3a10j.getId()) {
                    bi.fldGrp1016.setVisibility(View.VISIBLE);
                    bi.fldGrpf3a11.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrpf3a11, null);
                }
                if (checkedId == bi.f3a1097.getId()
                        || checkedId == bi.f3a1099.getId()) {
                    bi.fldGrp1016.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrp1016, null);
                }
            }
        });
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

        return ValidatorClass.EmptyCheckingContainer(this, bi.fdlGrpSectionF3);
    }

    public void BtnEnd() {

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
