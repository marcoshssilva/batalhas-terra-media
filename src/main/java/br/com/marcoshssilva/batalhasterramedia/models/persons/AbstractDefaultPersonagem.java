package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
import br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType;
import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

import java.util.stream.Stream;

public abstract class AbstractDefaultPersonagem implements Personagem {

    public final Double PERCENTUAL_PADRAO_REDUTOR_CASO_MODO_DEFESA = 0.45;

    private String nome;
    private Habilidade habilidade;
    private Nacao nacao;
    private ModoDoPersonagemEnumType modoDoPersonagem;
    private Double vida;

    public AbstractDefaultPersonagem(String nome, Habilidade habilidade, Nacao nacao) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.nacao = nacao;
        // when personagem inits without Modo defined
        this.modoDoPersonagem = ModoDoPersonagemEnumType.PARADO;
        // when personagem inits with default life
        this.vida = 100.00;
    }

    public AbstractDefaultPersonagem(String nome, Habilidade habilidade, Nacao nacao, ModoDoPersonagemEnumType modoDoPersonagem) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.nacao = nacao;
        this.modoDoPersonagem = modoDoPersonagem;
        // when personagem inits with default life
        this.vida = 100.00;
    }

    public AbstractDefaultPersonagem() { }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Habilidade getHabilidade() {
        return habilidade;
    }

    @Override
    public Nacao getNacao() {
        return nacao;
    }

    @Override
    public ModoDoPersonagemEnumType getModoDoPersonagem() {
        return modoDoPersonagem;
    }

    @Override
    public void setModoDoPersonagem(ModoDoPersonagemEnumType modo) {
        this.modoDoPersonagem = modo;
    }

    @Override
    public Double getVida() {
        return this.vida;
    }

    @Override
    public Double getVelocidade() {
        return 30.00 + (this.getHabilidade().getVelocidade() * 0.7);
    }

    @Override
    public Boolean podeMover() {
        ModoDoPersonagemEnumType[] modosAceitaveis = { ModoDoPersonagemEnumType.MOVIMENTO, ModoDoPersonagemEnumType.PARADO, ModoDoPersonagemEnumType.DEFESA };
        if (Stream.of(modosAceitaveis).anyMatch(a -> a.equals(getModoDoPersonagem())) ) {
            return true;
        }
        return false;
    }

    @Override
    public void receberDano(final Double potenciaAtaque) {
        if (podeDefender()
                && this.getModoDoPersonagem().equals(ModoDoPersonagemEnumType.DEFESA)
        ) {
            // reduz a vida de acordo com diferena entre potencie e resistencia mediante coeficiente redutor
            this.vida -= __calcularDano(potenciaAtaque, getResistencia()) * PERCENTUAL_PADRAO_REDUTOR_CASO_MODO_DEFESA;
        } else {
            // reduz a vida de acordo com a diferenca entre potencia e resistencia
            this.vida -= __calcularDano(potenciaAtaque, getResistencia());
        }
    }

    // protected methods -> only avaible by extends

    protected void setNacao(Nacao nacao) {
        this.nacao = nacao;
    }

    protected void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    // private methods -> only avaible by this class

    private Double __calcularDano(final Double potenciaAtaque, final Double potenciaDefesa) {
        Double danoMinimo = 0.00;
        if ((potenciaAtaque - potenciaDefesa) < danoMinimo) {
            return danoMinimo;
        } else {
            return potenciaAtaque - potenciaDefesa;
        }
    }
}
