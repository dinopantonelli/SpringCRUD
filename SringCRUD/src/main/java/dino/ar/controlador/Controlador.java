package dino.ar.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dino.ar.controlador.entity.Cliente;
import dino.ar.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")//ruta relativa para indicar el acceso desde el JSP
public class Controlador {

	@RequestMapping("/lista")//otra ruta relativa para indicar el acceso desde el JSP
	public String listaClientes(Model elModelo){    //nos devuelve el jsp

              //obtener los clientes desde el DAO 

              List<Cliente> losClientes=clienteDAO.getClientes(); //necesito hacer una inyeccion de dependencia de la variable de campo


             //agregar los clientes al Modelo   

             elModelo.addAttribute("clientes",losClientes);       


		  
	      return "lista-clientes"; //la vista  
	   
	   }
	
	
	 @RequestMapping("/FormularioAgregar")
     public String FormularioAgregarMetodo(Model elModelo){

       //Bind de datos de los clientes creo objeto cliente para agregar los datos que le voy a poner en el formulario

        Cliente elClientenuevo=new Cliente();

      //agrego el objeto Cliente vacio al modelo

          elModelo.addAttribute("cliente",elClientenuevo);       

         return "FormularioAgregarCliente";

     }
	
	
	 @PostMapping("/insertarCliente")
     public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente){   //ese "cliente es el que viene de  modelAttribute

       //insertar cliente en la BBDD a traves del cliente DAo y la inyeccion de dependencia y con la interfaz, a traves del metodo setter

        clienteDAO.isertarCliente(elCliente); 
         

       //muestra la lista actualizada

       return "redirect:/cliente/lista";
   

     }
	 
	 @PostMapping("/modificarCliente")
     public String modificarCliente(@ModelAttribute("clienteupdate") Cliente elCliente){   //ese "cliente es el que viene de  modelAttribute

       //insertar cliente en la BBDD a traves del cliente DAo y la inyeccion de dependencia y con la interfaz, a traves del metodo setter

        clienteDAO.modificarCliente(elCliente); 
         

       //muestra la lista actualizada

       return "redirect:/cliente/lista";
   

     }
	 
	 //VIDEO 72  ACTUALIZAR CLIENTE

     @GetMapping("/muestraFormularioActualizar")
     public String MetodoTraeIdActualizar(@RequestParam("clienteId") int id, Model elModelo){
  

       //rescatar el id que viene de la lista-clientes
        Cliente clienteupdate = clienteDAO.getCliente(id);

       //agregar al modelo el cliente para q lo lea el formulario
         elModelo.addAttribute("clienteupdate",clienteupdate); 

          return "FormularioModificarCliente";

     }
     
     
     
     //VIDEO 75  ELIMINAR CLIENTE

     @GetMapping("/muestraFormularioEliminar")
     public String MetodoEliminar(@RequestParam("clienteId") int id, Model elModelo){
  
       //rescatar el id que viene de la lista-clientes
        Cliente clienteeliminar = clienteDAO.getCliente(id);

        clienteDAO.eliminarCliente(clienteeliminar);

        return "redirect:/cliente/lista";

     }
     
	 
	 
	 
 
        @Autowired         //necesito hacer una inyeccion de dependencia de la variable de campo
        private ClienteDAO clienteDAO;
  
}
