package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    TextField name;

    @FXML
    TextField phoneNumber;

    @FXML
    TextField email;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void onAdd() {
        Contact item = new Contact(name.getText(), phoneNumber.getText(), email.getText());
        contacts.add(item);
        name.clear();
        phoneNumber.clear();
        email.clear();
    }

    public void onRemove() {
        SelectionModel model = list.getSelectionModel();
        Contact item = (Contact) model.getSelectedItem();
        contacts.remove(item);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
