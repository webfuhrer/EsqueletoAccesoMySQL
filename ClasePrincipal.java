package paquete.accesomysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasePrincipal {

	public static void main(String[] args) {
		try {
			Persona p=new Persona("Xavier", "Perez");
		//Para conectarme lo perimero, un objeto Connection. 
		//Al getConnection le paso la URL, el usuario y el pwd si lo tiene.
		//Algunas versiones del Driver exigen poner el serverTimeZone
			
			Connection c=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/pruebas?serverTimeZone=UTC", "root", "");
//Despu�s del Connection creo un Statement (o PreparedStatement)
			Statement stmt=c.createStatement();
//La query puede ser cualquier CRUD (create read update delete)
//String query="SELECT * from alumnos";
String query_insercion="INSERT INTO alumnos VALUES ('"+p.getNombre()+"', '"+
p.getApellido()+"')";
//Vamos a hacer una inserci�n
//Si mi query es de tipo read (para leer datos), entonces
//los datos le�dos me vienen en un ResultSet(que es un conjunto de resultados)
//La palabra Set significa "conjunto": Set de grabaci�n, set de cocina..
stmt.executeUpdate(query_insercion);
//ResultSet resultados=stmt.executeQuery(query);
//Recorro el ResultSet viendo si hay un siguiente (el m�todo next me 
//devuelve un boolean
/*
while(resultados.next())//El metodo next va avanzando el cursor
	//Al principio, es como si estuviera antes de la primera
	//fila. En cada llamada, va movi�ndose.
{
	String nombre=resultados.getString("nombre");
	String apellido=resultados.getString("apellido");*/
	//Accedo a los campos con los distintos getters:
	//Todos loe getters tienen 2 implementaciones, 
	//en una le paso el nombre de columna y en otra el �ndice:
	//Me puede interesar usar el indice de la columna si por ejemplo
	//s� que desde la columna 5 hasta la 15 hay datos, con un bucle for
	//puedo recorrer desde el 5 hasta el 15 y no tengo que meter el nombre
	//de la columna.
	//Normalmente accederemos a trav�s del nombre de la columnaString nombre=resultados.getString("nombre");
	//String apellido=resultados.getString("apellido");
	/*System.out.println(nombre+" "+apellido);
}*/
System.out.println("Todo bien");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
