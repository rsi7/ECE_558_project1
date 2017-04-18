/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 *
 */

import java.util.Formatter;

public class Quiz {

    private QuizItem    Question1;
    private String[]    Question1Answers = {"A: True", "B: False"};

    private int         NumCorrectAnswers = 0;
    private double      PercentCorrect = 0.0;

    public Quiz() {

        this.Question1 = new QuizItem("True or false?", Question1Answers, 'A');

    }

    public void runQuiz() {
        Question1.askQuestion();
        Question1.collectResponse();
        NumCorrectAnswers += ( Question1.checkResult() ) ? 1 : 0;
    }

    public void printResults() {

        PercentCorrect = ( NumCorrectAnswers / 1.0 ) * 100;
        System.out.format("\nYou got %4.2f%% correct\n", PercentCorrect);
    }

    public static void main ( String args[] ) {

        Quiz TestQuiz = new Quiz();

        TestQuiz.runQuiz();
        TestQuiz.printResults();

    }
}