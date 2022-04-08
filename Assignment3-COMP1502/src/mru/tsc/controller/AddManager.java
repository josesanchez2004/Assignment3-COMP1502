package mru.tsc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mru.tsc.exceptions.NegativePriceException;
import mru.tsc.exceptions.minMaxPlayerException;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;


public class AddManager {
	private Stage stage;
	private Scene scene;
	private Parent root;
	ObservableList<String> choicesCategory = FXCollections.observableArrayList("Figure","Animal", "Puzzle","Board Game");
	
	@FXML
	private ComboBox<String> category;
	@FXML
	private TextField serialNumber;
	@FXML
	private TextField name;
	@FXML
	private TextField brand;
	@FXML
	private TextField price;
	@FXML
	private TextField availableCount;
	@FXML
	private TextField ageAppropriate;
	@FXML
	private TextField classification;
	@FXML
	private TextField material;
	@FXML
	private TextField size;
	@FXML
	private TextField type;
	@FXML
	private TextField minNumOfPlayers;
	@FXML
	private TextField maxNumOfPlayers;
	@FXML
	private TextField designers; 
	@FXML
	private Button saveButton;
	
	
	@FXML
	private Button homeButton;
	
	@FXML 
	private Button addButton;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private Button clearButton;
	
	private String categoryText;
	AppManager app;
	
	@FXML
	private void initialize() {
		app=new AppManager();
		app.toys = new ArrayList<Toy>();
		app.loadData();
		category.setItems(choicesCategory);
		app.Log();
		app.LOGR.info("Opened Add Toy Page");
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
	void saveButtonListener(ActionEvent event) {
		if(event.getSource().equals(saveButton)) {
			String SN=serialNumber.getText();
			String nameValue=name.getText();
			String brandValue=brand.getText();
			double priceValue=Double.parseDouble(price.getText());
			int availableValue=Integer.parseInt(availableCount.getText());
			String ageAppropriateValue=ageAppropriate.getText();
			categoryText=category.getValue();
			try {
				if(isValid(priceValue)) {
					if(categoryText.equals("Figure")){
						
						
						String classificationValue=classification.getText();
						Toy t = new Figure(SN,nameValue,brandValue,priceValue,availableValue,ageAppropriateValue,classificationValue);
						app.toys.add(t);
						app.LOGR.info("A Figure has been added: " +t.getName());
					}else if(categoryText.equals("Animal")) {
						
						String materialValue=material.getText();
						String sizeValue=material.getText();
						Toy t = new Animal(SN,nameValue,brandValue,priceValue,availableValue,ageAppropriateValue,materialValue,sizeValue);
						app.toys.add(t);
						app.LOGR.info("A Animal has been added: " +t.getName());
					}else if (categoryText.equals("Puzzle")) {
						
						String typeValue=type.getText();
						Toy t = new Puzzle(SN,nameValue,brandValue,priceValue,availableValue,ageAppropriateValue,typeValue);
						app.toys.add(t);
						app.LOGR.info("A Puzzle has been added: " +t.getName());
					}else if (categoryText.equals("Board Game")) {
						
						int minNumValue= Integer.parseInt(minNumOfPlayers.getText());  
						int maxNumValue= Integer.parseInt(maxNumOfPlayers.getText()); 
						try {
							if(isValid(minNumValue, maxNumValue)) {
								String designerValue=designers.getText();
								Toy t = new BoardGame(SN,nameValue,brandValue,priceValue,availableValue,ageAppropriateValue,minNumValue,maxNumValue,designerValue);
								app.toys.add(t);
								app.LOGR.info("A Board Game has been added: " +t.getName());
							}
						} catch (minMaxPlayerException e) {
							e.printStackTrace();
						}
						
					}
				}
			} catch (NegativePriceException e) {
				e.printStackTrace();
			}
		}
		
		app.save();
	}
	
	private boolean isValid(int min, int max) throws minMaxPlayerException {
		if(min>max) {
			throw new minMaxPlayerException("The minimum number of players is greater than the maximum number amount. ");
		}
		return true; 
	}
	/**
	 * isValid is an overloaded method that takes in a double(price), and if the price is greater then 0 then it returns true. Otherwise it will throw a NegativePriceException. 
	 * @param price
	 * @return
	 * @throws NegativePriceException
	 */
	private boolean isValid(double price) throws NegativePriceException{
		if(price<0) {
			throw new NegativePriceException("Negative Toy Price");
		}
		return true;
	}
	
	@FXML
	void clearButtonListener() {
		serialNumber.setText("");
		name.setText("");
		brand.setText("");
		price.setText("");
		availableCount.setText("");
		ageAppropriate.setText("");
		classification.setText("");
		type.setText("");
		material.setText("");
		size.setText("");
		minNumOfPlayers.setText("");
		maxNumOfPlayers.setText("");
		designers.setText("");
		app.LOGR.info("TextFields have been cleared.");
	}
	
	
}
