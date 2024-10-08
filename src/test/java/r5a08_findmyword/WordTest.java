package r5a08_findmyword;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

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
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("E");
        Letter actual = score.letter(0);
        Letter expected = Letter.CORRECT;

        // Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
