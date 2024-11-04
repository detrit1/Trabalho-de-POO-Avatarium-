package org.exemplo.curso1.main;

import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            System.out.println(getClass().getResource("/org/exemplo/curso1/main/menus.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/org/exemplo/curso1/main/menus.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Meu RPG");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a tela: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
// criação oficial do projeto

