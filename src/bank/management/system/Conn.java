package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    //change passwort to connect to the database
    public Conn() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
