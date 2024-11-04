package org.exemplo.curso1.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.exemplo.curso1.dao.HabilidadeDAO;
import org.exemplo.curso1.model.Habilidades;

import java.sql.SQLException;
import java.util.List;

public class EditarHabilidadeController {
    private ObservableList<Habilidades> observableHabilidade;
    private Habilidades Habilidadeselecionado;


        @FXML
        private TextField campoMana;

        @FXML
        private TextField campoNome;

        @FXML
        private TextField campoDano;

        @FXML
        private TableColumn<Habilidades, Integer> colMana;

        @FXML
        private TableColumn<Habilidades, String> colNome;

        @FXML
        private TableColumn<Habilidades, Integer> colDano;

        @FXML
        private Button excluirButtonH;

        @FXML
        private Button salvarButtonH;

        @FXML
        private TableView<Habilidades> tabelaHabilidades;


    @FXML
    void handleExcluirButtonH(ActionEvent event) {
        if(Habilidadeselecionado!= null){
            HabilidadeDAO habilidadeDAO  = new HabilidadeDAO();

            try {
                habilidadeDAO.excluirBD(Habilidadeselecionado);

                Habilidadeselecionado = null;
                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();

                // Exibir erro na tela
            }
        }
    }

    @FXML
    void handleSaveButtonH(ActionEvent event) {
        if(Habilidadeselecionado != null){
            Habilidadeselecionado.setMana(Integer.parseInt(campoMana.getText()));
            Habilidadeselecionado.setDano(Integer.parseInt(campoDano.getText()));
            Habilidadeselecionado.setNome(campoNome.getText());


            HabilidadeDAO habilidadeDAO= new HabilidadeDAO();

            try {
                habilidadeDAO.atualizarBD(Habilidadeselecionado);
                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void atualizarTabela(){
        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
        List<Habilidades> habilidades = habilidadeDAO.buscarTodosH();

        observableHabilidade.setAll(habilidades);
    }

    public void initialize(){
        observableHabilidade = tabelaHabilidades.getItems();

        colDano.setCellValueFactory(new PropertyValueFactory<>("dano"));
        colMana.setCellValueFactory(new PropertyValueFactory<>("mana"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
        List<Habilidades> habilidades = habilidadeDAO.buscarTodosH();

        observableHabilidade.setAll(habilidades);

        tabelaHabilidades.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                Habilidadeselecionado = newSelection;

                campoDano.setText(Integer.toString(Habilidadeselecionado.getDano()));
                campoMana.setText(Integer.toString(Habilidadeselecionado.getMana()));
                campoNome.setText((Habilidadeselecionado.getNome()));
            }
        });
    }

}
