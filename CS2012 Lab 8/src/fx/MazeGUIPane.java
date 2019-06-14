package fx;

import javafx.scene.layout.*;
import logic.Bull;
import logic.Coordinate;
import logic.StreetMap;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

import javafx.event.*;

public class MazeGUIPane extends BorderPane {

	private StreetMap map;

	private Label[][] labels = new Label[27][27];

	// private Coordinate player = new Coordinate(1, 1);

	public MazeGUIPane(final StreetMap map) {
		super();
		getStylesheets().add("styles/style.css");

		this.map = map;

		HBox title = new HBox();
		title.getStyleClass().add("box");
		HBox bottom = new HBox();
		bottom.getStyleClass().add("box");

		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");

		Label titleText = new Label("The Bull Run");
		titleText.getStyleClass().add("titletext");
		title.getChildren().add(titleText);

		Button random = new Button();
		random.setText("Start");
		random.getStyleClass().add("startbutton");
		bottom.getChildren().add(random);
		random.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				map.randomise();
				updateGUI();
				// map.print();

			}

		});

		int row, column;

		for (row = 0; row < 27; row++) {
			for (column = 0; column < 27; column++) {

				Label label = new Label(" ");

				label.setMinWidth(20);
				label.setMinHeight(20);

				label.getStyleClass().add("wall");

				labels[row][column] = label;

				final Coordinate coord = map.getCoordinate(row, column);
				// coord.setLabel(label);

				int coordCol = coord.getColumn();
				int coordRow = coord.getRow();

				if (coordCol > 0 && coordCol < 26) {
					if (coordRow > 0 && coordRow < 26) {
						label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

							@Override
							public void handle(Event event) {
								char state = coord.getState();

								if (state == 'W') {
									coord.setState(' ');
								}
								if (state == ' ') {
									coord.setState('W');
								}
								updateGUI();
							}

						});
					}
				}
				grid.add(label, column, row);
			}
		}

		setCenter(grid);
		setTop(title);
		setBottom(bottom);

		this.setEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent key) {
				if (key.getCode() == KeyCode.R) {
					
					map.randomise();
					updateGUI();

				}
				if (!(map.isDead() || map.isWon())) {

					// map.isBlocked();

					if (key.getCode() == KeyCode.DOWN) {

						Coordinate player = map.getPlayer();

						if (map.validMove(player.getRow() + 1, player.getColumn())) {
							map.movePlayerDown();
							map.isBlocked();
							// updateGUI();
						}
					}
					if (key.getCode() == KeyCode.UP) {

						Coordinate player = map.getPlayer();

						if (map.validMove(player.getRow() - 1, player.getColumn())) {
							map.movePlayerUp();
							map.isBlocked();
							// updateGUI();
						}
					}
					if (key.getCode() == KeyCode.LEFT) {

						Coordinate player = map.getPlayer();

						if (map.validMove(player.getRow(), player.getColumn() - 1)) {
							map.movePlayerLeft();
							map.isBlocked();
							// updateGUI();
						}
					}
					if (key.getCode() == KeyCode.RIGHT) {

						Coordinate player = map.getPlayer();

						if (map.validMove(player.getRow(), player.getColumn() + 1)) {
							map.movePlayerRight();
							map.isBlocked();
							// updateGUI();
						}
					}
				}
				updateGUI();
			}

		});
	}

	public void updateGUI() {

		Label label;
		Coordinate coordinate;

		int row, column;
		for (row = 0; row < 27; row++) {
			for (column = 0; column < 27; column++) {

				coordinate = map.getCoordinate(row, column);
				label = labels[row][column];
				// System.out.println(coordinate.getState());

				label.getStyleClass().clear();

				switch (coordinate.getState()) {
				case ' ':
					label.getStyleClass().add("street");
					break;
				case 'W':
					label.getStyleClass().add("wall");
					break;
				case 'S':
					label.getStyleClass().add("start");
					break;
				case 'E':
					label.getStyleClass().add("exit");
					break;
				// case 'P':
				// label.getStyleClass().add("player");
				}

			}
		}

		Coordinate player = map.getPlayer();
		Label playerLabel = labels[player.getRow()][player.getColumn()];

		Bull[] bulls = map.getBulls();

		for (Bull bull : bulls) {

			Coordinate bullCoord = bull.getLocation();
			Label bullLabel = labels[bullCoord.getRow()][bullCoord.getColumn()];

			bullLabel.getStyleClass().clear();
			bullLabel.getStyleClass().add("bull");

		}

		playerLabel.getStyleClass().clear();
		if (map.isDead())
			playerLabel.getStyleClass().add("dead");
		else if (map.isWon())
			playerLabel.getStyleClass().add("won");
		else
			playerLabel.getStyleClass().add("player");

		// map.getCoordinate(0, 1).getLabel().setText("S");
		// map.getCoordinate(26, 25).getLabel().setText("E");

		labels[0][1].setText("S");
		labels[26][25].setText("E");

	}

	public Label[][] getLabels() {
		return labels;
	}

}
