package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Cliente;
import modelo.entidad.Persona;

public class DaoCliente {

	private EntityManager em;

	private boolean abrirConexion() {
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("ActividadUF5-1-MiguelAngel");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean cerrarConexion() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String insertar(Cliente cli) {
		if (!abrirConexion()) {
			return null;
		}

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(cli);
		et.commit();
		cerrarConexion();
		// una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return cli.getNif();
	}

	public List<Cliente> listar() {
		if(!abrirConexion()) {
		return null;
	}
		Query query = em.createQuery("select cli from Cliente cli");
		List<Cliente> listaClientes= query.getResultList();
		return listaClientes;
	}
}