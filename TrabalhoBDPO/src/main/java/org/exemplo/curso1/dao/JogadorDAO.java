package org.exemplo.curso1.dao;

import java.sql.*;
import org.exemplo.curso1.model.Jogador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.exemplo.curso1.model.Jogador;
import org.exemplo.curso1.dao.IConst;
import java.util.List;
import java.util.ArrayList;


public class JogadorDAO implements IJogador, IConst {
    private String sql;

    public void inserirBD(Jogador jogador) {
        sql = "INSERT INTO personagem (nome, id_personagem, classe, nível, pontos_de_vida, pontos_de_mana) VALUES (?,?,?,?,?,?)";
        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, jogador.getNome());
            pstmt.setInt(2, jogador.getId_personagem());
            pstmt.setString(3, jogador.getClasse());
            pstmt.setInt(4, jogador.getNivel());
            pstmt.setInt(5, jogador.getP_vida());
            pstmt.setInt(6, jogador.getP_mana());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(STR."Erro ao salvar jogador no banco de dados: \{e.getMessage()}");
        }
    }
        public void atualizarBD(Jogador jogador) throws SQLException {
            sql = "UPDATE personagem SET nome=?, classe=?, nivel=?, pontos_de_vida=?, pontos_de_mana=? WHERE id_personagem=?;";

            Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
            PreparedStatement pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, jogador.getNome());
            pstmt.setString(2, jogador.getClasse());
            pstmt.setInt(3, jogador.getNivel());
            pstmt.setInt(4, jogador.getP_vida());
            pstmt.setInt(5, jogador.getP_mana());
            pstmt.setInt(6, jogador.getId_personagem());

            pstmt.executeUpdate();

        }
    public void excluirBD(Jogador jogador) throws SQLException {
        sql = "DELETE FROM personagem WHERE id_personagem = ?";
        try (Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, jogador.getId_personagem()); // Supondo que o jogador tenha um ID único
            pstmt.executeUpdate();
        }
    }
    public List<Jogador> buscarTodos() {
        List<Jogador> jogadores = new ArrayList<>();

        // Exemplo de conexão e execução de consulta (substitua conforme sua configuração)
        try {
            Connection conexao = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM personagem;");
            while (rs.next()) {
                // Cria um novo objeto Jogador com os dados do ResultSet
                Jogador jogador = new Jogador(
                        rs.getString("nome"),
                        rs.getInt("id_personagem"),
                        rs.getString("classe"),
                        rs.getInt("nivel"),
                        rs.getInt("pontos_de_vida"),
                        rs.getInt("pontos_de_mana")
                );
                jogadores.add(jogador); // Adiciona o jogador à lista
            }

        } catch (Exception e) {
            System.out.println(STR."Erro ao buscar jogadores: \{e.getMessage()}");
        }

        return jogadores; // Retorna a lista de jogadores
    }
}