package it.polito.tdp.borders.model;

import org.jgrapht.*;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import it.polito.tdp.borders.db.BordersDAO;


import java.util.*;

public class Model {

	//1. elementi
	private Graph<Country, DefaultEdge> grafo;
	private Map<Integer, Country> idMap;
	
	//2. inizalizzazione
	public Model() {
		grafo = new SimpleGraph<>(DefaultEdge.class);
		idMap = new HashMap<Integer,Country>();
	}
	
	//3.Creazione grafo
	public void creaGrafo(int anno) {
		//idMAP
		BordersDAO dao = new BordersDAO();
		dao.loadAllCountries(idMap);
		
		//aggiungo vertici
		//Graphs.addAllVertices(grafo, this.idMap.values());
		
		//aggiungo gli archi -> creo oggetto -> aggiungo arco
		List<Border> adiacenze = dao.getCountryPairs(anno);
		 
		for(Border confine : adiacenze) {
			Country countryA = idMap.get(confine.getCodiceStatoA());
			Country countryB = idMap.get(confine.getCodiceStatoB());
			
			//aggiungo vertici qui - perchè voglio solo connessi
			grafo.addVertex(countryA);
			grafo.addVertex(countryB);
		
			Graphs.addEdgeWithVertices(grafo, countryA, countryB);
				
			
		}
	}
	
	
	public Integer getVertexSize() {
		return grafo.vertexSet().size();
	}
	
	public Integer getEdgeSize() {
		return grafo.edgeSet().size();
	}
	
	public String gradoCountries() {
		
		String s="";
		
		for(Country c : grafo.vertexSet()) {
			s+=c.getNomeCompleto()+" "+grafo.degreeOf(c)+"\n";
		}
		
		return s;
		
		
	}
	
	public int numeroComponentiConnesse() {
		
		ConnectivityInspector c = new ConnectivityInspector(grafo);
		
		return c.connectedSets().size();
	}
	
	public List<Country> listOfCountries(){
		BordersDAO dao = new BordersDAO();
		return dao.loadAllCountries(idMap);
	}
	
	
	
	
	//4.VISITA DEL GRAFO
	
	public List<Country> paesiRaggiungibili(Country source){
		
		//lista nodi raggiungibili
		List<Country> result = new ArrayList<Country>();
		
		
		//ALGORITMO DI VISITA
		GraphIterator<Country, DefaultEdge> it = new BreadthFirstIterator<>(this.grafo,source);
		
		
		//mentre esplora = salvo i nodi
		while(it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
		
		
	}
	
	
	//5. fai il listener per percorso
	
	
	
	
	
	
	
	
	
	
	
	
}
