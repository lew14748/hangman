package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HiddenWordTest {

    private HiddenWord hiddenWord;

    @BeforeEach
    void setUp() {
        hiddenWord = new HiddenWord();
    }

    @Test
    void initWords() {
        hiddenWord.initWords("машина");
        ArrayList<String> testActualWord = new ArrayList<>(Arrays.asList("м", "а", "ш", "и", "н", "а"));
        ArrayList<String> testMaskedWord = new ArrayList<>(Arrays.asList("_", "_", "_", "_", "_", "_"));
        assertEquals(testMaskedWord, hiddenWord.getMaskedWord());
        assertEquals(testActualWord, hiddenWord.getActualWord());
    }

    @Test
    void guessLetter() {
        hiddenWord.initWords("машина");
        ArrayList<String> testMaskedWordWithGuessedLetter = new ArrayList<>(Arrays.asList("_", "а", "_", "_", "_", "а"));
        assertTrue(hiddenWord.guessLetter("а"));
        assertEquals(testMaskedWordWithGuessedLetter, hiddenWord.getMaskedWord());
    }


}