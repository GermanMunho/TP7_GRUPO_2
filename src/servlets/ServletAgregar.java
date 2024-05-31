package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import Entidades.Seguros;
import Entidades.TipoSeguros;
import Negocio.SegurosNeg;
import Negocio.TipoSegNeg;
import NegocioImpl.SegurosNegImpl;
import NegocioImpl.TipoSegNegImpl;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAgregar() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SegurosNeg seguroImpl = new SegurosNegImpl();
		TipoSegNeg tipoSeguroImpl = new TipoSegNegImpl();

		ArrayList<TipoSeguros> tiposSeguro = (ArrayList<TipoSeguros>) tipoSeguroImpl.listar();
		int ultimoId = seguroImpl.obtenerUltimoID() + 1;

		request.setAttribute("ultimoId", ultimoId);
		request.setAttribute("tiposSeguro", tiposSeguro);

		if (request.getParameter("btnAceptar") != null) {
			String descripcion = request.getParameter("txtDescripcion");
			String tipoSeguro = request.getParameter("tipoSeguro");
			String costoContratacionStr = request.getParameter("txtContratacion");
			String costoMaximoStr = request.getParameter("txtCosto");
			TipoSeguros tipo = tipoSeguroImpl.BuscarTipoSeguro(Integer.parseInt(tipoSeguro));
			if (descripcion != null && tipo != null && costoContratacionStr != null && costoMaximoStr != null) {
				try {
					float costoContratacion = Float.parseFloat(costoContratacionStr);
					float costoMaximo = Float.parseFloat(costoMaximoStr);

					Seguros seguro = new Seguros(ultimoId, descripcion, tipo.getId(), tipo.getDescripcion(),
							costoContratacion, costoMaximo);
					seguroImpl.agregar(seguro);
					request.setAttribute("mensajeExito", "Seguro agregado exitosamente");

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} else {
			request.setAttribute("mensajeError", "Complete todos los campos");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarSeguro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
