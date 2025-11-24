package application;
	
//Imports from base Java
import java.awt.Dimension;
import java.awt.Toolkit;

//Imports from JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.geometry.*;
import javafx.beans.property.*;



public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//To start the application
	@Override
	public void start(Stage primaryStage) {
		try {
			//Getting the width and height
			double width = getScreenSize()[0];
			double height = getScreenSize()[1];
			Image icon = new Image("placeholder.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Railyard Game");
			primaryStage.setFullScreen(true);
			//Load the main menu
			MainSceneLoader loader = new MainSceneLoader(primaryStage, width, height);
			Scene mainScene = loader.createMainMenu();
	        primaryStage.setScene(mainScene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Gets screen size for window creation
 	private static double[] getScreenSize() {
		double[] widthHeight = new double[2];
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        widthHeight[0] = width;
        widthHeight[1] = height;
		return widthHeight;
	}
}
