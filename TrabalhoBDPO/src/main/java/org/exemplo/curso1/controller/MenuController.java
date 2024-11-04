package org.exemplo.curso1.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.exemplo.curso1.model.Jogador;

public class MenuController {

    @FXML
    protected ListView<Jogador> lvJogadores;

    @FXML
    private MenuItem menuEstudanteInclui;

    @FXML
    private MenuItem menuEstudanteAltera;

    @FXML
    private MenuItem telaVazia;

    // Método genérico para carregar e exibir uma nova tela
    private void carregarTela(String caminhoFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Stage newStage = new Stage();
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            newStage.setTitle(titulo);
            newStage.setScene(newScene);
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException e) {
            System.out.println("Erro ao carregar a tela: " + caminhoFXML);
            e.printStackTrace();
        }
    }

    @FXML
    void incluiPersonagemOnAction(ActionEvent event) {
        carregarTela("/org/exemplo/curso1/main/IncluiJogador.fxml", "Personagem");
    }
    @FXML
    void incluiHabilidadeOnAction(ActionEvent event) {
        carregarTela("/org/exemplo/curso1/main/IncluiHabilidade.fxml", "Habilidade");
    }

    @FXML
    public void excluiPersonagemOnAction(ActionEvent actionEvent) {
        carregarTela("/org/exemplo/curso1/main/EditarJogador.fxml", "Personagem");
    }

    @FXML
    public void excluirHabilidadeOnAction(ActionEvent actionEvent) {
        carregarTela("/org/exemplo/curso1/main/EditarHabilidade.fxml", "Habilidade");

    }

}
