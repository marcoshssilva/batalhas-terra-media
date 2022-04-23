package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public class AnaoNacaoImpl extends AbstractDefaultNacao {

    public AnaoNacaoImpl() {
        this.casa = CasaDaNacaoEnumTypes.COLINAS_DE_FERRO;
        this.nome = "Anão";
    }

}
