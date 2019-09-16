package edu.aku.hassannaqvi.src_2.ui.form3;

import android.content.Intent;
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
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
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


        setTitle(R.string.f3Heading);
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
        bi.f3a0597.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

        bi.f3a15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.f3a15d.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpf3a16, null);
                }
            }
        });

        bi.f3a1799.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a17check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a17check, true);
                }
            }
        });
        bi.f3a1797.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a17check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a17check, true);
                }
            }
        });

        bi.f3a0898.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a08check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a08check, true);
                }
            }
        });

        bi.f3a0997.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ClearClass.ClearAllFields(bi.f3a09check, false);
                } else {
                    ClearClass.ClearAllFields(bi.f3a09check, true);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), F3SectionA02Activity.class));
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
        int updcount = db.updatesF3();

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


        f1.put("f3a01", bi.f3a01a.isChecked() ? "1" : bi.f3a01b.isChecked() ? "2" : bi.f3a01c.isChecked() ? "3" : bi.f3a0198.isChecked() ? "98" : bi.f3a0199.isChecked() ? "99" : "0");
        f1.put("f3a0296x", bi.f3a0296x.getText().toString());
        f1.put("f3a02", bi.f3a02a.isChecked() ? "1" : bi.f3a02b.isChecked() ? "2" : bi.f3a0296.isChecked() ? "96" : "0");
        f1.put("f3a0396x", bi.f3a0396x.getText().toString());
        f1.put("f3a03", bi.f3a03a.isChecked() ? "1" : bi.f3a03b.isChecked() ? "2" : bi.f3a0399.isChecked() ? "99" : bi.f3a0396.isChecked() ? "96" : "0");
        f1.put("f3a04", bi.f3a04.getText().toString());
        f1.put("f3a05a", bi.f3a05a.isChecked() ? "1" : "0");
        f1.put("f3a05b", bi.f3a05b.isChecked() ? "2" : "0");
        f1.put("f3a05c", bi.f3a05c.isChecked() ? "3" : "0");
        f1.put("f3a05d", bi.f3a05d.isChecked() ? "4" : "0");
        f1.put("f3a05e", bi.f3a05e.isChecked() ? "5" : "0");
        f1.put("f3a05f", bi.f3a05f.isChecked() ? "6" : "0");
        f1.put("f3a05g", bi.f3a05g.isChecked() ? "7" : "0");
        f1.put("f3a05h", bi.f3a05h.isChecked() ? "8" : "0");
        f1.put("f3a0596", bi.f3a0596.isChecked() ? "96" : "0");
        f1.put("f3a0596x", bi.f3a0596x.getText().toString());
        f1.put("f3a0597", bi.f3a0597.isChecked() ? "97" : "0");
        f1.put("f3a0599", bi.f3a0599.isChecked() ? "99" : "0");
        //    f1.put("f3a06", bi.f3a06a.isChecked() ? "1" : bi.f3a06b.isChecked() ? "2" : bi.f3a06c.isChecked() ? "3" : bi.f3a06d.isChecked() ? "4" : bi.f3a0696.isChecked() ? "96" : bi.f3a0699.isChecked() ? "99" : bi.f3a0698.isChecked() ? "98" : "0");


        f1.put("f3a06a", bi.f3a06a.isChecked() ? "1" : "0");
        f1.put("f3a06b", bi.f3a06b.isChecked() ? "2" : "0");
        f1.put("f3a06c", bi.f3a06c.isChecked() ? "3" : "0");
        f1.put("f3a06d", bi.f3a06d.isChecked() ? "4" : "0");
        f1.put("f3a0696", bi.f3a0696.isChecked() ? "96" : "0");
        f1.put("f3a0696x", bi.f3a0696x.getText().toString());

        f1.put("f3a0699", bi.f3a0699.isChecked() ? "99" : "0");
        f1.put("f3a0698", bi.f3a0698.isChecked() ? "98" : "0");


        f1.put("f3a0696x", bi.f3a0696x.getText().toString());
        f1.put("f3a07", bi.f3a07a.isChecked() ? "1" : bi.f3a07b.isChecked() ? "2" : bi.f3a07c.isChecked() ? "3" : "0");
        f1.put("f3a08a", bi.f3a08a.isChecked() ? "1" : "0");
        f1.put("f3a08b", bi.f3a08b.isChecked() ? "2" : "0");
        f1.put("f3a08c", bi.f3a08c.isChecked() ? "3" : "0");
        f1.put("f3a08d", bi.f3a08d.isChecked() ? "4" : "0");
        f1.put("f3a08e", bi.f3a08e.isChecked() ? "5" : "0");
        f1.put("f3a0896", bi.f3a0896.isChecked() ? "96" : "0");
        f1.put("f3a0896x", bi.f3a0896x.getText().toString());
        f1.put("f3a0898", bi.f3a0898.isChecked() ? "98" : "0");
        f1.put("f3a09a", bi.f3a09a.isChecked() ? "1" : "0");
        f1.put("f3a09b", bi.f3a09b.isChecked() ? "2" : "0");
        f1.put("f3a09c", bi.f3a09c.isChecked() ? "3" : "0");
        f1.put("f3a09d", bi.f3a09d.isChecked() ? "4" : "0");
        f1.put("f3a09e", bi.f3a09e.isChecked() ? "5" : "0");
        f1.put("f3a09f", bi.f3a09f.isChecked() ? "6" : "0");
        f1.put("f3a09g", bi.f3a09g.isChecked() ? "7" : "0");
        f1.put("f3a09h", bi.f3a09h.isChecked() ? "8" : "0");
        f1.put("f3a09i", bi.f3a09i.isChecked() ? "9" : "0");
        f1.put("f3a0996", bi.f3a0996.isChecked() ? "96" : "0");
        f1.put("f3a0996x", bi.f3a0996x.getText().toString());
        f1.put("f3a0997", bi.f3a0997.isChecked() ? "99" : "0");
        f1.put("f3a1096x", bi.f3a1096x.getText().toString());
        f1.put("f3a10", bi.f3a10a.isChecked() ? "1" : bi.f3a10b.isChecked() ? "2" : bi.f3a10c.isChecked() ? "3" : bi.f3a10d.isChecked() ? "4" : bi.f3a10e.isChecked() ? "5" : bi.f3a10f.isChecked() ? "6" : bi.f3a10g.isChecked() ? "7" : bi.f3a10h.isChecked() ? "8" : bi.f3a10i.isChecked() ? "9" : bi.f3a10j.isChecked() ? "10" : bi.f3a1096.isChecked() ? "96" : bi.f3a1097.isChecked() ? "97" : bi.f3a1099.isChecked() ? "99" : "0");
        f1.put("f3a1196x", bi.f3a1196x.getText().toString());
        f1.put("f3a11", bi.f3a11a.isChecked() ? "1" : bi.f3a11b.isChecked() ? "2" : bi.f3a11c.isChecked() ? "3" : bi.f3a11d.isChecked() ? "4" : bi.f3a1196.isChecked() ? "96" : bi.f3a1199.isChecked() ? "99" : "0");
        f1.put("f3a1296x", bi.f3a1296x.getText().toString());
        f1.put("f3a12", bi.f3a12a.isChecked() ? "2" : bi.f3a12b.isChecked() ? "3" : bi.f3a12c.isChecked() ? "4" : bi.f3a1299.isChecked() ? "99" : bi.f3a1296.isChecked() ? "96" : "0");
        f1.put("f3a13", bi.f3a13a.isChecked() ? "1" : bi.f3a13b.isChecked() ? "2" : bi.f3a13c.isChecked() ? "3" : bi.f3a13d.isChecked() ? "4" : bi.f3a13e.isChecked() ? "5" : bi.f3a13f.isChecked() ? "6" : bi.f3a1399.isChecked() ? "99" : "0");
        f1.put("f3a14a", bi.f3a14a.isChecked() ? "1" : "0");
        f1.put("f3a14b", bi.f3a14b.isChecked() ? "2" : "0");
        f1.put("f3a14c", bi.f3a14c.isChecked() ? "3" : "0");
        f1.put("f3a1496", bi.f3a1496.isChecked() ? "96" : "0");
        f1.put("f3a1496x", bi.f3a1496x.getText().toString());
        f1.put("f3a1499", bi.f3a1499.isChecked() ? "99" : "0");
        f1.put("f3a15", bi.f3a15a.isChecked() ? "1" : bi.f3a15b.isChecked() ? "2" : bi.f3a15c.isChecked() ? "3" : bi.f3a15d.isChecked() ? "4" : bi.f3a1599.isChecked() ? "99" : "0");
        f1.put("f3a16a", bi.f3a16a.isChecked() ? "1" : "0");
        f1.put("f3a16b", bi.f3a16b.isChecked() ? "2" : "0");
        f1.put("f3a16c", bi.f3a16c.isChecked() ? "3" : "0");
        f1.put("f3a1696", bi.f3a1696.isChecked() ? "96" : "0");
        f1.put("f3a1696x", bi.f3a1696x.getText().toString());
        f1.put("f3a17a", bi.f3a17a.isChecked() ? "1" : "0");
        f1.put("f3a17b", bi.f3a17b.isChecked() ? "2" : "0");
        f1.put("f3a17c", bi.f3a17c.isChecked() ? "3" : "0");
        f1.put("f3a17d", bi.f3a17d.isChecked() ? "4" : "0");
        f1.put("f3a1796", bi.f3a1796.isChecked() ? "96" : "0");
        f1.put("f3a1796x", bi.f3a1796x.getText().toString());
        f1.put("f3a1799", bi.f3a1799.isChecked() ? "99" : "0");
        f1.put("f3a1797", bi.f3a1797.isChecked() ? "97" : "0");

        MainApp.fc.setF3(String.valueOf(f1));

    }

    private boolean formValidation() {

        return ValidatorClass.EmptyCheckingContainer(this, bi.fdlGrpSectionF3);
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back.", Toast.LENGTH_SHORT).show();
    }
}
