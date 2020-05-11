package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Negocio.GestorCliente;
import modelo.entidad.Cliente;

/**
 * Servlet implementation class ServletAlta
 */
@WebServlet(name="AltaCliente", urlPatterns={"/AltaCliente"})
public class AltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("index.html").forward(request,response);
		// response.getWriter().append("Hola, estas en la clase AltaCliente.\n Es un
		// servlet.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String nif = request.getParameter("nif");
		String ciudad = request.getParameter("Ciudad");
		String domicilio = request.getParameter("domicilio");
		String tlf = request.getParameter("tlf");
		
		Cliente cli = new Cliente();
		cli.setNif(nif);
		cli.setNombre(nombre);
		cli.setCiudad(ciudad);
		cli.setDomicilio(domicilio);
		cli.setTlf(tlf);

		// habria que comunicarse con la capa gestora dentro del modelo
		GestorCliente gc = new GestorCliente();
		int respuesta = gc.alta(cli);
			
		List<Cliente> listaCli = gc.listar();
		request.setAttribute("listaClientes", listaCli);
		
		switch (respuesta) {
		case -2:
			// Error de Nombre
			request.setAttribute("MensajeError", "El nombre es demasiado corto, necesitas minimo de 4 caracteres.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			System.out.println("Error en el nombre: desmasiado corto. ");
			break;
		case -1:
			// Error de ciudad
			request.setAttribute("MensajeError", "La ciudad no es 'Madrid' ");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			System.out.println("Error de ciudad: No esta en 'Madrid'. ");
			break;
		case 0:
			// Error de conexion
			request.setAttribute("MensajeError", "No se ha podido establecer conexion. ");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			break;
		default:
			//Ha salido correcta la operacion
			request.setAttribute("Mensaje", "Nuevo cliente: "+ respuesta);
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			System.out.println("Se ha agregado el nuevo cliente");
			break;
		}
	}

}
