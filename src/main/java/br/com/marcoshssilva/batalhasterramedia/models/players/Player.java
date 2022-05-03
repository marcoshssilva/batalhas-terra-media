package br.com.marcoshssilva.batalhasterramedia.models.players;

import br.com.marcoshssilva.batalhasterramedia.models.controls.ControleDoJogador;
import br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem;

public interface Player {
    /**
     * Refere-se ao personagem controlado pelo jogador
     * @return br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem
     */
    public Personagem getPersonagem();

    /**
     * @return Implementação dos controles do jogador
     */
    public ControleDoJogador getControle();

    /**
     * @return Id do jogador da instancia
     */
    public String getPlayerId();
}
