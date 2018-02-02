package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
	}
}
