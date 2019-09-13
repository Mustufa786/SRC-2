package edu.aku.hassannaqvi.src_2.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract.FormsTable;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "src_2.db";
    public static final String PROJECT_NAME = "src_2";
    private static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_" + MainApp.versionName + "_" + DATABASE_VERSION + "_copy.");


    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_RESP_LNO + " TEXT," +
            FormsTable.COLUMN_HH_NO + " TEXT," +
            FormsTable.COLUMN_CLUSTER_NO + " TEXT," +
            FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsTable.COLUMN_SA1 + " TEXT," +
            FormsTable.COLUMN_SA4 + " TEXT," +
            FormsTable.COLUMN_SA402 + " TEXT," +
            FormsTable.COLUMN_SA5 + " TEXT," +
            FormsTable.COLUMN_SA7 + " TEXT," +
            FormsTable.COLUMN_END_TIME + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88x + " TEXT," +
            FormsTable.COLUMN_ISTATUSHH + " TEXT," +
            FormsTable.COLUMN_COUNT + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_APP_VERSION + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    private static final String SQL_CREATE_FAMILY_MEMEBERS = "CREATE TABLE "
            + familyMembers.TABLE_NAME + "("
            + familyMembers.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + familyMembers.COLUMN_PROJECT_NAME + " TEXT,"
            + familyMembers.COLUMN_UID + " TEXT UNIQUE," +
            familyMembers.COLUMN_UUID + " TEXT," +
            familyMembers.COLUMN_FORMDATE + " TEXT," +
            familyMembers.COLUMN_USER + " TEXT," +
            familyMembers.COLUMN_SA2 + " TEXT," +
            familyMembers.COLUMN_ENM_NO + " TEXT," +
            familyMembers.COLUMN_HH_NO + " TEXT," +
            familyMembers.COLUMN_AV + " TEXT," +
            familyMembers.COLUMN_KISH_SELECTED + " TEXT," +
            familyMembers.COLUMN_KISH_SELECTED_MWRA_D + " TEXT," +
            familyMembers.COLUMN_KISH_SELECTED_ADOLESCENT + " TEXT," +
            familyMembers.COLUMN_DEVICEID + " TEXT," +
            familyMembers.COLUMN_DEVICETAGID + " TEXT," +
            familyMembers.COLUMN_APP_VERSION + " TEXT," +
            familyMembers.COLUMN_SYNCED + " TEXT," +
            familyMembers.COLUMN_SYNCED_DATE + " TEXT," +
            familyMembers.COLUMN_FLAG + " TEXT"
            + " );";


    private static final String SQL_DELETE_FORMS = "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;
    private static final String SQL_DELETE_FAMILYMEMBERS = "DROP TABLE IF EXISTS " + familyMembers.TABLE_NAME;

    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_FORMS);

        db.execSQL(SQL_CREATE_FAMILY_MEMEBERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_FAMILYMEMBERS);
    }

    public Long addForm(FormsContract fc, int type) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        if (type == 0) {
            values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
            values.put(FormsTable.COLUMN_UID, fc.getUID());
            values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
            values.put(FormsTable.COLUMN_USER, fc.getUser());
            values.put(FormsTable.COLUMN_RESP_LNO, fc.getRespLineNo());
            values.put(FormsTable.COLUMN_CLUSTER_NO, fc.getClusterNo());
            values.put(FormsTable.COLUMN_HH_NO, fc.getHhNo());
            values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
            values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
            values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
            values.put(FormsTable.COLUMN_ISTATUSHH, fc.getIstatusHH());

            //values.put(FormsTable.COLUMN_END_TIME, fc.getEndtime());
            values.put(FormsTable.COLUMN_COUNT, fc.getCount());
            values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
            values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
            values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
            values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
            values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
            values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
            values.put(FormsTable.COLUMN_APP_VERSION, fc.getAppversion());
        }
        if (type == 0 || type == 1) {
            values.put(FormsTable.COLUMN_SA1, fc.getsA1());
        }
        if (type == 0 || type == 4) {
            values.put(FormsTable.COLUMN_SA4, fc.getsA4());
        }
        if (type == 0 || type == 4) {
            values.put(FormsTable.COLUMN_SA402, fc.getsA402());
        }
        if (type == 0 || type == 5) {
            values.put(FormsTable.COLUMN_SA5, fc.getsA5());
        }
        if (type == 0 || type == 7) {
            values.put(FormsTable.COLUMN_SA7, fc.getsA7());
        }

        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        if (type == 0) {
            newRowId = db.insert(
                    FormsTable.TABLE_NAME,
                    FormsTable.COLUMN_NAME_NULLABLE,
                    values);
        } else {
            newRowId = db.update(
                    FormsTable.TABLE_NAME,
                    values,
                    FormsTable.COLUMN_UID + " = ?",
                    new String[]{fc.getUID()}
            );
        }
        return newRowId;
    }

    public Long addFamilyMembers(FamilyMembersContract fmc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(familyMembers.COLUMN_PROJECT_NAME, fmc.getProjectName());
        values.put(familyMembers.COLUMN_UID, fmc.get_UID());
        values.put(familyMembers.COLUMN_UUID, fmc.get_UUID());
        values.put(familyMembers.COLUMN_FORMDATE, fmc.getFormDate());
        values.put(familyMembers.COLUMN_USER, fmc.getUser());
        values.put(familyMembers.COLUMN_ENM_NO, fmc.getEnmNo());
        values.put(familyMembers.COLUMN_HH_NO, fmc.getHhNo());
        values.put(familyMembers.COLUMN_DEVICETAGID, fmc.getDevicetagID());
        values.put(familyMembers.COLUMN_DEVICEID, fmc.getDeviceId());
        values.put(familyMembers.COLUMN_SYNCED, fmc.getSynced());
        values.put(familyMembers.COLUMN_SYNCED_DATE, fmc.getSyncedDate());
        values.put(familyMembers.COLUMN_APP_VERSION, fmc.getApp_ver());
        values.put(familyMembers.COLUMN_FLAG, fmc.getDelflag());
        values.put(familyMembers.COLUMN_KISH_SELECTED, fmc.getKishSelected());
        values.put(familyMembers.COLUMN_KISH_SELECTED_ADOLESCENT, fmc.getKishAdolsSelected());
        values.put(familyMembers.COLUMN_KISH_SELECTED_MWRA_D, fmc.getKishMWRASelected());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                familyMembers.TABLE_NAME,
                familyMembers.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.getIstatus88x());
        values.put(FormsTable.COLUMN_END_TIME, MainApp.fc.getEndtime());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

}