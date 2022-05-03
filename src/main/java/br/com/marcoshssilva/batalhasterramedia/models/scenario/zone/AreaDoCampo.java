package br.com.marcoshssilva.batalhasterramedia.models.scenario.zone;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.AreaDeCampoHabitadaException;

public interface AreaDoCampo {
    /**
     * @return id do Player localizado nesta posicao
     */
    public String getPlayerId();

    /**
     * @return Objeto do jogador desta area
     */
    public Player getPlayer();

    /**
     * troca o jogador da area
     *
     * @param player   | objeto do jogador que será inserido
     * @param playerId | id do jogador.
     *
     * @throws AreaDeCampoHabitadaException
     *         Erro que ocorre quando ja existe um jogador nesta area de campo
     */
    public void inserirPlayer(Player player, String playerId) throws AreaDeCampoHabitadaException;

    /**
     * remove o jogador da area
     */
    public void removerPlayer();

    /**
     * @return True, caso a area exista um personagem sobre ela
     */
    public Boolean areaEstaOcupada();
}
