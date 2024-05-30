package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarSeguro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
