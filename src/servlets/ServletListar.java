package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Seguros;
import Entidades.TipoSeguros;
import Negocio.SegurosNeg;
import Negocio.TipoSegNeg;
import NegocioImpl.SegurosNegImpl;
import NegocioImpl.TipoSegNegImpl;

@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoSegNeg tipo;
	private SegurosNeg seg;

	public ServletListar() {
		super();
		tipo = new TipoSegNegImpl();
		seg = new SegurosNegImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Seguros> listaSeguros;
		if (request.getParameter("btnFiltrar") != null) {
			String tipoSeguroId = request.getParameter("tipoSeguro");
			if (tipoSeguroId != null && !tipoSeguroId.isEmpty()) {
				listaSeguros = (ArrayList<Seguros>) seg.listarPorTipo(Integer.parseInt(tipoSeguroId));
			} else {
				listaSeguros = (ArrayList<Seguros>) seg.listar();
			}
		} else {
			listaSeguros = (ArrayList<Seguros>) seg.listar();
		}

		request.setAttribute("listaSeguros", listaSeguros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarSeguro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("MostrarSeguros") != null) {
			ArrayList<TipoSeguros> lista = (ArrayList<TipoSeguros>) tipo.listar();
			request.setAttribute("listaT", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarSeguro.jsp");
			dispatcher.forward(request, response);
		} else {
			ArrayList<TipoSeguros> lista = (ArrayList<TipoSeguros>) tipo.listar();
			request.setAttribute("listaTipos", lista);

			doGet(request, response);

		}
	}
}
