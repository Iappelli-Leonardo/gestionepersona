package it.prova.gestionepersone.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepersone.service.MyServiceFactory;
import it.prova.gestionepersone.service.PersonaService;


@WebServlet("/ExecuteRimuoviServlet")
public class ExecuteRimuoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExecuteRimuoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idArticolo = Long.parseLong(request.getParameter("idDaRimuovere"));

		PersonaService personaServiceInstance = MyServiceFactory.getPersonaServiceInstance();

		try {
			personaServiceInstance.rimuovi(personaServiceInstance.caricaSingoloElemento(idArticolo));
			request.setAttribute("listaPersoneAttribute", MyServiceFactory.getPersonaServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/persona/results.jsp").forward(request, response);
	}

}
