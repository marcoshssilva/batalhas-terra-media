package br.com.marcoshssilva.batalhasterramedia.models.persons;

public class ArqueiroDefaultPersonagemImpl extends AbstractDefaultPersonagem{
    @Override
    public Double getDanoAtaqueCurto() {
        return 5.00;
    }

    @Override
    public Double getDanoAtaqueLongo() {
        return 15.00;
    }

    @Override
    public Double getResistencia() {
        return 10.00;
    }

    @Override
    public Double getVigor() {
        return 100.00;
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
    public Boolean podeDefenderCurto() {
        return false;
    }

    @Override
    public Boolean podeDefenderLongo() {
        return false;
    }
}
