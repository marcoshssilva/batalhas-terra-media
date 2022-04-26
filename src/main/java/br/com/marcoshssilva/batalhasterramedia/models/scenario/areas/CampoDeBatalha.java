package br.com.marcoshssilva.batalhasterramedia.models.scenario.areas;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;

public interface CampoDeBatalha {
    /**
     * inicializa o jogo com posição inicial na area e devidos Players.
     *
     * @param playerId | identificação do jogador
     * @param player | jogador
     * @param eixoX | Posição X do jogador
     * @param eixoY | Posição Y do jogador
     *
     * @throws AreaDeCampoInexistenteException
     * Erro ocorrido caso o jogador seja definido em uma posição inválido
     * dentro do campo de batalha.
     */
    public void adicionarPlayer(String playerId, Player player, Integer eixoX, Integer eixoY)
            throws AreaDeCampoInexistenteException;

}
