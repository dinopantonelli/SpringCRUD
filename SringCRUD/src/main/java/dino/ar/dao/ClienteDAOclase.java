package dino.ar.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dino.ar.controlador.entity.Cliente;

@Repository  //hace que spring tome la clase como un repositorio o BEAN
public class ClienteDAOclase implements ClienteDAO{  

    @Override
    @Transactional
    public List<Cliente> getClientes(){
       
          //Obtener la session
 
           Session miSession=sessionFactory.getCurrentSession();

          //Crear la consulta(Query)

          Query<Cliente> miQuery=miSession.createQuery("from Cliente", Cliente.class);


          //ejecutar la consulta y devolver resultados

            List<Cliente> clientes=miQuery.getResultList();

           System.out.println(clientes);
           return  clientes;
     }
    
    
    
    
    @Transactional
    public void isertarCliente(Cliente elCliente){

        
        //Obtener la session

         Session miSession=sessionFactory.getCurrentSession();


         //Insertar el Cliente

          miSession.saveOrUpdate(elCliente);
    }
    
    
    @Transactional
    public Cliente getCliente(int id){

     //Obtener la session

      Session miSession=sessionFactory.getCurrentSession();
    
      Cliente clienteupdate=miSession.get(Cliente.class, id);

      return clienteupdate;

   }

    @Transactional
    @Override
	public void modificarCliente(Cliente elCliente) {
		// TODO Auto-generated method stub
    	
    	 //Obtener la session

        Session miSession=sessionFactory.getCurrentSession();


        //Insertar el Cliente

         miSession.update(elCliente);
		
	}
    
    @Transactional
    @Override
	public void eliminarCliente(Cliente clienteeliminar) {
		// TODO Auto-generated method stub
    	
    	 //Obtener la session

        Session miSession=sessionFactory.getCurrentSession();
        
      //eliminar el Cliente

        miSession.delete(clienteeliminar);
		
	}
    

     @Autowired //nos hace la inyeccion de dependencia dentro del metodo
     private SessionFactory sessionFactory; //lo debemos llamar igual que en el archivo de configuracion




	


	

}