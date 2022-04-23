package br.com.marcoshssilva.batalhasterramedia.models.nation.enums;

/**
 * lista uma serie de nações disponíveis para uso
 */
public enum CasaDaNacaoEnumTypes {

    CIRITH_UNGOL("Cirith Ungol"),
    PORTAO_NEGRO("Portão Negro"),
    ABISMO_DE_HELM("Abismo de Helm"),
    MINAS_TIRITH("Minas Tirith"),
    CONDADO("O Condado"),
    FLORESTA_DAS_TREVAS("Floresta das Trevas"),
    CARAS_GALADHON("Caras Galadhon"),
    COLINAS_DE_FERRO("Colinas de Ferro");

    private String nome;

    CasaDaNacaoEnumTypes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
