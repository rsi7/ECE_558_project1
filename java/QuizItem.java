/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 * This module handles the functionality for one multiple-choice question.
 * It holds the question statement, possible choices, user answer, and
 * whether they got it right or not. It also has methods to 'ask' itself
 * to the user, collect the response, and check for correctness.
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class QuizItem {

    private char        QuizItemAnswer;
    private String      QuizItemQuestion;
    private String[]    QuizItemChoices;

    private boolean     AnsweredCorrect;
    private char        UserResponse;

    /**
     * Default constructor.  Checks the number of answer choices
     * and validity of the answer argument before assigning to object fields.
     * @param QuizItemQuestion - the question expressed as a sentence or equation
     * @param QuizItemChoices - an array of possible choices
     * @param QuizItemAnswer - the correct answer for the QuizItemQuestion
     */

    public QuizItem(String QuizItemQuestion, String[] QuizItemChoices, char QuizItemAnswer) {

        this.QuizItemQuestion = QuizItemQuestion;

        // validate the multiple-choice options

        if (QuizItemChoices.length >= 4) {
            this.QuizItemChoices = QuizItemChoices;
        }

        else throw new Error("\nNeed at least 4 multiple-choice options!");

        // validate the provided answer

        if ( String.valueOf(QuizItemAnswer).matches("[abcdABCD]") ) {
            this.QuizItemAnswer = QuizItemAnswer;
        }

        else throw new Error("\nNeed a valid character (A,B,C,D) for answer!");

    }

    /**
     * Method to 'ask' the user this QuizItem by printing it to console.
     * It will print the question & all possible choices.
     */

    public void askQuestion() {
        System.out.println("\n" + QuizItemQuestion + "\n");

        for (int i = 0; i < QuizItemChoices.length; i++) {
            System.out.println("\t" + QuizItemChoices[i]);
        }
    }

    /**
     * Method to ask grab the user's input. It will check for
     * a valid entry (i.e. a,b,c,d character) and store it
     * in the object's UserResponse field.
     */

    public void collectResponse() {

        String str;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nType a character: ");

        while (!scan.hasNext()) {
            String garbage = scan.nextLine();
            System.out.println("\nInput failed. Please type a valid character (A,B,C,D): ");
        }

        do {
            str = scan.next();
            if ( str.matches("[abcdABCD]") ) UserResponse = str.toUpperCase().charAt(0);
            else System.out.println("\nInput failed. Please type a valid character (A,B,C,D): ");

        } while (UserResponse == '\u0000');
    }

    /**
     * Method to compare the user's answer against the official answer
     * (as provided at Quiz creation time).
     * @return AnsweredCorrect - boolean reflecting whether user got it right or not
     */

    public boolean checkResult() {

        AnsweredCorrect = (UserResponse == QuizItemAnswer) ? true : false;

        if (AnsweredCorrect) System.out.println("\nCorrect!");
        else System.out.println("\nWrong - correct answer was " + String.valueOf(QuizItemAnswer) + ".");

        return AnsweredCorrect;
    }

    /**
     * Method to print the question statement - not used by Quiz,
     * but may be useful for log files.
     * @return QuizItemQuestion - the question statement given to this QuizItem
     */

    public String toString() {

            return QuizItemQuestion;
    }

}