package com.tvinh.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.tvinh.test1.AutomationTesting.baseuri;

public class Controller implements Initializable {

    public String api = new String();
    @FXML
    private TextArea textAreaGUI;
    static TextArea staticTxtArea;
    @FXML
    private Label menuLabel;

    @FXML
    private Label uriLabel;

    @FXML
    private Label apiLabel;

    @FXML
    private ChoiceBox<String> uriChoice;

    @FXML
    private ChoiceBox<String> apiChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uriChoice.getItems().addAll("heroku2", "heroku3");
        uriChoice.setOnAction(this::setUriChoice);
        apiChoice.getItems().addAll("Login", "Edit", "Sign Up", "Log Out", "Contact Us", "Get News");
        apiChoice.setOnAction(this::setApiChoice);
        staticTxtArea = textAreaGUI;
    }

    public void Test(){
        if (Objects.equals(api, "login")){
            LoginTest lt = new LoginTest();
            lt.call();
        }
        else if (Objects.equals(api, "signup")){
            SignUpTest sut = new SignUpTest();
            sut.call();
        }
        else if (Objects.equals(api, "edit")){
            EditTest et = new EditTest();
            et.call();
        }
        else if (Objects.equals(api, "logout")){
            LogOutTest lot = new LogOutTest();
            lot.call();
        }
        else if (Objects.equals(api, "contactUs")){
            ContactUsTest lot = new ContactUsTest();
            lot.call();
        }
        else if (Objects.equals(api, "news")){
            GetNewsTest lot = new GetNewsTest();
            lot.call();
        }

    }

    public void setUriChoice(ActionEvent event){
        String choice = uriChoice.getValue();
        if (choice == "heroku2") baseuri = "https://auction-app-2.herokuapp.com/api";
        else baseuri = "https://auction-app3.herokuapp.com/api";
    }
    public void setApiChoice(ActionEvent event){
        String choice = apiChoice.getValue();
        if (choice == "Login") api = "login";
        else if (choice == "Sign Up") api = "signup";
        else if (choice == "Edit") api = "edit";
        else if (choice == "Log Out") api = "logout";
        else if (choice == "Contact Us") api = "contactUs";
        else if (choice == "Get News") api = "news";
    }
}