package com.example.paul.keepandsavemoney.constants;

import android.os.Environment;

import static com.example.paul.keepandsavemoney.R.string.app_name;
import static com.example.paul.keepandsavemoney.constants.Constants.APP_PACKAGE_NAME;

/**
 * Created by paul on 14.12.16.
 */

public class SQLiteConstants {

    public static final String DB_NAME = String.valueOf(app_name);
    private static final int DB_VERSION = 1;

    //currency
    public static final String CURRENCY_TABLE_NAME = "currency";
    public static final String CURRENCY_KEY_ABBREVIATION = "abbreviation";
    public static final String CURRENCY_KEY_SCALE = "scale";
    public static final String CURRENCY_KEY_NAME = "name";
    public static final String CURRENCY_KEY_RATE = "officialRate";

//    public static final String


    public static final String DB_FILE_DIRECTOEY = String.format("%s/DATA/data/%s/databases/%s.db.", Environment.getDataDirectory(), APP_PACKAGE_NAME, DB_NAME);

}
