package demo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable  {
	
	@FXML
	private Label menuLabel;
	
	@FXML
	private Label firstLabel;
	
	@FXML 
	private ChoiceBox<String> URIChoice = new ChoiceBox<>();

	ObservableList<String> uri = FXCollections.observableArrayList("heroku2", "heroku3");
	
	@FXML
	private ChoiceBox<String> APIChoice;
	
	ObservableList<String> api = FXCollections.observableArrayList("Login", "Sign Up", "Edit", "Log Out");

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		URIChoice.setItems(uri);
		APIChoice.getItems().addAll(api);
		
	}
	
	public void getURI(ActionEvent event) {
		
		String neededURI = URIChoice.getValue();
		if (neededURI == "heroku2") Main.baseuri = "https://auctions-app-2.herokuapp.com/api";
		else Main.baseuri = "https://auction-app3.herokuapp.com/api";
		
	}
	
	TestLoginCall testLoginCall = new TestLoginCall();
	TestSignUpCall testSignUpCall = new TestSignUpCall();
	TestEditCall testEditCall = new TestEditCall();
	TestLogOutCall testLogOutCall = new TestLogOutCall();
	
	
	public void getAPI(ActionEvent event) {
		
		String neededAPI = URIChoice.getValue();
		if (neededAPI == "Login") testLoginCall.CallTestLogin();
		else if (neededAPI == "Sign Up") testSignUpCall.callSignUpTest();
		else if (neededAPI == "Edit") testEditCall.callEditTest();
		else testLogOutCall.callLogOutTest();
		
	}
}