package sim.ssn.com.servicealarmclockapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class TestDB extends SQLiteOpenHelper {

    private static int VERSION = 1;

    private static final String DATABASE_NAME = "test.db";
    private static final String TABLE_TEST = "TestTable";
    public static final String DROP_TABLE_TEST = //
            "DROP TABLE IF EXISTS " + TABLE_TEST;
    private static final String _ID = "_id";
    private static final String _STRING = "_id_project";

    public static final String CREATE_TABLE_TEST = //
            "CREATE TABLE "//
                    + TABLE_TEST + "("
                    + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " //
                    + _STRING + " TEXT" +
                    ");";
    private final String TAG = TestDB.class.getSimpleName();
    private String oldCardObjectString = "";

    public TestDB(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "DB UPGRADE: From version " + oldVersion + " to " + newVersion + ".");
        db.execSQL(DROP_TABLE_TEST);
        this.onCreate(db);
    }

    public void add(String string) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(_STRING, string);

        long id = db.insert(TABLE_TEST,
                null,
                values);

        Log.d(TAG, "String:" + "ADD [" + string + "]");
        db.close();
    }

    public void delete(String string) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEST,
                _STRING + " = ?",
                new String[]{string});
        Log.d(TAG, "DELETE [" + string + "]");
    }

    public void deleteALL(){
        List<String> strings = getALL();
        for(String string : strings){
            delete(string);
        }
    }

    public List<String> getALL() {
        List<String> strings = new LinkedList<>();
        String query = "SELECT  * FROM " + TABLE_TEST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String string = cursor.getString(cursor.getColumnIndex(_STRING));
                strings.add(string);

            } while (cursor.moveToNext());
        }

        Log.d(TAG, "Count [" + strings.size() + "] - " + strings);
        return strings;
    }
}
