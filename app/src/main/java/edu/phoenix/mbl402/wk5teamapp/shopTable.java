package edu.phoenix.mbl402.wk5teamapp;

public class shopTable {

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "productId";
    public static final String COLUMN_ITEM_NAME = "itemName";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_IMAGE = "image";


    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_ITEM_NAME, COLUMN_DESCRIPTION, COLUMN_PRICE,COLUMN_IMAGE};

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_ITEMS + "(" +
            COLUMN_ID + " TEXT PRIMARY KEY," +
            COLUMN_ITEM_NAME + " TEXT," +
            COLUMN_DESCRIPTION + " TEXT," +
            COLUMN_PRICE + " REAL" +
            COLUMN_IMAGE + " TEXT" + ");";
    public static final String SQL_DELETE = "DROP TABLE " + TABLE_ITEMS;
}
