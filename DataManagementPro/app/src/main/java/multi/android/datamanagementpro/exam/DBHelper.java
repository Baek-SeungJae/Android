package multi.android.datamanagementpro.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 2;
    public DBHelper(Context context) {
        super(context, "product.db", null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("dbtest","데이터베이스가 생성 되었습니다.");
        String sql = "create table product("
                + "_id integer primary key autoincrement,"
                + "name text not null, "
                + "price integer not null, "
                + "su integer not null, "
                + "totPrice integer not null)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("dbtest","데이터베이스가 업데이트 되었습니다.\noldVersion: "+oldVersion+"\nnewVersion: "+newVersion);
    }
}
