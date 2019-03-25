package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private Pane root = new Pane();

    private Sprite player = new Sprite(300,500,100,150,"player",Color.GOLD);

    private Parent content() {
        root.setPrefSize(1000, 800);
        root.getChildren().add(player);

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        }


    ;
            gameLoop.start();
            return root;
}


    public static void main(String[] args) {

        launch(args);
    }

   @Override
    public void start(Stage stage)throws Exception{
        Scene scene=new Scene(content());

        scene.setOnKeyPressed(event ->
        {switch (event.getCode()){
            case A:
                player.moveLeft();
                break;

            case D:
                player.moveRight();
           /*
            case SPACE:
                player.jump();
                */
        }
        });

        stage.setScene(scene);
        stage.show();
   }

   private static class Sprite extends Rectangle{
       private final String type;

       Sprite(int x, int y, int w, int h, String type, Color color){
        super(w,h,color);
        this.type=type;
        setTranslateX(x);
        setTranslateY(y);

   }
    void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }

    void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }


}
}