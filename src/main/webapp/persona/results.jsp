<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionepersone.model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaPersone</title>
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Lista Elementi</title>
</head>

<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div
				class="alert alert-success alert-dismissible fade show ${successMessage == null?'d-none':'' }"
				role="alert">
				${successMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<div class="alert alert-success alert-dismissible fade show d-none"
				role="alert">
				Esempio di messaggio di operazione avvenuta con successo
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show d-none"
				role="alert">
				Esempio di operazione fallita!
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-info alert-dismissible fade show d-none"
				role="alert">
				Aggiungere d-none nelle class per non far apparire
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>



			<div class='card'>
				<div class='card-header'>
					<h5>Lista dei risultati:</h5>
				</div>
				<div class='card-body'>
					<a class="btn btn-primary " href="PrepareInsertPersonaServlet">Add
						New</a>

					<div class='table-responsive'>
						<table class='table table-striped '>
							<thead>
								<tr>
									<th>Id</th>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Altezza</th>
									<th>Data di nascita</th>
									<th>Azioni:</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="listaPersone" items="${listaPersoneAttribute}">
									<fmt:formatDate value="${listaPersone.dataNascita}" pattern="dd/MM/yyyy" var="dataNascita"/>
									<tr>
										<td>${listaPersone.id}</td>
										<td>${listaPersone.nome}</td>
										<td>${listaPersone.cognome}</td>
										<td>${listaPersone.altezza}</td>
				                        <td>${dataNascita}</td>
									
									<td><a class="btn  btn-sm btn-outline-secondary"
										href="ExecuteVisualizzaPersonaServlet?idPersona=${listaPersone.id} ">Visualizza</a>
										<a class="btn  btn-sm btn-outline-primary ml-2 mr-2"
										href="PrepareModificaServlet?idPersona=${listaPersone.id}">Modifica</a>
										<a class="btn btn-outline-danger btn-sm"
										href="PrepareRimuoviServlet?idPersona=${listaPersone.id}">Delete</a>
									</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<!-- end card-body -->
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />

	<!-- Modal conferma delete -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">Conferma
						Operazione</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Continuare con l'operazione?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Annulla</button>
					<button type="button" class="btn btn-primary">Continua</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal conferma delete -->

</body>
</html>