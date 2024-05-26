package Entidades;

public class Seguros {
	private int id;
	private String Descripcion;
	private int idTipo;
	private float CostoContracion;
	private float CostoAsegurado;

	public Seguros() {
	}

	public Seguros(int id, String Descripcion, int idTipo, float CostoContracion, float CostoAsegurado) {
		this.id = id;
		this.Descripcion = Descripcion;
		this.idTipo = idTipo;
		this.CostoContracion = CostoContracion;
		this.CostoAsegurado = CostoAsegurado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public float getCostoContracion() {
		return CostoContracion;
	}

	public void setCostoContracion(float costoContracion) {
		CostoContracion = costoContracion;
	}

	public float getCostoAsegurado() {
		return CostoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		CostoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "Seguros [id=" + id + ", Descripcion=" + Descripcion + ", idTipo=" + idTipo + ", CostoContracion="
				+ CostoContracion + ", CostoAsegurado=" + CostoAsegurado + "]";
	}

}
