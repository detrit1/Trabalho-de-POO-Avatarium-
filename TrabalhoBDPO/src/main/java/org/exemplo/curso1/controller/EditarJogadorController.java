package org.exemplo.curso1.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.exemplo.curso1.dao.JogadorDAO;
import org.exemplo.curso1.model.Jogador;

import java.sql.SQLException;
import java.util.List;

public class EditarJogadorController {
    private ObservableList<Jogador> observableJogadores;
    private Jogador jogadorSelecionado;


    @FXML
    private TextField campoClasse;

    @FXML
    private TextField campoMana;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoNivel;

    @FXML
    private TextField campoVida;

    @FXML
    private TableColumn<Jogador, String> colClasse;

    @FXML
    private TableColumn<Jogador, Integer> colNivel;

    @FXML
    private TableColumn<Jogador, String> colNome;

    @FXML
    private Button excluirButton;

    @FXML
    private Button salvarButton;

    @FXML
    private TableView<Jogador> tabelaPersonagens;

    @FXML
    void handleExcluirButton(ActionEvent event) {
        if(jogadorSelecionado != null){
            JogadorDAO jogadorDAO = new JogadorDAO();

            try {
                jogadorDAO.excluirBD(jogadorSelecionado);

                jogadorSelecionado = null;
                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();

                // Exibir erro na tela
            }
        }
    }

    @FXML
    void handleSaveButton(ActionEvent event) {
        if(jogadorSelecionado != null){
            jogadorSelecionado.setNivel(Integer.parseInt(campoNivel.getText()));
            jogadorSelecionado.setClasse(campoClasse.getText());
            jogadorSelecionado.setNome(campoNome.getText());
            jogadorSelecionado.setP_mana(Integer.parseInt(campoMana.getText()));
            jogadorSelecionado.setP_vida(Integer.parseInt(campoVida.getText()));

            JogadorDAO jogadorDAO = new JogadorDAO();

            try {
                jogadorDAO.atualizarBD(jogadorSelecionado);
                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void atualizarTabela(){
        JogadorDAO jogadorDAO = new JogadorDAO();
        List<Jogador> jogadores = jogadorDAO.buscarTodos();

        observableJogadores.setAll(jogadores);
    }

    public void initialize(){
        observableJogadores = tabelaPersonagens.getItems();

        colClasse.setCellValueFactory(new PropertyValueFactory<>("classe"));
        colNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        JogadorDAO jogadorDAO = new JogadorDAO();
        List<Jogador> jogadores = jogadorDAO.buscarTodos();

        observableJogadores.setAll(jogadores);

        tabelaPersonagens.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                jogadorSelecionado = newSelection;

                campoClasse.setText(jogadorSelecionado.getClasse());
                campoMana.setText(Integer.toString(jogadorSelecionado.getP_mana()));
                campoNome.setText(jogadorSelecionado.getNome());
                campoNivel.setText(Integer.toString(jogadorSelecionado.getNivel()));
                campoVida.setText(Integer.toString(jogadorSelecionado.getP_vida()));
            }
        });
    }

}