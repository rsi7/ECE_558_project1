/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 *
 */

import java.util.Scanner;

public class QuizItem {

    private char        QuizItemAnswer;
    private String      QuizItemQuestion;
    private String[]    QuizItemChoices;

    private boolean     CorrectAnswer;
    private char        UserResponse;

    public QuizItem(String QuizItemQuestion, String[] QuizItemChoices, char QuizItemAnswer) {

        // validate the data for constructor

        this.QuizItemQuestion = QuizItemQuestion;
        this.QuizItemChoices = QuizItemChoices;
        this.QuizItemAnswer = QuizItemAnswer;

    }

    public void askQuestion() {
        System.out.println("\n" + QuizItemQuestion + "\n");

        for (int i = 0; i < QuizItemChoices.length; i++) {
            System.out.println("\t" + QuizItemChoices[i]);
        }
    }

    public void collectResponse() {

        String s;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nType a character: ");

        while (!scan.hasNext()) {
            String garbage = scan.nextLine();
            System.out.println("Input failed. Please type a character: ");
        }

        s = scan.next( );
        UserResponse = s.toUpperCase().charAt(0);
    }

    public boolean checkResult() {

        CorrectAnswer = (UserResponse == QuizItemAnswer) ? true : false;

        if (CorrectAnswer) System.out.println("\nCorrect!");
        else System.out.println("\nWrong - correct answer was: " + String.valueOf(QuizItemAnswer));

        return CorrectAnswer;
    }

    public String toString() {

            return ( QuizItemQuestion + "\n\n" + "Answer: " + String.valueOf(UserResponse) );
    }

}