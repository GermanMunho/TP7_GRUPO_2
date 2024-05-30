package Entidades;

public class Seguros {
	private int id;
	private String Descripcion;
	private TipoSeguros Tipo;
	private float CostoContracion;
	private float CostoAsegurado;

	public Seguros() {
	}

	public Seguros(int id, String Descripcion, int idTipo,String TDescrip, float CostoContracion, float CostoAsegurado) {
		this.id = id;
		this.Descripcion = Descripcion;
		this.Tipo.setId(idTipo);
		this.Tipo.setDescripcion(TDescrip);
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
		return "Seguros [id=" + id + ", Descripcion=" + Descripcion + ", idTipo=" + Tipo.getDescripcion() + ", CostoContracion="
				+ CostoContracion + ", CostoAsegurado=" + CostoAsegurado + "]";
	}

	public TipoSeguros getTipo() {
		return Tipo;
	}

	public void setTipo(TipoSeguros tipo) {
		Tipo = tipo;
	}

}
