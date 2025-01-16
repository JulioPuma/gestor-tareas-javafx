package com.gestor.gestortareasjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class TareaApplication extends Application {
    
    private ConfigurableApplicationContext context;
    
    @Override
    public void init() {
        context = new SpringApplicationBuilder(TareaApplication.class).run();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TareaApplication.class.getResource("principal-view.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gestor de Tareas!");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
    public static void main(String[] args) {
        launch();
    }
}