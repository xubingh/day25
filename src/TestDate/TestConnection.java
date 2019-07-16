package TestDate;

import java.sql.*;

public class TestConnection {
    public static void main(String[] arge){
        String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/test01?characterEncoding=utf8&useSSL=false&serverTimezone=CST&rewriteBatchedStatements=true";
        String usernname = "root";
        String password = "123456";
        Connection con=null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName(DRIVER_CLASS);
            //获得数据连接对象
             con =DriverManager.getConnection(url,usernname,password);
            System.out.println(con);//测试是否连接成功
            sta = con.createStatement();
            String sql ="select * from test03";
             rs = sta.executeQuery(sql);
            while(rs.next()){
                System.out.println("学号："+rs.getString(1)+"，姓名："+rs.getString(2)+"，年龄："+rs.getString(3)+"，身份证："+rs.getString(4)+"，年级："+rs.getString(5)+"，性别："+rs.getString(6));



            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}