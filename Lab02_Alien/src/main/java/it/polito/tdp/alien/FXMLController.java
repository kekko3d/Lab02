package it.polito.tdp.alien;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.*;

public class FXMLController {
	
	private AlienDictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtImput;

    @FXML
    private Button idTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button idClear;

    @FXML
    void actionClear(ActionEvent event) {
    	model.clear();
    	txtResult.clear();
    }

    @FXML
    void actionTraslate(ActionEvent event) {
    	
    	String input[] = txtImput.getText().trim().split(" ");
    	Pattern letter = Pattern.compile("[^a-z?A-Z ]");
    	Matcher hasLetter1 = letter.matcher(input[0]);
    	boolean hasSpecial1 = hasLetter1.find();
    	String checkMultipeQuestionMark = txtImput.getText().trim();
    	String temp;
    	
    	
    	if(input.length>2) {
    		txtResult.appendText("Errore: hai inserito troppe parole");    	
			return;
    	}
    	if(checkMultipeQuestionMark.contains("?")) {
    		int num = checkMultipeQuestionMark.indexOf('?');
    		temp = checkMultipeQuestionMark.substring(0, num) + checkMultipeQuestionMark.substring(num+1);
    		if(temp.contains("?")) {
    			txtResult.appendText("Errore: hai inserito troppe punti interrogativi");    	
    			return;
    		}
    	}

    	if(txtImput.getText().trim().contains(" ")) {
        	Matcher hasLetter2 = letter.matcher(input[1]);
        	boolean hasSpecial2 = hasLetter2.find();
        	if(hasSpecial1 || hasSpecial2) {
        		txtResult.appendText("Errore: hai inserito caratteri speciali");    	
        		return;
        	}
    	} else {
    		if(hasSpecial1) {
        		txtResult.appendText("Errore: hai inserito caratteri speciali");    	
        		return;
        	}
    	}
    	
    	if(txtImput.getText().trim().contains(" ")) {
    		model.add(input[0], input[1]);
    		txtResult.setText(model.toString());    	
    	} else {
    		//    		for(Parola p: parole)
    		//    			if(p.getAlieno().toUpperCase().equals(imput[0].toUpperCase()))
    		//    				txtResult.setText(p.getTraduzione());
    		if(model != null)
    			if(model.doTranslate(input[0]) != null)
    				txtResult.setText(model.doTranslate(input[0]).trim());
    	}
    }
    
    public void setModel(AlienDictionary model) {
    	
    	this.model = model;
    	
    }
    
    @FXML
    void initialize() {
        assert txtImput != null : "fx:id=\"txtImput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idTranslate != null : "fx:id=\"idTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idClear != null : "fx:id=\"idClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
