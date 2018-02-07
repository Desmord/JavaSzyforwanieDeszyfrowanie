package controller;

import java.net.URL;
import java.util.ResourceBundle;

import data.EncryptionManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class MainPaneController implements Initializable {

	private EncryptionManager encryption = new EncryptionManager();

	@FXML
	private ChoiceBox<String> encriptionChoiseBox;

	@FXML
	private TextArea codeTextField;

	@FXML
	private Label actionTitleLabel;

	@FXML
	private Button encryptButton;

	@FXML
	private Button decryptButton;

	@FXML
	private Label keyLabel;

	@FXML
	private TextArea keyTextField;

	@FXML
	private Button clearButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		addEncryptionListElements();

		setEncryptionBoxEvent();

		setButtonsEvents();

		setTextFieldsEvents();

	}

	private void addEncryptionListElements() {

		encriptionChoiseBox.setItems(FXCollections.observableArrayList("Szyfr Cezara", "Szyfr Vigenere’a","Szyfr przestawieniowy - wspak"));

		keyTextField.setDisable(true);
	}

	private void setEncryptionBoxEvent() {

		encriptionChoiseBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (encriptionChoiseBox.getValue() == "Szyfr Vigenere’a") {
					keyTextField.setDisable(false);
				} else {
					keyTextField.setDisable(true);
				}
			}

		});
	}

	private void setButtonsEvents() {
		setEncryptionButtonEvent();
		setDecryptionButtonEvent();
		setClearButtonEvent();
	}

	private void setClearButtonEvent() {

		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				codeTextField.setText("");
				keyTextField.setText("");

			}

		});
	}

	private void setEncryptionButtonEvent() {

		encryptButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (properText() && selectedEncryption() && zeroLenghtText()) {

					actionTitleLabel.setTextFill(Color.BLACK);
					actionTitleLabel.setText("");

					codeTextField.setText(encryption.encrypt(encriptionChoiseBox.getValue(), codeTextField.getText(),keyTextField.getText()));

				} else {
					actionTitleLabel.setTextFill(Color.RED);
					actionTitleLabel.setText(
							"Nieprawid³owy tekst\n( tekst mo¿e zawieraæ tylko \n litery alfabetu ),\n b¹dŸ nie wybrano \n ¿adnego szyfru.");
				}

			}
		});
	}

	private void setDecryptionButtonEvent() {

		decryptButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (properText() && selectedEncryption() && zeroLenghtText()) {

					actionTitleLabel.setTextFill(Color.BLACK);
					actionTitleLabel.setText("");

					codeTextField.setText(encryption.decrypt(encriptionChoiseBox.getValue(), codeTextField.getText(),keyTextField.getText()));

				} else {
					actionTitleLabel.setTextFill(Color.RED);
					actionTitleLabel.setText(
							"Nieprawid³owy tekst\n( tekst mo¿e zawieraæ tylko \n litery alfabetu ),\n b¹dŸ nie wybrano \n ¿adnego szyfru.");
				}

			}
		});
	}

	/**
	 * Checks if text in codeTextField contains only characters
	 * 
	 * @return ture if contains only characters
	 */
	private boolean properText() {

		String text = codeTextField.getText();
		String rex = "[A-Za-z ¹êæ³ñóœŸ¿¥ÊÆ£ÑÓŒ¯]*";

		if (text.matches(rex)) {
			return true;
		} else {
			return false;
		}

	}

	private boolean zeroLenghtText() {

		if (codeTextField.getText().length() == 0) {
			return false;
		} else if (!keyTextField.isDisabled() && keyTextField.getText().length() == 0) {
			return false;
		} else {
			return true;
		}

	}

	private boolean selectedEncryption() {

		if (encriptionChoiseBox.getValue() != null) {
			return true;
		}
		return false;
	}

	private void setTextFieldsEvents() {
		setTextFieldChangeEvents(keyTextField);
		setTextFieldChangeEvents(codeTextField);
	}

	private void setTextFieldChangeEvents(TextArea element) {
		element.addEventFilter(KeyEvent.KEY_PRESSED, x -> {

			String text = element.getText();

			try {
				if (text.length() > 500) {

					actionTitleLabel.setTextFill(Color.RED);
					actionTitleLabel.setText("Makszymalna liczba \n znaków to 500.");

					element.setText(text.substring(0, text.length() - 1));
					element.end();

				} else {
					actionTitleLabel.setText("");
					actionTitleLabel.setTextFill(Color.BLACK);
				}
			} catch (NullPointerException e) {
			}

		});
	}
}
