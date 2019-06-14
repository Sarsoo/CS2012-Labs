package fx;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import io.BinaryMonsterPersister;
import io.MonsterPersister;
import io.TextMonsterPersister;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import model.MonsterAttack;

public class MainController {

	private ArrayList<MonsterAttack> list;

	public MainController() {
		list = new ArrayList<MonsterAttack>();
	}

	@FXML
	private void initialize() {
		
		labelName.getStyleClass().add("headerLabel");
		labelLocation.getStyleClass().add("headerLabel");
		labelReporter.getStyleClass().add("headerLabel");
		labelDate.getStyleClass().add("headerLabel");
		
		refresh();
	}
	
	private Label labelName = new Label("monster name");
	private Label labelLocation = new Label("location");
	private Label labelReporter = new Label("reporter name");
	private Label labelDate = new Label("date");

	@FXML
	private TextField textFieldMonsterName;
	@FXML
	private TextField textFieldLocation;
	@FXML
	private TextField textFieldReporter;
	@FXML
	private DatePicker datePicker;
	@FXML
	private GridPane gridPane;

	@FXML
	protected void handleAdd() {

		String name = textFieldMonsterName.getText();
		String location = textFieldLocation.getText();
		String reporter = textFieldReporter.getText();
		LocalDate date = datePicker.getValue();

//		System.out.println(name + location + reporter + date.toString());

		if (name != null && location != null && reporter != null && date != null) {
			
//			System.out.println(date.toString());
			MonsterAttack attack = new MonsterAttack(date.toString(), name, location, reporter);

			System.out.println(attack);

			list.add(attack);
			refresh();

		}
	}

	public void refresh() {

		gridPane.getChildren().clear();

		gridPane.add(labelName, 0, 0);
		gridPane.add(labelLocation, 1, 0);
		gridPane.add(labelReporter, 2, 0);
		gridPane.add(labelDate, 3, 0);

		int counter;
		for (counter = 0; counter < list.size(); counter++) {
			final MonsterAttack attack = list.get(counter);

			Label name = new Label(attack.getNameOfMonster());
			name.getStyleClass().add("monsterName");
			
			Label location = new Label(attack.getAttackLocation());
			Label reporter = new Label(attack.getReporterName());
			Label date = new Label(
					attack.getMonthOfAttack() + "/" + attack.getDayOfAttack() + "/" + attack.getYearOfAttack());

			Button delete = new Button("delete");
			delete.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

				@Override
				public void handle(Event event) {

					list.remove(attack);
					refresh();

				}

			});

			gridPane.add(name, 0, counter + 1);
			gridPane.add(location, 1, counter + 1);
			gridPane.add(reporter, 2, counter + 1);
			gridPane.add(date, 3, counter + 1);
			gridPane.add(delete, 4, counter + 1);
		}

	}

	@FXML
	protected void handleSave() {
		if (list.size() > 0) {
			FileChooser choose = new FileChooser();

			choose.setTitle("save attack list");
			choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text IO", "*.monstertext"));
			choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Binary IO", "*.monsterbinary"));
			File file = choose.showSaveDialog(MonsterAttackApplication.getStage());

			if (file != null) {

				String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
				System.out.println(extension);

				MonsterPersister persist;

				if (extension.equals("monstertext")) {
					System.out.println("Text");

					persist = new TextMonsterPersister();

				} else {

					System.out.println("Binary");

					persist = new BinaryMonsterPersister();

				}

				persist.write(file, list);
			}
		}
	}

	@FXML
	protected void handleOpen() {
		FileChooser choose = new FileChooser();

		choose.setTitle("open attack list");
		choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text IO", "*.monstertext"));
		choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Binary IO", "*.monsterbinary"));
		File file = choose.showOpenDialog(MonsterAttackApplication.getStage());

		if (file != null) {

			String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
//			System.out.println(extension);

			MonsterPersister persist;

			if (extension.equals("monstertext")) {
				System.out.println("Text");

				persist = new TextMonsterPersister();

			} else {

				System.out.println("Binary");

				persist = new BinaryMonsterPersister();

			}


			list = persist.read(file);
			refresh();
		}
	}

}
