package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.property.*;
import javafx.fxml.*;


//Class to load menu separately from main 
public class MainSceneLoader extends Main {
	private final Stage primaryStage;
	private final double width;
	private final double height;
	
	//Constructor
	public MainSceneLoader(Stage stage, double width, double height) {
		this.primaryStage = stage;
		this.width = width;
		this.height = height;
	}
	
	//Returns scene to load into stage
	public Scene createMainMenu() {
		Label title = new Label("Main Menu");
		VBox root = new VBox(20, title, createPlay(), createQuit());
        root.setAlignment(Pos.CENTER);
        return new Scene(root);
	}
	
	//Creates quit button
	public Node createQuit() {
		Button results = new Button("Quit Game");
		results.setOnAction(evt -> this.primaryStage.close());
		return results;
	}
	
	//Creates play button
	public Node createPlay() {
		Button results = new Button("Play Game");
		results.setOnAction(evt -> startGame());
		return results;
	}
	
	//Load the game
	public void startGame() {
		GameSceneLoader playGame = new GameSceneLoader(primaryStage, width, height);
		Scene gameScene = playGame.createGame();
		primaryStage.setScene(gameScene);
		primaryStage.centerOnScreen();
	}
}