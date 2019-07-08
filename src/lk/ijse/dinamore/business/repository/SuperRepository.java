/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author acer
 */
public interface SuperRepository <T,Id>{
    public void setConnection(Connection connection);
    
    public boolean save(T t)throws Exception;
    public T find(Id id)throws Exception;
    public boolean update(T t)throws Exception;
    public boolean delete(Id id)throws Exception;
    public List<T> view()throws Exception;
}
