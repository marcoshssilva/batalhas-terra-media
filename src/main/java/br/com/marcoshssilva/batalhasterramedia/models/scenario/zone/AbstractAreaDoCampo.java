package br.com.marcoshssilva.batalhasterramedia.models.scenario.zone;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.AreaDeCampoHabitadaException;

public abstract class AbstractAreaDoCampo implements AreaDoCampo {

    protected String playerId;
    protected Player player;

    @Override
    public String getPlayerId() {
        return this.playerId;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void inserirPlayer(Player player, String playerId) throws AreaDeCampoHabitadaException {
        if (areaEstaOcupada()) throw new AreaDeCampoHabitadaException();

        this.player = player;
        this.playerId = playerId;
    }

    @Override
    public void removerPlayer() {
        this.player = null;
        this.playerId = null;
    }

    @Override
    public Boolean areaEstaOcupada() {
        return this.player != null;
    }
}
