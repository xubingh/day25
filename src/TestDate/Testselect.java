package TestDate;

import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.*;
/**
 * 1、获得连接对象
 *    Class.forname(driverClass);
 *    Connection conn = DriverManager.getConnection(url,username,password)
 * 2、创建语句集
 *    Statement sta = conn.createStatement();
 *    // 执行语句集
 *    // 查询
 *    ResultSet rs = sta.executeQuery(sql);
 *    rs.getInt();//报错
 *    // rs.next()：用于指向某条记录
 *    while(rs.next()){
 *        rs.getXxx();//只有指向了某条记录，这个方法才可以用
 *    }
 *    // 增删改
 *    int rows = sta.executeUpdate(sql);
 *  3、关闭资源：从里向外关闭
 *    // 查询要关闭ResultSet
 *    // 增删改查都需要关闭Statement和Connection
 *
 * @author Ivy Li
 * @create 2019-07-09
 */
public class Testselect {
    private static  final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private static  final String url= "jdbc:mysql://localhost:3306/test01?characterEncoding=utf8&useSSL=false&serverTimezone=CST";
    private static final String username="root";
    private static final String password="123456";
    @Test
    public void testConnection(){
        ResultSet rs=null;
        Statement sta= null;
        Connection connection = null;
        try {
            //1.加载驱动
            Class.forName(DRIVER_CLASS);
            //2.获得连接对象

            connection = DriverManager.getConnection(url,username,password);
            System.out.println(connection);
            //新：3.获得语句集并执行操作
            //新：3.1创建语句集

            sta = connection.createStatement();
            //新：3.2执行sql语句
            //只看查询
            String sql = "select stuNo,stuName,stuAge,sex from test03";


            rs = sta.executeQuery(sql);
            //新：3.3遍历结果集
            //rs.next():用于判断是否有下一条记录，如果有就返回true，否则为false
            while(rs.next()){
                //stuNo int ==>java int
                // loginName varchar==>java String
                // 第一种：rs.getXxx(int index)：index从1开始取值
//                int id = rs.getInt(1);
//                String loginName = rs.getString(2);
                // 第二种：rs.getXxx(String columnLable)：根据列名或别名取值
                // 推荐用第二种
                int stuNo = rs.getInt("stuNo");
                String stuName = rs.getString("stuName");
                int stuAge = rs.getInt("stuAge");
                // sql中的列名加了别名，获取时要用别名
                String sex = rs.getString("sex");
                System.out.println("stuNo:"+stuNo+",stuName:"+stuName+",stuAge:"+stuAge+",sex:"+sex);
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.关闭资源
            //关闭规则：从里向外关
            try {
                //查询结果集关闭
                if (rs!=null){
                    rs.close();
                }
                //更新和查询都要关闭
                if (sta!=null){
                    sta.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
