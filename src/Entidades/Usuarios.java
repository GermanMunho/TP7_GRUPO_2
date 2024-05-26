package Entidades;

public class Usuarios {
	private int tipoUsuario;
	private String nombreUsuario;
	private String pass;
	private String dni;
	private String nombre;
	private String apellido;

	public Usuarios() {
	}

	public Usuarios(int tipoUsuario, String nombreUsuario, String pass, String dni, String nombre, String apellido) {
		this.tipoUsuario = tipoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Usuarios [tipo de Usuario=" + tipoUsuario + ", nombre de Usuario=" + nombreUsuario + ", pass=" + pass
				+ ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
