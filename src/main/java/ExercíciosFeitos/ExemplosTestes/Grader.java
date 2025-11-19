package ExercíciosFeitos.ExemplosTestes;

public class Grader {
    public char determineLetterGrade(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        } else if (score < 60) {
            return 'F';
        } else if (score < 70) {
            return 'D';
        } else if (score < 80) {
            return 'C';
        } else if (score < 90) {
            return 'B';
        }
        else if (score > 100) {
            throw new IllegalArgumentException("Score cannot be more than 100");
        }
        else {
            return 'A';
        }
    }
}