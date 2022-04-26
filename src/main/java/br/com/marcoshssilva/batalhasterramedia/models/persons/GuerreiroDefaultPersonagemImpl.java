package br.com.marcoshssilva.batalhasterramedia.models.persons;

public class GuerreiroDefaultPersonagemImpl extends AbstractDefaultPersonagem{
    @Override
    public Double getDanoAtaqueCurto() {
        return 20.00;
    }

    @Override
    public Double getDanoAtaqueLongo() {
        return 0.00;
    }

    @Override
    public Double getResistencia() {
        return 15.00;
    }

    @Override
    public Double getVigor() {
        return 100.00;
    }

    @Override
    public Boolean podeAtacarLonge() {
        return false;
    }

    @Override
    public Boolean podeAtacarCurto() {
        return true;
    }

    @Override
    public Boolean podeDefenderCurto() {
        return true;
    }

    @Override
    public Boolean podeDefenderLongo() {
        return true;
    }
}
