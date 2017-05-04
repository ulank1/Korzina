package kg.putinbyte.korzina.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import kg.putinbyte.korzina.Serializable.Product;

/**
 * Created by Oma on 04.05.2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mydatabase.db";
    public static final String TABLE_PRODUCT = "Product";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_IMAGE = "image";



    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_PRODUCT + "(" +
                BaseColumns._ID + " integer primary key autoincrement," +
                 PRODUCT_NAME + " text," +
                 PRODUCT_IMAGE + " text," +

                PRODUCT_PRICE + " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public Cursor getProduct() {
        return getReadableDatabase().query(TABLE_PRODUCT,
                null, null, null,
                null, null, null);
    }

    public void addProduct(Product product) {
        ContentValues values = new ContentValues();

        values.put(PRODUCT_IMAGE, product.getImage());
        values.put(PRODUCT_NAME,product.getName());
        values.put(PRODUCT_PRICE,product.getPrice());


        getWritableDatabase().insert(TABLE_PRODUCT, null, values);

    }

    public void deletePruduct() {
        getWritableDatabase().delete(TABLE_PRODUCT, null, null);
    }
    public void deleteProductById(long id) {
        getWritableDatabase().delete(TABLE_PRODUCT, BaseColumns._ID + " = " + id, null);
    }









}