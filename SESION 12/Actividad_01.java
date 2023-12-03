//a.	Operaciones Insertar, Recuperar, Actualizar, Borrar registros de una tabla
//a.	Operaciones Insertar, Recuperar, Actualizar, Borrar registros de una tabla
//a.	Operaciones Insertar, Recuperar, Actualizar, Borrar registros de una tabla
import java.sql.*;

public class MySQLExample {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo", "root", "123456");

            // Definir valores para el nuevo registro
            int id = 101;
            String name = "John";
            int salary = 50000;

            // Actualizar el registro existente si ya tiene la misma clave primaria
            PreparedStatement updateStmt = con.prepareStatement("update emp set name=?, salary=? where id=?");
            updateStmt.setString(1, name);
            updateStmt.setInt(2, salary);
            updateStmt.setInt(3, id);

            int updateResult = updateStmt.executeUpdate();

            if (updateResult > 0) {
                System.out.println("Registro existente actualizado");
            } else {
                // Si no se actualizó ningún registro, realizar la inserción
                PreparedStatement insertStmt = con.prepareStatement("insert into emp (id, name, salary) values (?, ?, ?)");
                insertStmt.setInt(1, id);
                insertStmt.setString(2, name);
                insertStmt.setInt(3, salary);
                
                int insertResult = insertStmt.executeUpdate();
                
                if (insertResult > 0) {
                    System.out.println("Nuevo registro insertado");
                } else {
                    System.out.println("Error al insertar el nuevo registro");
                }
            }

            // Recuperar registros
            Statement retrieveStmt = con.createStatement();
            ResultSet rs = retrieveStmt.executeQuery("select * from emp");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            // Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



//b.	Interfaz RowSet
//b.	Interfaz RowSet
//b.	Interfaz RowSet
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/sonoo");
        rowSet.setUsername("root");
        rowSet.setPassword("123456");

        rowSet.setCommand("select * from emp400");
        rowSet.execute();

        while (rowSet.next()) {
            System.out.println("Id: " + rowSet.getString(1));
            System.out.println("Name: " + rowSet.getString(2));
            System.out.println("Salary: " + rowSet.getString(3));
        }

    }
}



//c.	Interfaz PreparedStatement 
//c.	Interfaz PreparedStatement 
//c.	Interfaz PreparedStatement 
import java.sql.*;

class InsertPrepared {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "123456");

            PreparedStatement stmt = con.prepareStatement("insert into Emp values(?,?)");
            stmt.setInt(1, 101); 
            stmt.setString(2, "Ratan");

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


//d.	CallableStatement para invocar a Procedimientos Almacenados y Funciones.
//d.	CallableStatement para invocar a Procedimientos Almacenados y Funciones.
//d.	CallableStatement para invocar a Procedimientos Almacenados y Funciones.

//Procedimientos Almacenados:
import java.sql.*;

public class FuncSum {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "123456");
            CallableStatement stmt = con.prepareCall("{? = call sum4(?, ?)}");
            stmt.setInt(2, 10);
            stmt.setInt(3, 15);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();

            int result = stmt.getInt(1);
            System.out.println("Suma: " + result);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Funciones:
import java.sql.*;

public class FuncSum {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "123456");
            CallableStatement stmt = con.prepareCall("{? = call sum4(?, ?)}");
            stmt.setInt(2, 10);
            stmt.setInt(3, 15);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();

            int result = stmt.getInt(1);
            System.out.println("Suma: " + result);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//e.	Manejo de Transacciones en JDBC
//e.	Manejo de Transacciones en JDBC
//e.	Manejo de Transacciones en JDBC
import java.sql.*;

class FetchRecords {
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "123456");
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into user420 values(192, 'nuevoUsuario1', 60000)");
        stmt.executeUpdate("insert into user420 values(193, 'nuevoUsuario2', 70000)");

        con.commit();
        con.close();
    }
}
