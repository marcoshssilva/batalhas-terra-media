package br.com.marcoshssilva.batalhasterramedia.game;

import br.com.marcoshssilva.batalhasterramedia.game.controller.BasicController;
import br.com.marcoshssilva.batalhasterramedia.models.controls.ControleDoJogador;
import br.com.marcoshssilva.batalhasterramedia.models.persons.MagoDefaultPersonagemImpl;
import br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem;
import br.com.marcoshssilva.batalhasterramedia.models.players.DefaultPlayer;
import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.CampoDeBatalhaDefaultLinearImpl;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.duels.Duelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * uma instancia do jogo.
 */
public final class Game {

    private final Integer LIMITE_JOGADORES = 8;

    private List<Player> players;
    private List<Duelo>  duelos  = new LinkedList<>();

    /**
     * abre uma nova instancia do jogo
     * a partir de uma lista de jogadores salva
     */
    public Game(SaveGameLoader save) {
        this.players = save.getJogadores();
    }

    public void execGame() throws Exception {
        if (this.players.size() > LIMITE_JOGADORES) {
            throw new Exception("Quantidade de jogadores Excedeu o limite. " +
                        "LIMITE: " + LIMITE_JOGADORES +
                        " " +
                        "ENCONTRADO: " + this.players.size() +
                        "."
            );
        }

        // carrega os duelos iniciais
        this.duelos = rodada(this.players);
        // refaz em sequencia cada duelo de jogo.
        while (this.players.size() > 1) {
            // a cada repeticao de loop uma nova lista de vencedores é refeita
            List<Player> playersVencedores = new ArrayList<>();
            duelos.forEach(duelo -> {
                // inicia o duelo.
                duelo.iniciarDuelo();
                // restaurando a vida do vencedor
                duelo.getVencedor().getPersonagem().reporVida();
                // adicionando o vencedor do duelo a lista de vencedores
                playersVencedores.add(duelo.getVencedor());
            });
            // refazendo os proximos duelos apenas com os vencedores
            this.duelos = rodada(playersVencedores);
        }

        System.out.println("Parabens o vencedor: " + this.players.get(0).getPersonagem().getNome());
    }

    private List<Duelo> rodada(List<Player> jogadores) throws Exception {
        List<Duelo> duelosDaRodada = new Stack<>();
        int quantidadeDeJogadores = jogadores.size();
        int tamanhoPadraoDoCampo  = 70;

        for (int i = 0; i < quantidadeDeJogadores; i+= 2) {
            Player jogador1 = jogadores.get(i);
            Player jogador2 = null;

            try { jogador2 = jogadores.get(i+1); }
            catch (IndexOutOfBoundsException e) {
                Personagem fakePersonagem = new MagoDefaultPersonagemImpl();
                ControleDoJogador fakeControle = new BasicController();
                // mata ele instantaneo
                fakePersonagem.receberDano(Double.MAX_VALUE);
                jogador2 = new DefaultPlayer(String.valueOf(System.currentTimeMillis()), fakePersonagem, fakeControle);
            }

            duelosDaRodada.add(new Duelo(
                            jogador1,
                            jogador2,
                            new CampoDeBatalhaDefaultLinearImpl(tamanhoPadraoDoCampo)
                    ));
        }

        return duelosDaRodada;
    }
}
