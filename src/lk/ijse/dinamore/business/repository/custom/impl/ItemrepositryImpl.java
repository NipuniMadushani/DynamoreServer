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
import lk.ijse.dinamore.business.repository.custom.ItemRepositry;
import lk.ijse.dinamore.entity.Item;

/**
 *
 * @author acer
 */
public class ItemrepositryImpl implements ItemRepositry{
    private Connection connection;
    
    @Override
    public ArrayList<Item> getAllItem() throws Exception {
        String sql = "Select * from item";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rst = stm.executeQuery();
        ArrayList<Item> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Item(rst.getString("itemName"), rst.getDouble("itemPrice")));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(Item t) throws Exception {
        String sql="insert into item values(?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1, t.getIid());
        pstm.setObject(2, t.getItemName());
        pstm.setObject(3, t.getItemPrice());
        
        return pstm.executeUpdate()>0;
    }

    @Override
    public Item find(String name) throws Exception {
        String sql = "Select * from item where itemName='"+name+"' || iid='"+name+"'";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rst = stm.executeQuery();
        Item list = new Item();
        while (rst.next()) {
            list=new Item(rst.getInt("iid"),rst.getString("itemName"), rst.getDouble("itemPrice"));
        }
        return list;
    }

    @Override
    public boolean update(Item t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
