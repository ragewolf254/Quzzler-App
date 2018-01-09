package com.ragew.quizzler;

/**
 * Created by ragew on 1/10/2018.
 */

public class TrueFalse {
    //create variables
    private int m_questionID;
    private boolean m_trueFalse;

    //create constructor
    public TrueFalse (int questionID, boolean trueOrFalse){
        m_questionID = questionID;
        m_trueFalse = trueOrFalse;
    }

    public int getQuestionID() {
        return m_questionID;
    }

    public void setQuestionID(int questionID) {
        m_questionID = questionID;
    }

    public boolean isTrueFalse() {
        return m_trueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        m_trueFalse = trueFalse;
    }
}
