package fx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonsterAttackApplication extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage stageIn) throws Exception {
		stage = stageIn;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/main.fxml"));
		
		Parent root = (Parent)loader.load();
		
		Scene scene = new Scene(root, 1000, 800);
		

		stage.setMinHeight(800);
		stage.setMinWidth(960);
		stage.setTitle("fm framework");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
}
