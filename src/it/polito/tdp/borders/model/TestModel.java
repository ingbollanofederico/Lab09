package it.polito.tdp.borders.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("TestModel -- TODO");
		
		System.out.println("Creo il grafo relativo al 2000");
		model.creaGrafo(2000);
		
		System.out.println("Grafo creato : "+model.getVertexSize() + " vertici "
				+ "e "+model.getEdgeSize()+" archi");
		
		System.out.println("Elenco delle nazioni e del numero di stati confinanti");
		
		System.out.println(model.gradoCountries());
		
		System.out.println(model.numeroComponentiConnesse());

		
//		List<Country> countries = model.getCountries();
//		System.out.format("Trovate %d nazioni\n", countries.size());

//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
