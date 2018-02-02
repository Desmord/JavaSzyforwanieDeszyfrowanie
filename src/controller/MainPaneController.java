package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class MainPaneController implements Initializable {

	@FXML
	private ChoiceBox<?> encriptionChoiseBox;

	@FXML
	private TextArea codeTextField;

	@FXML
	private Label actionTitleLabel;

	@FXML
	private Button encryptButton;

	@FXML
	private Button decryptButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Witam");
		proba();
		proba2();
	}
	
	private void proba2() {
		 decryptButton.addEventFilter(MouseEvent.MOUSE_CLICKED, x-> {
			 codeTextField.setText("de witam");
		 });
	}
	
	private void proba() {
		encryptButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
		        public void handle(ActionEvent event) {
		        	codeTextField.setText("Witam");
		        }
		});
	}
}
