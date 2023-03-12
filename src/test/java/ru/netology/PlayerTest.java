package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldSumGenreIfTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 4);

        int expected = 7;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSumGenreIfTwoGamesOfDifferentGenres() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл", "Стратегии");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);
        player.installGame(game2);
        player.play(game2, 4);

        int expected = 4;
        int actual = player.sumGenre(game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {
        Player player = new Player("Kolya");

        assertTrue(player.getName().equals("Kolya"));

    }

    @Test
    public void testPlayMethodGameInstalled() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 3;
        int actual = player.play(game, 3);

        Assertions.assertEquals(expected, actual);


    }
    @Test
    public void testPlayMethodGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");


        Assertions.assertThrows(RuntimeException.class,
                () -> player.play(null, 2));
    }

    @Test
    public void testMostPlayerByGenrePlayedOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        assertTrue(player.mostPlayerByGenre("Аркады").equals(game));

    }
    @Test
    public void testMostPlayerByGenreNotPlayed() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        assertNull(player.mostPlayerByGenre("Стратегии"));
    }
    // другие ваши тесты
}