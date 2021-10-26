package it.prova.gestionepersone.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepersone.model.Persona;


@WebServlet("/PrepareInsertPersonaServlet")
public class PrepareInsertPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PrepareInsertPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
				request.setAttribute("insert_persona_attr", new Persona());
				request.getRequestDispatcher("/persona/insert.jsp").forward(request, response);
	}

	
}
