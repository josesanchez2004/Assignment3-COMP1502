package mru.tsc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;
import javafx.scene.Node;
import java.util.logging.*;
/**
 *  this is the controller class for the Home.fxml file. It contains the code that processes all the responses on this gui stage. 
 * @author Jose Sanchez
 *
 */
public class AppManager {
	private final String FILE_PATH = "res/Toys.txt";
	 public ArrayList <Toy> toys;
	 public ArrayList <Toy> names;
	 public ArrayList <Toy> names1;
	 public ArrayList <Toy> names2;
	 
	@FXML
	private Button homeButton;
	
	@FXML 
	private Button addButton;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private RadioButton serialRadio;
	
	@FXML
	private RadioButton nameRadio;
	
	@FXML
	private RadioButton typeRadio;
	
	@FXML 
	private TextField serialNumber;
	
	@FXML 
	private TextField name;
	
	@FXML
	private TextField type;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private ListView<Toy> listView;
	
	@FXML
	private Button clearButton;
	
	@FXML 
	private Button buyButton;

	public final Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public ObservableList<Toy> list;
	
	// I NEED TO FIX THE CLEAR BUTTON AS IF IT WONT REFRESH OBSERVABLE LIST
	@FXML
	private void initialize() {
		toys = new ArrayList<Toy>();
		names= new ArrayList<Toy>();
		names1= new ArrayList<Toy>();
		loadData();
		Log();
		LOGR.info("Opened Home Page");
		
	}
	public void Log() {
		try {
			FileHandler fh =  new FileHandler("doc/appLog",true);
			fh.setLevel(Level.ALL);
			fh.setFormatter(new SimpleFormatter());
			LOGR.addHandler(fh);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * this is the event handler for the search button, it will search for the toy/toys depending on what radio box is selected. It will then list them in the list view. 
	 * @param event
	 */
	@FXML
	void searchButtonListener(ActionEvent event) {
		
		if(serialRadio.isSelected()) {
			
			String serialNum=serialNumber.getText();
			searchToySN(serialNum);
			list = FXCollections.observableArrayList(names2);
			listView.getItems().addAll(list);
			LOGR.info("Searched for Toy by Serial Number");
			
		}else if (nameRadio.isSelected()) {
			
			String nameText=name.getText();
			searchToyName(nameText);
			list = FXCollections.observableArrayList(names);
			listView.getItems().addAll(list);
			LOGR.info("Searched for Toy by name");
			
		}else if (typeRadio.isSelected()) {
			
			String typeText= type.getText();
			searchType(typeText);
			list = FXCollections.observableArrayList(names1);
			listView.getItems().addAll(list);
			LOGR.info("Searched for Toy by type");
			
		}
	}
	/**
	 * this is the event handler for the buy button, it will subtract the availability count by 1 when the item is purchased then save it. 
	 * @param event
	 */
	@FXML
	void buyButtonListener(ActionEvent event) {
		Toy toy=listView.getSelectionModel().getSelectedItem();
		toy.setAvailableCount(toy.getAvailableCount()-1);
		save();
		LOGR.info(toy.getName()+" Has been Purchased. ");
		
	}
	/**
	 * this is the event handler for the clear button, it will clear all the fields for the user. including the listview and the arrayLists. 
	 * @param event
	 */
	@FXML
	void clearButtonListener(ActionEvent event) {
		listView.getItems().removeAll(list);
		LOGR.info("ListView has been cleared");
		if(serialRadio.isSelected()) {
			names2.clear();
		}
		else if (nameRadio.isSelected()) {
			names.clear();	
		}
		else if (typeRadio.isSelected()) {
			names1.clear();
		}
		
		
	}
	/**
	 * searchType takes in the parameter name, it will then use that name to decipher the type of Toy the user wants to find. It will then list all the Toys under the Toys categories(BoardGame,Animal,Figure,Puzzle).
	 * @param name
	 */
	private void searchType(String name) {
	
		for(Toy t: toys) {
			if(name.toLowerCase().equals("animal")) {
				if(t instanceof Animal) {
					names1.add(t);
				
			}
			}
			else if(name.toLowerCase().equals("boardgame")) {
				if(t instanceof BoardGame) {
					names1.add(t);
				}
				
			}else if (name.toLowerCase().equals("puzzle")) {
				if(t instanceof Puzzle) {
				
					names1.add(t);
				}
				
			}else if (name.toLowerCase().equals("figure")) {
				if(t instanceof Figure) {

					names1.add(t);
				}
			}
		}
	}
	
	/**
	 * searchToyName takes in a parameter of name, and any Toy's name that contains that parameters char sequence will be printed out on the console. 
	 * @param name
	 */
	private void searchToyName(String name) {
		for(Toy t: toys) {
			if(t.getName().toLowerCase().contains(name.toLowerCase())) {
				names.add(t);
			}
		}
		
	}
	
	/**
	 * save, writes to the FILE_PATH and formats the Toys information in its proper Txt.file form. 
	 */
	public void save() {
		File file= new File(FILE_PATH);
		try {
			PrintWriter pw= new PrintWriter(file);
			for(Toy t: toys) {
				pw.println(t.format());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * loadData loads all of the information from the Toys.txt file, and creates objects corresponding to the information given and adds them to the toys arraylist. 
	 */
	public void loadData() {
		String line;
		String[] lineSplitter;
		
		try {
			File data = new File(FILE_PATH);
			Scanner fileRead= new Scanner(data);
			
			while(fileRead.hasNextLine()) {
				
				line=fileRead.nextLine();
				lineSplitter=line.split(";");
				
				String SN1= (lineSplitter[0]);
				char ID= SN1.charAt(0);
				double price=Double.parseDouble(lineSplitter[3]);
				int availableCount=Integer.parseInt(lineSplitter[4]);
				
				//Figure
				if(ID=='0'|| ID=='1') {
					
					String classification=lineSplitter[6];
					
					Toy figure = new Figure(SN1,lineSplitter[1],lineSplitter[2],price,availableCount,lineSplitter[5],classification);
					toys.add(figure);
					
	
				}
				// Animals 
				else if(ID=='2'|| ID=='3') {
					
					Toy animal = new Animal(SN1,lineSplitter[1],lineSplitter[2],price,availableCount,lineSplitter[5],lineSplitter[6],lineSplitter[7]);
					toys.add(animal);
					
					
				}
				//Puzzles 
				else if (ID=='4' || ID=='5'|| ID=='6') {
					
					Toy puzzle= new Puzzle(SN1,lineSplitter[1],lineSplitter[2],price,availableCount,lineSplitter[5],lineSplitter[6]);
					toys.add(puzzle);
				
					
				}
				//Board Games 
				else if (ID=='7'|| ID=='8'|| ID=='9') {
					String [] split= lineSplitter[6].split("-");
					
					int minNumOfPlayers=Integer.parseInt(split[0]);
					int maxNumOfPlayers=Integer.parseInt(split[1]);
					
					Toy boardGame= new BoardGame(SN1,lineSplitter[1],lineSplitter[2],price,availableCount,lineSplitter[5],minNumOfPlayers,maxNumOfPlayers,lineSplitter[7]);
					toys.add(boardGame);
					
				}
				
			}
			fileRead.close();
				
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
			
	}
	
	/**
	 * searchToySN searches the arraylist for a Toy that matches the SN number passed through the parameter. 
	 * @param SN
	 * @return toy
	 */
    public Toy searchToySN(String SN) {
    	names2=new ArrayList<Toy>();
    	Toy toy = null;
    	
    	for(Toy t:toys) {
    		if(t.getSN().equals(SN)) {
    			toy=t;
    			names2.add(toy);
    			break;
    		}
    	}
		return toy;
		
	}
	
}
