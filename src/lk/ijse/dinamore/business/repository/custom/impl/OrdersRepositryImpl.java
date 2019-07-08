/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinamore.business.repository.custom.OrdersRepositry;
import lk.ijse.dinamore.entity.Orders;
import lk.ijse.dinamore.entity.Report;

/**
 *
 * @author acer
 */
public class OrdersRepositryImpl implements OrdersRepositry{
    
    private Connection connection;
    
    @Override
    public int lastId() throws Exception {
        String sql = "select oid from orders order by oid desc limit 1";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }

    @Override
    public ArrayList<Orders> searchThisOrder(String id) throws Exception {
        String sql = "select * from orders where cusId='" + id + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Orders> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Orders(rst.getInt("oid"), rst.getInt("tid"), rst.getDouble("price"), rst.getInt("cusId"), rst.getString("date")));
        }
        return list;
    }

    @Override
    public ArrayList<Orders> getPendingOrders() throws Exception {
        String sql = "select * from orders where status='pending'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Orders> list = new ArrayList<>();
        System.out.println(list);
        while (rst.next()) {
            list.add(new Orders(rst.getInt("oid"), rst.getInt("tid"), rst.getDouble("price"), rst.getInt("cusId"), rst.getString("date")));
        }
        return list;
    }

    @Override
    public boolean saveReport(Report t) throws Exception {
        String sql = "insert into Report values(?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, t.getCid());
        stm.setObject(2, t.getCusId());
        stm.setObject(3, t.getTid());
        stm.setObject(4, t.getOid());
        stm.setObject(5, t.getDate());
        stm.setObject(6, t.getProcessTime());
        stm.setObject(7, t.getQty());

        return stm.executeUpdate() > 0;
    }

    @Override
    public Orders todayOrderReport(String date, String id) throws Exception {
        String sql = "select count(oid),sum(qty),sum(processTime) from Report where date='"+date+"' && cid='"+id+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Orders list = new Orders();
        //.out.println(list);
        while (rst.next()) {
            list= new Orders(rst.getInt(1), rst.getInt(2), rst.getDouble(3));
        }
        return list;
    }

    @Override
    public Orders OrderReport(String date,String id,String in) throws Exception {
        String sql = "select count(oid),sum(qty),sum(processTime) from Report where (date <='"+date+"' && date >='"+in+"') || (date >='"+date+"' && date <='"+in+"') && cid='"+id+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        Orders list = new Orders();
        //.out.println(list);
        while (rst.next()) {
            list= new Orders(rst.getInt(1), rst.getInt(2), rst.getDouble(3));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(Orders t) throws Exception {
        String sql = "insert into orders values(?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, t.getOid());
        stm.setObject(2, t.getPrice());
        stm.setObject(3, t.getDateTime());
        stm.setObject(4, t.getCusId());
        stm.setObject(5, t.getTid());
        stm.setObject(6, t.getQty());
        stm.setObject(7, "delivered");

        return stm.executeUpdate() > 0;
    }

    @Override
    public Orders find(String id) throws Exception {
        String sql = "select * from orders where oid=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, id);

        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Orders(rst.getInt("oid"), rst.getDouble("price"), rst.getInt("cusId"), rst.getInt("tid"), rst.getString("status"), rst.getString("date"));
        }
        return null;
    }

    @Override
    public boolean update(Orders t) throws Exception {
        System.out.println("update : " + t);

        String sql = "Update orders set status=? where oid=?";

        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setObject(1, t.getStatus());
        stm.setObject(2, t.getOid());

        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orders> view() throws Exception {
        String sql = "select * from orders";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Orders> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Orders(rst.getInt("oid"), rst.getInt("tid"), rst.getDouble("price"), rst.getInt("cusId"), rst.getString("dateTime")));
        }
        return list;
    }
    
}
