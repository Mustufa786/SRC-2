package edu.aku.hassannaqvi.src_2.ui.form3;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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



        JSONObject f1 = new JSONObject();

        f1.put("f3a01", bi.f3a01a.isChecked() ? "1"
                : bi.f3a01b.isChecked() ? "2"
                : bi.f3a01c.isChecked() ? "3"
                : bi.f3a0198.isChecked() ? "98"
                : bi.f3a0199.isChecked() ? "99"
                : "0");


        f1.put("f3a02", bi.f3a02a.isChecked() ? "1"
                : bi.f3a02b.isChecked() ? "2"
                : bi.f3a0296.isChecked() ? "96"
                : "0");




        f1.put("f3a0296x", bi.f3a0296x.getText().toString());

        f1.put("f3a03", bi.f3a03a.isChecked() ? "1"
                : bi.f3a03b.isChecked() ? "2"
                : bi.f3a03c.isChecked() ? "3"
                : bi.f3a0396.isChecked() ? "96"
                : "0");

        f1.put("f3a0396x", bi.f3a0396x.getText().toString());

        f1.put("f3a04", bi.f3a04.getText().toString());


        f1.put("f3a05a", bi.f3a05a.isChecked() ? "1" : "0");
        f1.put("f3a05b", bi.f3a05b.isChecked() ? "1" : "0");
        f1.put("f3a05c", bi.f3a05c.isChecked() ? "1" : "0");
        f1.put("f3a05d", bi.f3a05d.isChecked() ? "1" : "0");
        f1.put("f3a05e", bi.f3a05e.isChecked() ? "1" : "0");
        f1.put("f3a05f", bi.f3a05f.isChecked() ? "1" : "0");
        f1.put("f3a05g", bi.f3a05g.isChecked() ? "1" : "0");
        f1.put("f3a05h", bi.f3a05h.isChecked() ? "1" : "0");
        f1.put("f3a0596", bi.f3a0596.isChecked() ? "1" : "0");
        f1.put("f3a0598", bi.f3a0598.isChecked() ? "1" : "0");
        f1.put("f3a0599", bi.f3a0599.isChecked() ? "1" : "0");
        f1.put("f3a0596x", bi.f3a0596x.getText().toString());



        f1.put("f3a06a", bi.f3a06a.isChecked() ? "1" : "0");
        f1.put("f3a06b", bi.f3a06b.isChecked() ? "1" : "0");
        f1.put("f3a06c", bi.f3a06c.isChecked() ? "1" : "0");
        f1.put("f3a06d", bi.f3a06d.isChecked() ? "1" : "0");
        f1.put("f3a0697", bi.f3a0697.isChecked() ? "1" : "0");
        f1.put("f3a0698", bi.f3a0698.isChecked() ? "1" : "0");
        f1.put("f3a0699", bi.f3a0699.isChecked() ? "1" : "0");


        f1.put("f3a07", bi.f3a01a.isChecked() ? "1"
                : bi.f3a07b.isChecked() ? "2"
                : bi.f3a07c.isChecked() ? "3"
                : "0");

        f1.put("f3a08a", bi.f3a08a.isChecked() ? "1" : "0");
        f1.put("f3a08b", bi.f3a08b.isChecked() ? "1" : "0");
        f1.put("f3a08c", bi.f3a08c.isChecked() ? "1" : "0");
        f1.put("f3a08d", bi.f3a08d.isChecked() ? "1" : "0");
        f1.put("f3a0896", bi.f3a0896.isChecked() ? "1" : "0");
        f1.put("f3a0896x", bi.f3a0896x.getText().toString());







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
