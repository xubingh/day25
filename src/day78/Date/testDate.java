package day78.Date;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDate {
    public static void main(String[] arge){
        //无参构造调用系统时间
//        Date date1 = new Date();
//        System.out.println(date1);
        //有参构造方法传入毫秒
        Date date2 =new Date(System.currentTimeMillis());
        System.out.println(date2);
        //日期格式化 format:格式化
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1.将日期类型转换为字符串类型：方法：DateFormeat
        String frmatstr = df.format(date2);
        System.out.println(frmatstr);
        //2.将字符串类型转换为日期类型
        try {
            Date parse1 = df.parse("2080-12-30 23:59:59");
            System.out.println(parse1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
