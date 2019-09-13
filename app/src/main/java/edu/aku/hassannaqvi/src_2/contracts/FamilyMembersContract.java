package edu.aku.hassannaqvi.src_2.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FamilyMembersContract implements Serializable {

    private final String projectName = "Central Asia Stunting Initiative 2019";
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String deviceId = "";
    private String devicetagID = "";
    private String user = "";
    private String app_ver = "";

    private String serialNo = "";
    private String name = "";
    private String dob = "";
    private String age = "";
    private String ageInYear = "";
    private String na204 = "";
    private String motherId = "";
    private String sA2 = "";
    private String av = "";
    private String delflag = "";

    private String enmNo = "";
    private String hhNo = "";

    private String synced = "";
    private String syncedDate = "";

    private String motherName = "";
    private String fatherName = "";
    private String maritialStatus = "";
    private String realtionHH = "";
    private String resp = "";
    private String type = "";
    private String kishSelected = "";
    private String kishMWRASelected = "";
    private String kishAdolsSelected = "";

    public FamilyMembersContract() {
    }

    public FamilyMembersContract(FamilyMembersContract fmc) {
        this.serialNo = fmc.serialNo;
        this.name = fmc.name;
        this.ageInYear = fmc.ageInYear;
        this.na204 = fmc.na204;
        this.motherName = fmc.motherName;
        this.fatherName = fmc.fatherName;
        this.maritialStatus = fmc.maritialStatus;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getRealtionHH() {
        return realtionHH;
    }

    public void setRealtionHH(String realtionHH) {
        this.realtionHH = realtionHH;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(String maritialStatus) {
        this.maritialStatus = maritialStatus;
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

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAgeInYear() {
        return ageInYear;
    }

    public void setAgeInYear(String ageInYear) {
        this.ageInYear = ageInYear;
    }

    public String getna204() {
        return na204;
    }

    public void setna204(String na204) {
        this.na204 = na204;
    }

    public String getApp_ver() {
        return app_ver;
    }

    public void setApp_ver(String app_ver) {
        this.app_ver = app_ver;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getsA2() {
        return sA2;
    }

    public void setsA2(String sA2) {
        this.sA2 = sA2;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncedDate() {
        return syncedDate;
    }

    public void setSyncedDate(String syncedDate) {
        this.syncedDate = syncedDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getEnmNo() {
        return enmNo;
    }

    public void setEnmNo(String enmNo) {
        this.enmNo = enmNo;
    }

    public String getHhNo() {
        return hhNo;
    }

    public void setHhNo(String hhNo) {
        this.hhNo = hhNo;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getKishSelected() {
        return kishSelected;
    }

    public void setKishSelected(String kishSelected) {
        this.kishSelected = kishSelected;
    }

    public String getKishMWRASelected() {
        return kishMWRASelected;
    }

    public void setKishMWRASelected(String kishMWRASelected) {
        this.kishMWRASelected = kishMWRASelected;
    }

    public String getKishAdolsSelected() {
        return kishAdolsSelected;
    }

    public void setKishAdolsSelected(String kishAdolsSelected) {
        this.kishAdolsSelected = kishAdolsSelected;
    }

    public FamilyMembersContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(familyMembers.COLUMN_ID);
        this._UID = jsonObject.getString(familyMembers.COLUMN_UID);
        this._UUID = jsonObject.getString(familyMembers.COLUMN_UUID);
        this.formDate = jsonObject.getString(familyMembers.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(familyMembers.COLUMN_DEVICEID);
        this.user = jsonObject.getString(familyMembers.COLUMN_USER);
        this.app_ver = jsonObject.getString(familyMembers.COLUMN_APP_VERSION);
        this.sA2 = jsonObject.getString(familyMembers.COLUMN_SA2);
        this.av = jsonObject.getString(familyMembers.COLUMN_AV);
        this.hhNo = jsonObject.getString(familyMembers.COLUMN_HH_NO);
        this.enmNo = jsonObject.getString(familyMembers.COLUMN_ENM_NO);
        this.devicetagID = jsonObject.getString(familyMembers.COLUMN_DEVICETAGID);
        this.delflag = jsonObject.getString(familyMembers.COLUMN_FLAG);
        this.kishSelected = jsonObject.getString(familyMembers.COLUMN_KISH_SELECTED);
        this.kishMWRASelected = jsonObject.getString(familyMembers.COLUMN_KISH_SELECTED_MWRA_D);
        this.kishAdolsSelected = jsonObject.getString(familyMembers.COLUMN_KISH_SELECTED_ADOLESCENT);

        return this;

    }

    public FamilyMembersContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_USER));
        this.app_ver = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_APP_VERSION));
        this.sA2 = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_SA2));
        this.av = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_AV));
        this.enmNo = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_ENM_NO));
        this.hhNo = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_HH_NO));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICETAGID));
        this.delflag = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_FLAG));
        this.kishSelected = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_KISH_SELECTED));
        this.kishMWRASelected = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_KISH_SELECTED_MWRA_D));
        this.kishAdolsSelected = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_KISH_SELECTED_ADOLESCENT));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(familyMembers.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(familyMembers.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(familyMembers.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(familyMembers.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(familyMembers.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(familyMembers.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(familyMembers.COLUMN_ENM_NO, this.enmNo == null ? JSONObject.NULL : this.enmNo);
        json.put(familyMembers.COLUMN_HH_NO, this.hhNo == null ? JSONObject.NULL : this.hhNo);
        json.put(familyMembers.COLUMN_APP_VERSION, this.app_ver == null ? JSONObject.NULL : this.app_ver);
        json.put(familyMembers.COLUMN_AV, this.av == null ? JSONObject.NULL : this.av);
        json.put(familyMembers.COLUMN_FLAG, this.delflag == null ? JSONObject.NULL : this.delflag);
        json.put(familyMembers.COLUMN_KISH_SELECTED, this.kishSelected == null ? JSONObject.NULL : this.kishSelected);
        json.put(familyMembers.COLUMN_KISH_SELECTED_MWRA_D, this.kishMWRASelected == null ? JSONObject.NULL : this.kishMWRASelected);
//        json.put(familyMembers.COLUMN_KISH_SELECTED_ADOLESCENT, this.kishAdolsSelected == null ? JSONObject.NULL : this.kishAdolsSelected);
        if (this.sA2 != null && !this.sA2.equals("")) {
            json.put(familyMembers.COLUMN_SA2, this.sA2.equals("") ? JSONObject.NULL : new JSONObject(this.sA2));
        }

        json.put(familyMembers.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(familyMembers.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);


        return json;
    }

    public static abstract class familyMembers implements BaseColumns {

        public static final String TABLE_NAME = "familymembers";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_APP_VERSION = "app_ver";

        public static final String COLUMN_SA2 = "sA2";
        public static final String COLUMN_ENM_NO = "cluster_no";
        public static final String COLUMN_HH_NO = "hh_no";
        public static final String COLUMN_AV = "av";
        public static final String COLUMN_FLAG = "delflag";
        public static final String COLUMN_KISH_SELECTED = "kish_sel";
        public static final String COLUMN_KISH_SELECTED_MWRA_D = "kish_sel_mwra";
        public static final String COLUMN_KISH_SELECTED_ADOLESCENT = "kish_sel_adols";

        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";

        public static String _URL = "familymembers.php";
        public static String _URI = "getfamilymembers.php";
    }
}
