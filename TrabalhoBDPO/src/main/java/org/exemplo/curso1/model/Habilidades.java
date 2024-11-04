package org.exemplo.curso1.model;

public class Habilidades {
    private int id_habilidade;
    private String nome_habilidade;
    private int custo_mana;
    private int dano;

    public Habilidades(int id_habilidade, String nome_habilidade, int custo_mana, int dano) {
        this.id_habilidade = id_habilidade;
        this.nome_habilidade = nome_habilidade;
        this.custo_mana = custo_mana;
        this.dano = dano;

    }
    public String getNome() {
        return nome_habilidade;
    }
    public void setNome(String nome_habilidade) {
        this.nome_habilidade = nome_habilidade;
    }
    public int getMana() {
        return custo_mana;
    }
    public void setMana(int custo_mana) {
        this.custo_mana = custo_mana;
    }
    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }

    public Habilidades(String nome_habilidade, int custo_mana, int dano) {
        this.nome_habilidade = nome_habilidade;
        this.custo_mana = custo_mana;
        this.dano = dano;
    }
    public String toString() {
        return "Habilidade{" +
                "ID = " + id_habilidade +
                ", Dome =' " + nome_habilidade + '\'' +
                ", Dano = " + dano +
                '}';
    }
}

