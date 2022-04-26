package br.com.marcoshssilva.batalhasterramedia.models.scenario.duels;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalha;

public interface Duelo {
    /**
     * Adiciona um novo jogador ao campo de batalha.
     *
     * @param player | br.com.marcoshssilva.batalhasterramedia.models.players.Player
     * jogador que irá ingressar no campo.
     *
     * @param playerId | java.lang.String
     * código de identificação do jogador.
     */
    public void addPlayer(String playerId, Player player);

    /**
     * Retorna o campo de batalha
     * @return br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalha
     */
    public CampoDeBatalha getCampoDeBatalha();

    /**
     * Atribui uma area onde deve ocorrer a batalha.
     *
     * @param campoDeBatalha | br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalha
     * Campo onde ocorrerá a luta.
     */
    public void defineCampoDeBatalha(CampoDeBatalha campoDeBatalha);

    /**
     * Inicia o duelo
     */
    public void start();
}
