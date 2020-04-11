package multi.android.datamanagementpro.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import multi.android.datamanagementpro.R;

public class DBHandler {
    static DBHelper dbHelper;
    static SQLiteDatabase db;

    public static DBHandler open(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return new DBHandler();
    }

    public void insert(View v, String name, String price, String quantity) {
        if (name.equals("") || price.equals("") || quantity.equals("")) {
            Toast.makeText(v.getContext(), "데이터를 정확히 입력하세요.", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("price", Integer.parseInt(price));
            contentValues.put("quantity", Integer.parseInt(quantity));
            db.insert("product", null, contentValues);
        }
    }

    public void select1(View v, ArrayList<String> datalist) {
        Cursor cursor = db.query("product", new String[]{"idx", "name", "price", "quantity"}, null, null, null, null, null);
        datalist.clear();
        while (cursor.moveToNext()) {
            int idx = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int quantity = cursor.getInt(3);
            datalist.add(idx + ", " + name + ", " + price + ", " + quantity);
        }
    }

    public void select2(View v, ArrayList<HashMap<String, String>> datalist2) {
        Cursor cursor = db.query("product", new String[]{"idx", "name", "price", "quantity"}, null, null, null, null, null);
        HashMap<String, String> item = new HashMap<String, String>();
        datalist2.clear();
        while (cursor.moveToNext()) {
            item = new HashMap<String, String>();
            int idx = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int quantity = cursor.getInt(3);
            item.put("name", name);
            item.put("info", price + ", " + quantity);
            datalist2.add(item);
        }
    }

    public void search(View v, String arg, ArrayList<HashMap<String, String>> datalist2) {
        Cursor cursor = db.query("product", new String[]{"idx", "name", "price", "quantity"}, "name like ?", new String[]{"%" + arg + "%"}, null, null, null);
        HashMap<String, String> item = new HashMap<String, String>();
        datalist2.clear();
        if (!arg.equals("")) {
            while (cursor.moveToNext()) {
                int idx = cursor.getInt(0);
                String name = cursor.getString(1);
                int price = cursor.getInt(2);
                int quantity = cursor.getInt(3);
                item.put("name", name);
                item.put("info", price + ", " + quantity);
                datalist2.add(item);
            }
        } else {
            Toast.makeText(v.getContext(), "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}
