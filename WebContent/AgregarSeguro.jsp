<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
	<%@ page import="java.util.ArrayList" %>
	<%@page import="Entidades.TipoSeguros" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar seguro</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> <a href="AgregarSeguro.jsp">Agregar seguro</a> <a href="ListarSeguro.jsp">Listar seguro</a>
<h1>Agregar seguro</h1>

<form method="get" action="ServletAgregar">
    <% 
    Object ultimoIdObj = request.getAttribute("ultimoId");
    if (ultimoIdObj != null) { %>
        <p>Id Seguro: <%= ultimoIdObj %></p>
    <% } else { %>
        <p>Id Seguro no disponible</p>
    <% } %>
    <p>Descripción  <input type="text" name="txtDescripcion"/> </p> 
    <p>Tipo de seguro</p> 
    <select name="tipoSeguro">
        <% 
        List<TipoSeguros> lista = (List<TipoSeguros>) request.getAttribute("tiposSeguro");
        if (lista != null && !lista.isEmpty()) {
            for (TipoSeguros tipo : lista) { %>
                <option value="<%= tipo.getDescripcion() %>"><%= tipo.getDescripcion() %></option>
            <% }
        } else { %>
            <option value="">No hay tipos de seguro disponibles</option>
        <% } %>
    </select>
    <p>Costo de contratación <input type="number" name="txtContratacion"/> </p> 
    <p>Costo máximo asegurado <input type="number" name="txtCosto"/></p> 
    <input type="submit" name="btnAceptar" value="Aceptar" />
</form>


</body>
</html>