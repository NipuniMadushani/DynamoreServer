/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinamore.business.custom.ChefBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.ChefRepository;
import lk.ijse.dinamore.dto.ChefDTO;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class ChefBOImpl implements ChefBO{
    
    private ChefRepository rep;
    
    public ChefBOImpl(){
        rep=(ChefRepository) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.CHEF);
    }
    
    @Override
    public ArrayList<ChefDTO> view() throws Exception {
        Connection connection=DBConnection.getConnection();
        rep.setConnection(connection);
        
        List<Chef> list = rep.view();
        ArrayList<ChefDTO> all = new ArrayList<>();
        for (Chef chef : list) {
            ChefDTO dto = new ChefDTO(chef.getCid(), chef.getChefName(), chef.getChefContract(), chef.getChefAddress());
            all.add(dto);

        }
        return all;
    }

    @Override
    public ArrayList<ChefDTO> chefReport(String name) throws Exception {
        Connection connection = DBConnection.getConnection();
        rep.setConnection(connection);
        
         ArrayList<Chef> l=rep.chefReport(name);
        ArrayList<ChefDTO> list=new ArrayList<>();
        for (Chef t : l) {
            //System.out.println(t.getChefName()); --> time count
            ChefDTO dto=new ChefDTO(t.getCid(), t.getChefName(), t.getTop(),t.getChefAddress());
            list.add(dto);
        }
        return list;
    }
    
}
