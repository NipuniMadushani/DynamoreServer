/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinamore.business.custom.TelBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.TpOperatorRepositry;
import lk.ijse.dinamore.dto.TelOperatorDTO;
import lk.ijse.dinamore.entity.TelOparator;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class TelBOImpl implements TelBO{
    
    private TpOperatorRepositry operatorRepositry;

    public TelBOImpl() {
        operatorRepositry=(TpOperatorRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.TP);
    }
    
    

    @Override
    public ArrayList<TelOperatorDTO> telReport(String name) throws Exception {
        Connection connection = DBConnection.getConnection();
        operatorRepositry.setConnection(connection);
        
        ArrayList<TelOparator> l=operatorRepositry.telReport(name);
        ArrayList<TelOperatorDTO> list=new ArrayList<>();
        for (TelOparator t : l) {
            TelOperatorDTO dto=new TelOperatorDTO(t.getTid(), t.getTopQty(), t.getTopDate());
            list.add(dto);
        }
        return list;
    }

    @Override
    public ArrayList<TelOperatorDTO> view() throws Exception {
        Connection connection = DBConnection.getConnection();
        operatorRepositry.setConnection(connection);

        List<TelOparator> list = operatorRepositry.view();
        ArrayList<TelOperatorDTO> all = new ArrayList<>();
        for (TelOparator t : list) {
            TelOperatorDTO dto=new TelOperatorDTO(t.getTid(), t.getTelName(), t.getTelContract(),t.getTelAddress());
            all.add(dto);


        }
        return all;
    }
    
}
