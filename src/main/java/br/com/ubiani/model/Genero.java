
package br.com.ubiani.model;

public class Genero {

    private int idGenero;
    private String nome;

    public Genero(int idGenero, String nome) {
        this.idGenero = idGenero;
        this.nome = nome;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
