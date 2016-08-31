package hp.test.com.databasesql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by latha on 30-08-2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;

    public String CREATE_QUERY = "CREATE TABLE"+ TableData.TableInfo.TABLE_NAME + " (" + TableData.TableInfo.USER_NAME + " TEXT," + TableData.TableInfo.USER_PASS + " TEXT );";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(DatabaseOperations dop, String name, String pass) {

        SQLiteDatabase sqLiteDatabase = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, name);
        cv.put(TableData.TableInfo.USER_PASS, pass);
        long k = sqLiteDatabase.insert(TableData.TableInfo.TABLE_NAME, null, cv);
    }


    public Cursor getInformation(DatabaseOperations dop) {

        SQLiteDatabase sqLiteDatabase = dop.getReadableDatabase();

        String[] coloumns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};

        Cursor CR = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME, coloumns, null, null, null, null, null);

        return CR;
    }

    public Cursor getUserPass(DatabaseOperations Dop, String user) {

        SQLiteDatabase sqLiteDatabase = Dop.getReadableDatabase();
        String selection = TableData.TableInfo.USER_NAME + "LIKE ?";
        String[] coloumns = {TableData.TableInfo.USER_PASS};
        String[] args = {user};
        Cursor CR = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME, coloumns, selection, args, null, null, null);
        return CR;
    }

    public void deleteUser(DatabaseOperations Dop, String user, String pass) {

        String selection = TableData.TableInfo.USER_NAME + "LIKE ? AND " + TableData.TableInfo.USER_PASS + " LIKE ?";
        String coloumns[] = {TableData.TableInfo.USER_PASS};
        String args[] = {user, pass};
        SQLiteDatabase sqLiteDatabase = Dop.getWritableDatabase();
        sqLiteDatabase.delete(TableData.TableInfo.TABLE_NAME, selection, args);
    }

    public void updateUserInfo(DatabaseOperations Dop, String user, String pass, String newusername){
        SQLiteDatabase sqLiteDatabase=Dop.getWritableDatabase();
        String selection = TableData.TableInfo.USER_NAME+"LIKE ? AND"+ TableData.TableInfo.USER_PASS +"LIKE ?";
        String args[]={user, pass};
        ContentValues values = new ContentValues();
        values.put(TableData.TableInfo.USER_NAME, newusername);
        sqLiteDatabase.update(TableData.TableInfo.TABLE_NAME, values, selection, args);




    }


}