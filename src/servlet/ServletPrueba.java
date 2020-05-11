package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Cliente;

/*En vez de que tomcat lo de de alta mediante web.xml
 * Podemos darlo de alta por anotaciones @webServlet
 * 
 * Para entrar en este servlet, estara mapeado a la URL /ServletPrueba
 * http://localhost:8080/ActividadUF5-1-Miguel/ServletPrueba
 *  */
/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPrueba() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("HOLAAAAAAA \n Served at: ").append(request.getContextPath());
		response.getWriter().append("\r \n Vamos a probar a llamar a una base de datos (una query): ");
		// los parametros llegan en formato cadena
//		String id = request.getParameter("NOMBRE");
//		int iId = Integer.parseInt(id);
//		System.out.println(2222222 + " " + id);

		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ActividadUF5-1-MiguelAngel");
		EntityManager em = factoria.createEntityManager();

		Cliente p = em.find(Cliente.class, "02285185C");
		System.out.println(22222 + "   " + p.getNombre());

		System.out.println("Fin de la query");
		response.getWriter().append("<h1> El servlet de Miguel </h1> \n Se bienvenido ").append(p.getNombre());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
