package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.SeguroImpl;
import DaoImpl.TipoSeguroImpl;
import Entidades.Seguros;
import Entidades.TipoSeguros;

@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletListar() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("MostrarSeguros") != null) {
			TipoSeguroImpl tipo = new TipoSeguroImpl();
			ArrayList<TipoSeguros> lista = new ArrayList<TipoSeguros>();
			lista = tipo.listar();
			request.setAttribute("listaT", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarSeguro.jsp");
	        dispatcher.forward(request, response);
		}
		
		TipoSeguroImpl tipo = new TipoSeguroImpl();
		ArrayList<TipoSeguros> lista = (ArrayList<TipoSeguros>) tipo.listar();
		
		SeguroImpl seg = new SeguroImpl();
		request.setAttribute("listaTipos", lista);
		ArrayList<Seguros> listaSeguros;
		
		if (request.getParameter("btnFiltrar") != null) {
            String tipoSeguroId = request.getParameter("tipoSeguro");
            if (tipoSeguroId != null && !tipoSeguroId.isEmpty()) {
                ///listaSeguros = (ArrayList<Seguros>) seg.listarPorTipo(Integer.parseInt(tipoSeguroId));
            } else {
                listaSeguros = (ArrayList<Seguros>) seg.listar();
            }
        } else {
            listaSeguros = (ArrayList<Seguros>) seg.listar();
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarSeguro.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
