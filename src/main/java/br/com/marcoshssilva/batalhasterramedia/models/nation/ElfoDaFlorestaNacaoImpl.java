package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public class ElfoDaFlorestaNacaoImpl extends AbstractDefaultNacao{

    public ElfoDaFlorestaNacaoImpl() {
        this.casa = CasaDaNacaoEnumTypes.FLORESTA_DAS_TREVAS;
        this.nome = "Elfo da Floresta";
    }

}
