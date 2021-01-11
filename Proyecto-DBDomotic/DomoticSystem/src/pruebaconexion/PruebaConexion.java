package pruebaconexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConexion {
    
    public static void main(String[] args) {
        String JDBCUrl = "jdbc:mysql://localhost:3306/devicesystem";
        String usuario = "root";
        String password = "";

        try {
            System.out.println("Intentando conectar a " + JDBCUrl);
            Connection myConnection = DriverManager.getConnection(JDBCUrl, usuario, password);
            System.out.println("Conexion Exitosa!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
