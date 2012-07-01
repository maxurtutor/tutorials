package org.maxur.monopoly.domain;

/**
 * @author Maxim Yunusov
 * @version 1.0 01.07.12
 */
public class Game {

    private int playersNumber;

    private Game(int playersNumber) {
        this.playersNumber = playersNumber;
    }

    public int getPlayersNumber() {
        return this.playersNumber;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void play() {
        this.playersNumber = 1;
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
