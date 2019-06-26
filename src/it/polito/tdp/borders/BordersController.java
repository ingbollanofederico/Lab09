/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BordersController {

	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox hbox1;

    @FXML
    private TextField txtAnno;

    @FXML
    private HBox hbox2;

    @FXML
    private ComboBox<Country> cmbox;

    @FXML
    private Button btnvicini;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaConfini(ActionEvent event) {
		
		try {
			int numeroInserito = Integer.parseInt(this.txtAnno.getText());
			
			if(numeroInserito>=1816 && numeroInserito<=2016) {
				this.txtResult.appendText("Creo il grafo relativo al 2000\n");
				model.creaGrafo(numeroInserito);
				
				this.txtResult.appendText("Grafo creato : "+model.getVertexSize() + " vertici "
						+ "e "+model.getEdgeSize()+" archi\n");
				
				this.txtResult.appendText("Elenco delle nazioni e del numero di stati confinanti\n");
				this.txtResult.appendText(model.gradoCountries()+"\n");
				
				this.txtResult.appendText("Numero Compenenti connesse\n");
				this.txtResult.appendText(""+model.numeroComponentiConnesse()+"\n");
				
			}else {
				this.txtResult.appendText("Attenzione! Devi inserire un numero compreso tra il 1816 e il 2016!");
			}
			
		}catch(NumberFormatException e) {
			this.txtResult.appendText("Attenzione! Devi inserire un numero!");
		}
		
		this.hbox2.setDisable(false);
		
	}

    @FXML
    void doCalcolaVicini(ActionEvent event) {
    	
    	Country selezionato = this.cmbox.getValue();
    	
    	List<Country> raggiungibili = model.paesiRaggiungibili(selezionato);
    	this.txtResult.appendText("Paesi raggiungibili da: "+selezionato+"\n");
    	
    	for(Country c : raggiungibili) {
    		this.txtResult.appendText(c.getNomeCompleto()+"\n");
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert hbox1 != null : "fx:id=\"hbox1\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
        assert hbox2 != null : "fx:id=\"hbox2\" was not injected: check your FXML file 'Borders.fxml'.";
        assert cmbox != null : "fx:id=\"cmbox\" was not injected: check your FXML file 'Borders.fxml'.";
        assert btnvicini != null : "fx:id=\"btnvicini\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	
    }
    
    public void setModel(Model model2) {
		this.model=model2;
		
		this.cmbox.getItems().addAll(model.listOfCountries());
		
	}
}



