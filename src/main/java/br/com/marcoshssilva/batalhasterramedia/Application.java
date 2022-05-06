package br.com.marcoshssilva.batalhasterramedia;

import br.com.marcoshssilva.batalhasterramedia.game.Game;
import br.com.marcoshssilva.batalhasterramedia.game.SaveGameLoader;

import java.io.File;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Informe o caminho exato para o jogo salvo: ");
        String caminho = leitura.nextLine();

        try {
            SaveGameLoader saveGameLoader = new SaveGameLoader(new File(caminho));
            Game jogo = new Game(saveGameLoader);
            jogo.execGame();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
