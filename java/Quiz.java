/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 * This module handles the overall Quiz functionality, which is nothing
 * more than a collection of five questions (QuizItems) and a few methods
 * for executing them in sequence and printing results. There is also a test
 * client under 'main' if you need an example of how to run it.
 */

import java.util.Formatter;
import java.util.Collections;
import java.util.Arrays;

public class Quiz {

    private QuizItem[]  QuizItemArray;

    private int         NumCorrectAnswers = 0;
    private double      PercentCorrect = 0.0;

    /**
     * Default constructor.  Initializes five QuizItems with their questions,
     * choices, and correct answer.
     */

    public Quiz() {

        String[][]  QuizChoices = { {"A: Chien", "B: Pero", "C: Inu", "D: Hund"},
                                    {"A: Chat", "B: Gato", "C: Neko", "D: Catze"},
                                    {"A: Poisson", "B: Sakana", "C: Fisch", "D: Peces"},
                                    {"A: Conejo", "B: Hase", "C: Lapin", "D: Usagi"},
                                    {"A: Vogel", "B: Pajaro", "C: Oiseau", "D: Tori"} };

        QuizItemArray = new QuizItem[5];

        QuizItemArray[0] = new QuizItem("What is the Japanese word for dog?", QuizChoices[0], 'C');
        QuizItemArray[1] = new QuizItem("What is the Spanish word for cat?", QuizChoices[1], 'B');
        QuizItemArray[2] = new QuizItem("What is the French word for fish?", QuizChoices[2], 'A');
        QuizItemArray[3] = new QuizItem("What is the German word for rabbit?", QuizChoices[3], 'B');
        QuizItemArray[4] = new QuizItem("What is the Japanese word for bird?", QuizChoices[4], 'D');

    }

    /**
     * Method to execute the quiz - it will run through all questions in a
     * shuffled, random order. It will also log the number of correct answers
     * to the Quiz object.
     */

    public void runQuiz() {

        // shuffle the questions around
        Collections.shuffle(Arrays.asList(QuizItemArray));

        for (int i = 0; i < QuizItemArray.length; i++) {

            QuizItemArray[i].askQuestion();
            QuizItemArray[i].collectResponse();

            // increment the score if the user answered correctly
            NumCorrectAnswers += (QuizItemArray[i].checkResult()) ? 1 : 0;
        }
    }

    /**
     * Method to crunch the quiz statistics and print them to console.
     * It will format print the percentage of correct answers.
     */

    public void printResults() {

        PercentCorrect = ( NumCorrectAnswers / ( (double) QuizItemArray.length) ) * 100;
        System.out.format("\nYou got %4.2f%% correct\n", PercentCorrect);
    }

    /**
     * Test client for the Quiz object, available as a main method.
     *
     * @param args - default command line arguments from console (not used by Quiz)
     */

    public static void main ( String args[] ) {

        Quiz TestQuiz = new Quiz();

        TestQuiz.runQuiz();
        TestQuiz.printResults();

    }
}