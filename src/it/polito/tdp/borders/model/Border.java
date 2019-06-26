package it.polito.tdp.borders.model;

public class Border {
	
	private int codiceStatoA;
	private int codiceStatoB;
	private int anno;
	
	public Border(int codiceStatoA, int codiceStatoB, int anno) {
		this.codiceStatoA = codiceStatoA;
		this.codiceStatoB = codiceStatoB;
		this.anno = anno;
	}

	public int getCodiceStatoA() {
		return codiceStatoA;
	}

	public void setCodiceStatoA(int codiceStatoA) {
		this.codiceStatoA = codiceStatoA;
	}

	public int getCodiceStatoB() {
		return codiceStatoB;
	}

	public void setCodiceStatoB(int codiceStatoB) {
		this.codiceStatoB = codiceStatoB;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "Border [codiceStatoA=" + codiceStatoA + ", codiceStatoB=" + codiceStatoB + ", anno=" + anno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiceStatoA;
		result = prime * result + codiceStatoB;
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
		Border other = (Border) obj;
		if (codiceStatoA != other.codiceStatoA)
			return false;
		if (codiceStatoB != other.codiceStatoB)
			return false;
		return true;
	}
	

}
