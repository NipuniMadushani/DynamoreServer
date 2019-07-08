/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import lk.ijse.dinamore.business.repository.custom.CustomerRepositry;
import lk.ijse.dinamore.entity.Customer;

/**
 *
 * @author acer
 */
public class CustomerRepositryImpl implements CustomerRepositry{
    
    private Connection connection;
    
    
    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(Customer t) throws Exception {
        String sql="Insert into customer values(?,?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1, t.getCusId());
        pstm.setObject(2, t.getName());
        pstm.setObject(3, t.getContract());
        pstm.setObject(4, t.getAddress());
        
        return pstm.executeUpdate()>0;
    }

    @Override
    public Customer find(String id) throws Exception {
        String sql="select name,cusId,address,contact from customer where contact=? || cusId=?";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, id);
        stm.setObject(2, id);
        
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            return new Customer(rst.getInt("cusId"),rst.getString("name"),rst.getString("contact"),rst.getString("address"));
        }
        return null;
    }

    @Override
    public boolean update(Customer t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
