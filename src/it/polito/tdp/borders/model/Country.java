package it.polito.tdp.borders.model;

public class Country {
	
	private int codice;
	private String abbreviazione;
	private String nomeCompleto;
	
	public Country(int codice, String abbreviazione, String nomeCompleto) {
		this.codice = codice;
		this.abbreviazione = abbreviazione;
		this.nomeCompleto = nomeCompleto;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getAbbreviazione() {
		return abbreviazione;
	}

	public void setAbbreviazione(String abbreviazione) {
		this.abbreviazione = abbreviazione;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Override
	public String toString() {
		return "Country [codice=" + codice + ", abbreviazione=" + abbreviazione + ", nomeCompleto=" + nomeCompleto
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	
	
	
}
