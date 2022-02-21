package dino.ar.controlador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")    //coincidir con el nombre de la tabla de la BBDD

public class Cliente {

    public Cliente(){

    }


     public Cliente(int id, String nombre,  String apellido, String email) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			
		}


      public Cliente(String nombre, String apellido, String email) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			
      }

        
       public int getId() {
			return id;
		}


	public void setId(int id) {
			this.id = id;
	}


        public String getNombre() {
			return nombre;
		}


	public void setNombre(String nombre) {
			this.nombre = nombre;
	}

        public String getApellido() {
			return apellido;
		}


	public void setApellido(String apellido) {
			this.apellido = apellido;
	}

          public String getEmail() {
			return email;
		}


	public void setEmail(String email) {
			this.email = email;
	}




         //Hacer el metodo toString
     
	   @Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
		}


       @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY) //le decimos con esto que es el campo clave
       @Column(name="id")
       private int id;
      




	@Column(name="nombre")
       private String nombre;
       @Column(name="apellido")
       private String apellido;
       @Column(name="email")
       private String email;    
	
}
