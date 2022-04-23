package br.com.marcoshssilva.batalhasterramedia.models.players;

import br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem;

public interface Player {

    /**
     * Refere-se ao personagem controlado pelo jogador
     * @return br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem
     */
    public Personagem getPersonagem();

}
