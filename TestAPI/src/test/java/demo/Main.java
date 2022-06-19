package demo;

import java.awt.Label;

import org.testng.TestListenerAdapter;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.testng.TestNG;

import tests.LoginTest;

public class Main extends Application {
	
	Stage window;
	
	public static String baseuri;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Automation Restful API Test");
		
		Label label = new Label("Menu");
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		choiceBox.getItems().add("heroku2");
		choiceBox.getItems().add("heroku3");
		
		Button chooseURIButton = new Button("confirm");
		
		chooseURIButton.setOnAction(e -> chooseURI(choiceBox));
		
		Button button = new Button("Test Login nè");
		
		TestLoginCall tlc = new TestLoginCall();
		
		button.setOnAction(e -> tlc.CallTestLogin());
		
		VBox layout = new VBox();
		
		layout.getChildren().add(choiceBox);
		layout.getChildren().add(chooseURIButton);
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 200, 200);
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void chooseURI(ChoiceBox<String> choiceBox ) {
		
		String choice = choiceBox.getValue();
		switch (choice) {
		case "heroku2":
			
			baseuri = "https://auctions-app-2.herokuapp.com/api";
			
			break;

		case "heroku3":
			
			baseuri = "https://auction-app3.herokuapp.com/api";
			
			break;
		}
		
	}
}
