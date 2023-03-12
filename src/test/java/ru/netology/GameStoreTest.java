package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldFindMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 6);
        store.addPlayTime("Anton", 3);
        store.addPlayTime("Sergey", 9);

        assertTrue(store.getMostPlayer().equals("Sergey"));
    }

    @Test
    public void shouldFindMostPlayerWhenPlayedTwice() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 6);
        store.addPlayTime("Anton", 3);
        store.addPlayTime("Sergey", 9);
        store.addPlayTime("Anton", 8);

        assertTrue(store.getMostPlayer().equals("Anton"));
    }

    @Test
    public void shouldNotFindMostPlayerIfNoPlayers() {

        GameStore store = new GameStore();

        assertNull(store.getMostPlayer());
    }
    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petya", 6);
        store.addPlayTime("Anton", 3);
        store.addPlayTime("Sergey", 9);
        store.addPlayTime("Anton", 8);

        int expected = 26;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
}
