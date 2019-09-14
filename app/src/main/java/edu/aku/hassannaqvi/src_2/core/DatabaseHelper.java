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

import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.src_2.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract;
import edu.aku.hassannaqvi.src_2.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.src_2.contracts.UsersContract;
import edu.aku.hassannaqvi.src_2.contracts.UsersContract.UsersTable;


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
    private static final String SQL_DELETE_USER = "DROP TABLE IF EXISTS " + UsersTable.TABLE_NAME;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_FAMILYMEMBERS);
        db.execSQL(SQL_DELETE_USER);
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
        values.put(FormsTable.COLUMN_ISTATUSHH, fc.getIstatusHH());
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
        values.put(familyMembers.COLUMN_ENM_NO, fmc.getEnmNo());
        values.put(familyMembers.COLUMN_HH_NO, fmc.getHhNo());
        values.put(familyMembers.COLUMN_DEVICETAGID, fmc.getDevicetagID());
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