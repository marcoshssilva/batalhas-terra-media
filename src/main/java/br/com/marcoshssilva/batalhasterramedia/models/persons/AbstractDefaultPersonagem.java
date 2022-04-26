package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
import br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType;
import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

public abstract class AbstractDefaultPersonagem implements Personagem {

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
}
