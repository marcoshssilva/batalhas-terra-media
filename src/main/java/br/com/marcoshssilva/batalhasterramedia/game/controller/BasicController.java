package br.com.marcoshssilva.batalhasterramedia.game.controller;

import br.com.marcoshssilva.batalhasterramedia.models.controls.ControleDoJogador;
import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BasicController implements ControleDoJogador {

    private final InputStream  cmdInput;
    private final OutputStream cmdOutput;

    private Scanner reader;

    public BasicController() {
        this(System.in, System.out);
    }

    public BasicController(InputStream cmdInput, OutputStream cmdOutput) {
        this.cmdInput  = cmdInput;
        this.cmdOutput = cmdOutput;
    }


    @Override
    public void requisitarAcao(CampoDeBatalha campo, Player player) {
        try {
            String response = null;
            String printMessage = new StringBuilder()
                    .append("REQUISITANDO AÇÃO DE")
                    .append(" ")
                    .append(player.getPlayerId())
                    .append("\n \n")
                    .append("Exemplo ATAQUE MOVIMENTO:  2000 10 10 (220 | 330)\n")
                    .append("Exemplo ATAQUE CURTO    :  1000 10 10\n")
                    .append("Exemplo ATAQUE LONGO    :  1001 10 10\n")
                    .append("INFORME o CODIGO:")
                    .toString();

            response = entradaDeAcao(printMessage, false, true);
            // dados da acao
            String[] partsResponse = response.split(" ");
            // ataque curto
            if (partsResponse[0].equals("1000")) {
                this.atacarCurto(
                        Integer.valueOf(partsResponse[1]),
                        Integer.valueOf(partsResponse[2]),
                        campo,
                        player
                );
            }

            // ataque longo
            if (partsResponse[0].equals("1001")) {
                this.atacarLongo(
                        Integer.valueOf(partsResponse[1]),
                        Integer.valueOf(partsResponse[2]),
                        campo,
                        player
                );
            }

            // movimento
            if (partsResponse[0].equals("2000")) {
                SentidoEnumType sentido = null;

                switch (partsResponse[3]) {
                    case "220":
                        sentido = SentidoEnumType.ESQUERDA_PARA_DIREITA;
                        break;
                    case "330":
                        sentido = SentidoEnumType.DIREITA_PARA_ESQUERDA;
                        break;
                }

                this.mover(
                        Integer.valueOf(partsResponse[1]),
                        Integer.valueOf(partsResponse[2]),
                        sentido,
                        campo,
                        player
                );
            }

        } catch (Exception e1) {
            try {
                this.saidaDeAcao("ERRO DE COMANDO Controller");

            } catch (Exception e2) {
                e2.printStackTrace();

            } finally {
                e1.printStackTrace((PrintStream) cmdOutput);

            }



        }
    }

    // private methods

    private String entradaDeAcao(String message, boolean breakLine, boolean fullLine) throws IOException {
        String msg = null;
        this.reader = new Scanner(this.cmdInput);

        if (breakLine) {
            this.saidaDeAcao(message);
        } else {
            this.saidaDeAcao(message);
        }

        if (fullLine) {
            msg = this.reader.nextLine();
        } else {
            msg = this.reader.next();
        }
        this.reader.close();
        return msg;
    }

    private void saidaDeAcao(String message) throws IOException {
        this.cmdOutput.write(message.getBytes(StandardCharsets.UTF_8));
    }

    /*
        Ações do Controle
     */

    private void atacarCurto(int offsetX, int offsetY, CampoDeBatalha campo, Player player)
            throws
            AreaDeCampoNaoPodeAtacarZonaException,
            AreaDeCampoNaoExisteJogadorRequisitadoException
    {
        campo.atacarAreaComAtaqueCurto(player.getPlayerId(), offsetX, offsetY);
    }

    private void atacarLongo(int offsetX, int offsetY, CampoDeBatalha campo, Player player)
            throws
            AreaDeCampoNaoPodeAtacarZonaException,
            AreaDeCampoNaoExisteJogadorRequisitadoException,
            AreaDeCampoInexistenteException
    {
        campo.atacarAreaComAtaqueLongo(player.getPlayerId(), offsetX, offsetY);
    }

    private void mover (int offsetX, int offsetY, SentidoEnumType sentido, CampoDeBatalha campo, Player player)
            throws
            AreaDeCampoNaoPodeMoverPersonagemException,
            AreaDeCampoHabitadaException,
            AreaDeCampoInexistenteException
    {
        campo.moverPlayer(player.getPlayerId(), offsetX, offsetY, sentido);
    }

}
