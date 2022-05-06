package br.com.marcoshssilva.batalhasterramedia.game;

import br.com.marcoshssilva.batalhasterramedia.game.controller.BasicController;
import br.com.marcoshssilva.batalhasterramedia.models.controls.ControleDoJogador;
import br.com.marcoshssilva.batalhasterramedia.models.nation.*;
import br.com.marcoshssilva.batalhasterramedia.models.persons.ArqueiroDefaultPersonagemImpl;
import br.com.marcoshssilva.batalhasterramedia.models.persons.GuerreiroDefaultPersonagemImpl;
import br.com.marcoshssilva.batalhasterramedia.models.persons.MagoDefaultPersonagemImpl;
import br.com.marcoshssilva.batalhasterramedia.models.persons.Personagem;
import br.com.marcoshssilva.batalhasterramedia.models.players.DefaultPlayer;
import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class SaveGameLoader {

    private Scanner scanFile;
    private List<Player> jogadores = new LinkedList<>();

    public SaveGameLoader(File file) throws Exception {

        this.scanFile = new Scanner(file);

        while (scanFile.hasNextLine()) {
            // dados do jogador em 1 linha exemplo
            // MyCard 3 1 30 20 20 20 10
            String[] parts = scanFile.nextLine().split(" ");

            String nomeJogador = parts[0];
            // gera um iD aleatorio
            String playerId = System.currentTimeMillis() + new Random().nextInt() + "_player";
            Nacao nacao = null;
            Habilidade habilidade = new Habilidade(
                    Integer.valueOf(parts[3]),
                    Integer.valueOf(parts[4]),
                    Integer.valueOf(parts[5]),
                    Integer.valueOf(parts[6]),
                    Integer.valueOf(parts[7])
            );

            Personagem personagem = null;
            ControleDoJogador controle = new BasicController();

            switch (parts[1]) {
                case "1": nacao = new AnaoNacaoImpl(); break;
                case "2": nacao = new CavaleiroDeRohanNacaoImpl(); break;
                case "3": nacao = new ElfoDaFlorestaNacaoImpl(); break;
                case "4": nacao = new ElfoDeLothlorienNacaoImpl(); break;
                case "5": nacao = new GuerreiroDeGondorNacaoImpl(); break;
                case "6": nacao = new HobbitNacaoImpl(); break;
                case "7": nacao = new OrcSnagaNacaoNacaoImpl(); break;
                case "8": nacao = new UrukHaiNacaoNacaoImpl(); break;
                default:
                    throw new Exception("Tipo de nação inválido.");
            }

            switch (parts[2]) {
                case "1": personagem = new MagoDefaultPersonagemImpl(nomeJogador, habilidade, nacao);
                    break;
                case "2": personagem = new ArqueiroDefaultPersonagemImpl(nomeJogador, habilidade, nacao);
                    break;
                case "3": personagem = new GuerreiroDefaultPersonagemImpl(nomeJogador, habilidade, nacao);
                    break;
                default:
                    throw new Exception("Tipo de Personagem inválido.");
            }

            this.jogadores.add(new DefaultPlayer(playerId, personagem, controle));
        }
    }

    public List<Player> getJogadores() {
        return jogadores;
    }

}
