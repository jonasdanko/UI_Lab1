package com.danko.jonas.ui_lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 1/29/2020.
 */

public class FakeDB {

    private List<Question> questions;

    public FakeDB(){
        questions = new ArrayList<>();
        fillQuestionsTable();
    }



    public void fillQuestionsTable(){
        Question q1 = new Question("a is correct", "a", "b", "c", "d", 1);
        questions.add(q1);
        Question q2 = new Question("b is correct", "a", "b", "c", "d", 2);
        questions.add(q2);
        Question q3 = new Question("c is correct", "a", "b", "c", "d", 3);
        questions.add(q3);
        Question q4 = new Question("d is correct", "a", "b", "c", "d", 4);
        questions.add(q4);
    }

    public List<Question> getQuestions(){
        return questions;
    }
}
