package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class DictionaryTest {


    private Dictionary dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new Dictionary();
    }

    @Test
    @DisplayName("Correct words reading")
    void readWordsFromFile_success() {
        dictionary.readWordsFromFile("src/test/resources/TestDictionary.txt");
        ArrayList<String> testDictionaryContent = new ArrayList<>() {
            {
                add("окно");
                add("машина");
                add("энтропия");
            }
        };
        assertEquals(dictionary.getWords(), testDictionaryContent);
    }

    @Test
    @DisplayName("Reading from non-existing file")
    void readFromFile_fileNotFound() {
        boolean readingStatus = dictionary.readWordsFromFile("src/test/resources/TestDictionary11.txt");
        assertFalse(readingStatus);
    }

    @Test
    @DisplayName("Getting random word")
    void getRandomWord_dict_contains_word() {
        dictionary.readWordsFromFile("src/test/resources/TestDictionary.txt");
        String word = dictionary.getRandomWord();
        assertTrue(dictionary.getWords().contains(word));
    }
}