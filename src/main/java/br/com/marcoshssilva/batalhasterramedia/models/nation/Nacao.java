package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public interface Nacao {

    /**
     * Recupera o nome da nação
     * @return java.lang.String
     */
    public String getNome();

    /**
     * Recupera a casa pertinente a nação
     * @return br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes
     */
    public CasaDaNacaoEnumTypes getCasa();

}
