package br.com.marcoshssilva.batalhasterramedia.models.persons;

public class ArqueiroDefaultPersonagemImpl extends AbstractDefaultPersonagem{
    @Override
    public Double getDanoAtaqueCurto() {
        return 5.00 + (this.getHabilidade().getForca() * 0.6);
    }

    @Override
    public Double getDanoAtaqueLongo() {
        return 15.00 + (this.getHabilidade().getForca() * 0.75);
    }

    @Override
    public Double getResistencia() {
        return 10.00 + (this.getHabilidade().getArmadura() * 0.4);
    }

    @Override
    public Double getVigor() {
        return 100.00 + (this.getHabilidade().getRecuperacao() * 0.6);
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
