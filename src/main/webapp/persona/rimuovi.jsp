<%@page import="it.prova.gestionepersone.model.Persona"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rimozione</title>

<head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Stai per eliminare: </h5>
					    </div>
					     <% Persona personaInPagina = (Persona)request.getAttribute("delete_persona_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9"><%=personaInPagina.getNome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Cognome:</dt>
							  <dd class="col-sm-9"><%=personaInPagina.getCognome() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Altezza:</dt>
							  <dd class="col-sm-9"><%=personaInPagina.getAltezza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di nascita:</dt>
							  <dd class="col-sm-9"><%=personaInPagina.getDataNascita()!=null? new SimpleDateFormat("dd/MM/yyyy").format(personaInPagina.getDataNascita()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    
					    
					    
					    
					    
					    <div class='card-footer'>
					     <form method="post" action="ExecuteRimuoviServlet" class="row g-3" novalidate="novalidate">		
					           <input type="hidden" name="idDaRimuovere" value="<%=personaInPagina.getId() %>">
					           	<input type="submit" value="Delete" class='btn btn-outline-danger' style='width:100px'>&nbsp
					        <a href="ListPersoneServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a> 
					     </form>
					        
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>