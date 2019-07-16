package TestDate;

import org.junit.Test;

import java.sql.*;

public class Testsql {
    String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/test01?characterEncoding=utf8&useSSL=false&serverTimezone=CST&rewriteBatchedStatements=true";
    String usernname = "root";
    String password = "123456";
@Test
public void Tesesql1(){
        Connection connection=null;
         ResultSet rs=null;
        PreparedStatement sta=null;
        try {
            //加载链接
            Class.forName(DRIVER_CLASS);
            //获得对象
            connection =DriverManager.getConnection(url,usernname,password);
            System.out.println(connection);
////<================sql注入===没有用===============================================================================>
//            // 3、获得语句集并执行操作
//            Statement sta = connection.createStatement();
//            String loginName="afdsaf";
//            String password = "' or 1=1 or '";
//            String sql = "select id,password,loginName ln from users where loginName='"
//                   +loginName+"' AND PASSWORD='"+password+"'";
//            rs = sta.executeQuery(sql);
//《====================statement===sql 注入没啥用==================================================》
//<========================preparedStatement      预编译语句==重点掌握=======================================>
                //创建预编译语句
         String stuNO = "afdsaf";
         String stuName = "'or 1=1 or'";
    // 传入的值部分使用占位符（占位符通过?表示)：让值还是值，不会改变sql本身的结构
         String sql="select stuNo,stuName from test03 where stuNO=? and stuName=?";
            //创建预编译语句时发送sql给DBMS去进行编译操作
         sta = connection.prepareStatement(sql);
         sta.setString(1,stuNO);
         sta.setString(2,stuName);
         rs=sta.executeQuery();
            /*--------------------preparedStatement end---------------*/
            // 3.3、遍历结果集
            // rs.next()：用于判断是否有下一条记录，如果有就返回true，否则为false
            // 帐号和密码如果正确时只会返回1条或0条记录
            if(rs.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}