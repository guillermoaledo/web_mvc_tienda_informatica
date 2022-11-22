<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.dto.FabricanteDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fabricantes</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/jsp/style.jspf" %>
	<%@include file="/WEB-INF/jsp/header.jspf" %>
	<%@include file="/WEB-INF/jsp/nav.jspf" %>
	<div id="contenedora"
		style="float: none; margin: 0 auto; width: 900px;">
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Fabricantes</h1>
			</div>
			<div
				style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">

				<div style="position: absolute; left: 39%; top: 39%;">

					<form action="/tienda_informatica/fabricantes/crear">
						<input type="submit" value="Crear">
					</form>

					<form action="/tienda_informatica/fabricantes/" method="get">
						<select name="ordenar-por">
							<%
							if (request.getAttribute("ordenar-por").equals("nombre")) {
							%>
							<option value="nombre" selected>Nombre</option>
							<option value="codigo">Codigo</option>
							<%
							} else if (request.getAttribute("ordenar-por").equals("codigo")){
							%>
							<option value="nombre">Nombre</option>
							<option value="codigo" selected>Codigo</option>
							<%
							}
							%>
						</select>
						<select name="modo">
							<%
							if (request.getAttribute("modo").equals("asc")) {
							%>
							<option value="asc" selected>Ascendente</option>
							<option value="desc">Descendente</option>
							<%
							} else if (request.getAttribute("modo").equals("desc")){
							%>
							<option value="asc">Ascendente</option>
							<option value="desc" selected>Descendente</option>
							<%
							}
							%>
						</select> <input type="submit" value="ordenar">
					</form>

				</div>

			</div>
		</div>
		<div class="clearfix">
			<hr />
		</div>
		<div class="clearfix">
			<div style="float: left; width: 25%">Código</div>
			<div style="float: left; width: 25%">Nombre</div>
			<div style="float: left; width: 25%">Número productos</div>
			<div style="float: none; width: auto; overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr />
		</div>
		<%
		if (request.getAttribute("listaFabricantes") != null) {
			List<FabricanteDTO> listaFabricante = (List<FabricanteDTO>) request.getAttribute("listaFabricantes");

			for (FabricanteDTO fabricante : listaFabricante) {
		%>

		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left; width: 25%"><%=fabricante.getCodigo()%></div>
			<div style="float: left; width: 25%"><%=fabricante.getNombre()%></div>
			<div style="float: left; width: 25%"><%=fabricante.getNumero_productos_int()%></div>
			<div style="float: none; width: auto; overflow: hidden;">
				<form
					action="/tienda_informatica/fabricantes/<%=fabricante.getCodigo()%>"
					style="display: inline;">
					<input type="submit" value="Ver Detalle" />
				</form>
				<form
					action="/tienda_informatica/fabricantes/editar/<%=fabricante.getCodigo()%>"
					style="display: inline;">
					<input type="submit" value="Editar" />
				</form>
				<form action="/tienda_informatica/fabricantes/borrar/" method="post"
					style="display: inline;">
					<input type="hidden" name="__method__" value="delete" /> <input
						type="hidden" name="codigo" value="<%=fabricante.getCodigo()%>" />
					<input type="submit" value="Eliminar" />
				</form>
			</div>
		</div>

		<%
		}
		} else {
		%>
		No hay registros de fabricante
		<%
		}
		%>


	</div>
	<%@include file="/WEB-INF/jsp/footer.jspf"%>
</body>
</html>