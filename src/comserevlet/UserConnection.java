package comserevlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnection {
    public static void main(String[] args){
        String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/comtest?characterEncoding=utf8&useSSL=false&serverTimezone=CST&rewriteBatchedStatements=true";
        String username="root";
        String password="123456";
        Connection connection = null;
        try {
            //加载驱动
            Class.forName(DRIVER_CLASS);
            //获得数据连接对象
            try {

                connection = DriverManager.getConnection(url,username,password);
                System.out.println(connection);//测试连接sql是否成功
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
