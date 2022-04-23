package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

public interface Personagem {

    /**
     * Retorna o nome do personagem
     * @return java.lang.String
     */
    public String getNome();

    /**
     * Retorna a quantidade de energia disponivel do personagem
     * @return br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade
     */
    public Habilidade getHabilidade();

}
