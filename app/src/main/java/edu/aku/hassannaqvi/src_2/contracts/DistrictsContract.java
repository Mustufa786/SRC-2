package edu.aku.hassannaqvi.src_2.contracts;

/**
 * Created by isd on 30/12/2016.
 */

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by isd on 20/10/2016.
 */
public class DistrictsContract {

    private String districtCode;
    private String districtName;

    public DistrictsContract() {
    }

    public DistrictsContract sync(JSONObject jsonObject) throws JSONException {
        this.districtCode = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_NAME);

        return this;
    }

    public DistrictsContract hydrate(Cursor cursor) {
        this.districtCode = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_NAME));

        return this;
    }

    public DistrictsContract setDefaultVal(String code, String name) {
        this.districtCode = code;
        this.districtName = name;

        return this;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public static abstract class singleDistrict implements BaseColumns {

        public static final String TABLE_NAME = "Districts";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_DISTRICT_CODE = "district_code";
        public static final String COLUMN_DISTRICT_NAME = "district";

        public static final String _URI = "districts.php";

    }

}