/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.dinamore.business.BOFactory;
import lk.ijse.dinamore.business.custom.ChefBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.ChefRepository;
import lk.ijse.dinamore.dto.ChefDTO;
import lk.ijse.dinamore.dto.ChefLoginDTO;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinamore.entity.ChefLogin;
import lk.ijse.dinamore.resource.DBConnection;
import lk.ijse.dinamore.service.custom.ChefService;

/**
 *
 * @author acer
 */
public class ChefServiceImpl extends UnicastRemoteObject implements ChefService{
    
    private ChefRepository chefRepository;
    private ChefBO bo;

    public ChefServiceImpl() throws RemoteException {
        chefRepository = (ChefRepository) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.CHEF);
        bo=(ChefBO) BOFactory.getInstance().getBOType(BOFactory.BOType.CHEF);
    }
    
    @Override
    public boolean saveChef(ChefDTO chefDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastId() throws Exception {
        Connection connection = DBConnection.getConnection();
        chefRepository.setConnection(connection);
        return chefRepository.lastId();
    }

    @Override
    public boolean addChef(ChefDTO dto, ChefLoginDTO log) throws Exception {
        Connection connection = DBConnection.getConnection();
        chefRepository.setConnection(connection);
        try {
            connection.setAutoCommit(false);
            Chef chef = new Chef(dto.getCid(), dto.getChefName(), dto.getChefContact(), dto.getChefAddress());
            ChefLogin log2 = new ChefLogin(log.getCid(), log.getUserName(), log.getPassword());
            if (chefRepository.save(chef)) {
                if (chefRepository.saveLogin(log2)) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } catch (SQLException e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public ChefLoginDTO findLogin(String name) throws Exception {
        Connection connection = DBConnection.getConnection();
        chefRepository.setConnection(connection);
        ChefLogin log=chefRepository.findLogin(name);
        if(log!=null){
            return new ChefLoginDTO(log.getCid(), log.getUserName(), log.getPassword());
        }
        return null;
    }

    @Override
    public ArrayList<ChefDTO> view() throws Exception {
        return bo.view();
    }

    @Override
    public ArrayList<ChefDTO> chefReport(String name) throws Exception {
        return bo.chefReport(name);
    }
    
}
