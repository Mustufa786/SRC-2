package edu.aku.hassannaqvi.src_2.ui.form1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityF1SectionBBinding;

public class F1SectionBActivity extends AppCompatActivity {


    ActivityF1SectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_f1_section_b);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_f1_section_b);
        bi.setCallback(this);

    }


    public void BtnAddMembers() {

        final AlertDialog b = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.dialog_f1_section_b_add_member, null);
        b.setView(v);
        b.show();
        b.setCancelable(false);

        Button btn_Continue, btn_End;


        btn_Continue = v.findViewById(R.id.btn_Continue);
        btn_End = v.findViewById(R.id.btn_End);

        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b.dismiss();
            }
        });


    }

    public void BtnContinue() {

    }

    public void BtnEnd() {

    }


}
