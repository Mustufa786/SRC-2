package edu.aku.hassannaqvi.src_2.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import edu.aku.hassannaqvi.src_2.MainActivity;
import edu.aku.hassannaqvi.src_2.R;
import edu.aku.hassannaqvi.src_2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {


    ActivityLoginBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_login);
        bi.setCallback(this);


    }


    public void syncData() {


    }

    public void login() {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }
}
