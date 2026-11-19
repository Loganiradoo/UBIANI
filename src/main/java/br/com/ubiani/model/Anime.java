package br.com.ubiani.model;

public class Anime {

    private int idAnimes;
    private String titulo;
    private String descricao;
    private int classificacao;
    private int anoDeLancamento;
    private int generoIdGenero;

    public Anime(int idAnimes, String titulo, String descricao,
            int classificacao, int anoDeLancamento, int generoIdGenero) {

        this.idAnimes = idAnimes;
        this.titulo = titulo;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.anoDeLancamento = anoDeLancamento;
        this.generoIdGenero = generoIdGenero;
    }

    public int getIdAnimes() {
        return idAnimes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getGeneroIdGenero() {
        return generoIdGenero;
    }

    @Override
    public String toString() {
        return "ID: " + idAnimes
                + " | Título: " + titulo
                + " | Ano: " + anoDeLancamento;
    }
}