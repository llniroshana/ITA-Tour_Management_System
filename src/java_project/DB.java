package java_project;

/**
 *
 * @author Chamara Niroshana
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    
    public static Connection mycon() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hotels_db?useSSL=false","root","");
        
        return c;
        
    }
    
}
