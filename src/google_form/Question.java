package google_form;

public class Question {
    private String questionText;
    private QuestionType questionType;

    protected Question() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    protected void setQuestionType(QuestionType questionType) {
        // Perform Input Validations
        /*
         * 
         */

        this.questionType = questionType;
    }

    protected void setQuestionText(String questionText) {
        // Perform Input Validations
        /*
         * 
         */

        this.questionText = questionText;
    }
}
