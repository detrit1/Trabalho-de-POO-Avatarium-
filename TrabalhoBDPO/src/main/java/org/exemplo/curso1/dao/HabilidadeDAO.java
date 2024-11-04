package org.exemplo.curso1.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.exemplo.curso1.model.Habilidades;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabilidadeDAO implements IHabilidade, IConst {
    private String sql;

    public void inserirHB(Habilidades habilidade){

        // Ajuste a consulta SQL para não incluir id_habilidade, que será gerado automaticamente
        sql = "INSERT INTO habilidades (nome_habilidade, dano, custo_mana) VALUES (?,?,?)";
        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, habilidade.getNome());
            pstmt.setInt(2, habilidade.getDano());
            pstmt.setInt(3, habilidade.getMana());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar habilidade no banco de dados: " + e.getMessage());
        }
    }

    public void atualizarBD(Habilidades habilidades) throws SQLException {
        sql = "UPDATE habilidades SET nome_habilidade=?, custo_mana=?, dano=? WHERE nome_habilidade=?;";

        Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        PreparedStatement pstmt = conexao.prepareStatement(sql);


        pstmt.setString(1, habilidades.getNome());
        pstmt.setInt(2, habilidades.getDano());
        pstmt.setInt(3, habilidades.getMana());
        pstmt.setString(4, habilidades.getNome());
        pstmt.executeUpdate();

    }
    public void excluirBD(Habilidades habilidade) throws SQLException {
        sql = "DELETE FROM habilidades WHERE nome_habilidade = ?";
        Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.executeUpdate();

    }
    public List<Habilidades> buscarTodosH() {
        ArrayList<Habilidades> habilidades = new ArrayList<>();

        // Exemplo de conexão e execução de consulta (substitua conforme sua configuração)
        try {
            Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM habilidades;");
            while (rs.next()) {
                Habilidades habilidades1 = new Habilidades(
                        rs.getString("nome_habilidade"),
                        rs.getInt("custo_mana"),
                        rs.getInt("dano")
                );
                habilidades.add(habilidades1); // Adiciona o habilidades à lista
            }

        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar habilidades: \{e.getMessage()}");
        }

        return habilidades; // Retorna a lista de jogadores
    }

}


