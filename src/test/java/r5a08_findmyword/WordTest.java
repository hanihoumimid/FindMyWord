package r5a08_findmyword;
import r5a08_findmyword.Word;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import r5a08_findmyword.domain.Letter;
import r5a08_findmyword.domain.Score;

import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E");
        // Act
        Score score = word.guess("B");

        // Assert
        assertThat(score.letter(0)).isEqualTo(Letter.INCORRECT);

    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("E");

        // Assert
        assertThat(score.letter(0)).isEqualTo(Letter.CORRECT);
    }

    @Test
    void should_check_second_letter_wrong_position(){
        // Arrange
        Word word = new Word("EX");

        // Act
        Score score = word.guess("GE");

        // Assert
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
    }

    @Test
    void should_check_all_score_combinaison_correct(){
        Word word = new Word("EMT");
        Score score = word.guess("GET");
        assertScoreForLetter(score, 0, Letter.INCORRECT);
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
        assertScoreForLetter(score, 2, Letter.CORRECT);
    }
    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position))
                .isEqualTo(expected);
    }
}
