package Entidades;

public class Contratacion {
	private int ID;
	private String Nombre;
	private int IDSeguro;
	private float Costo;

	public Contratacion() {
	}

	public Contratacion(int ID,String Nombre, int IDSeguro, float Costo) {
		this.ID=ID;
		this.Nombre = Nombre;
		this.IDSeguro = IDSeguro;
		this.Costo = Costo;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getIDSeguro() {
		return IDSeguro;
	}

	public void setIDSeguro(int iDSeguro) {
		IDSeguro = iDSeguro;
	}

	public float getCosto() {
		return Costo;
	}

	public void setCosto(float costo) {
		Costo = costo;
	}

	@Override
	public String toString() {
		return "Contratacion [ID=" + ID + ", Nombre=" + Nombre + ", IDSeguro=" + IDSeguro + ", Costo=" + Costo + "]";
	}

}
