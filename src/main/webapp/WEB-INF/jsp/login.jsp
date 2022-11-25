<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Usuario"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}

</style>
</head>
<body>
	<%@include file="/WEB-INF/jsp/style.jspf"%>
	<%@include file="/WEB-INF/jsp/header.jspf"%>
	<%@include file="/WEB-INF/jsp/nav.jspf"%>
<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
	<form action="/tienda_informatica/usuarios/login/" method="post">
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Login</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">								
					<input type="submit" value="Login"/>					
				</div>
				
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%">
				Usuario
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="usuario" />
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%">
				Contraseña
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="password" />
			</div> 
		</div>

	</form>
</div>
	<%@include file="/WEB-INF/jsp/footer.jspf"%>
</body>
</html>