package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public class HobbitNacaoImpl extends AbstractDefaultNacao{

    public HobbitNacaoImpl() {
        this.casa = CasaDaNacaoEnumTypes.CONDADO;
        this.nome = "Hobbit";
    }

}
