/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 *
 */

public class Quiz {

    private QuizItem Question1;
    private String[] Question1Answers = {"A: True", "B: False"};

    private int NumCorrectAnswers = 0;
    private double PercentCorrect = 0.0;

    public Quiz() {

        this.Question1 = new QuizItem("True or false?", Question1Answers, 'A');

    }

    public void runQuiz() {
        Question1.askQuestion();
    }

//    public void printResults() {
//
//    }

    public static void main (String args[]) {

        Quiz TestQuiz = new Quiz();
        TestQuiz.runQuiz();


        System.out.println("\nQuiz finished successfully!");

    }
}