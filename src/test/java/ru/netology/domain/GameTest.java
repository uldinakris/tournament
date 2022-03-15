package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.domain.Player;
import ru.netology.exeptions.NotRegisteredException;

class GameTest {
    private Player player1 = new Player(12, "Nick", 125);
    private Player player2 = new Player(13, "Luck", 23);
    private Player player3 = new Player(14, "Kitty", 23);
    private Player player4 = new Player(14, "John", 85);

    private Game game = new Game();

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);

        Player expected = player1;
        Player actual = game.findByName("Nick");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        game.register(player1);
        game.register(player2);

        Player expected = null;
        Player actual = game.findByName("Kitty");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisterSamePlayerTwice() {
        game.register(player1);
        game.register(player1);

        int expected = 1;
        int actual = game.getAll().toArray().length;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowWinner() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Nick", "Luck");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowLooser() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Luck", "Nick");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowDraw() {
        game.register(player3);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Kitty", "Luck");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotRegisteredExeption() {
        game.register(player3);
        game.register(player2);

        try {
            game.round("John", "Nick");
        } catch (RuntimeException ex) {
            Assertions.assertThrows(NotRegisteredException.class, () -> game.round("John", "Nick"));
        }
    }

    @Test
    public void shouldThrowNotRegisteredExeptionForOnePlayer() {
        game.register(player1);
        game.register(player2);

        try {
            game.round("John", "Nick");
        } catch (RuntimeException ex) {
            Assertions.assertThrows(NotRegisteredException.class, () -> game.round("John", "Nick"));
        }
    }
}

