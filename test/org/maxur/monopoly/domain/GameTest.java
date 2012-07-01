package org.maxur.monopoly.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * @author Maxim Yunusov
 * @version 1.0 01.07.12
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private Round round;

    @Test
    public void testMinPlayersNumberIs2() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        int playersNumber = game.getPlayersNumber();
        assertEquals(2, playersNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinPlayersNumberMoreThan1() throws Exception {
        Game.builder().setPlayersNumber(1).build();
    }

    @Test
    public void testMaxPlayersNumberIs8() throws Exception {
        final Game game = Game.builder().setPlayersNumber(8).build();
        int playersNumber = game.getPlayersNumber();
        assertEquals(8, playersNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxPlayersNumberLessThan9() throws Exception {
        Game.builder().setPlayersNumber(9).build();
    }

    @Test
    public void testGameMustBeTerminatedOnOnePlayer() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.play();
        int playersNumber = game.getPlayersNumber();
        assertEquals(1, playersNumber);
    }

    @Test
    public void testWinnerIsPlayer() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        final Collection players = game.getPlayers();
        game.play();
        final Player winner = game.getWinner();
        assertTrue(players.contains(winner));
    }

    @Test
    public void testPlayersSizeMustBeEqualsPlayersNumber() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        final Collection players = game.getPlayers();
        assertEquals(game.getPlayersNumber(), players.size());
    }

    @Test
    public void testPlayersMustContainsUniquePlayers() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        assertNotSame(game.getPlayer(0), game.getPlayer(1));
    }

    @Test
    public void testWinnerHasMoney() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.play();
        Player winner = game.getWinner();
        assertTrue(0 < winner.getMoney());
    }

    @Test
    public void testLooserHasNotMoney() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.play();
        Collection<Player> looser = game.getLoosers();
        for (Player player : looser) {
            assertTrue(0 == player.getMoney());
        }
    }

    @Test
    public void testLoosersNumberIsPlayerNumberWithoutOne() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.play();
        assertEquals(game.getPlayers().size() - 1, game.getLoosers().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetWinnerThrowsExceptionWithoutPlay() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.getWinner();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetLoosersThrowsExceptionWithoutPlay() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.getLoosers();
    }

    @Test
    public void testGameRunningRound() throws Exception {
        final Game game = Game.builder().setPlayersNumber(2).build();
        game.play();
        verify(round).run();
    }

}
