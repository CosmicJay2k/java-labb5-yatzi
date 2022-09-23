package edu.lernia.labb5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] diceArray = new Die[5];
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Die();
        }
        assertTrue(YatziMain.CheckForYatzi(diceArray));
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] diceArray = new Die[5];
        for (int i = 0; i < 5; i++) {
            diceArray[i] = new Die();
        }
        diceArray[4].value = 1;
        assertFalse(YatziMain.CheckForYatzi(diceArray));
    }

}
