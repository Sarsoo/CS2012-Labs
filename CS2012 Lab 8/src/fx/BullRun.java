package fx;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.StreetMap;
import javafx.scene.Scene;

public class BullRun extends Application {

	
	@Override
	public void start(Stage stage) {
		stage.setTitle("bull run");

		
		StreetMap map = new StreetMap(6, 2, 7, 22);
		map.randomise();
		
		MazeGUIPane maze = new MazeGUIPane(map);
		maze.updateGUI();
		Scene scene = new Scene(maze, 600, 700);

		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
