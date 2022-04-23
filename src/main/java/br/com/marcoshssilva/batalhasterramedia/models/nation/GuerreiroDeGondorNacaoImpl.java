package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public class GuerreiroDeGondorNacaoImpl extends AbstractDefaultNacao{

    public GuerreiroDeGondorNacaoImpl() {
        this.casa = CasaDaNacaoEnumTypes.MINAS_TIRITH;
        this.nome = "Guerreiro de Gondor";
    }

}
