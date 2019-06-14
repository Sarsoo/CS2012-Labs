package clickcounter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	private Text results;
	
	private int clicked = 0;
	
	@FXML
	protected void handleButtonClick(ActionEvent event) {
		int num = 0;
		
		Button button = (Button) event.getSource();
		
		if(button.getText().equals("unclicked")) {
			results.setText("Clicked: " + ++clicked);
			button.setText("clicked");
		}else {
			results.setText("Clicked: " + --clicked);
			button.setText("unclicked");
		}
	}
}
