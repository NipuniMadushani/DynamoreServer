/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinamore.business.repository.custom.OrderDetailRepositry;
import lk.ijse.dinamore.entity.OrderDetail;

/**
 *
 * @author acer
 */
public class OrderDetailRepositryImpl implements OrderDetailRepositry{
    
    private Connection connection;
    
    @Override
    public boolean saveOrderDetail(OrderDetail od) throws Exception {
        String sql = "insert into orderdetail values(?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
           
            stm.setObject(1, od.getOid());
            stm.setObject(2, od.getIid());
            stm.setObject(3, od.getQty());
            

            return stm.executeUpdate() > 0;
    }

    @Override
    public List<OrderDetail> searchOrder(String oid) throws Exception {
        String sql = "Select * from orderdetail where oid='"+oid+"'";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rst = stm.executeQuery();
        ArrayList<OrderDetail> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new OrderDetail(rst.getInt("oid"),rst.getInt("iid"),rst.getInt("qty")));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(OrderDetail t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetail find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetail t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetail> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
