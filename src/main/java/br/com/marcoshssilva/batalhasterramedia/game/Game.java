package br.com.marcoshssilva.batalhasterramedia.game;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.duels.Duelo;

import java.util.LinkedList;
import java.util.List;

public final class Game {
    /**
     * esta classe não pode ser intanciada, exceto por si propria
     */
    private Game() { }
    /**
     * jogadores participantes do jogo
     */
    private static final List<Player> players = new LinkedList<>();
    /**
     * duelos do jogo
     */
    private static final List<Duelo> duelos = new LinkedList<>();
}
