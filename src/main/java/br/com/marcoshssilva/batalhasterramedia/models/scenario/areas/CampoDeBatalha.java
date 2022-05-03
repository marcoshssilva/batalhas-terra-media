package br.com.marcoshssilva.batalhasterramedia.models.scenario.areas;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.zone.AreaDoCampo;

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
            throws AreaDeCampoInexistenteException,
                   AreaDeCampoHabitadaException;

    /**
     * move o personagem dentro do campo de batalha
     *
     * @param playerId | id do jogador que irá movimentar
     * @param saltoX   | quantidade de casas que ira mover sobre o eixo X
     * @param saltoY   | quantidade de casas que ira mover sobre o eixo Y
     * @param sentido  | orientacao do movimento
     *
     * @throws AreaDeCampoNaoPodeMoverPersonagemException
     *         Falha ocorrida quando nao é possivel mover o personagem
     *         para a area desejada.
     */
    public void moverPlayer(String playerId, int saltoX, int saltoY, SentidoEnumType sentido)
            throws AreaDeCampoNaoPodeMoverPersonagemException,
                   AreaDeCampoHabitadaException,
                   AreaDeCampoInexistenteException;

    /**
     * coordena um devido jogador a atacar uma determina area
     * utilizando um ataque longo.
     *
     * @param playerId | id do jogador
     * @param eixoX    | eixoX alvo
     * @param eixoY    | eixoY alvo
     *
     * @throws AreaDeCampoNaoPodeAtacarZonaException
     *         Ocorrido quando a zona esta distante e nao pode ser alvejada pelo ataque
     *
     * @throws AreaDeCampoNaoExisteJogadorRequisitadoException
     *         Ocorrido quando o playerId nao existe dentro do campo de batalha
     */
    public void atacarAreaComAtaqueLongo(String playerId, int eixoX, int eixoY)
            throws AreaDeCampoNaoPodeAtacarZonaException,
            AreaDeCampoNaoExisteJogadorRequisitadoException, AreaDeCampoInexistenteException;

    /**
     * coordena um devido jogador a atacar uma determina area
     * utilizando um ataque curto.
     *
     * @param playerId | id do jogador
     * @param eixoX    | eixoX alvo
     * @param eixoY    | eixoY alvo
     *
     * @throws AreaDeCampoNaoPodeAtacarZonaException
     *         Ocorrido quando a zona esta distante e nao pode ser alvejada pelo ataque
     *
     * @throws AreaDeCampoNaoExisteJogadorRequisitadoException
     *         Ocorrido quando o playerId nao existe dentro do campo de batalha
     */
    public void atacarAreaComAtaqueCurto(String playerId, int eixoX, int eixoY)
            throws AreaDeCampoNaoPodeAtacarZonaException,
                   AreaDeCampoNaoExisteJogadorRequisitadoException;

    /**
     * @return Array bidimensional de zonas do campo de batalha
     */
    public AreaDoCampo[][] getZonasDoCampoDeBatalha();
}
