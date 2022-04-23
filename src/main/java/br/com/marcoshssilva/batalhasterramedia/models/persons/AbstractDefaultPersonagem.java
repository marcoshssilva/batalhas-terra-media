package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

public abstract class AbstractDefaultPersonagem implements Personagem {

    private String nome;
    private Habilidade habilidade;
    private Nacao nacao;

    public AbstractDefaultPersonagem(String nome, Habilidade habilidade, Nacao nacao) {
        this.nome = nome;
        this.habilidade = habilidade;
    }

    public AbstractDefaultPersonagem() { }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    @Override
    public Nacao getNacao() {
        return nacao;
    }

    public void setNacao(Nacao nacao) {
        this.nacao = nacao;
    }
}
