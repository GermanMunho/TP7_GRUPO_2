package servlets;

import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.SeguroImpl;
import DaoImpl.TipoSeguroImpl;



@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletAgregar() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	SeguroImpl seguroImpl = new SeguroImpl();
        TipoSeguroImpl tipoSeguroImpl = new TipoSeguroImpl();
        
        List tiposSeguro = (List) tipoSeguroImpl.listar();
        int ultimoId = seguroImpl.obtenerUltimoID() + 1;
        
        request.setAttribute("ultimoId", ultimoId);
        request.setAttribute("tiposSeguro", tiposSeguro);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarSeguro.jsp");
        dispatcher.forward(request, response);
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
