package r5a08_findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test_Word {
    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot à déviner fait une lettre
        // Act
        String expected = "E";
        String actual = word.guess("E");
        // Assert
        Assertions.assertEquals(expected, actual);
    }

}
