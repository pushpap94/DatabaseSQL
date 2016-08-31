package hp.test.com.databasesql;

import android.provider.BaseColumns;

/**
 * Created by latha on 30-08-2016.
 */
public final class TableData {

    private TableData(){

    }

    public static class TableInfo implements BaseColumns {

        public static final String USER_NAME= "user_name";
        public static final String USER_PASS= "user_pass";
        public static final String DATABASE_NAME= "user_info";
        public static final String TABLE_NAME= "reg_info";



    }
}
