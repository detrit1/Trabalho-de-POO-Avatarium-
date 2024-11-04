package org.exemplo.curso1.model;

public class Equipamento {
    private int idEquipamento;
    private String nomeEquipamento;
    private String tipoEquipamento;
    private String AttBonus;

    public Equipamento(int idEquipamento, String nomeEquipamento, String tipoEquipamento, String attBonus) {
        this.idEquipamento = idEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        AttBonus = attBonus;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getAttBonus() {
        return AttBonus;
    }

    public void setAttBonus(String attBonus) {
        AttBonus = attBonus;
    }
}
