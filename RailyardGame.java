import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.*;

public class RailyardGame extends Application{
    //This class serves to act as the game object, initiated by the main method.

    //array of destination strings to be referenced by each node.
    public static String[] destinations = {"Nanning","Kowloon","Xiamen","Changsha","Nanchang"};
    
    //stack storing all cars to be sorted by player
    public nLinkedList stack = new nLinkedList();

    //Spot where nodes popped from stack to be stored
    public static Node sortNode = null; 

    //Tracks for sorted cars by player
    public nLinkedList track1 = new nLinkedList();
    public nLinkedList track2 = new nLinkedList();
    public nLinkedList track3 = new nLinkedList();

    //train items
    private final List<Rectangle> trainButtons = new ArrayList<>();
    private final List<Color> trainColors = List.of(Color.RED, Color.NAVY, Color.YELLOW);
    private final List<String> trainColorList = List.of("Red", "Blue", "Yellow");

    //stack class
    private Stack<Integer> correctOrderStack = new Stack<>();
    private Stack<Integer> playerStack = new Stack<>();

    //fx 
    private Label mainText = new Label("Click start when ready (:");
    private boolean canInput = false;
    private Random ranNum = new Random();

    //image assets
    Image conductorStill = new Image(
        getClass().getResource("/assets/conductorStill.png").toExternalForm()
    );

    Image conductorSpeak = new Image(
        getClass().getResource("/assets/conductorSpeak.gif").toExternalForm()
    );

    ImageView conductor = new ImageView(conductorStill);

    Pane root = new Pane();
    Pane playerPane = new Pane();

    public void start(Stage mainStage){

        GameSceneLoader(mainStage)

        int x = 50;
        int y = 150;

        for (int i = 0; i < trainColors.size(); i++){
            Rectangle newRect = new Rectangle(100,100,trainColors.get(i));
            newRect.setX(x + i * 100);
            newRect.setY(y);

            final int rectIndex = i;
            newRect.setOnMouseClicked(e -> handleClick(rectIndex));
            trainButtons.add(newRect);
            root.getChildren().add(newRect);
        }

        //conductor
        conductor.setLayoutX(50);
        conductor.setLayoutY(30);
        root.getChildren().add(conductor);

        //start
        Button start = new Button("Start");
        start.setLayoutX(250);
        start.setLayoutY(50);
        start.setOnAction(e -> startGame());
        root.getChildren().add(start);

        //text appearance
        mainText.setLayoutX(100);
        mainText.setLayoutY(30);
        root.getChildren().add(mainText);

        //panes
        playerPane.setLayoutY(300);
        root.getChildren().add(playerPane);

        //scene
        Scene mainScene = new Scene(root,600,400);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Railyard Game");
        mainStage.show();
    }

    private void startGame() {
        // TODO Auto-generated method stub
        correctOrderStack.clear();
        playerStack.clear();
        mainText.setText("Listen closely!");
        addTrain();
        playSequence();
    }

    private void addTrain() {
        // TODO Auto-generated method stub
        int nextTrain = ranNum.nextInt(trainColors.size());
        correctOrderStack.push(nextTrain);
    }

    private void playSequence() {
        
        // TODO Auto-generated method stub
        canInput = false;
        conductor.setImage(conductorSpeak);

        Stack<Integer> tempStack = (Stack<Integer>) correctOrderStack.clone();
        Stack<Integer> reversedStack = new Stack<>();

        while(!tempStack.isEmpty()){
            reversedStack.push(tempStack.pop());
        }

        Timeline timeline = new Timeline();
        Duration delay = Duration.ZERO;

        delay = delay.add(Duration.seconds(2));
        

        while(!reversedStack.isEmpty()){
            int trainIndex = reversedStack.pop();

            KeyFrame frame1 = new KeyFrame(delay, e -> mainText.setText(trainColorList.get(trainIndex)));
          //  delay = delay.add(Duration.seconds(0.5));
            timeline.getKeyFrames().add(frame1);
            delay = delay.add(Duration.seconds(0.5));
        }
        
        KeyFrame frame2 = new KeyFrame(delay, e ->{
            conductor.setImage(conductorStill);
            mainText.setText("Click in the right order!");
            canInput = true;
        });
        
        timeline.getKeyFrames().add(frame2);
        timeline.play();

    }

    private void flash(Rectangle rect) {
        // TODO Auto-generated method stub
        FillTransition fill = new FillTransition(Duration.seconds(0.5), rect);
        Color mainColor = (Color) rect.getFill();
        Color brightColor = Color.WHITE;

        fill.setFromValue(mainColor);
        fill.setToValue(brightColor);
        fill.setCycleCount(2);
        fill.setAutoReverse(true);
        fill.play();
    }

    private void handleClick(int i) {
        // TODO Auto-generated method stub
        if (!canInput) {
            return;
        }

        playerStack.push(i);
        flash(trainButtons.get(i));

        drawPlayerTrains();

        if (playerStack.size() == correctOrderStack.size()){
            checkPlayer();
        }
    }

    private void drawPlayerTrains() {
        // TODO Auto-generated method stub

        int trainSpace = 110;
        int trainStart = 50; 
        for (int i : playerStack){
            Rectangle playerRect = new Rectangle(100,100, trainColors.get(i));

            playerRect.setX(trainStart);
            playerPane.getChildren().add(playerRect);
            trainStart+=trainSpace;
        }
    }

    private void checkPlayer() {
        // TODO Auto-generated method stub
        canInput = false;

        Stack<Integer> correctCopy = (Stack<Integer>) correctOrderStack.clone();
        Stack<Integer> playerCopy = (Stack<Integer>) playerStack.clone();

        boolean isCorrect = true;

        while(!correctCopy.isEmpty()){
            if(!correctCopy.pop().equals(playerCopy.pop())){
                isCorrect=false;
                break;
            }
        }

        if (isCorrect) {
            mainText.setText("Good job!");
            playerStack.clear();
            PauseTransition load = new PauseTransition(Duration.seconds(1));
            load.setOnFinished(e->{
                addTrain();
                mainText.setText("Listen closely!");
                playSequence();
            });
            load.play();
        }
        else {
            mainText.setText("Incorrect order! Try again.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
