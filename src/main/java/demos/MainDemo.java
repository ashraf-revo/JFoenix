package demos;

import com.jfoenix.controls.JFXDecorator;
import demos.gui.main.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainDemo extends Application {

    @FXMLViewFlowContext
    private ViewFlowContext flowContext;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flowContext = new ViewFlowContext();
        flowContext.register("Stage", stage);
        flow.createHandler(flowContext).start(container);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(new JFXDecorator(stage, container.getView()), screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
        scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
        scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}