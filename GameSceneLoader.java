package application;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.property.*;
import javafx.fxml.*;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class GameSceneLoader {
	private final Stage primaryStage;
	private final double width;
	private final double height;
	private VBox root; //Universal VBox to store things in
	
	//Constructor
	public GameSceneLoader(Stage stage, double width, double height) {
		this.primaryStage = stage;
		this.width = width;
		this.height = height;
	}
	
	public Scene createGame() {
		Region results = memorizeMenu();
		return new Scene(results, width, height);
	}
	
	//The game: First, shows a scene where there are a random assortment of items to memorize, then, leads to game where you place cars in the correct order
	//Need something that generates an array of random things to display
	public Region memorizeMenu() {
		String[] randomItems = randomizedItemList();
		Region results = createMemorizeMenu(randomItems);
		return results;
	}

	//Method to get randomized item list
	private String[] randomizedItemList() {
		//This is the random items in the different cars 
		String[] items = {"Coal", "Tires", "Gravel", "Lumber", "Passengers"};
		//TODO: Find a way to make this value increase with like every 2 levels or something
		int number = 10;
		String[] randItemList = new String[number];
		for(int i=0; i < number; i++) {
			Random random = new Random();
	        int randomIndex = random.nextInt(items.length); // Generates a random index
	        String randomWord = items[randomIndex];
	        randItemList[i] = randomWord;
		}
		return randItemList;
	}
	
	//Method to turn all random items into HBox region
	private Region createMemorizeMenu(String[] randItems) {
		VBox root = new VBox(50);
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.TOP_CENTER); //VBox to store HBoxes
		this.root = root;
		
		Label instructions = new Label("Memorize this!");
		HBox instruction = new HBox(20, instructions);
		instruction.setAlignment(Pos.TOP_CENTER);
		root.getChildren().add(instruction); //HBox with instructions for game + added to VBox
		
		for(int i = 0; i<randItems.length; i++) { //Turns each item to HBox and stores in array
			Label item = new Label(randItems[i]);
			HBox randItem = new HBox(20, item);
			randItem.setAlignment(Pos.TOP_CENTER);
			root.getChildren().add(randItem); 
		}
		Button contButton = createContButton();
		root.getChildren().add(contButton);
		return root;
	}
	
	//Method to create continue button 
	private Button createContButton() {
		Button cont = new Button("Got it?");
		cont.setOnAction(evt -> mainGame());
		return cont;
	}
	
	//Method to get to place trains
	private void mainGame() {
		root.getChildren().clear(); //Clears out the scene to work with empty scene 
		VBox cars = createCars();
		Scene mainGame = new Scene(cars, width, height);
		primaryStage.setScene(mainGame);
	}
	
	//Method to create train cars on the left side along with buttons in an HBox
	private VBox createCars() {
		VBox root = new VBox(50);
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.CENTER_LEFT); //VBox to store HBoxes
		this.root = root;
		
		Image coal = new Image("placeholder.png");
        ImageView imageView = new ImageView(coal);
		HBox coalTrain = new HBox(10);
		coalTrain.getChildren().add(imageView);
		root.getChildren().add(coalTrain);
		return root;
	}
}