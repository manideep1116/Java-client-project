import java.sql.*;
import java.util.*;

// Implementing the remote interface 
public class Implement implements Hello {
    private static final long serialVersionUID = 1L;

    // Implementing the interface method
    public List<Student> getStudents() throws Exception {
        List<Student> list = new ArrayList<Student>();

        try {

            // JDBC driver name and database URL
            String JDBC_DRIVER = "org.postgresql.Driver";
            String DB_URL = "jdbc:postgresql://localhost:5432/cpe_545";
            System.out.println("CameHere");
            // Database credentials
            String USER = "postgres";
            String PASS = "manideep1116";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("org.postgresql.Driver");
//java -cp .;postgresql-42.1.4.jar ImplExample

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");

                String name = rs.getString("name");
                String lastname = rs.getString("last_name");


                // Setting the values
                Student student = new Student();
                student.setId(id);
                student.setname(name);
                student.setLastname(lastname);
                list.add(student);
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Java -Djava.security.policy=Client.policy Client_RMI
        return list;

    }

    public Student  getName(String name) throws Exception{
        String lastName  = "";
        Student student = null;
        try {

            // JDBC driver name and database URL
            String JDBC_DRIVER = "org.postgresql.Driver";
            String DB_URL = "jdbc:postgresql://localhost:5432/cpe_545";
            System.out.println("CameHere");
            // Database credentials
            String USER = "postgres";
            String PASS = "manideep1116";

            Connection conn = null;
            Statement stmt = null;

            //Register JDBC driver
            Class.forName("org.postgresql.Driver");
//java -cp .;postgresql-42.1.4.jar ImplExample

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql = "select * from Students where '" + name+ "'  like '%' || name || '%';";

            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String fname = rs.getString("name");
                String lastname = rs.getString("last_name");


                // Setting the values
                student = new Student();
                student.setId(id);
                student.setname(fname);
                student.setLastname(lastname);
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Java -Djava.security.policy=Client.policy Client_RMI
        return student;
    }

}