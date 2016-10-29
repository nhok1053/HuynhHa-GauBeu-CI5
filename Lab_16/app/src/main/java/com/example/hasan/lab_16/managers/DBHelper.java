package com.example.hasan.lab_16.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hasan.lab_16.models.Note;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ha San~ on 10/29/2016.
 */

public class DBHelper extends SQLiteAssetHelper {

    private final static String DB_NAME = "content.db";
    private final static int DB_VERSION = 1;
    private static final String QUOTE_TABLE_NAME = "Database_TQL";
    private static final String QUOTE_COLUMN_ID = "id";
    private static final String QUOTE_COLUMN_TITLE = "title";
    private static final String QUOTE_COLUMN_CONTENT = "content";
    private static final String QUOTE_COLUMN_DATE = "date";
    private static final String[] QUOTE_COLUMNS = new String[]{
            QUOTE_COLUMN_ID,
            QUOTE_COLUMN_TITLE,
            QUOTE_COLUMN_CONTENT,
            QUOTE_COLUMN_DATE
    };

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public  void insert(Note note){
        SQLiteDatabase writeDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE,note.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT,note.getContent());
        contentValues.put(QUOTE_COLUMN_DATE,note.getDate());
        long id = writeDatabase.insert(QUOTE_TABLE_NAME,null,contentValues);
        note.setId((int)id);
        writeDatabase.close();
    }
    public void update(Note note){

        SQLiteDatabase writeDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE,note.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT,note.getContent());
        contentValues.put(QUOTE_COLUMN_DATE,note.getDate());
        writeDatabase.update(QUOTE_TABLE_NAME,contentValues,""+note.getId(),null);


    }

    public void delete(Note note){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(QUOTE_TABLE_NAME,QUOTE_COLUMN_ID+"="+note.getId(),null);
        db.close();
    }
    private Note createNote(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(QUOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_CONTENT));
        String time_created = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_DATE));
        return new Note(id, title, content, time_created);
    }

    public List<Note> selectAllDB(){
        ArrayList<Note> quotesList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME,QUOTE_COLUMNS,null,null,null,null,null);
        while (cursor.moveToNext()){
            quotesList.add(createNote(cursor));
        }
        return quotesList;
    }
    private static DBHelper instance;

    public static DBHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DBHelper(context);
    }
}
