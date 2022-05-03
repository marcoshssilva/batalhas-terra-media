package br.com.marcoshssilva.batalhasterramedia.models.players;

import br.com.marcoshssilva.batalhasterramedia.models.controls.ControleDoJogador;
import br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem;

public class DefaultPlayer implements Player {

    private String playerId;
    private Personagem personagem;
    private ControleDoJogador controle;

    public DefaultPlayer(String playerId, Personagem personagem, ControleDoJogador controle) {
        this.playerId = playerId;
        this.personagem = personagem;
        this.controle = controle;
    }

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public Personagem getPersonagem() {
        return personagem;
    }

    @Override
    public ControleDoJogador getControle() {
        return controle;
    }

    // protected methods -> only avaible by extends

    protected void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    protected void setControle(ControleDoJogador controle) {
        this.controle = controle;
    }

    protected void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
