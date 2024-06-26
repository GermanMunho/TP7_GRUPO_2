<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidades.Seguros"%>
<%@ page import="Entidades.TipoSeguros"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar seguro</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="ServletAgregar?nuevo">Agregar seguro</a>
	<a href="ServletListar?MostrarSeguros">Listar seguro</a>
	<h1>Listar seguro</h1>

	<%
		ArrayList<TipoSeguros> ls = null;
		if (request.getAttribute("listaT") != null) {
			ls = (ArrayList<TipoSeguros>) request.getAttribute("listaT");
		}
	%>

	<form method="get" action="ServletListar">
    Tipos de seguros: <select name="tipoSeguro">
        <%
            ArrayList<TipoSeguros> Ls = (ArrayList<TipoSeguros>) request.getAttribute("listaTipos");
            if (ls != null) {
                for (TipoSeguros tipo : ls) {
        %>
        <option value="<%= tipo.getId() %>"><%= tipo.getDescripcion() %></option>
        <%
                }
            }
        %>
    </select>
    <input type="submit" name="btnFiltrar" value="Filtrar seguros">
</form>

	<%
		ArrayList<Seguros> listaSeguros = null;
		if (request.getAttribute("listaSeguros") != null) {
			listaSeguros = (ArrayList<Seguros>) request.getAttribute("listaSeguros");
		}
	%>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Descripci�n</th>
			<th>Tipo</th>
			<th>Costo de contrataci�n</th>
			<th>Costo m�ximo asegurado</th>
		</tr>
		<%
			if (listaSeguros != null) {
				for (Seguros seg : listaSeguros) {
		%>
		<tr>
			<td><%=seg.getId()%></td>
			<td><%=seg.getDescripcion()%></td>
			<td><%=seg.getTipo().getDescripcion()%></td>
			<td><%=seg.getCostoContracion()%></td>
			<td><%=seg.getCostoAsegurado()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>
