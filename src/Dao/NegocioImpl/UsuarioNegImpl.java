package NegocioImpl;

import java.util.List;

import Dao.UsuariosDao;
import DaoImpl.UsuariosImpl;
import Entidades.Usuarios;
import Negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
	UsuariosDao UserDao = new UsuariosImpl();

	public boolean agregar(Usuarios User) {
		boolean estado = false;
		if (User.getTipoUsuario() > 0 && User.getNombre().trim().length() > 0&& User.getNombre().trim().length() > 0
				&& User.getNombreUsuario().trim().length() > 0&& User.getPass().trim().length() > 0
				&& User.getApellido().trim().length() > 0&& User.getDni().trim().length() > 0) {
			estado = UserDao.agregar(User);
		}
		return estado;

	}

	public boolean eliminar(Usuarios Usuarios_eliminar) {
		return UserDao.eliminar(Usuarios_eliminar);
	}

	public boolean modificar(Usuarios Usuarios_modificar) {
		return UserDao.modificar(Usuarios_modificar);
	}

	public List<Usuarios> listar() {
		return UserDao.listar();
	}
}
