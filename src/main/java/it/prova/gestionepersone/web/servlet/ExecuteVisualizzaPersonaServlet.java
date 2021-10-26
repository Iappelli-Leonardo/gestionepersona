package it.prova.gestionepersone.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionepersone.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaPersonaServlet")
public class ExecuteVisualizzaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ExecuteVisualizzaPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArticoloParam = request.getParameter("idPersona");

		if (!NumberUtils.isCreatable(idArticoloParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_persona_attr", MyServiceFactory.getPersonaServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idArticoloParam)));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/persona/mostra.jsp").forward(request, response);
	}

}

	