package org.exemplo.curso1.controller;

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
import org.exemplo.curso1.dao.HabilidadeDAO;
import org.exemplo.curso1.model.Habilidades;
import org.exemplo.curso1.model.Habilidades;

public class IncluiHabilidadeController {

    @FXML
    private Label lblNomeTela;

    @FXML
    private TextField txtNomHab;

    @FXML
    private TextField txtCustoMana;

    @FXML
    private TextField txtIdHab;

    @FXML
    private TextField txtDanHab;

    @FXML
    private Button btnConfHab;

    @FXML
    private Button btnVoltarHab;

    private ObservableList<Habilidades> listaHabilidades = FXCollections.observableArrayList();

    @FXML
    private ListView<Habilidades> listViewHabilidades;


    @FXML
   void btnConfHabOnAction() {
        try {
            String nome_habilidade = txtNomHab.getText();
            int idhab = Integer.parseInt(txtIdHab.getText());
            int custo_mana = Integer.parseInt(txtCustoMana.getText());
            int dano = Integer.parseInt(txtDanHab.getText());

            Habilidades habilidade = new Habilidades(nome_habilidade,custo_mana, dano);
            System.out.println(habilidade);

            HabilidadeDAO habilidadeDAO = new HabilidadeDAO();
            habilidadeDAO.inserirHB(habilidade);

            listaHabilidades.add(habilidade);
            listViewHabilidades.setItems(listaHabilidades);

            limparCampos();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um valor válido para nível.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar habilidade: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtNomHab.clear();
        txtDanHab.clear();
        txtIdHab.clear();
        txtCustoMana.clear();
    }

    @FXML
    void btnVoltarHabOnAction(ActionEvent event) {
        Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageAtual.close();
    }
}
