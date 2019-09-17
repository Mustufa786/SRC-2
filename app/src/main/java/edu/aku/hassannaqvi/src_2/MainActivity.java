package edu.aku.hassannaqvi.src_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Collection;

import edu.aku.hassannaqvi.src_2.contracts.FormsContract;
import edu.aku.hassannaqvi.src_2.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.src_2.core.DatabaseHelper;
import edu.aku.hassannaqvi.src_2.core.MainApp;
import edu.aku.hassannaqvi.src_2.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.src_2.ui.SyncActivity;
import edu.aku.hassannaqvi.src_2.ui.form1.F1SectionAActivity;
import edu.aku.hassannaqvi.src_2.util.Util;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding bi;
    SharedPreferences sharedPref;
    DatabaseHelper db;
    private String rSumText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        if (MainApp.admin) {
            bi.databaseBtn.setVisibility(View.VISIBLE);
        } else {
            bi.databaseBtn.setVisibility(View.GONE);
        }


        db = new DatabaseHelper(this);
        Collection<FormsContract> todaysForms = db.getTodayForms();
        Collection<FormsContract> unsyncedForms = db.getUnsyncedForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";
        rSumText += "=======================\r\n";
        rSumText += "\r\n";
        rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
        rSumText += "Unsynced Forms: " + unsyncedForms.size() + "\r\n";
        rSumText += "\r\n";
        if (todaysForms.size() > 0) {
            rSumText += "\tFORMS' LIST: \r\n";
            String iStatus;
            rSumText += "--------------------------------------------------\r\n";
            rSumText += "[ FORM_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
            rSumText += "--------------------------------------------------\r\n";

            for (FormsContract fc : todaysForms) {
                if (fc.getIstatus() != null) {
                    switch (fc.getIstatus()) {
                        case "1":
                            iStatus = "\tComplete";
                            break;
                        case "2":
                            iStatus = "\tIncomplete";
                            break;
                        case "3":
                            iStatus = "\tRefused";
                            break;
                        case "4":
                            iStatus = "\tRefused";
                            break;
                        default:
                            iStatus = "\tN/A";
                    }
                } else {
                    iStatus = "\tN/A";
                }

                rSumText += fc.get_ID();

                rSumText += " " + iStatus + " ";

                rSumText += (fc.getSynced() == null ? "\t\tNot Synced" : "\t\tSynced");
                rSumText += "\r\n";
                rSumText += "--------------------------------------------------\r\n";
            }
        }
        if (MainApp.admin) {
            bi.databaseBtn.setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
            rSumText += "\r\n";
            rSumText += "\r\n";
            rSumText += "\r\n";

        }
        bi.recordSummary.setText(rSumText);

    }

    public void onSyncServer() {

        startActivity(new Intent(this, SyncActivity.class));
//        ConnectivityManager connMgr = (ConnectivityManager)
//                getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()) {
//
//            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
//            new SyncAllData(
//                    this,
//                    "Forms",
//                    "updateSyncedForms",
//                    FormsContract.class,
//                    MainApp._HOST_URL + FormsContract.FormsTable._URL,
//                    db.getUnsyncedForms()
//            ).execute();
//            Toast.makeText(getApplicationContext(), "Syncing Family Members", Toast.LENGTH_SHORT).show();
//            new SyncAllData(
//                    this,
//                    "Family Members",
//                    "updateSyncedFamilyMembers",
//                    FormsContract.class,
//                    MainApp._HOST_URL + FamilyMembersContract.familyMembers._URL,
//                    db.getUnsyncedFamilyMember()
//            ).execute();
//        } else {
//            Toast.makeText(this, "Internet is not available", Toast.LENGTH_SHORT).show();
//        }
    }

    public void openForm() {
        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            startActivity(new Intent(MainActivity.this, F1SectionAActivity.class));
        } else {
            Util.showTagDialog(this);
        }
    }


    public void openDatabaseManager() {
        startActivity(new Intent(this, AndroidDatabaseManager.class));
    }
}
