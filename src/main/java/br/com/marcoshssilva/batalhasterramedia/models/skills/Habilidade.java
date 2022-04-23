package br.com.marcoshssilva.batalhasterramedia.models.skills;

public class Habilidade {

    private Integer forca;
    private Integer precisao;
    private Integer velocidade;
    private Integer recuperacao;
    private Integer armadura;

    public Habilidade(Integer forca, Integer precisao, Integer velocidade, Integer recuperacao, Integer armadura) {
        this.forca = forca;
        this.precisao = precisao;
        this.velocidade = velocidade;
        this.recuperacao = recuperacao;
        this.armadura = armadura;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getPrecisao() {
        return precisao;
    }

    public void setPrecisao(Integer precisao) {
        this.precisao = precisao;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(Integer recuperacao) {
        this.recuperacao = recuperacao;
    }

    public Integer getArmadura() {
        return armadura;
    }

    public void setArmadura(Integer armadura) {
        this.armadura = armadura;
    }
}
