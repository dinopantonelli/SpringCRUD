package conexion.dino.ar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl="jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
        String usuario="root";
        String contra="";
        String driver="com.mysql.jdbc.Driver"; //fijarse el cual es el Driver. com.mysql.cj.jdbc.Driver para Version 8

        try{

          PrintWriter salida = response.getWriter();
          salida.print("Nombre de la BBDD: " + jdbcUrl + "<br>");
          Class.forName(driver);
          Connection miConexion=DriverManager.getConnection(jdbcUrl,usuario,contra); 
          salida.print("CONECTADO A LA BBDD!!");
          miConexion.close();

      }catch(Exception e){

       e.printStackTrace();

      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
