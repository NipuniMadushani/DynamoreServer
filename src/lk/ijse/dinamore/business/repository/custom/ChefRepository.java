/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.repository.SuperRepository;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinamore.entity.ChefLogin;

/**
 *
 * @author acer
 */
public interface ChefRepository extends SuperRepository<Chef, String>{
    public int lastId() throws Exception;

    public boolean saveLogin(ChefLogin log)throws Exception;

    public ChefLogin findLogin(String name)throws Exception;
    
    public ArrayList<Chef> chefReport(String name)throws Exception;
}
