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
        Letter actual = score.letter(0);
        Letter expected = Letter.INCORRECT;

        // Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("E");
        Letter actual = score.letter(0);
        Letter expected = Letter.CORRECT;

        // Assert
        Assertions.assertThat(actual).isEqualTo(expected);
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
        Assertions.assertThat(actual).isEqualTo(expected);
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
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
