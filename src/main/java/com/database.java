package com;

import com.domain.Table1;
import com.sql.ConnectionDateBases;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 喜🐑
 * @create: 2018-12-19 10:09
 */
@SpringBootApplication
public class database {
    public static void main(String[] args) throws SQLException {
        Connection natiCon = new ConnectionDateBases().getConnection("com.mysql.jdbc.Driver",
                "jdbc:mysql://218.90.248.155:33060/tzzq?useUnicode=true&characterEncoding=utf-8",
                "tzzq", "n}gVbB-lca-3o{9");
//        Connection zwgxxypt = new ConnectionDateBases().getConnection("com.mysql.jdbc.Driver",
//                "jdbc:mysql://192.168.1.87:3306/zwgxxypt?useUnicode=true&characterEncoding=utf-8",
//                "root", "root@2017");
        List<Table1> tables=new ArrayList<Table1>();
        Statement  stmt=natiCon.createStatement();
        String sql="select bumen,mulu,ku,tab from res";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            System.out.println("s1:"+s1+"\ts2:"+s2+"\ts3:"+s3+"\ts4:"+s4);
            String db="use "+rs.getString(3);
            Statement st=natiCon.createStatement();
//            st.execute(db);
            Statement stne=natiCon.createStatement();
            st.execute("DROP TABLE IF EXISTS `"+rs.getString(4)+"`");
            String create="CREATE TABLE "+rs.getString(4)+" (\n" +
                    " id int(25) DEFAULT NULL\n" +
                    ")";
            stne.execute(create);
            Statement s33=natiCon.createStatement();
            s33.execute("alter table "+rs.getString(4)+" comment '"+rs.getString(1)+"-"+rs.getString(2)+"'");

        }
        rs.close();
        stmt.close();
        natiCon.close();

    }
}
