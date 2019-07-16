package TestDate;

import org.junit.Test;

import java.sql.*;

public class TestUpdate {
    private static  final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private static  final String url= "jdbc:mysql://localhost:3306/test01?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username="root";
    private static final String password="123456";
    @Test
    public void TestUpdata2(){
        Connection connection=null;
        Statement sta=null;
        //加载驱动
        try {
            Class.forName(DRIVER_CLASS);
            try {
                // 2、获得连接对象
                connection = DriverManager.getConnection(url,username,password);
                System.out.println(connection);
                // 3、获得语句集并执行操作
                // 3.1 创建语句集
                sta = connection.createStatement();
                // 3.2、执行sql语句
                //String sql="insert into test03(stuNo,stuName,sex)value('010','泰国','人妖')";
                //删
                //String sql ="delete from test03 where stuNo=10";
                //改
                String sql="update test03 set stuName='李五' where stuNo=002";
                int row = sta.executeUpdate(sql);
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
        }finally {
            // 4、关闭资源
            // 4、关闭资源
            // 关闭规则：从里向外关
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
    @Test
    public void TestUpdate2(){
        Connection connection=null;
        Statement sta=null;
        ResultSet rs=null;
        try {
            Class.forName(DRIVER_CLASS);
            try {

                connection = DriverManager.getConnection(url,username,password);
                System.out.println(connection);
                // 3、获得语句集并执行操作
                // 3.1 创建语句集
                 sta = connection.createStatement();
                // 3.2、执行sql语句
                // 只看查询
                String loginName = "afdsaf";
                String password = "' or 1=1 or '";
                String sql = "select id,password,loginName ln from users where loginName='"
                        +loginName+"' AND PASSWORD='"+password+"'";

                rs = sta.executeQuery(sql);
                // 3.3、遍历结果集
                // rs.next()：用于判断是否有下一条记录，如果有就返回true，否则为false
                // 帐号和密码如果正确时只会返回1条或0条记录
                if (rs.next()){
                    System.out.println("登陆成功");

                }else{
                    System.out.println("登陆失败");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(sta!=null){
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
