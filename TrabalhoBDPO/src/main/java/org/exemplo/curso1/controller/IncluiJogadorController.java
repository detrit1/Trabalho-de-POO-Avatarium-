package org.exemplo.curso1.controller;

import org.exemplo.curso1.dao.JogadorDAO;
import org.exemplo.curso1.model.Jogador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;



public class IncluiJogadorController {

    @FXML
    private Label lblNomeTela;

    @FXML
    private TextField txtIdPer;

    @FXML
    private TextField txtNomEst;

    @FXML
    private TextField txtNivJog;

    @FXML
    private TextField txtClasJog;

    @FXML
    private TextField txtManaJog;

    @FXML
    private TextField txtVdaJog;

    @FXML
    private Button btnConf;

    @FXML
    private Button btnVoltar;

    @FXML

    private ObservableList<Jogador> listaJogadores = FXCollections.observableArrayList();
    // para adicionar a tabela
    @FXML
    private ListView<Jogador> listViewJogadores;



    @FXML
    void btnConfOnAction() {
        try {
            String nome = txtNomEst.getText();
            int id_personagem = Integer.parseInt(txtIdPer.getText());
            int nível = Integer.parseInt(txtNivJog.getText());
            String classe = txtClasJog.getText();
            int pMana = Integer.parseInt(txtManaJog.getText());
            int pVida = Integer.parseInt(txtVdaJog.getText());

            Jogador jogador = new Jogador(nome, id_personagem, classe, nível, pVida, pMana);
            System.out.println(jogador);

            JogadorDAO jogadorDAO = new JogadorDAO();
            jogadorDAO.inserirBD(jogador);

            listaJogadores.add(jogador); // Adiciona o jogador à lista
            listViewJogadores.setItems(listaJogadores); // Atualiza o ListView

            limparCampos(); // Limpa os campos após adicionar


        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira valores válidos para nível, pontos de mana e pontos de vida.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar jogador: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtNomEst.clear();
        txtIdPer.clear();
        txtNivJog.clear();
        txtClasJog.clear();
        txtManaJog.clear();
        txtVdaJog.clear();
    }


    @FXML
    void btnVoltarOnAction(ActionEvent  event) {
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
        // Lógica para voltar, se aplicável
    }
}
