/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 *
 */

import java.util.Formatter;

public class Quiz {

    private QuizItem[]  QuizItemArray;

    private String[][]  QuizChoices = { {"A: Chien", "B: Perro", "C: Inu", "D: Hund"},
                                        {"A: Gato", "B: Chat", "C: Neko", "D: Catze"} };

    private int         NumCorrectAnswers = 0;
    private double      PercentCorrect = 0.0;

    public Quiz() {

        QuizItemArray = new QuizItem[2];

        QuizItemArray[0] = new QuizItem("What is the Japanese word for dog?", QuizChoices[0], 'C');
        QuizItemArray[1] = new QuizItem("What is the Spanish word for cat?", QuizChoices[1], 'A');

    }

    public void runQuiz() {

        for (int i = 0; i < QuizItemArray.length; i++) {

            QuizItemArray[i].askQuestion();
            QuizItemArray[i].collectResponse();
            NumCorrectAnswers += (QuizItemArray[i].checkResult()) ? 1 : 0;
        }
    }

    public void printResults() {

        PercentCorrect = ( NumCorrectAnswers / ( (double) QuizItemArray.length) ) * 100;
        System.out.format("\nYou got %4.2f%% correct\n", PercentCorrect);
    }

    public static void main ( String args[] ) {

        Quiz TestQuiz = new Quiz();

        TestQuiz.runQuiz();
        TestQuiz.printResults();

    }
}