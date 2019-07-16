package TestDate;

import org.junit.Test;

import java.sql.*;

public class Testsqlupdate {
    String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/test01?characterEncoding=utf8&useSSL=false&serverTimezone=CST&rewriteBatchedStatements=true";
    String usernname = "root";
    String password = "123456";

    @Test
    public void Testsqlupdate2(){
        Connection connection=null;
        PreparedStatement sta=null;
        //1.获得加载链接
        try {
            Class.forName(DRIVER_CLASS);
        //2.获得链接对象
            try {
               connection=DriverManager.getConnection(url,usernname,password);
               System.out.println(connection);
         //3.创建预编译语句集
         //3.1执行sql语句
         //增insert into
         //String sql="insert into test03(stuNo,stuName) value(?,?)";
         //删除 dalete
         //String sql="daleta from test03 where stuNo";
         //改 update
          String sql="update test03 set stuName=? where stuNo=?";
          //创建预编译语句集
                sta=connection.prepareStatement(sql);
          //增
//          sta.setString(1,"09");
//          sta.setString(2,"王老五");
          //删除
 //         sta.setString(1,"008");
          //改
           sta.setString(1,"铁拐李");
           sta.setString(2,"007");
           //执行sql语句
                int row = sta.executeUpdate();
                System.out.println(row);
                if (row>0){
                    System.out.println("更新成功");
                }else{
                    System.out.println("更新失败");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if (sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
