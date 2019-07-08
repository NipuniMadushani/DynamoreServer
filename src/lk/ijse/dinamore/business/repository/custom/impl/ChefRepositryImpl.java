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
import lk.ijse.dinamore.business.repository.custom.ChefRepository;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinamore.entity.ChefLogin;

/**
 *
 * @author acer
 */
public class ChefRepositryImpl implements ChefRepository{
    
    private Connection connection;
    
    
    
    @Override
    public int lastId() throws Exception {
        String sql="select cid from chef order by cid desc limit 1";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean saveLogin(ChefLogin log) throws Exception {
        String sql="insert into chefLogin values(?,?,?)";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, log.getCid());
        stm.setObject(2, log.getUserName());
        stm.setObject(3, log.getPassword());
        
        
        return stm.executeUpdate()>0;
    }

    @Override
    public ChefLogin findLogin(String name) throws Exception {
         String sql="select * from chefLogin where userName=?";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, name);
               
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            return new ChefLogin(rst.getInt("chefId"),rst.getString("userName"),rst.getString("password"));
        }
        return null;
    }

    @Override
    public ArrayList<Chef> chefReport(String name) throws Exception {
        String sql = "select cusId,processTime,qty,date from Report where cid='"+name+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Chef> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Chef(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(Chef t) throws Exception {
        String sql="insert into chef values(?,?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1, t.getCid());
        pstm.setObject(2, t.getChefName());
        pstm.setObject(3, t.getChefContract());
        pstm.setObject(4, t.getChefAddress());
        
        return pstm.executeUpdate()>0;
    }

    @Override
    public Chef find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Chef t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chef> view() throws Exception {
        String sql="select * from chef";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Chef> list = new ArrayList<>();
        if(rst.next()){
            list.add(new Chef(rst.getInt("cid"), rst.getString("chefName"), rst.getString("chefContract"), rst.getString("chefAddress")));
        }
        return list;
    }
    
}
