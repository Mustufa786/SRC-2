package edu.aku.hassannaqvi.src_2.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

//import edu.aku.hassannaqvi.nns_2018.contracts.dummy.A1Model;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private final String projectName = "SRC-2";
    //private final String surveyType = "SN";
    private String _ID = "";
    private String _UID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer


    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String istatusHH = ""; // HH Status

    private String sA1 = "";     // Info Section
    private String sA4 = ""; // sA4
    private String sA402 = ""; // sA4
    private String sA7 = ""; //
    private String f1 = ""; //
    private String f2 = ""; //
    private String f3 = ""; //
    private String f4 = ""; //
    private String f5 = ""; //


    private String f6 = ""; //
    private String f7 = ""; //
    private String f8 = ""; //
    private String f9 = ""; //


    private String endtime = "";
    private String count = "";
    private String respLineNo = "";

    private String clusterNo = "";
    private String hhNo = "";

    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion;
    private String sA5 = ""; //

    public FormsContract() {
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable._ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.respLineNo = jsonObject.getString(FormsTable.COLUMN_RESP_LNO);
        this.clusterNo = jsonObject.getString(FormsTable.COLUMN_CLUSTER_NO);
        this.hhNo = jsonObject.getString(FormsTable.COLUMN_HH_NO);

        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88x);
        this.istatusHH = jsonObject.getString(FormsTable.COLUMN_ISTATUSHH);
        this.gpsElev = jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.sA1 = jsonObject.getString(FormsTable.COLUMN_SA1);
        this.sA4 = jsonObject.getString(FormsTable.COLUMN_SA4);
        this.sA402 = jsonObject.getString(FormsTable.COLUMN_SA402);
        this.sA5 = jsonObject.getString(FormsTable.COLUMN_SA5);
        this.sA7 = jsonObject.getString(FormsTable.COLUMN_SA7);
        this.endtime = jsonObject.getString(FormsTable.COLUMN_END_TIME);
        this.count = jsonObject.getString(FormsTable.COLUMN_COUNT);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APP_VERSION);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable._ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.respLineNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_RESP_LNO));
        this.clusterNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CLUSTER_NO));
        this.hhNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HH_NO));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88x));
        this.istatusHH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUSHH));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        this.sA1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA1));
        this.sA4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA4));
        this.sA402 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA402));
        this.sA5 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA5));
        this.sA7 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA7));
        this.endtime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_END_TIME));
        this.count = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_COUNT));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APP_VERSION));

        // TODO:

        return this;

    }

    /*public A1Model toA1Model(String jsonStr) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonStr, A1Model.class);
    }*/

    public FormsContract Hydrate1(Cursor cursor, int type) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable._ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));

        //this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        if (type == 1 || type == 4) {
            this.sA4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA4));
        }
        if (type == 1 || type == 402) {
            this.sA4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA402));
        }
        if (type == 1 || type == 5) {
            this.sA5 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA5));
        }
        if (type == 1 || type == 7) {
            this.sA7 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA7));
        }
        if (type == 1) {
            this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
            this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
            this.respLineNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_RESP_LNO));
            this.clusterNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CLUSTER_NO));
            this.hhNo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HH_NO));
            this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
            this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88x));
            this.istatusHH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUSHH));
            this.endtime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_END_TIME));
            this.count = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_COUNT));
            this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
            this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
            this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
            this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
            this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
            this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
            this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
            this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
            this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APP_VERSION));
            this.sA1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA1));
        }


        // TODO:

        return this;

    }

    public String getRespLineNo() {
        return respLineNo;
    }

    public void setRespLineNo(String respLineNo) {
        this.respLineNo = respLineNo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }


    public String getsA1() {
        return sA1;
    }

    public void setsA1(String sA1) {
        this.sA1 = sA1;
    }


    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getsA4() {
        return sA4;
    }

    public void setsA4(String sA4) {
        this.sA4 = sA4;
    }

    public String getsA5() {

        return sA5;
    }

    public void setsA5(String sA5) {
        this.sA5 = sA5;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getClusterNo() {
        return clusterNo;
    }

    public void setClusterNo(String clusterNo) {
        this.clusterNo = clusterNo;
    }

    public String getHhNo() {
        return hhNo;
    }

    public void setHhNo(String hhNo) {
        this.hhNo = hhNo;
    }

    public String getIstatusHH() {
        return istatusHH;
    }

    public void setIstatusHH(String istatusHH) {
        this.istatusHH = istatusHH;
    }

    public String getsA402() {
        return sA402;
    }

    public void setsA402(String sA402) {
        this.sA402 = sA402;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }

    public String getF6() {
        return f6;
    }

    public void setF6(String f6) {
        this.f6 = f6;
    }

    public String getF7() {
        return f7;
    }

    public void setF7(String f7) {
        this.f7 = f7;
    }

    public String getF8() {
        return f8;
    }

    public void setF8(String f8) {
        this.f8 = f8;
    }

    public String getF9() {
        return f9;
    }

    public void setF9(String f9) {
        this.f9 = f9;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_RESP_LNO, this.respLineNo == null ? JSONObject.NULL : this.respLineNo);
        json.put(FormsTable.COLUMN_CLUSTER_NO, this.clusterNo == null ? JSONObject.NULL : this.clusterNo);
        json.put(FormsTable.COLUMN_HH_NO, this.hhNo == null ? JSONObject.NULL : this.hhNo);

        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_ISTATUSHH, this.istatusHH == null ? JSONObject.NULL : this.istatusHH);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);


        if (!this.sA1.equals("")) {

            json.put(FormsTable.COLUMN_SA1, this.sA1.equals("") ? JSONObject.NULL : new JSONObject(this.sA1));
        }


        if (!this.count.equals("")) {

            json.put(FormsTable.COLUMN_COUNT, this.count.equals("") ? JSONObject.NULL : new JSONObject(this.count));
        }


        if (!this.sA4.equals("")) {

            json.put(FormsTable.COLUMN_SA4, this.sA4.equals("") ? JSONObject.NULL : new JSONObject(this.sA4));
        }
        if (!this.sA402.equals("")) {

            json.put(FormsTable.COLUMN_SA402, this.sA402.equals("") ? JSONObject.NULL : new JSONObject(this.sA402));
        }
        if (!this.sA5.equals("")) {

            json.put(FormsTable.COLUMN_SA5, this.sA5.equals("") ? JSONObject.NULL : new JSONObject(this.sA5));
        }
        if (!this.sA7.equals("")) {

            json.put(FormsTable.COLUMN_SA7, this.sA7.equals("") ? JSONObject.NULL : new JSONObject(this.sA7));
        }
        json.put(FormsTable.COLUMN_END_TIME, this.endtime == null ? JSONObject.NULL : this.endtime);
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        /*json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);*/
        json.put(FormsTable.COLUMN_APP_VERSION, this.appversion == null ? JSONObject.NULL : this.appversion);


        return json;
    }

    public String getsA7() {
        return sA7;
    }

    public void setsA7(String sA7) {
        this.sA7 = sA7;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectname";
        public static final String _ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";
        public static final String COLUMN_ISTATUSHH = "istatusHH";

        public static final String COLUMN_SA1 = "sa1";
        public static final String COLUMN_SA4 = "sa4";
        public static final String COLUMN_SA402 = "sa402";
        public static final String COLUMN_SA5 = "sa5";
        public static final String COLUMN_SA7 = "sa7";
        public static final String COLUMN_END_TIME = "endtime";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_RESP_LNO = "resp_lno";
        public static final String COLUMN_CLUSTER_NO = "cluster_no";
        public static final String COLUMN_HH_NO = "hh_no";

        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APP_VERSION = "appversion";

        public static String _URL = "forms.php";
    }
}
