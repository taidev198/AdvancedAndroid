package com.example.advancedandroid.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper {

    public SQLiteDatabase db;
    private static final String DB_NAME = "USER";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "user_table";
    private static final String TABLE_ROW_ID = "_id";
    private static final String TABLE_ROW_NAME = "username";
    private static final String TABLE_ROW_PASSWORD = "password";
    Context context;

    public DataBaseHelper(Context context){
        this.context = context;
        CustomSqliteOpenHelper helper = new CustomSqliteOpenHelper(context);
      //  helper.onCreate(db);
        db = helper.getWritableDatabase();
    }

    public void addRow(User users){
        ContentValues cv = new ContentValues();
        cv.put(TABLE_ROW_NAME , users.getUsername());
        cv.put(TABLE_ROW_PASSWORD, users.getPassword());

       /* String insertStatement = "insert into " +TABLE_NAME
                +"("
                +TABLE_ROW_NAME +","
                +TABLE_ROW_PASSWORD+")"
                + "values"
                +"(?, ?)";*/
       /* SQLiteStatement prestatement = db.compileStatement(insertStatement);
        prestatement.bindString(1, users.getUsername());
        prestatement.bindString(2, users.getPassword());*/
        //execute statement
       // prestatement.execute();
       // db.insert(TABLE_NAME, null, cv);
        try{
            db.insert(TABLE_NAME, null, cv);
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
    }


    public List<User> getRowAsObject(int rowID){
        User rowUser = new User();
        Cursor cursor;
        List<User> users = new ArrayList<>();
        try {
            cursor = db.query(TABLE_NAME, new String[]{TABLE_ROW_ID,TABLE_ROW_NAME, TABLE_ROW_PASSWORD},
                    TABLE_ROW_ID +" = " +rowID, null, null, null, null);
            //cursor.moveToFirst();
            while (cursor.moveToNext()){
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setUsername(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                users.add(user);
                System.out.println("added");
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }


    public boolean getRowAsObjectByUsername(String username, String password){

        Cursor cursor;

        try {
            cursor = db.query(TABLE_NAME, new String[]{TABLE_ROW_ID,TABLE_ROW_NAME, TABLE_ROW_PASSWORD},
                    null, null, null, null, null);
            while (cursor.moveToNext()){
                if(cursor.getString(1).equals(username) && cursor.getString(2).equals(password))
                    return true;
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return false;
    }



    public Cursor getAllData(){

        Cursor data ;

        try{
            String query = "select * from " + TABLE_NAME;

            data = db.query(TABLE_NAME, new String[]{TABLE_ROW_NAME, TABLE_ROW_PASSWORD}, null, null, null, null, null,null);
            //data.moveToFirst();
           // data.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return data;


    }

    public User getRowAsObjectAlternative(int rowID){
        User user = new User();
        Cursor cursor;
        try{
            String queryStatement = "select * from " + TABLE_NAME + "where "+
                    TABLE_ROW_ID +" =?";
            cursor = db.rawQuery(queryStatement, new String[]{String.valueOf(rowID), });
            cursor.moveToFirst();
            cursor.close();
            user.setId(cursor.getInt(0));

        }catch (Exception e){
            e.printStackTrace();
        }



        return user;
    }

    int deleteRow(int rowID){
        String selection =  TABLE_ROW_ID + " =  1";
        String[] selectionArgs = {"admin"};
        //returns the number of deleted column.
        return db.delete(TABLE_NAME, selection, null);
    }

    public boolean deleteRowAlternative(int rowID){
        try{
            String deleteStatement = "DELETE FROM " + TABLE_NAME+
                    " WHERE " + TABLE_ROW_ID + " = ?";
            SQLiteStatement s = db.compileStatement(deleteStatement);
            s.bindLong(1, rowID);
            s.executeUpdateDelete();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean updateRow(int rowID, User user){
        ContentValues cv = new ContentValues();
        cv.put(TABLE_ROW_NAME, user.getUsername());
        cv.put(TABLE_ROW_PASSWORD, user.getPassword());
        cv.put(TABLE_ROW_ID, user.getId());
        try{
            String whereClause = TABLE_ROW_ID + " = ?";
            String[] whereArgs = new String[]{String.valueOf(rowID)};
            //returns the number of updated column
            db.update(TABLE_NAME, cv, whereClause, whereArgs);
            db.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    static class CustomSqliteOpenHelper extends SQLiteOpenHelper{

        public CustomSqliteOpenHelper(Context context){
            super(context,DB_NAME, null, DB_VERSION);
            System.out.println("created database");
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE "
                    +TABLE_NAME + " ("
                    + TABLE_ROW_ID
                    +" integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    +" text not null, "
                    + TABLE_ROW_PASSWORD
                    +" text not null" +");";

            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String DROP_TABLE = "DROP TABLE IF EXISTS " +
                    TABLE_NAME;
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }

    }

}
