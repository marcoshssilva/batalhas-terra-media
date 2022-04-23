package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
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

    /**
     * Retorna uma implementação de uma nação correspondente ao personagem
     * @return br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao
     */
    public Nacao getNacao();
}
