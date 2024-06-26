<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">

<title>Conta Poupan�a</title>
</head>
<body>
	<header>
		<a href="index.jsp">Home</a>|<a href="especial.jsp">Especial</a>|<a
			href="poupanca.jsp">Poupan�a</a>
	</header>
	<div class="main">
		<h1>Conta Poupan�a</h1>

		<button class="note">Saque</button>
		<div class="content">
			<form action="contapoupanca" method="post">
				<input type="number" min="5" step="0.1" id="saque" name="saque"
					placeholder="Informe valor para saque" required="required">
				<input class="buttonSubmit" type="submit" id="enviar" name="enviar"
					value="Saque">
			</form>
		</div>

		<button class="note">Deposito</button>
		<div class="content">
			<form action="contapoupanca" method="post">
				<input type="number" min="5" step="0.1" id="deposito"
					name="deposito" placeholder="Informe valor para dep�sito"
					required="required"> <input class="buttonSubmit"
					type="submit" id="enviar" name="enviar" value="Deposito">
			</form>
		</div>

		<button class="note">Rendimento</button>
		<div class="content">
			<form action="contapoupanca" method="post">
				<input class="buttonSubmit" type="submit" id="enviar" name="enviar"
					value="Calcular">
			</form>
		</div>

		<div class="consulta">
			<br />
			<h1>Consulta</h1>
			<form action="contapoupanca" method="post">
				<input class="buttonSubmit" type="submit" id="enviar" name="enviar"
					value="Consulta">
			</form>
			<c:if test="${not empty saida}">
				<h3>
					<c:out value="${saida}" />
				</h3>
			</c:if>
			<c:if test="${not empty contaPoupanca}">
				<tr>
					<th>| Nome |</th>
					<th>CodConta |</th>
					<th>Saldo |</th>
					<th>DiaRendimento |</th>
				</tr>
				<br>
				<table>
					<tbody>
						<tr>
							<c:out value="${contaPoupanca}" />
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>

	</div>

	<script src="js/script.js"></script>
</body>
</html>