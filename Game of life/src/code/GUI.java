package code;
import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {
	static int worldSize = 600; //world size
	
	BorderPane borderUI = new BorderPane();
	Pane world = new Pane();
	
	MenuBar menuB = new MenuBar();
	Menu file = new Menu("File");
	//Menu play = new Menu("play");
	MenuItem save = new MenuItem("Save");
	MenuItem load = new MenuItem("Load");
	MenuItem exit = new MenuItem("Exit");	
	Button play = new Button("Play");
	
	Boolean on = false;
	
	KeyFrame frame = new KeyFrame(Duration.seconds(.5),new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			//System.out.print("test ");
			game.turn();
			
		}
		
	});
	
	Timeline time = new Timeline(frame);
	
	static Game game = new Game(worldSize);
	
	@Override
	public void start(Stage main) throws Exception {
	
	//menu
	menuB.setPrefWidth(worldSize);
	file.getItems().add(save);	
	file.getItems().add(load);	
	file.getItems().add(exit);	
	menuB.getMenus().addAll(file);
	Thread.sleep(1000);
	
	play.setOnAction((ActionEvent arg0)->{
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	});
	
	
	
	save.setOnAction((ActionEvent arg0)->{
		
	});
	
	//button stuff
	
	//cell test  
	int x = 25; //when fully implemented it will be an equation that figures how big they will have to be but for now screw it... Windowsize/x = Xsize
	
	
	
	
	//pane stuff
	for(int i=0;i<game.cellNum;i++) {
		world.getChildren().addAll(game.cells[i]);
	}
	
	borderUI.setTop(menuB);
	borderUI.setCenter(world);
	borderUI.setBottom(play);
	world.setPrefSize(worldSize,worldSize);
	world.setStyle("-fx-background-color: #ead6cc");
	//scene stuff
	Scene scene = new Scene(borderUI);
	main.setScene(scene);
	main.show();
	
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
