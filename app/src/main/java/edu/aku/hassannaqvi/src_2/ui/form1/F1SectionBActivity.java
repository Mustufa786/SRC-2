package edu.aku.hassannaqvi.src_2.ui.form1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF1SectionBBinding;
import edu.aku.hassannaqvi.src_2.other.DateUtils;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

import static edu.aku.hassannaqvi.src_2.core.MainApp.fc;
import static edu.aku.hassannaqvi.src_2.core.MainApp.fmc;

public class F1SectionBActivity extends AppCompatActivity {


    ActivityF1SectionBBinding bi;
    boolean iam_respondent;
    String respondent_type = "";
    Calendar dob = Calendar.getInstance();
    long age;

    ArrayList<String>
            lstf1b01,
            lstf1b02,
            lstf1b03,
            lstf1b03D,
            lstf1b03M,
            lstf1b03Y,
            lstf1b04,
            lstf1b05,
            lstf1b06,
            lstf1b07,
            lstf1b07x,
            lstf1b08,
            lstf1b09;

    ArrayList<ArrayList<String>> subList = new ArrayList<>();
    ArrayList<String> allQuestions = new ArrayList<>(Arrays.asList(
            "f1b01",
            "f1b02",
            "f1b03",
            "f1b03D",
            "f1b03M",
            "f1b03Y",
            "f1b04",
            "f1b05",
            "f1b06",
            "f1b07",
            "f1b07x",
            "f1b08",
            "f1b09"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_f1_section_b);

        iam_respondent = true;
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_b);
        bi.setCallback(this);

        setTitle(R.string.f1bHeading);

        lstf1b01 = new ArrayList<>();
        lstf1b02 = new ArrayList<>();
        lstf1b03 = new ArrayList<>();
        lstf1b03D = new ArrayList<>();
        lstf1b03M = new ArrayList<>();
        lstf1b03Y = new ArrayList<>();
        lstf1b04 = new ArrayList<>();
        lstf1b05 = new ArrayList<>();
        lstf1b06 = new ArrayList<>();
        lstf1b07 = new ArrayList<>();
        lstf1b07x = new ArrayList<>();
        lstf1b08 = new ArrayList<>();
        lstf1b09 = new ArrayList<>();

//        MainApp.two_year_child = false;
//        if(MainApp.lst_U2.size() > 0 || MainApp.lst_U5.size() > 0){
//            MainApp.lst_U2.clear();
//            MainApp.lst_U5.clear();
//        }


    }


    public void BtnAddMembers() {

        final AlertDialog b = new AlertDialog.Builder(this).create();


        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.dialog_f1_section_b_add_member, null);
        b.setView(v);
        b.show();
        b.setCancelable(false);

        //region Declaration
        Button btn_Continue, btn_End;
        final RadioButton
                f1b02a,
                f1b02b,
                f1b03a,
                f1b03b,
                f1b04a,
                f1b04b,
                f1b04c,
                f1b04d,
                f1b04e,
                f1b04f,
                f1b04g,
                f1b05a,
                f1b05b,
                f1b05c,
                f1b06a,
                f1b06b,
                f1b06c,
                f1b06d,
                f1b06e,
                f1b07a,
                f1b07b,
                f1b07c,
                f1b07d,
                f1b07e,
                f1b07f,
                f1b07g,
                f1b07h,
                f1b07i,
                f1b07j,
                f1b07k,
                f1b07l,
                f1b07m,
                f1b07n,
                f1b07o;


        f1b02a = v.findViewById(R.id.f1b02a);
        f1b02b = v.findViewById(R.id.f1b02b);
        f1b03a = v.findViewById(R.id.f1b03a);
        f1b03b = v.findViewById(R.id.f1b03b);
        f1b04a = v.findViewById(R.id.f1b04a);
        f1b04b = v.findViewById(R.id.f1b04b);
        f1b04c = v.findViewById(R.id.f1b04c);
        f1b04d = v.findViewById(R.id.f1b04d);
        f1b04e = v.findViewById(R.id.f1b04e);
        f1b04f = v.findViewById(R.id.f1b04f);
        f1b04g = v.findViewById(R.id.f1b04g);
        f1b05a = v.findViewById(R.id.f1b05a);
        f1b05b = v.findViewById(R.id.f1b05b);
        f1b05c = v.findViewById(R.id.f1b05c);
        f1b06a = v.findViewById(R.id.f1b06a);
        f1b06b = v.findViewById(R.id.f1b06b);
        f1b06c = v.findViewById(R.id.f1b06c);
        f1b06d = v.findViewById(R.id.f1b06d);
        f1b06e = v.findViewById(R.id.f1b06e);
        f1b07a = v.findViewById(R.id.f1b07a);
        f1b07b = v.findViewById(R.id.f1b07b);
        f1b07c = v.findViewById(R.id.f1b07c);
        f1b07d = v.findViewById(R.id.f1b07d);
        f1b07e = v.findViewById(R.id.f1b07e);
        f1b07f = v.findViewById(R.id.f1b07f);
        f1b07g = v.findViewById(R.id.f1b07g);
        f1b07h = v.findViewById(R.id.f1b07h);
        f1b07i = v.findViewById(R.id.f1b07i);
        f1b07j = v.findViewById(R.id.f1b07j);
        f1b07k = v.findViewById(R.id.f1b07k);
        f1b07l = v.findViewById(R.id.f1b07l);
        f1b07m = v.findViewById(R.id.f1b07m);
        f1b07n = v.findViewById(R.id.f1b07n);
        f1b07o = v.findViewById(R.id.f1b07o);


        final EditText
                f1b01,
                f1b03a1,
                f1b03a2,
                f1b03a3,
                f1b03b1,
                f1b03b2,
                f1b03b3,
                f1b05x,
                f1b07ox,
                f1b08,
                f1b09;


        f1b01 = v.findViewById(R.id.f1b01);
        f1b03a1 = v.findViewById(R.id.f1b03a1);
        f1b03a2 = v.findViewById(R.id.f1b03a2);
        f1b03a3 = v.findViewById(R.id.f1b03a3);
        f1b03b1 = v.findViewById(R.id.f1b03b1);
        f1b03b2 = v.findViewById(R.id.f1b03b2);
        f1b03b3 = v.findViewById(R.id.f1b03b3);
        f1b05x = v.findViewById(R.id.f1b05x);
        f1b07ox = v.findViewById(R.id.f1b07ox);
        f1b08 = v.findViewById(R.id.f1b08);
        f1b09 = v.findViewById(R.id.f1b09);

        final CheckBox f1b08a;
        f1b08a = v.findViewById(R.id.f1b08a);

        final LinearLayout
                lvmain,
                lvf1b04,
                lvf1b08,
                lvf1b09;

        lvmain = v.findViewById(R.id.lvmain);
        lvf1b04 = v.findViewById(R.id.lvf1b04);
        lvf1b08 = v.findViewById(R.id.lvf1b08);
        lvf1b09 = v.findViewById(R.id.lvf1b09);

        //endregion


        //#region respondent validations
        if (iam_respondent == true) {
            f1b02a.setEnabled(false);
            lvf1b04.setVisibility(View.GONE);


        } else {
            lvf1b08.setVisibility(View.GONE);
            lvf1b09.setVisibility(View.GONE);
        }
        if (respondent_type == "UM") {


            f1b04a.setEnabled(false);
            f1b04b.setEnabled(false);
            f1b04c.setEnabled(false);
        } else if (respondent_type == "M") {
            f1b04e.setEnabled(false);
            f1b04f.setEnabled(false);
            f1b04g.setEnabled(false);
        } else {
            f1b04a.setEnabled(false);
        }


        //#endregion


        f1b03a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b03a.isChecked()) {
                    f1b03a1.setVisibility(View.VISIBLE);
                    f1b03a2.setVisibility(View.VISIBLE);
                    f1b03a3.setVisibility(View.VISIBLE);

                    f1b03b1.setVisibility(View.GONE);
                    f1b03b2.setVisibility(View.GONE);
                    f1b03b3.setVisibility(View.GONE);
                    f1b03b1.setText("");
                    f1b03b2.setText("");
                    f1b03b3.setText("");
                }
            }
        });


        f1b03b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b03b.isChecked()) {
                    f1b03b1.setVisibility(View.VISIBLE);
                    f1b03b2.setVisibility(View.VISIBLE);
                    f1b03b3.setVisibility(View.VISIBLE);

                    f1b03a1.setVisibility(View.GONE);
                    f1b03a2.setVisibility(View.GONE);
                    f1b03a3.setVisibility(View.GONE);

                    f1b03a1.setText("");
                    f1b03a2.setText("");
                    f1b03a3.setText("");
                }
            }
        });


        f1b05a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b05a.isChecked()) {
                    f1b05x.setVisibility(View.VISIBLE);


                }
            }
        });

        f1b05b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b05b.isChecked()) {
                    f1b05x.setVisibility(View.GONE);
                    f1b05x.setText("");

                }
            }
        });

        f1b05c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b05c.isChecked()) {
                    f1b05x.setVisibility(View.GONE);
                    f1b05x.setText("");

                }
            }
        });


        f1b07a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07a.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });

        f1b07b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07b.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07c.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07d.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07e.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07f.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07g.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07h.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07i.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07j.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07k.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07l.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07m.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });
        f1b07n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07n.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b07o.isChecked()) {
                    f1b07ox.setVisibility(View.VISIBLE);


                }
            }
        });

        f1b08a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (f1b08a.isChecked()) {
                    f1b08.setVisibility(View.GONE);
                    f1b08.setText("");
                    lvf1b09.setVisibility(View.GONE);
                    f1b09.setText("");


                } else {
                    f1b08.setVisibility(View.VISIBLE);
                    lvf1b09.setVisibility(View.VISIBLE);

                }
            }
        });


        btn_Continue = v.findViewById(R.id.btn_Continue);
        btn_End = v.findViewById(R.id.btn_End);

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ValidatorClass.EmptyCheckingContainer(F1SectionBActivity.this, lvmain)) {
                    return;
                }

                if (iam_respondent) {
                    if (f1b03a.isChecked()) {
                        if (f1b03a3.getText().toString().length() > 0) {
                            int age = Integer.parseInt(f1b03a3.getText().toString());
                            if (age > 49 || age < 14) {
                                f1b03a3.setError("Respondent age Must be Between 14 to 49 Years");
                                f1b03a3.requestFocus();
                                return;
                            }
                        } else {
                            f1b03a3.setError(null);
                            f1b03a3.clearFocus();
                        }

//                        if (f1b03a1.getText().toString().length() == 0) {
//                            f1b03a1.setError("Please Enter");
//                            f1b03a1.requestFocus();
//                            return;
//                        }
//                        if (f1b03a2.getText().toString().length() == 0) {
//                            f1b03a2.setError("Please Enter");
//                            f1b03a2.requestFocus();
//                            return;
//                        }
                    }

                    if (f1b03b.isChecked()) {
                        if (!f1b03b3.getText().toString().equals("") && f1b03b3.getText().toString().length() > 0) {
                            int age = Integer.parseInt(f1b03b3.getText().toString());
                            if (age > 2005 || age < 1970) {
                                f1b03b3.setError("Respondent age must be between 14 to 49 Years");
                                f1b03b3.requestFocus();
                                return;
                            }
                        } else {
                            f1b03b3.setError(null);
                            f1b03b3.clearFocus();
                        }

                        if (f1b03b1.getText().toString().length() == 0) {
                            f1b03b1.setError("Please Enter");
                            f1b03b1.requestFocus();
                            return;
                        } else {
                            int agee = Integer.parseInt(f1b03b1.getText().toString());
                            if (agee != 99 & agee > 30) {
                                f1b03b1.setError("Please enter 1 31 in range ");
                                f1b03b1.requestFocus();
                                return;
                            }

                        }
//                        if (f1b03b2.getText().toString().length() == 0) {
//                            f1b03b2.setError("Please Enter");
//                            f1b03b2.requestFocus();
//                            return;
//                        }
                    }

                    if (f1b06a.isChecked()) {
                        respondent_type = "UM";
                        MainApp.Respondent_is_UnMarried = true;
                    } else if (f1b06b.isChecked()) {
                        MainApp.Respondent_is_UnMarried = false;
                        respondent_type = "M";
                    } else {
                        MainApp.Respondent_is_UnMarried = false;
                        respondent_type = "others";
                    }


                }


                // at end of first memeber


                lstf1b01.add(f1b01.getText().toString());
                if (f1b02a.isChecked()) {
                    lstf1b02.add("1");
                }
                if (f1b02b.isChecked()) {
                    lstf1b02.add("2");
                }

                if (f1b03a.isChecked()) {
                    lstf1b03.add("1");

                    lstf1b03D.add(f1b03a1.getText().toString());
                    lstf1b03M.add(f1b03a2.getText().toString());
                    lstf1b03Y.add(f1b03a3.getText().toString());

                    if (f1b03a3.getText().toString().length() > 0) {
                        int age = Integer.parseInt(f1b03a3.getText().toString());
                        if (age < 2) {
                            MainApp.two_year_child = true;
                            MainApp.lst_U2.add(f1b01.getText().toString());
                        }

                        if (age < 5) {
                            MainApp.lst_U5.add(f1b01.getText().toString());

                        }
                    }
                }
                if (f1b03b.isChecked()) {
                    lstf1b03.add("2");

                    lstf1b03D.add(f1b03b1.getText().toString());
                    lstf1b03M.add(f1b03b2.getText().toString());
                    lstf1b03Y.add(f1b03b3.getText().toString());


                    if (f1b03b3.getText().toString().length() > 0) {
//                        int age = Integer.parseInt(f1b03b3.getText().toString());
                        dob = DateUtils.getCalendarDate(f1b03b1.getText().toString(), f1b03b2.getText().toString(), f1b03b3.getText().toString());
                        age = DateUtils.ageInYearByDOB(dob);
                        if (age < 2) {
                            MainApp.two_year_child = true;
                            MainApp.lst_U2.add(f1b01.getText().toString());

                        }

                        if (age < 5) {
                            MainApp.lst_U5.add(f1b01.getText().toString());

                        }
                    }
                }
                if (iam_respondent == true) {
                    lstf1b04.add("97");
                } else if (f1b04a.isChecked()) {
                    lstf1b04.add("1");
                } else if (f1b04b.isChecked()) {
                    lstf1b04.add("2");
                } else if (f1b04c.isChecked()) {
                    lstf1b04.add("3");
                } else if (f1b04d.isChecked()) {
                    lstf1b04.add("4");
                } else if (f1b04e.isChecked()) {
                    lstf1b04.add("5");
                } else if (f1b04f.isChecked()) {
                    lstf1b04.add("6");
                } else if (f1b04g.isChecked()) {
                    lstf1b04.add("7");
                } else {
                    lstf1b04.add("97");
                }
                if (f1b05a.isChecked()) {
                    lstf1b05.add(f1b05x.getText().toString());
                } else if (f1b05b.isChecked()) {
                    lstf1b05.add("0");
                } else {
                    lstf1b05.add("97");
                }


                if (f1b06a.isChecked()) {
                    lstf1b06.add("1");
                } else if (f1b06b.isChecked()) {
                    lstf1b06.add("2");
                } else if (f1b06c.isChecked()) {
                    lstf1b06.add("3");
                } else if (f1b06d.isChecked()) {
                    lstf1b06.add("4");
                } else if (f1b06e.isChecked()) {
                    lstf1b06.add("5");
                } else {
                    lstf1b06.add("97");
                }


                if (f1b07a.isChecked()) {
                    lstf1b07.add("1");
                } else if (f1b07b.isChecked()) {
                    lstf1b07.add("2");
                } else if (f1b07c.isChecked()) {
                    lstf1b07.add("3");
                } else if (f1b07d.isChecked()) {
                    lstf1b07.add("4");
                } else if (f1b07e.isChecked()) {
                    lstf1b07.add("5");
                } else if (f1b07f.isChecked()) {
                    lstf1b07.add("6");
                } else if (f1b07g.isChecked()) {
                    lstf1b07.add("7");
                } else if (f1b07h.isChecked()) {
                    lstf1b07.add("8");
                } else if (f1b07i.isChecked()) {
                    lstf1b07.add("9");
                } else if (f1b07g.isChecked()) {
                    lstf1b07.add("10");
                } else if (f1b07k.isChecked()) {
                    lstf1b07.add("11");
                } else if (f1b07l.isChecked()) {
                    lstf1b07.add("12");
                } else if (f1b07m.isChecked()) {
                    lstf1b07.add("13");
                } else if (f1b07n.isChecked()) {
                    lstf1b07.add("14");
                } else if (f1b07o.isChecked()) {
                    lstf1b07.add("97");

                }

                if (f1b07ox.getText().toString().length() > 0) {
                    lstf1b07x.add(f1b07ox.getText().toString());
                } else {
                    lstf1b07x.add("97");
                }

                if (iam_respondent == true) {
                    if (f1b08a.isChecked()) {
                        lstf1b08.add("97");
                        lstf1b09.add("97");

                    } else {
                        lstf1b08.add(f1b08.getText().toString());
                        lstf1b09.add(f1b09.getText().toString());
                    }
                } else {
                    lstf1b08.add("97");
                    lstf1b09.add("97");

                }


                bi.itextview.setText("Number of Added Members (" + lstf1b09.size() + ")");
                iam_respondent = false;


                subList.addAll(Arrays.asList(
                        lstf1b01,
                        lstf1b02,
                        lstf1b03,
                        lstf1b03D,
                        lstf1b03M,
                        lstf1b03Y,
                        lstf1b04,
                        lstf1b05,
                        lstf1b06,
                        lstf1b07,
                        lstf1b07x,
                        lstf1b08,
                        lstf1b09
                ));
//
//

                try {
                    saveDraft();
                    UpdateDB();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b.dismiss();

            }


        });

        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b.dismiss();
            }
        });


    }

    private void saveDraft() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        fmc = new FamilyMembersContract();
        fmc.setDevicetagID(sharedPref.getString("tagName", null));
        fmc.setDeviceId(MainApp.deviceId);
        fmc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        fmc.setUser(MainApp.userName);
        fmc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        fmc.setSerialNo(String.valueOf(MainApp.serial_no));
        fmc.set_UUID(fc.getDeviceID() + fc.get_ID());

        JSONObject object = new JSONObject();

        for (int i = 0; i < allQuestions.size(); i++) {
            object.put(allQuestions.get(i), subList.get(i).get(lstf1b07.size() - 1));

        }
        fmc.setF1b(String.valueOf(object));

        MainApp.serial_no++;

//        clearArray();
        subList.clear();
    }

    private void clearArray() {
        for (int i = 0; i < subList.size(); i++) {
            subList.get(i).clear();
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        // 2. UPDATE FORM ROWID
        long rowId = db.addFamilyMembers(fmc);

        if (rowId > 0) {
            fmc.set_ID(String.valueOf(rowId));
            fmc.set_UID((fmc.getDeviceId() + fmc.get_ID()));
            db.updateFamilyMemID(fmc);
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;

        }
    }

    public void BtnContinue() {
        if (lstf1b01.size() == 0) {
            Toast.makeText(F1SectionBActivity.this, "Please Enter at least  Two Member", Toast.LENGTH_LONG).show();
            return;
        }
        if (respondent_type != "UM") {
            if (MainApp.lst_U5.size() == 0) {
                Toast.makeText(F1SectionBActivity.this, "Please Add U5 Child ", Toast.LENGTH_LONG).show();
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to move to next section?");
        builder.setTitle("Alert!");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(new Intent(getApplicationContext(), F1SectionCActivity.class));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);
    }


}
