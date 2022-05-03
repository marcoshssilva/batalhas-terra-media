package br.com.marcoshssilva.batalhasterramedia.models.scenario.areas;

import br.com.marcoshssilva.batalhasterramedia.models.players.Player;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.areas.dto.PosicaoNoCampoDto;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.zone.AreaDoCampo;
import br.com.marcoshssilva.batalhasterramedia.models.scenario.zone.CampoVazio;

public class CampoDeBatalhaDefaultLinearImpl implements CampoDeBatalha{

     private AreaDoCampo[] campoDeBatalha;

     public CampoDeBatalhaDefaultLinearImpl(int size) {
          // inicializa um campo de batalha com a quantidade de posicoes desejada
          this.campoDeBatalha = new AreaDoCampo[size];
          // inicializa o campo de batalha com areas totalmente vazias
          for (int i = 0; i < this.campoDeBatalha.length; i++) {
               this.campoDeBatalha[i] = new CampoVazio();
          }
     }

     @Override
     public void adicionarPlayer(String playerId, Player player, Integer eixoX, Integer eixoY)
             throws AreaDeCampoInexistenteException,
                    AreaDeCampoHabitadaException {

          this.checkPosicaoCampo(eixoX);
          this.checkPosicaoJogador(eixoX);

          this.campoDeBatalha[eixoX].inserirPlayer(player, playerId);
     }

     @Override
     public void moverPlayer(String playerId, int saltoX, int saltoY, SentidoEnumType sentido)
             throws AreaDeCampoNaoPodeMoverPersonagemException,
                    AreaDeCampoHabitadaException,
                    AreaDeCampoInexistenteException {

          // procura o jogador no campo de batalha
          PosicaoNoCampoDto busca = buscarJogador(playerId);
          // retorna erro caso o personagem não possa se movimentar
          if (!busca.getPlayer().getPersonagem().podeMover()) throw new AreaDeCampoNaoPodeMoverPersonagemException();

          int indexAreaAlvo = 0;
          switch (sentido) {
               case DIREITA_PARA_ESQUERDA:
                    indexAreaAlvo = busca.getIndexX() - saltoX;
                    break;
               case ESQUERDA_PARA_DIREITA:
                    indexAreaAlvo = busca.getIndexX() + saltoX;
                    break;
          }

          this.checkPosicaoCampo(indexAreaAlvo);
          this.checkPosicaoJogador(indexAreaAlvo);

          this.campoDeBatalha[busca.getIndexX()].removerPlayer();
          this.campoDeBatalha[indexAreaAlvo].inserirPlayer(busca.getPlayer(), busca.getPlayerId());

     }

     @Override
     public void atacarAreaComAtaqueLongo(String playerId, int eixoX, int eixoY) throws AreaDeCampoNaoPodeAtacarZonaException, AreaDeCampoNaoExisteJogadorRequisitadoException, AreaDeCampoInexistenteException {
          // falta implementação

          /* checkPosicaoCampo(eixoX);
          PosicaoNoCampoDto jogadorDto = buscarJogador(playerId);
          if (jogadorDto == null) throw new AreaDeCampoNaoExisteJogadorRequisitadoException(); */

     }

     @Override
     public void atacarAreaComAtaqueCurto(String playerId, int eixoX, int eixoY) throws AreaDeCampoNaoPodeAtacarZonaException, AreaDeCampoNaoExisteJogadorRequisitadoException {
          // falta implementação
     }

     @Override
     public AreaDoCampo[][] getZonasDoCampoDeBatalha() {
          AreaDoCampo[][] areas = { this.campoDeBatalha };
          return areas;
     }

     // private methods -> only avaible by this class

     private PosicaoNoCampoDto buscarJogador(String playerId) {
          // armazena o player encontrado em DTO
          PosicaoNoCampoDto po = null;
          // procura o playerId dentro do campo de batalha
          for (int i = 0; i < this.campoDeBatalha.length; i++) {
               if (playerId.equals( this.campoDeBatalha[i].getPlayerId() )) {
                    po = new PosicaoNoCampoDto(i, 0, this.campoDeBatalha[i].getPlayerId(), this.campoDeBatalha[i].getPlayer());
                    break;
               }
               continue;
          }
          // devolve o DTO com dados do jogador
          return po;
     }

     private void checkPosicaoCampo(int eixoX) throws AreaDeCampoInexistenteException {
          int inicioEixoX = 0;
          int finalEixoX = this.campoDeBatalha.length;

          if (eixoX < inicioEixoX || eixoX >= finalEixoX)
               throw new AreaDeCampoInexistenteException();


     }

     private void checkPosicaoJogador(int eixoX) throws AreaDeCampoHabitadaException {
          if (this.campoDeBatalha[eixoX].areaEstaOcupada())
               throw new AreaDeCampoHabitadaException();
     }
}
