package com.tvinh.test1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

public class AutomationTesting extends Application {

    private final PipedInputStream pipeIn = new PipedInputStream();
    private final PipedInputStream pipeIn2 = new PipedInputStream();
    Thread errorThrower;
    private Thread reader;
    private  Thread reader2;
    boolean quit;
    private TextArea txtArea;

    public static String baseuri;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutomationTesting.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        txtArea = Controller.staticTxtArea;

        executeReaderThreads();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                closeThread();
                Platform.exit();
                System.exit(0);
            }
        });
    }

    synchronized void closeThread(){
        System.out.println("Message: Stage is closed.");
        this.quit =true;
        try{
            this.reader.join(1000L);
            this.pipeIn.close();
        } catch (Exception e) {}
        try {
            this.reader2.join(1000L);
            this.pipeIn2.close();
        } catch (Exception e) {}
        System.exit(0);
    }
    public static void main(String[] args) {
        launch();
    }

    public void executeReaderThreads() throws IOException {
        try {
            PipedOutputStream pout = new PipedOutputStream(this.pipeIn);
            System.setOut(new PrintStream(pout, true));

        }
        catch (IOException e) {
        }
        catch (SecurityException se) {}

        try {
            PipedOutputStream pout2 = new PipedOutputStream(this.pipeIn2);
            System.setErr(new PrintStream(pout2, true));
        }
        catch (IOException io) {
        }
        catch (SecurityException se) {}

        ReaderThread obj = new ReaderThread(pipeIn, pipeIn2, errorThrower, reader,reader2, quit, txtArea);
    }

}