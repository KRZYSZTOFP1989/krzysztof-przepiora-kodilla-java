package com.kodilla;

import java.io.Serializable;

public class Ranking implements Serializable {

    private String playerTeam;
    private int playerWin;
    private String cpuTeam;
    private int cpuWin;

    public Ranking(String playerTeam, int playerWin, String cpuTeam, int cpuWin) {
        this.playerTeam = playerTeam;
        this.playerWin = playerWin;
        this.cpuTeam = cpuTeam;
        this.cpuWin = cpuWin;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public int getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(int playerWin) {
        this.playerWin = playerWin;
    }

    public String getCpuTeam() {
        return cpuTeam;
    }

    public void setCpuTeam(String cpuTeam) {
        this.cpuTeam = cpuTeam;
    }

    public int getCpuWin() {
        return cpuWin;
    }

    public void setCpuWin(int cpuWin) {
        this.cpuWin = cpuWin;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "playerTeam='" + playerTeam + '\'' +
                ", playerWin=" + playerWin +
                ", cpuTeam='" + cpuTeam + '\'' +
                ", cpuWin=" + cpuWin +
                '}';
    }
}
