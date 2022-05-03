package br.com.marcoshssilva.batalhasterramedia.models.controls;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalha;

@FunctionalInterface
public interface ControleDoJogador {
    /**
     * ciclo de vida, toda vez que for efetuado requisição do movimento do jogador
     * devera ser executado esta função para determinar a ação disparada.
     *
     * @param campo  | campo de batalha onde esta o duelo
     * @param player | jogador da instancia
     */
    public void requisitarAcao(CampoDeBatalha campo, Player player);

}
