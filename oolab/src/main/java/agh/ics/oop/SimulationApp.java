package agh.ics.oop;

import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
            BorderPane viewRoot = loader.load();
            SimulationPresenter presenter = loader.getController();

            WorldMap map = new RectangularMap(10, 10); // Możesz użyć GrassField lub innego typu mapy
            presenter.setWorldMap(map); // Ustawienie mapy w prezenterze
            presenter.drawMap(); // Rysowanie mapy na ekranie

            configureStage(primaryStage, viewRoot);
            primaryStage.show();
        }catch (IOException e){e.printStackTrace();}
    }


    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        Scene scene = new Scene(viewRoot); // Tworzy nową scenę z widokiem uzyskanym z FXML
        primaryStage.setScene(scene); // Ustawia nową scenę w oknie aplikacji
        primaryStage.setTitle("Symulacja"); // Ustawia tytuł okna aplikacji
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty()); // Ustawia minimalną szerokość okna
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty()); // Ustawia minimalną wysokość okna
    }

}

