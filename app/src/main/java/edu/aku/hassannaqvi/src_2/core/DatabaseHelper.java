package edu.aku.hassannaqvi.src_2.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.src_2.contracts.DistrictsContract;
import edu.aku.hassannaqvi.src_2.contracts.DistrictsContract.singleDistrict;
import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.src_2.contracts.UsersContract;
import edu.aku.hassannaqvi.src_2.contracts.UsersContract.UsersTable;
import edu.aku.hassannaqvi.src_2.contracts.VillagesContract;
import edu.aku.hassannaqvi.src_2.contracts.VillagesContract.singleVillages;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "src_2.db";
    public static final String PROJECT_NAME = "src_2";
    private static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_" + MainApp.versionName + "_" + DATABASE_VERSION + "_copy.");


    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersTable.TABLE_NAME + "("
            + UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.ROW_USERNAME + " TEXT,"
            + UsersTable.ROW_PASSWORD + " TEXT"
            + " ) ;";
    public static final String SQL_CREATE_UCS = "CREATE TABLE " + singleDistrict.TABLE_NAME + "("
            + singleDistrict._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleDistrict.COLUMN_DISTRICT_NAME + " TEXT,"
            + singleDistrict.COLUMN_DISTRICT_CODE + " TEXT"
            + " ) ;";
    public static final String SQL_CREATE_VILLAGES = "CREATE TABLE " + singleVillages.TABLE_NAME + "("
            + singleVillages._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleVillages.COLUMN_VILLAGES_NAME + " TEXT,"
            + singleVillages.COLUMN_VILLAGES_CODE + " TEXT,"
            + singleVillages.COLUMN_DISTRICT_CODE + " TEXT"
            + " ) ;";


    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_UC_ID + " TEXT," +
            FormsTable.COLUMN_village_ID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_HH_NO + " TEXT," +
            FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsTable.COLUMN_F1 + " TEXT," +
            FormsTable.COLUMN_F2 + " TEXT," +
            FormsTable.COLUMN_F3 + " TEXT," +
            FormsTable.COLUMN_F4 + " TEXT," +
            FormsTable.COLUMN_F5 + " TEXT," +
            FormsTable.COLUMN_F6 + " TEXT," +
            FormsTable.COLUMN_F7 + " TEXT," +
            FormsTable.COLUMN_F8 + " TEXT," +
            FormsTable.COLUMN_F9 + " TEXT," +
            FormsTable.COLUMN_END_TIME + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88x + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_GPSTIME + " TEXT," +
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
            familyMembers.COLUMN_F1B + " TEXT," +
            familyMembers.COLUMN_DEVICEID + " TEXT," +
            familyMembers.COLUMN_DEVICETAGID + " TEXT," +
            familyMembers.COLUMN_APP_VERSION + " TEXT," +
            familyMembers.COLUMN_SYNCED + " TEXT," +
            familyMembers.COLUMN_SYNCED_DATE + " TEXT"
            + " );";


    private static final String SQL_DELETE_FORMS = "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;
    private static final String SQL_DELETE_FAMILYMEMBERS = "DROP TABLE IF EXISTS " + familyMembers.TABLE_NAME;
    private static final String SQL_DELETE_USER = "DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + singleDistrict.TABLE_NAME;
    private static final String SQL_DELETE_VILLAGES = "DROP TABLE IF EXISTS " + singleVillages.TABLE_NAME;

    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_FAMILY_MEMEBERS);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_UCS);
        db.execSQL(SQL_CREATE_VILLAGES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_FAMILYMEMBERS);
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_UCS);
        db.execSQL(SQL_DELETE_VILLAGES);
    }

    public List<DistrictsContract> getDistrictList() {
        List<DistrictsContract> formList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + singleDistrict.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                DistrictsContract fc = new DistrictsContract();
                fc.setDistrictCode(c.getString(c.getColumnIndex(singleDistrict.COLUMN_DISTRICT_CODE)));
                fc.setDistrictName(c.getString(c.getColumnIndex(singleDistrict.COLUMN_DISTRICT_NAME)));
                formList.add(fc.hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public List<VillagesContract> getVillages(String id) {
        List<VillagesContract> formList = new ArrayList<>();

        String[] columns = {
                singleVillages.COLUMN_VILLAGES_NAME,
                singleVillages.COLUMN_VILLAGES_CODE
        };
        String selection = singleVillages.COLUMN_DISTRICT_CODE + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        String orderBy =
                singleVillages.COLUMN_VILLAGES_NAME + " COLLATE NOCASE ASC;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(
                singleVillages.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                orderBy);

        if (c.moveToFirst()) {
            do {
                VillagesContract fc = new VillagesContract();
//                fc.setHf_name(c.getString(c.getColumnIndex(singleHF.COLUMN_HF_NAME)));
//                fc.setHf_uen_code(c.getLong(c.getColumnIndex(singleHF.COLUMN_HF_UEN_CODE)));
                formList.add(fc.hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.getUID());
        values.put(FormsTable.COLUMN_UC_ID, fc.getUc());
        values.put(FormsTable.COLUMN_village_ID, fc.getVillage());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_HH_NO, fc.getHhNo());
        values.put(FormsTable.COLUMN_F1, fc.getF1());
        values.put(FormsTable.COLUMN_F2, fc.getF2());
        values.put(FormsTable.COLUMN_F3, fc.getF3());
        values.put(FormsTable.COLUMN_F4, fc.getF4());
        values.put(FormsTable.COLUMN_F5, fc.getF5());
        values.put(FormsTable.COLUMN_F6, fc.getF6());
        values.put(FormsTable.COLUMN_F7, fc.getF7());
        values.put(FormsTable.COLUMN_F8, fc.getF8());
        values.put(FormsTable.COLUMN_F9, fc.getF9());
        values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsTable.COLUMN_GPSTIME, fc.getGpsElev());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_APP_VERSION, fc.getAppversion());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
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
        values.put(familyMembers.COLUMN_DEVICETAGID, fmc.getDevicetagID());
        values.put(familyMembers.COLUMN_F1B, fmc.getF1b());
        values.put(familyMembers.COLUMN_DEVICEID, fmc.getDeviceId());
        values.put(familyMembers.COLUMN_SYNCED, fmc.getSynced());
        values.put(familyMembers.COLUMN_SYNCED_DATE, fmc.getSyncedDate());
        values.put(familyMembers.COLUMN_APP_VERSION, fmc.getApp_ver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                familyMembers.TABLE_NAME,
                familyMembers.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Collection<FormsContract> getTodayForms() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_UC_ID,
                FormsTable.COLUMN_village_ID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_END_TIME,
                FormsTable.COLUMN_F1,
                FormsTable.COLUMN_F2,
                FormsTable.COLUMN_F3,
                FormsTable.COLUMN_F4,
                FormsTable.COLUMN_F5,
                FormsTable.COLUMN_F6,
                FormsTable.COLUMN_F7,
                FormsTable.COLUMN_F8,
                FormsTable.COLUMN_F9,
                FormsTable.COLUMN_HH_NO,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSELEV,
                FormsTable.COLUMN_GPSTIME,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APP_VERSION,
        };

        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> formList = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return formList;
    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_UC_ID,
                FormsTable.COLUMN_village_ID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_END_TIME,
                FormsTable.COLUMN_F1,
                FormsTable.COLUMN_F2,
                FormsTable.COLUMN_F3,
                FormsTable.COLUMN_F4,
                FormsTable.COLUMN_F5,
                FormsTable.COLUMN_F6,
                FormsTable.COLUMN_F7,
                FormsTable.COLUMN_F8,
                FormsTable.COLUMN_F9,
                FormsTable.COLUMN_HH_NO,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSELEV,
                FormsTable.COLUMN_GPSTIME,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APP_VERSION,
        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public int updatesF1() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F1, MainApp.fc.getF1());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF2() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F2, MainApp.fc.getF2());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF3() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F3, MainApp.fc.getF3());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF4() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F4, MainApp.fc.getF4());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF5() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F5, MainApp.fc.getF5());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF6() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F6, MainApp.fc.getF6());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF7() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F7, MainApp.fc.getF7());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF8() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F8, MainApp.fc.getF8());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updatesF9() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_F9, MainApp.fc.getF9());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
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

    public int updateFormID(FormsContract fc) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =?";
        String[] selectionArgs = {String.valueOf(fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateFamilyMemID(FamilyMembersContract fmc) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(familyMembers.COLUMN_UID, fmc.get_UID());

// Which row to update, based on the ID
        String selection = familyMembers._ID + " =?";
        String[] selectionArgs = {String.valueOf(fmc.get_ID())};

        int count = db.update(familyMembers.TABLE_NAME,
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

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.ROW_USERNAME, user.getUserName());
                values.put(UsersTable.ROW_PASSWORD, user.getPassword());
                db.insert(UsersTable.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public void syncUcs(JSONArray ucslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = ucslist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                DistrictsContract user = new DistrictsContract();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(DistrictsContract.singleDistrict.COLUMN_DISTRICT_NAME, user.getDistrictName());
                values.put(DistrictsContract.singleDistrict.COLUMN_DISTRICT_CODE, user.getDistrictCode());

                db.insert(DistrictsContract.singleDistrict.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public void syncVillages(JSONArray villages) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = villages;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                VillagesContract user = new VillagesContract();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(VillagesContract.singleVillages.COLUMN_VILLAGES_NAME, user.getVILLAGESName());
                values.put(VillagesContract.singleVillages.COLUMN_VILLAGES_CODE, user.getVILLAGESCode());
                values.put(VillagesContract.singleVillages.COLUMN_DISTRICT_CODE, user.getDistrictCode());
                db.insert(VillagesContract.singleVillages.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public boolean Login(String username, String password) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        String[] columns = {
                UsersTable._ID,
                UsersTable.ROW_USERNAME,
                UsersTable.ROW_PASSWORD
        };

// Which row to update, based on the ID
        String selection = UsersContract.UsersTable.ROW_USERNAME + " = ?" + " AND " + UsersContract.UsersTable.ROW_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(UsersContract.UsersTable.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        /*cursor.close();
        db.close();
        return cursorCount > 0;*/

        if (cursorCount > 0) {
            cursor.moveToFirst();
            MainApp.usersContract = new UsersContract().Hydrate(cursor);
            return true;
        }

        return false;
    }


}