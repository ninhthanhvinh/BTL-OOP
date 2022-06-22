package demo;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class CustomOutputStream  {
	
	@FXML
	private Label menuLabel;
	
	@FXML
	private Label firstLabel;
	
	@FXML 
	private ChoiceBox<String> URIChoice;

	private String[] api = {"heroku2", "heroku3"};
}
