package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ListView contactList;

    @FXML
    TextField name;

    @FXML
    TextField email;

    @FXML
    TextField phone;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addContact() {
        if (name.getText().isEmpty() | email.getText().isEmpty() | phone.getText().isEmpty()) {
            System.out.println("Not enough information has been entered.\nAll three fields are required!");
        } else {
            Contact contact = new Contact(name.getText(), email.getText(), phone.getText());
            contacts.add(contact);
            name.setText("");
            email.setText("");
            phone.setText("");
        }
    }

    public void removeContact() {
        Contact name = (Contact) contactList.getSelectionModel().getSelectedItem();
        Contact email = (Contact) contactList.getSelectionModel().getSelectedItem();
        Contact phone = (Contact) contactList.getSelectionModel().getSelectedItem();
        contacts.remove(name);
        contacts.remove(email);
        contacts.remove(phone);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contactList.setItems(contacts);
    }

}
