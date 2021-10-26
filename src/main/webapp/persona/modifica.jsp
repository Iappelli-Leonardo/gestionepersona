<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionepersone.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Stai modificando: </h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteModificaServlet" class="row g-3" novalidate="novalidate">
							
								<% Persona personaInPagina = (Persona)request.getAttribute("update_persona_attr"); %>
							
								<input type="hidden" name ="idPersona" value="<%=personaInPagina.getId()%>">
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Codice <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="<%=personaInPagina.getNome()!=null?personaInPagina.getNome():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Descrizione <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire la cognome"  
										value="<%=personaInPagina.getCognome()!=null?personaInPagina.getCognome():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="altezza" class="form-label">Prezzo <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="altezza" id="altezza" placeholder="Inserire altezza" 
									value="<%=personaInPagina.getAltezza()!=null?personaInPagina.getAltezza():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataNascita" class="form-label">Data di Arrivo<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataNascita" id="dataNascita" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=personaInPagina.getDataNascita()!=null? new SimpleDateFormat("yyyy-MM-dd").format(personaInPagina.getDataNascita()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-primary">Confirm</button>
								
								   <a href="ListPersoneServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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