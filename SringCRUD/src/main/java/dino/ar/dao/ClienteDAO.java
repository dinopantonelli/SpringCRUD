package dino.ar.dao;

import java.util.List;

import dino.ar.controlador.entity.Cliente;

public interface ClienteDAO {  //nos permitira de hacer una inyeccion de independencia del objeto de la interfaz ClienteDAO

      public List<Cliente> getClientes();
      
      public void isertarCliente(Cliente elCliente);

    //VIDEO 73

      public Cliente getCliente(int id);

	  public void modificarCliente(Cliente elCliente);

	  public void eliminarCliente(Cliente clienteeliminar);
      
      
      
         
}