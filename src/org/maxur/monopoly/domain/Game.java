package org.maxur.monopoly.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Maxim Yunusov
 * @version 1.0 01.07.12
 */
public class Game {

    private int playersNumber;

    private ArrayList<Player> players;

    private Game(int playersNumber) {
        this.playersNumber = playersNumber;
        players = new ArrayList<>(playersNumber);
        for (int i = 0; i < playersNumber; i++) {
            final Player player = new Player();
            players.add(player);
        }
    }

    public int getPlayersNumber() {
        return this.playersNumber;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void play() {
        players.get(0).setMoney(1);
        for (int i = 1; i < players.size(); i++) {
            players.get(i).setMoney(0);
        }
        this.playersNumber = 1;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        if (!isGameTerminated()) {
            throw new IllegalStateException();
        }
        return players.get(0);
    }

    public Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    public Collection<Player> getLoosers() {
        if (!isGameTerminated()) {
            throw new IllegalStateException();
        }
        Collection<Player> result = new ArrayList<>();
        for (Player player : players) {
          if (!player.hasMoney()) {
               result.add(player);
          }
        }
        return result;
    }

    public boolean isGameTerminated() {
        return playersNumber == 1;
    }

    public static class GameBuilder {
        private static final int MIN_PLAYER_NUMBER = 2;
        private static final int MAX_PLAYER_NUMBER = 8;
        private int playersNumber;

        public GameBuilder setPlayersNumber(int playersNumber) {
            if (MIN_PLAYER_NUMBER > playersNumber || MAX_PLAYER_NUMBER < playersNumber) {
                throw new IllegalArgumentException("");
            }
            this.playersNumber = playersNumber;
            return this;
        }

        public Game build() {
            return new Game(playersNumber);
        }
    }
}
