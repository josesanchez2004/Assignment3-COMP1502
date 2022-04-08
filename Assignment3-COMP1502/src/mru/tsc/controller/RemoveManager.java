package mru.tsc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.LogRecord;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;

/**
 *  this is the controller class for the RemoveMenu.fxml file. It contains the code that processes all the responses on this gui stage. 
 * @author Jose Sanchez
 *
 */
public class RemoveManager {
	private final String FILE_PATH = "res/Toys.txt";
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button homeButton;
	
	@FXML 
	private Button addButton;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private TextField serialNumberText;
	
	@FXML 
	private Button removeToyButton;
	
	@FXML
	 private ListView<Toy> text;
	@FXML
	private Button searchButton;
	
	AppManager app;
	/**
	 * this is the constructor class for this class. it loads the data, and loads the arraylists with new references. 
	 */
	public RemoveManager() {
		app=new AppManager();
		app.toys = new ArrayList<Toy>();
		app.names= new ArrayList<Toy>();
		app.names1= new ArrayList<Toy>();
		app.loadData();
		app.Log();
		app.LOGR.info("Opened Remove Toy Page");
		
	}
	/**
	 * event handler for home button, upon pressing it, it will take you to home Page. 
	 * @param event
	 */
	@FXML
	void homeButtonListener(ActionEvent event) {
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root,865,537);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  event handler for add button, upon pressing it, it will take you to add Toy page.
	 * @param event
	 */
	@FXML
	void addButtonListener(ActionEvent event) {
		try {
			root= FXMLLoader.load(getClass().getResource("/view/addMenu.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root,865,537);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * event handler for remove button, upon pressing it, it will take you to the remove Toy page. 
	 * @param event
	 */
	@FXML
	void removeButtonListener(ActionEvent event) {
		try {
			root= FXMLLoader.load(getClass().getResource("/view/removeMenu.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root,865,537);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this is the eventhandler for the remove toy button, it will take the choice from the listview and remove the item from the toys arraylist and save. 
	 * @param event
	 */
	@FXML
	void removeToyListener(ActionEvent event) {
		Toy t = text.getSelectionModel().getSelectedItem();
		removeToy(t);
		app.save();
		text.getItems().removeAll(app.list);
		app.LOGR.info(t.getName()+" has been removed..");
	}
	/**
	 * this is the event handler for the search button, it will search the toy by serial number and display it to the user in the listview. 
	 * @param event
	 */
	@FXML
	void searchButtonListener(ActionEvent event) {
		app.LOGR.info("Toy has been searched using Serial Number...");
		if(event.getSource().equals(searchButton)) {
			String serialNum= serialNumberText.getText();
			app.searchToySN(serialNum);
			app.list = FXCollections.observableArrayList(app.names2);
			text.getItems().addAll(app.list);
			
		}
		app.names2.clear();
		
	}
	/**
	 * removeToy takes in a Toy parameter and removes it from the toys arraylist. 
	 * @param t
	 */
	private void removeToy(Toy t) {
			app.toys.remove(t);
	}
	
}
