package br.com.marcoshssilva.batalhasterramedia.models.nation;

import br.com.marcoshssilva.batalhasterramedia.models.nation.enums.CasaDaNacaoEnumTypes;

public abstract class AbstractDefaultNacao implements Nacao {

    protected String nome;
    protected CasaDaNacaoEnumTypes casa;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public CasaDaNacaoEnumTypes getCasa() {
        return casa;
    }

}
