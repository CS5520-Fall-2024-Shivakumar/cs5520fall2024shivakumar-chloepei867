package com.example.numad24fa_zhiyanpei;

public class Constants {
    public static final String DATABASE_NAME = "CONTACT_DB";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "CONTACT_TABLE";

    //query for creating table
    public static final String C_ID = "ID";
    public static final String C_NAME = "NAME";
    public static final String C_PHONE = "PHONE";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( "
            + C_ID + " ID, "
            + C_NAME + " TEXT, "
            + C_PHONE + " TEXT"
            + " );";
}
