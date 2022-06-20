package demo;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	
	String API;
	
	public static String baseuri;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		window.setTitle("Automation Restful API Test");
		
		VBox layout = new VBox();
		
		Label menuLabel = new Label("Menu");
		menuLabel.setFont(Font.font("Times New Roman", 32));
		menuLabel.setTextAlignment(TextAlignment.CENTER);
		menuLabel.setTextFill(Color.web("#e28743"));
		
		Label firstLabel = new Label("Choose your base URI:");
		firstLabel.setFont(Font.font("Times New Roman", 24));
		firstLabel.setTextAlignment(TextAlignment.LEFT);
		firstLabel.setTextFill(Color.web("#eeff03"));
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		
		choiceBox.getItems().add("heroku2");
		choiceBox.getItems().add("heroku3");
		
		Button chooseURIButton = new Button("Confirm");
		
		chooseURIButton.setOnAction(e -> chooseURI(choiceBox));
		
		Button button = new Button("Test");
		
		TestLoginCall tlc = new TestLoginCall();
		TestSignUpCall tsuc = new TestSignUpCall();
		TestEditCall tec = new TestEditCall();
		TestLogOutCall tloc = new TestLogOutCall();
		
		HBox layout1 = new HBox();
		layout1.getChildren().add(choiceBox);
		layout1.getChildren().add(chooseURIButton);
		layout1.setSpacing(10);
		
		Label secondLabel = new Label("Choose your API that need to test:");
		secondLabel.setFont(Font.font("Times New Roman", 24));
		secondLabel.setTextAlignment(TextAlignment.LEFT);
		secondLabel.setTextFill(Color.web("#eeff03"));
		
		HBox layout2 = new HBox();
		
		ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
		choiceBox2.getItems().add("Login");
		choiceBox2.getItems().add("Sign Up");
		choiceBox2.getItems().add("Edit");
		choiceBox2.getItems().add("Log Out");
		
		Button chooseAPIButton = new Button("Confirm");
		chooseAPIButton.setOnAction(e -> setAPI(choiceBox2));
		
		layout2.getChildren().addAll(choiceBox2, chooseAPIButton);
		layout2.setSpacing(10);
		
		button.setOnAction(e -> {
			if(API == "login") {tlc.CallTestLogin();}
			else if(API == "signup") {tsuc.callSignUpTest();}
			else if(API == "edit") {tec.callEditTest();}
			else if(API == "logout") {tloc.callLogOutTest();}
		});
		
		Image image = new Image("https://img.freepik.com/free-photo/digital-cyberspace-with-particles-digital-data-network-connections_24070-1303.jpg?w=2000");
		BackgroundImage bgImage = new BackgroundImage(image, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, 
				new BackgroundSize(100, 100, true, true, true, true));
		Background bg = new Background(bgImage);
		layout.setBackground(bg);
		layout.getChildren().addAll(menuLabel, firstLabel, layout1, secondLabel, layout2, button);
		layout.setSpacing(10);
		layout.setPadding(new Insets(10));
		
		Scene scene = new Scene(layout, 960, 540);
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void chooseURI(ChoiceBox<String> choiceBox) {
		
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
	
	public void setAPI(ChoiceBox<String> choiceBox) {
		
		String choice = choiceBox.getValue();
		
		switch (choice) {
		case "Login":
			API = "login";
			break;
			
		case "Sign Up":
			API = "signup";
			break;
		
		case "Edit":
			API = "edit";
			break;
			
		case "Log Out":
			API = "logout";
			break;
	}
}
}
