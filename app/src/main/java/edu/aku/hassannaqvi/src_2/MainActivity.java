package edu.aku.hassannaqvi.src_2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.aku.hassannaqvi.src_2.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.src_2.ui.form1.F1SectionAActivity;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);


    }


    public void openForm() {

        startActivity(new Intent(MainActivity.this, F1SectionAActivity.class));
    }
}
