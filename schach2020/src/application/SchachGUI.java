package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SchachGUI extends Application implements EventHandler<ActionEvent> {
	private SpielFeld start = null; //Dient nur zum Speichern der Startposition, um die bereits geschlagenen Figuren zu ermitteln
	private SpielFeld sf = null;
	private boolean gameOver = false;
	private boolean first = true;
	private Button[][] buttons = new Button[8][8];
	private Label label = new Label();
	private Label player = new Label();
	private void imagesAufsFeld() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				String imgName = "img/" + sf.getFeld(j, i) + ".png";
				Image im = new Image(imgName);
				ImageView iv = new ImageView(im);
				buttons[i][j].setGraphic(iv);
				buttons[i][j].getStyleClass().remove("field_selected");
			}
		}
	}

	private void zeichneGeschlageneFiguren()
	{
		ArrayList<Figur> geschlageneWeiss = start.minus(sf, true);
		ArrayList<Figur> geschlageneSchwarz = start.minus(sf, false);
		System.out.println("Geschlagen Weiss:");
		System.out.println(Arrays.toString(geschlageneWeiss.toArray()));
		System.out.println("Geschlagen Schwarz:");
		System.out.println(Arrays.toString(geschlageneSchwarz.toArray()));
		//TODO: Zeichnen 
	}
	
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		sf = SpielFeldIO.einlesen("start.txt");
		start = SpielFeldIO.einlesen("start.txt");
		sf.ausgabe();
		GridPane sfGrid = new GridPane();
		BorderPane root = new BorderPane();
		// Erzeuge leere Buttons
		for (int i = 7; i >= 0; i--) // Zeile
		{
			for (int j = 0; j < 8; j++) { // Spalte
				Button b = new Button();
				b.setPrefSize(1000, 1000); // so wachsen die Buttons mit wenn man vergrössert
				b.getStyleClass().add("field");
				String id = ((char) (j + 'a') + "" + (char) ('8' - i));
				b.setId(id);
				b.setOnAction(this);
				b.setTooltip(new Tooltip(id));
				if ((i - j) % 2 != 0) {
					b.setStyle("-fx-background-color: #4a2700");
				} else {
					b.setStyle("-fx-background-color: #FFFFFF");
				}
				buttons[j][i] = b;
				sfGrid.add(b, j, i); // Achtung: (Zeile, Spalte)
			}
		}
		imagesAufsFeld();
		root.setCenter(sfGrid);
		root.setBottom(label);
		root.setTop(player);
		Scene scene = new Scene(root, 800, 800);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private void markiereSpielZugMoeglich(String von) {
		if (gameOver) return;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				String nach = buttons[i][j].getId();
				String fullMove = von + "-" + nach;
				if (sf.spielzugMoeglich(fullMove)) {
					buttons[i][j].getStyleClass().add("field_selected");
				}
			}
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Node b = (Node) event.getSource();
		if (first) {
			//b.getStyleClass().add("field_selected");
			label.setText(b.getId());
			markiereSpielZugMoeglich(b.getId());
		} else {
			String fullMove = label.getText() + "-" + b.getId();
			System.out.println(fullMove);
			sf.spielzug(fullMove);
			imagesAufsFeld();
			zeichneGeschlageneFiguren();
			//sf.ausgabe();
			label.setText("");
			if (sf.schach())
			{
				label.setText("schach!!");
			} 
			if (sf.schachmatt())
			{
				label.setText("schachmatt!!");
				gameOver = true;
			} else if (sf.patt())
			{
				gameOver = true;
				label.setText("patt!!");
			}
			player.setText(String.format("%s ist am Zug", sf.isWerAmZug() ?  "Weiss" : "Schwarz"));
		}
		first = !first;
	}

}