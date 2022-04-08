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

	public RemoveManager() {
		app=new AppManager();
		app.toys = new ArrayList<Toy>();
		app.names= new ArrayList<Toy>();
		app.names1= new ArrayList<Toy>();
		app.loadData();
		app.Log();
		app.LOGR.info("Opened Remove Toy Page");
		
	}
	
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
	
	@FXML
	void removeToyListener(ActionEvent event) {
		Toy t = text.getSelectionModel().getSelectedItem();
		removeToy(t);
		app.save();
		text.getItems().removeAll(app.list);
		app.LOGR.info(t.getName()+" has been removed..");
	}
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
	
	private void removeToy(Toy t) {
			app.toys.remove(t);
	}
	
}
