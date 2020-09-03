package toutiao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    Vector<Connection> pool = new Vector<>();
    Connection selectConn = null;
    int tab = 0;
    int poolSize = 10;
    int newCount = 10;
    ReentrantLock lock1 = new ReentrantLock();


    public ConnectionPool(int poolSize) throws Exception {
        this.poolSize = poolSize;
        selectConn = DriverManager.getConnection("", "", "");
        for (int i = 0; i < poolSize; i++) {
            pool.add(DriverManager.getConnection("", "", ""));
        }
    }

//    public Connection getConnection() throws Exception{
//        boole
//        if(lock1.tryLock(10, TimeUnit.SECONDS)){
//
//        }else {
//            while ()
//        }
//
//    }

    public Connection createConnection() {
        try {
            tab++;
            Connection conn = DriverManager.getConnection("", "", "");
            pool.add(conn);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(123);
    }
}