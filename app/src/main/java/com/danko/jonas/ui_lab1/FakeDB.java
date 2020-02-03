package com.danko.jonas.ui_lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 1/29/2020.
 */

public class FakeDB {

    private List<Question> questionsTest1, questionsTest2;

    public FakeDB(){
        questionsTest1 = new ArrayList<>();

        fillQuestionsTable();
    }



    public void fillQuestionsTable(){
        Question q1 = new Question("What is 4+4?", "8", "7", "16", "10", 1);
        questionsTest1.add(q1);
        Question q2 = new Question("What is 4x4?", "8", "7", "16", "10", 3);
        questionsTest1.add(q2);
        Question q3 = new Question("What is the square root of 16?", "8", "4", "2", "16", 2);
        questionsTest1.add(q3);
        Question q4 = new Question("What is 12/4?", "8", "1", "3", "4", 3);
        questionsTest1.add(q4);
        Question q5 = new Question("What is 20-7?", "12", "13", "16", "14", 2);
        questionsTest1.add(q5);
        Question q6 = new Question("What is 9x5?", "45", "54", "36", "44", 1);
        questionsTest1.add(q6);
        Question q7 = new Question("What is 5 mod 4?", "0", "4", "1", "5", 3);
        questionsTest1.add(q7);
        Question q8 = new Question("What is 4 mod 5?", "0", "1", "3", "4", 4);
        questionsTest1.add(q8);
        Question q9 = new Question("What is 2^3?", "6", "8", "4", "10", 2);
        questionsTest1.add(q9);
        Question q10 = new Question("What is 4+2x3?", "10", "18", "10", "11", 1);
        questionsTest1.add(q10);
        Question q11 = new Question("What is the square root of 64?", "8", "4", "6", "16", 1);
        questionsTest1.add(q11);
        Question q12 = new Question("What is 5 in binary?", "110", "101", "111", "011", 2);
        questionsTest1.add(q12);
    }

    public List<Question> getQuestionsTest1(){
        return questionsTest1;
    }
}
