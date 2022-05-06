package br.com.marcoshssilva.batalhasterramedia.models.persons;

import br.com.marcoshssilva.batalhasterramedia.models.nation.Nacao;
import br.com.marcoshssilva.batalhasterramedia.models.persons.enums.ModoDoPersonagemEnumType;
import br.com.marcoshssilva.batalhasterramedia.models.skills.Habilidade;

public class MagoDefaultPersonagemImpl extends AbstractDefaultPersonagem{

    public MagoDefaultPersonagemImpl(String nome, Habilidade habilidade, Nacao nacao) {
        super(nome, habilidade, nacao);
    }

    public MagoDefaultPersonagemImpl(String nome, Habilidade habilidade, Nacao nacao, ModoDoPersonagemEnumType modoDoPersonagem) {
        super(nome, habilidade, nacao, modoDoPersonagem);
    }

    public MagoDefaultPersonagemImpl() {
    }

    @Override
    public Double getDanoAtaqueCurto() {
        return 5.00 + (this.getHabilidade().getForca() * 0.4);
    }

    @Override
    public Double getDanoAtaqueLongo() {
        return 15.00 + (this.getHabilidade().getForca() * 0.85);
    }

    @Override
    public Double getResistencia() {
        return 10.00 + (this.getHabilidade().getArmadura() * 0.4);
    }

    @Override
    public Double getVigor() {
        return 100.00 + (this.getHabilidade().getRecuperacao() * 0.4);
    }

    @Override
    public Boolean podeAtacarLonge() {
        return true;
    }

    @Override
    public Boolean podeAtacarCurto() {
        return true;
    }

    @Override
    public Boolean podeDefender() {
        return false;
    }
}
