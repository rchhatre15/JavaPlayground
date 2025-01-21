import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;


public class InterestTableGUI extends Application{
	protected static TextField principalField;
	protected static TextField rateField;
	protected static TextField timeField;
	protected static TextArea result;
	protected static Slider verticalSlider;
	protected static Button simple;
	protected static Button compound;
	protected static Button both;
	
	@Override
	public void start(Stage arg0) throws Exception {
		int sceneWidth = 500, sceneHeight = 500;
		FlowPane pane = new FlowPane();
		TextArea result = new TextArea();
		result.setPrefHeight(120);
		result.setPrefWidth(300);
		pane.setHgap(10);
		pane.setHgap(10);
		Label principal = new Label("Principal: ");
		Label rate = new Label("Rate: ");
		Label time = new Label("Number of Years: ");
		principalField = new TextField();
		rateField = new TextField();
		pane.getChildren().addAll(principal, principalField);
		pane.getChildren().addAll(rate, rateField);
		verticalSlider = new Slider();
		verticalSlider.setOrientation(Orientation.VERTICAL);
		verticalSlider.setMin(0);
		verticalSlider.setMax(25);
		verticalSlider.setValue(1);
		verticalSlider.setMajorTickUnit(1);
		verticalSlider.setShowTickMarks(true);
		verticalSlider.setShowTickLabels(true);
		pane.getChildren().addAll(time, verticalSlider);
		simple = new Button("Simple Interest");
		compound = new Button("Compound Interest");
		both = new Button("Both");
		pane.getChildren().addAll(simple);
		pane.getChildren().addAll(compound);
		pane.getChildren().addAll(both);
		Interest interest = new Interest();
		
		simple.setOnAction(interest);
		
		compound.setOnAction(interest);
		
		both.setOnAction(interest);
		
		Scene scene = new Scene(pane, sceneWidth, sceneHeight);
		arg0.setTitle("Interest Table");
		arg0.setScene(scene);
		arg0.show();		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
