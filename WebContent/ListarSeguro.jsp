<%@page import="java.util.ArrayList" %>
<%@page import="Entidades.Seguros" %>
<%@page import="Entidades.TipoSeguros" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar seguro</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> <a href="AgregarSeguro.jsp">Agregar seguro</a> <a href="ListarSeguro.jsp">Listar seguro</a>
<h1>Listar seguro</h1>

<form method="get" action="ServletListar">
	Tipos de seguros:
	<select name="tipoSeguro">
        <% 
        ArrayList<TipoSeguros> listaTipos = null;
        if(request.getAttribute("listaTipos")!=null){
        	listaTipos = (ArrayList<TipoSeguros>) request.getAttribute("listaTipos");
        }
        if (listaTipos != null && !listaTipos.isEmpty()) {
            for (TipoSeguros tipo : listaTipos) { %>
                <option value="<%= tipo.getId() %>"><%= tipo.getDescripcion() %></option>
            <% }
        } else { %>
            <option value="">No hay tipos de seguro disponibles</option>
        <% } %>
    </select>
	<input type="submit" name="btnFiltrar" value="Filtrar seguros">
</form>

<%
	ArrayList<Seguros> listaSeguros = null;
	if(request.getAttribute("listaSeguros")!=null){
		listaSeguros = (ArrayList<Seguros>) request.getAttribute("listaSeguros");
	}
	
 %>

<table border="1">
	<tr>	<th>ID</th>	<th>Descripción</th>	<th>Tipo</th>	<th>Costo de contratación</th>	<th>Costo máximo asegurado</th>	</tr>
	
	<%
	if(listaSeguros != null){
	for(Seguros seg: listaSeguros){
	 %>
	
	<tr>	<td><%=seg.getId() %></td>	<td><%=seg.getDescripcion() %></td>	<td><%=seg.getIdTipo() %></td>	<td><%=seg.getCostoContracion() %></td>	<td><%=seg.getCostoAsegurado()%></td>	</tr>
	<%}
	}
	 %>
</table>


</body>
</html>