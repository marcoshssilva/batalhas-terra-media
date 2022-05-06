package br.com.marcoshssilva.batalhasterramedia.models.scenario.duels;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalha;

public class Duelo {

    private final Double VIDA_MINIMA = 0.00;

    private Player player1;
    private Player player2;
    private CampoDeBatalha campoDeBatalha;
    private Integer turno;

    private Player vencedor;

    public Duelo(Player player1, Player player2, CampoDeBatalha campoDeBatalha) throws Exception {
        this.player1 = player1;
        this.player2 = player2;
        this.campoDeBatalha = campoDeBatalha;
        // começa o turno na rodada 1
        this.turno = 1;

        Integer sizeX = campoDeBatalha.getZonasDoCampoDeBatalha()[0].length;
        Integer posPlayer1 = sizeX / 2 - (sizeX /4);
        Integer posPlayer2 = sizeX / 2 + (sizeX /4);

        this.campoDeBatalha.adicionarPlayer(player1.getPlayerId(), player1, posPlayer1, 0);
        this.campoDeBatalha.adicionarPlayer(player2.getPlayerId(), player1, posPlayer2, 0);
    }

    public void iniciarDuelo() {

        do { jogada(); }
        while (this.player1.getPersonagem().getVida() > VIDA_MINIMA
                    && this.player2.getPersonagem().getVida() > VIDA_MINIMA);

        // após finalizar o jogo. Definir vencedor

    }

    private void jogada() {
        // Se o turno for PAR,   Player 1 faz movimento
        // Se o turno for ÍMPAR, PLayer 2 faz movimento
        if (turno % 2 == 0) {
            this.player1.getControle().requisitarAcao(this.campoDeBatalha, this.player1);
        } else {
            this.player2.getControle().requisitarAcao(this.campoDeBatalha, this.player2);
        }
        // passa o turno para o próximo após chamar a ação
        turno += 1;
    }

    private void vencedor() {
        if (this.player1.getPersonagem().getVida() > VIDA_MINIMA) {
            this.vencedor = this.player1;

        } else if (this.player1.getPersonagem().getVida() > VIDA_MINIMA) {
            this.vencedor = this.player2;
        }
    }

    /*
        Apenas GET
     */

    public Double getVIDA_MINIMA() {
        return VIDA_MINIMA;
    }

    public Player getVencedor() {
        return vencedor;
    }

    /*
        GETs e SETs
     */

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public CampoDeBatalha getCampoDeBatalha() {
        return campoDeBatalha;
    }

    public void setCampoDeBatalha(CampoDeBatalha campoDeBatalha) {
        this.campoDeBatalha = campoDeBatalha;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }
}
