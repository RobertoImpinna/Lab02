/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AlienController {
	
	AlienDictionary v= new AlienDictionary();
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInsert"
    private TextField txtInsert; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="imgAlien"
    private ImageView imgAlien; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML
    void onClear(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void onTranslate(ActionEvent event) {
    	txtResult.clear();
    	String stringa=txtInsert.getText().trim();
    	String vett[]=stringa.split(" ");
    	
    	if(stringa.equals("")) {
    		txtResult.appendText("Inserisci parola!\n");
    		txtInsert.clear();	
    	return;
    	}
    	
    	if(vett.length>2) {
    		txtResult.appendText("Formato testo errato!\n");
    	}
    	
    	if(vett.length==2) {
    		Word w=new Word(vett[0], vett[1]);
    		
    		
    		if(v.equals(vett[0])) {
    			
    			//AGGIORNA
    			//v.aggiorna(vett[0], w);
    			//txtResult.appendText("Traduzione aggiornata!\n"+vett[0]+" = "+vett[1]+"\n");
    			
    			if(v.getWord(vett[0]).controllo(vett[1])==true) {
    			//AGGIUNGE VARIANTI
    			v.aggiungiVarianti(vett[0], vett[1]);
    			txtResult.appendText("Variante aggiunta!\n"+vett[0]+" = "+vett[1]+"\n");
    			txtInsert.clear();	
    			return;
    			}else {
    				txtResult.appendText("Treaduzione gia inserita!\n");
    				txtInsert.clear();	
    				return;
    			}
    		}
    			
    		
    		v.add(vett[0], w);
    		txtResult.appendText("Traduzione aggiunta!\n"+vett[0]+" = "+vett[1]+"\n");
    	}
    	
    	if(vett.length==1) {
    		if(v.equals(stringa)==true)
    			txtResult.appendText("Traduzione: "+v.trova(vett[0])+"\n");
    		else
    			txtResult.appendText("Nessuna traduzione trovata!!\n");
    	}
    		
    	
    	
    	txtInsert.clear();	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert imgAlien != null : "fx:id=\"imgAlien\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
