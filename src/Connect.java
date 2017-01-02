
import java.sql.*; //import library

public class Connect {

    static String db_driver = "com.mysql.jdbc.Driver";
    //static String url = "jdbc:mysql://localhost/dbmysql";//StudentDB
    static String url = "jdbc:mysql://localhost/StudentDB";

    //สร้าง static Method โดยมีการ return ค่าเป็น Interface ชื่อว่า Connection
    public static Connection ConnectDB() {
        try {
            Class.forName(db_driver); //ระบุเป็น Driver mySQL
            Connection con = DriverManager.getConnection(url, "root", "123456");
            System.out.println("เชื่อมต่อฐานข้อมูลเรียบร้อย");
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
