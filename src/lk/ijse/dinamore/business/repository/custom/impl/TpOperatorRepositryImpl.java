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
import lk.ijse.dinamore.business.repository.custom.TpOperatorRepositry;
import lk.ijse.dinamore.entity.TelOparator;
import lk.ijse.dinamore.entity.TelOperatorLogin;

/**
 *
 * @author acer
 */
public class TpOperatorRepositryImpl implements TpOperatorRepositry{
    
    private Connection connection;
    
    @Override
    public int lastId() throws Exception {
        String sql="select tid from telOparator order by tid desc limit 1";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean saveLogin(TelOperatorLogin t) throws Exception {
        String sql="insert into tpOperatorLogin values(?,?,?)";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, t.getTid());
        stm.setObject(2, t.getUserName());
        stm.setObject(3, t.getPassword());
        
        
        return stm.executeUpdate()>0;
    }

    @Override
    public TelOperatorLogin findLogin(String name) throws Exception {
        String sql="select * from tpOperatorLogin where userName=?";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, name);
               
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            return new TelOperatorLogin(rst.getInt("tid"),rst.getString("userName"),rst.getString("password"));
        }
        return null;
    }

    @Override
    public ArrayList<TelOparator> telReport(String name) throws Exception {
        String sql = "select cusId,qty,date from Report where tid='"+name+"'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<TelOparator> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new TelOparator(rst.getInt(1), rst.getInt(2), rst.getString(3)));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(TelOparator t) throws Exception {
        String sql="insert into telOparator values(?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, t.getTid());
        stm.setObject(2, t.getTelName());
        stm.setObject(3, t.getTelContract());
        stm.setObject(4, t.getTelAddress());
        
        return stm.executeUpdate()>0;
    }

    @Override
    public TelOparator find(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TelOparator t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TelOparator> view() throws Exception {
        String sql = "select * from telOparator";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<TelOparator> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new TelOparator(rst.getInt("tid"), rst.getString("telName"), rst.getString("telContract"), rst.getString("telAddress")));
        }
        return list;
    }
    
}
