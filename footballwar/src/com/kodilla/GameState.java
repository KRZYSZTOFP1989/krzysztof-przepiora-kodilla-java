package com.kodilla;

import java.io.Serializable;
import java.util.Arrays;

public class GameState implements Serializable {

    private int playerWin;
    private int cpuWin;
    private String playerTeam;
    private String cpuTeam;
    private int[][] gameBoard; //0 - empty, 1- player, 2 - cpu

    public GameState(int playerWin, int cpuWin, String playerTeam, String cpuTeam, int[][] gameBoard) {
        this.playerWin = playerWin;
        this.cpuWin = cpuWin;
        this.playerTeam = playerTeam;
        this.cpuTeam = cpuTeam;
        this.gameBoard = gameBoard;
    }

    public int getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(int playerWin) {
        this.playerWin = playerWin;
    }

    public int getCpuWin() {
        return cpuWin;
    }

    public void setCpuWin(int cpuWin) {
        this.cpuWin = cpuWin;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getCpuTeam() {
        return cpuTeam;
    }

    public void setCpuTeam(String cpuTeam) {
        this.cpuTeam = cpuTeam;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "playerWin=" + playerWin +
                ", cpuWin=" + cpuWin +
                ", playerTeam=" + playerTeam +
                ", cpuTeam=" + cpuTeam +
                ", gameBoard=" + Arrays.toString(gameBoard) +
                '}';
    }
}
