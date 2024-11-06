package r5a08_findmyword;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("B");
        Letter expected = score.letter(0);
        // Assert
        assertScoreForLetter(score,0,expected);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("E");
        Letter expected = score.letter(0);

        // Assert
        assertScoreForLetter(score,0,expected);
    }

    @Test
    public void should_check_two_correct_letter(){
        // Arrange
        Word word = new Word("EX");

        // Act
        Score score = word.guess("EX");
        Letter actual = score.letter(1);
        Letter expected = Letter.CORRECT;

        // Assert
        assertScoreForLetter(score,1,expected);
    }

    @Test
    public void should_check_two_incorrect_letter(){
        // Arrange
        Word word = new Word("EX");

        // Act
        Score score = word.guess("EFX");
        Letter actual = score.letter(1);
        Letter expected = Letter.CORRECT;

        // Assert
        assertScoreForLetter(score,1,expected);
    }

    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position))
                .isEqualTo(expected);
    }
}
