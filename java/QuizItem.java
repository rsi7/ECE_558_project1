/**
 * @author Rehan Iqbal(riqbal@pdx.edu) <BR> <BR>
 *
 *
 */

public class QuizItem {

        private char QuizItemAnswer;
        private String QuizItemQuestion;
        private String[] QuizItemChoices;

        private boolean CorrectAnswer;
        private char UserResponse;

        public QuizItem(String QuizItemQuestion, String[] QuizItemChoices, char QuizItemAnswer) {

            // validate the data for constructor

            this.QuizItemQuestion = QuizItemQuestion;
            this.QuizItemChoices = QuizItemChoices;
            this.QuizItemAnswer = QuizItemAnswer;

    }

    public void askQuestion() {
        System.out.println(QuizItemQuestion);

        for (int i = 0; i < QuizItemChoices.length; i++) {
            System.out.println(QuizItemChoices[i]);
        }
    }

//    public void checkResult() {
//
//    }

    public String toString() {

            return (QuizItemQuestion + "\n\n" + "Answer: " + String.valueOf(QuizItemAnswer));
    }

}