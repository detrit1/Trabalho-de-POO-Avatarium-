package org.exemplo.curso1.model;

public class Jogador {
    private String nome;
    private int id_personagem;
    private String classe;
    private int nivel;
    private int p_vida;
    private int p_mana;

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getP_mana() {
        return p_mana;
    }
    public void setP_mana(int p_mana) {
        this.p_mana = p_mana;
    }

    public int getP_vida() {
        return p_vida;
    }
    public void setP_vida(int p_vida) {
        this.p_vida = p_vida;
    }

    public String getClasse() {
        return classe;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getId_personagem() {
        return id_personagem;
    }
    public void setId_personagem(int id_personagem) {
        this.id_personagem = id_personagem;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getp_vida(){
        return p_vida;
    }
    public void setp_vida(int p_vida){
        this.p_vida = p_vida;
    }

    public int p_mana(){
        return p_mana;
    }
    public void setp_mana(int p_mana){
        this.p_mana = p_mana;
    }

    public Jogador(String nome, int id_personagem, String classe, int nivel, int p_vida, int p_mana) {
        this.nome = nome;
        this.id_personagem = id_personagem;
        this.classe = classe;
        this.nivel = nivel;
        this.p_vida = p_vida;
        this.p_mana = p_mana;
    }
    public String toString() {
        return "Jogador{" +
                "PersonagemID = " + id_personagem +
                ", nome =' " + nome + '\'' +
                ", classe = " + classe +
                '}';
    }

}


