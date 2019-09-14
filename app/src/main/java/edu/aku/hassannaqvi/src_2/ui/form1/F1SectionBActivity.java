package edu.aku.hassannaqvi.src_2.ui.form1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF1SectionBBinding;
import edu.aku.hassannaqvi.src_2.validation.ValidatorClass;

public class F1SectionBActivity extends AppCompatActivity {



    ActivityF1SectionBBinding bi;
    boolean iam_respondent;
       String respondent_type="";

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_f1_section_b);

        iam_respondent=true;
        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_b);
        bi.setCallback(this);

                lstf1b01=new ArrayList<>();
                lstf1b02=new ArrayList<>();
                lstf1b03=new ArrayList<>();
                lstf1b03D=new ArrayList<>();
                lstf1b03M=new ArrayList<>();
                lstf1b03Y=new ArrayList<>();
                lstf1b04=new ArrayList<>();
                lstf1b05=new ArrayList<>();
                lstf1b06=new ArrayList<>();
                lstf1b07=new ArrayList<>();
                lstf1b07x=new ArrayList<>();
                lstf1b08=new ArrayList<>();
                lstf1b09=new ArrayList<>();

    }


    public void BtnAddMembers() {

         final AlertDialog b = new AlertDialog.Builder(this).create();


        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.dialog_f1_section_b_add_member, null);
        b.setView(v);
        b.show();
        b.setCancelable(false);

        //region Declaration
        Button btn_Continue,btn_End;
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


                f1b02a=v.findViewById(R.id.f1b02a);
                f1b02b=v.findViewById(R.id.f1b02b);
                f1b03a=v.findViewById(R.id.f1b03a);
                f1b03b=v.findViewById(R.id.f1b03b);
                f1b04a=v.findViewById(R.id.f1b04a);
                f1b04b=v.findViewById(R.id.f1b04b);
                f1b04c=v.findViewById(R.id.f1b04c);
                f1b04d=v.findViewById(R.id.f1b04d);
                f1b04e=v.findViewById(R.id.f1b04e);
                f1b04f=v.findViewById(R.id.f1b04f);
                f1b04g=v.findViewById(R.id.f1b04g);
                f1b05a=v.findViewById(R.id.f1b05a);
                f1b05b=v.findViewById(R.id.f1b05b);
                f1b05c=v.findViewById(R.id.f1b05c);
                f1b06a=v.findViewById(R.id.f1b06a);
                f1b06b=v.findViewById(R.id.f1b06b);
                f1b06c=v.findViewById(R.id.f1b06c);
                f1b06d=v.findViewById(R.id.f1b06d);
                f1b06e=v.findViewById(R.id.f1b06e);
                f1b07a=v.findViewById(R.id.f1b07a);
                f1b07b=v.findViewById(R.id.f1b07b);
                f1b07c=v.findViewById(R.id.f1b07c);
                f1b07d=v.findViewById(R.id.f1b07d);
                f1b07e=v.findViewById(R.id.f1b07e);
                f1b07f=v.findViewById(R.id.f1b07f);
                f1b07g=v.findViewById(R.id.f1b07g);
                f1b07h=v.findViewById(R.id.f1b07h);
                f1b07i=v.findViewById(R.id.f1b07i);
                f1b07j=v.findViewById(R.id.f1b07j);
                f1b07k=v.findViewById(R.id.f1b07k);
                f1b07l=v.findViewById(R.id.f1b07l);
                f1b07m=v.findViewById(R.id.f1b07m);
                f1b07n=v.findViewById(R.id.f1b07n);
                f1b07o=v.findViewById(R.id.f1b07o);


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


                f1b01=v.findViewById(R.id.  f1b01);
                f1b03a1=v.findViewById(R.id.f1b03a1);
                f1b03a2=v.findViewById(R.id.f1b03a2);
                f1b03a3=v.findViewById(R.id.f1b03a3);
                f1b03b1=v.findViewById(R.id.f1b03b1);
                f1b03b2=v.findViewById(R.id.f1b03b2);
                f1b03b3=v.findViewById(R.id.f1b03b3);
                f1b05x=v.findViewById(R.id. f1b05x);
                f1b07ox=v.findViewById(R.id.f1b07ox);
                f1b08=v.findViewById(R.id. f1b08);
                f1b09=v.findViewById(R.id.  f1b09);

               final CheckBox f1b08a;
        f1b08a=v.findViewById(R.id.f1b08a);

        final LinearLayout
                lvmain,
                lvf1b04,
                lvf1b08,
                lvf1b09;

                lvmain=v.findViewById(R.id.lvmain);
                lvf1b04=v.findViewById(R.id.lvf1b04);
                lvf1b08=v.findViewById(R.id.lvf1b08);
                lvf1b09=v.findViewById(R.id.lvf1b09);

                //endregion



        //#region respondent validations
                if (iam_respondent==true)
                {
                    f1b02a.setEnabled(false);
                    lvf1b04.setVisibility(View.GONE);



                }
                else
                {
                    lvf1b08.setVisibility(View.GONE);
                    lvf1b09.setVisibility(View.GONE);
                }
              if(respondent_type=="UM")
               {

                   f1b04a.setEnabled(false);
                   f1b04b.setEnabled(false);
                   f1b04c.setEnabled(false);
              }
              else if(respondent_type=="M")
              {
                  f1b04e.setEnabled(false);
                  f1b04f.setEnabled(false);
                  f1b04g.setEnabled(false);
              }
              else
              {
                  f1b04a.setEnabled(false);
              }



              //#endregion


        f1b03a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b03a.isChecked()) {
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

                if(f1b03b.isChecked()) {
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

                if(f1b05a.isChecked()) {
                    f1b05x.setVisibility(View.VISIBLE);


                }
            }
        });

        f1b05b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b05b.isChecked()) {
                    f1b05x.setVisibility(View.GONE);
                    f1b05x.setText("");

                }
            }
        });

        f1b05c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b05c.isChecked()) {
                    f1b05x.setVisibility(View.GONE);
                    f1b05x.setText("");

                }
            }
        });


        f1b07a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07a.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });

        f1b07b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07b.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07c.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07d.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07e.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07f.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07g.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07h.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07i.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });



        f1b07j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07j.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });



        f1b07k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07k.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });


        f1b07l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07l.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });



        f1b07m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07m.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });
        f1b07n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07n.isChecked()) {
                    f1b07ox.setVisibility(View.GONE);
                    f1b07ox.setText("");

                }
            }
        });



        f1b07o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b07o.isChecked()) {
                    f1b07ox.setVisibility(View.VISIBLE);


                }
            }
        });

        f1b08a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(f1b08a.isChecked()) {


                    f1b08.setVisibility(View.GONE);
                    f1b08.setText("");
                    lvf1b09.setVisibility(View.GONE);
                    f1b09.setText("");


                }
                else
                {
                    f1b08.setVisibility(View.VISIBLE);
                    lvf1b09.setVisibility(View.VISIBLE);

                }
            }
        });




        btn_Continue=v.findViewById(R.id.btn_Continue);
        btn_End=v.findViewById(R.id.btn_End);

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               if(!ValidatorClass.EmptyCheckingContainer(F1SectionBActivity.this,lvmain))
               {
                   return;
               }


                if (iam_respondent ==true) {

                    if(f1b03a.isChecked())
                    {
                        if(f1b03a3.getText().toString().length()>0)
                        {
                            int age=Integer.parseInt(f1b03a3.getText().toString());
                            if(age>49|| age<14)
                            {
                                f1b03a3.setError("Respondent age Muste be Between 14 to 49 Years");
                                f1b03a3.requestFocus();
                                return;
                            }
                        }
                        else
                        {
                            f1b03a3.setError("Please Enter");
                            f1b03a3.requestFocus();
                        }

                        if(f1b03a1.getText().toString().length()==0)
                        {
                            f1b03a1.setError("Please Enter");
                            f1b03a1.requestFocus();
                        }
                        if(f1b03a2.getText().toString().length()==0)
                        {
                            f1b03a2.setError("Please Enter");
                            f1b03a2.requestFocus();
                        }
                    }

                    if(f1b03b.isChecked())
                    {
                        if(f1b03b3.getText().toString().length()>0)
                        {
                            int age=Integer.parseInt(f1b03a3.getText().toString());
                            if(age>2005|| age<1970)
                            {
                                f1b03b3.setError("Respondent age Muste be Between 14 to 49 Years");
                                f1b03b3.requestFocus();
                                return;
                            }
                        }

                        else
                        {
                            f1b03b3.setError("Please Enter");
                            f1b03b3.requestFocus();
                        }

                        if(f1b03b1.getText().toString().length()==0)
                        {
                            f1b03b1.setError("Please Enter");
                            f1b03b1.requestFocus();
                        }
                        if(f1b03b2.getText().toString().length()==0)
                        {
                            f1b03b2.setError("Please Enter");
                            f1b03b2.requestFocus();
                        }
                    }

                    if(f1b06a.isChecked())
                    {
                        respondent_type="UM";
                    }
                    else if(f1b06b.isChecked())
                    {
                        respondent_type="M";
                    }
                    else
                    {
                        respondent_type="others";
                    }


                }






                // at end of first memeber


                lstf1b01.add(f1b01.getText().toString());
                if(f1b02a.isChecked())
                {
                    lstf1b02.add("1");
                }
                if(f1b02b.isChecked())
                {
                    lstf1b02.add("2");
                }

                if(f1b03a.isChecked())
                {
                    lstf1b03.add("1");
                    
                    lstf1b03D.add(f1b03a1.getText().toString());
                    lstf1b03M.add(f1b03a2.getText().toString());
                    lstf1b03Y.add(f1b03a3.getText().toString());
                }
                if(f1b03b.isChecked())
                {
                    lstf1b03.add("2");

                    lstf1b03D.add(f1b03b1.getText().toString());
                    lstf1b03M.add(f1b03b2.getText().toString());
                    lstf1b03Y.add(f1b03b3.getText().toString());
                }
                if(iam_respondent==true)
                {
                    lstf1b04.add("97");
                }
                else if(f1b04a.isChecked())
                {
                    lstf1b04.add("1");
                }
                else if(f1b04b.isChecked())
                {
                    lstf1b04.add("2");
                }
                else if(f1b04c.isChecked())
                {
                    lstf1b04.add("3");
                }
                else if(f1b04d.isChecked())
                {
                    lstf1b04.add("4");
                }
                else if(f1b04e.isChecked())
                {
                    lstf1b04.add("5");
                }
                else if(f1b04f.isChecked())
                {
                    lstf1b04.add("6");
                }
                else if(f1b04g.isChecked())
                {
                    lstf1b04.add("7");
                }
                else
                {
                    lstf1b04.add("97");
                }
                if(f1b05a.isChecked())
                {
                    lstf1b05.add(f1b05x.getText().toString());
                }
                else if(f1b05b.isChecked())
                {
                    lstf1b05.add("0");
                }
                else
                {
                    lstf1b05.add("97");
                }




                if(f1b06a.isChecked())
                {
                    lstf1b06.add("1");
                }
                else if(f1b06b.isChecked())
                {
                    lstf1b06.add("2");
                }

                else if(f1b06c.isChecked())
                {
                    lstf1b06.add("3");
                }

                else if(f1b06d.isChecked())
                {
                    lstf1b06.add("4");
                }

                else if(f1b06e.isChecked())
                {
                    lstf1b06.add("5");
                }

                else
                {
                    lstf1b06.add("97");
                }




                if(f1b07a.isChecked())
                {
                    lstf1b07.add("1");
                }
                else if(f1b07b.isChecked())
                {
                    lstf1b07.add("2");
                }

                else if(f1b07c.isChecked())
                {
                    lstf1b07.add("3");
                }

                else if(f1b07d.isChecked())
                {
                    lstf1b07.add("4");
                }

                else if(f1b07e.isChecked())
                {
                    lstf1b07.add("5");
                }

                else if(f1b07f.isChecked())
                {
                    lstf1b07.add("6");
                }
                else if(f1b07g.isChecked())
                {
                    lstf1b07.add("7");
                }
                else if(f1b07h.isChecked())
                {
                    lstf1b07.add("8");
                }
                else if(f1b07i.isChecked())
                {
                    lstf1b07.add("9");
                }
                else if(f1b07g.isChecked())
                {
                    lstf1b07.add("10");
                }
                else if(f1b07k.isChecked())
                {
                    lstf1b07.add("11");
                }
                else if(f1b07l.isChecked())
                {
                    lstf1b07.add("12");
                }
                else if(f1b07m.isChecked())
                {
                    lstf1b07.add("13");
                }
                else if(f1b07n.isChecked())
                {
                    lstf1b07.add("14");
                }
                else if(f1b07o.isChecked())
                {
                    lstf1b07.add("15");

                }


                else
                {
                    lstf1b07.add("97");
                }

                if(f1b07ox.getText().toString().length()>0) {
                    lstf1b07x.add(f1b07ox.getText().toString());
                }
                else
                {
                    lstf1b07x.add("97");
                }

                if(iam_respondent==true)
                {
                    if(f1b08a.isChecked())
                    {
                        lstf1b08.add("97");
                        lstf1b09.add("97");

                    }
                    else
                    {
                        lstf1b08.add(f1b08.getText().toString());
                        lstf1b09.add(f1b09.getText().toString());
                    }
                }
                else
                {
                    lstf1b08.add("97");
                    lstf1b09.add("97");

                }



                bi.itextview.setText("Number of Added Members ("+lstf1b09.size()+")");

                iam_respondent=false;
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

        public void BtnContinue()
        {

        }

    public void BtnEnd()
    {

    }


}
