package com.danko.jonas.ui_lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.danko.jonas.ui_lab1.TestContract.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 1/29/2020.
 */

public class TestDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TestApp.db";
    private static final int DATABASE_VERSION = 1;

    private List<Question> questions;

    private SQLiteDatabase db;

    public TestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;
        questions = new ArrayList<>();

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER " + ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public void fillQuestionsTable(){
        Question q1 = new Question("a is correct", "a", "b", "c", "d", 1);
        addQuestion(q1);
        questions.add(q1);
        Question q2 = new Question("b is correct", "a", "b", "c", "d", 2);
        addQuestion(q2);
        questions.add(q2);
        Question q3 = new Question("c is correct", "a", "b", "c", "d", 3);
        addQuestion(q3);
        questions.add(q3);
        Question q4 = new Question("d is correct", "a", "b", "c", "d", 4);
        addQuestion(q4);
        questions.add(q4);
    }

    private void addQuestion(Question q){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, q.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, q.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, q.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, q.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, q.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, q.getAnswerNum());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if(c.moveToFirst()){
            do{
                Question q = new Question();
                q.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                q.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                q.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                q.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                q.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                q.setAnswerNum(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                questionList.add(q);
            }while(c.moveToNext());
        }

        c.close();
        return questions;
    }

    public List<Question> getQuestions(){
        return questions;
    }
}
