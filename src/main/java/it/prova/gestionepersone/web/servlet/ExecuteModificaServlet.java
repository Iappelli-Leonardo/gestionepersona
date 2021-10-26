package it.prova.gestionepersone.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionepersone.model.Persona;
import it.prova.gestionepersone.service.MyServiceFactory;
import it.prova.gestionepersone.utility.UtilityPersonaForm;

@WebServlet("/ExecuteModificaServlet")
public class ExecuteModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExecuteModificaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idPersonaParam = request.getParameter("idPersona");
		
		if (!NumberUtils.isCreatable(idPersonaParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		String nomeInputParam = request.getParameter("nome");
		String cognomeInputParam = request.getParameter("cognome");
		String altezzaInputStringParam = request.getParameter("altezza");
		String dataNascitaStringParam = request.getParameter("dataNascita");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Persona personaInstance = UtilityPersonaForm.createPersonaFromParams(nomeInputParam,
				cognomeInputParam, altezzaInputStringParam, dataNascitaStringParam);
		personaInstance.setId(Long.parseLong(idPersonaParam));
		// se la validazione non risulta ok
		if (!UtilityPersonaForm.validatePersonaBean(personaInstance)) {
			request.setAttribute("update_persona_attr", personaInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/persona/modifica.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getPersonaServiceInstance().aggiorna(personaInstance);
			request.setAttribute("listaPersoneAttribute", MyServiceFactory.getPersonaServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/persona/results.jsp").forward(request, response);

	}

}
