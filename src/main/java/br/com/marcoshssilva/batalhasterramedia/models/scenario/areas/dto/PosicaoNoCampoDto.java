package br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.dto;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;

public class PosicaoNoCampoDto {

    private Integer indexX;
    private Integer indexY;
    private String playerId;
    private Player player;

    public PosicaoNoCampoDto(Integer indexX, Integer indexY, String playerId, Player player) {
        this.indexX = indexX;
        this.indexY = indexY;
        this.playerId = playerId;
        this.player = player;
    }

    public Integer getIndexX() {
        return indexX;
    }

    public void setIndexX(Integer indexX) {
        this.indexX = indexX;
    }

    public Integer getIndexY() {
        return indexY;
    }

    public void setIndexY(Integer indexY) {
        this.indexY = indexY;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
