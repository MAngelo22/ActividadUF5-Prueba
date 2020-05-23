package modelo.Negocio;

import java.util.List;

import modelo.entidad.Cliente;
import modelo.persistencia.DaoCliente;

//van aqui nuestras reglas de negocio.
public class GestorCliente {
	/**
	 * 
	 * @param cli el cliente a dar de alta
	 * @return
	 */
	// Validar un nombre con 3 caracteres como minimo, la edad debe ser al menos de
	// 18.
	public int alta(Cliente cli) {
		if (cli.getNombre().length() < 3) {
			return -2;
		}
		if (!cli.getCiudad().equals("Madrid")) {
			return -1;
		}

		DaoCliente daoPersona = new DaoCliente();
		String nif = cli.getNif();
		nif = daoPersona.insertar(cli);
		cli.setNif(nif);
		return +1;
	}
	
	 public List<Cliente> listar(){
		 DaoCliente daoCliente = new DaoCliente();
		 return daoCliente.listar();
	 }
	
}
