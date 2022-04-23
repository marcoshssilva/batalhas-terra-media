package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
import br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType;
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

    /**
     * Retorna qual o modo ofensivo, defensivo ou movimentação do personagem
     * @return br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType
     */
    public ModoDoPersonagemEnumType getModoDoPersonagem();

    /**
     * Atribui um novo modo ao personagem
     *
     * @param modo br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType
     *        Novo modo que o personagem estará
     */
    public void setModoDoPersonagem(ModoDoPersonagemEnumType modo);
}
