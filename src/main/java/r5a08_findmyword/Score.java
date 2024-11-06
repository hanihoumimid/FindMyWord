package r5a08_findmyword;

public class Score {


    private final String correct;
    private Letter result = Letter.INCORRECT;

    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return result;
    }

    public void assess(int position, String attempt) {
        if (isLetterAtCorrectPosition(position, attempt)){
            result = Letter.CORRECT;
        }
    }

    public boolean isLetterAtCorrectPosition(int position, String attempt) {
        return this.correct.charAt(position)==attempt.charAt(position);
    }
}