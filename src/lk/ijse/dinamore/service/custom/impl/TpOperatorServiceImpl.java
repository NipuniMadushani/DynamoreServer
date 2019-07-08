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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinamore.business.BOFactory;
import lk.ijse.dinamore.business.custom.TelBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.TpOperatorRepositry;
import lk.ijse.dinamore.dto.OrdersDTO;
import lk.ijse.dinamore.dto.TelOperatorDTO;
import lk.ijse.dinamore.dto.TelOperatorLoginDTO;
import lk.ijse.dinamore.entity.TelOparator;
import lk.ijse.dinamore.entity.TelOperatorLogin;
import lk.ijse.dinamore.observer.Observer;
import lk.ijse.dinamore.observer.Subject;
import lk.ijse.dinamore.resource.DBConnection;
import lk.ijse.dinamore.service.custom.TpOparatorService;

/**
 *
 * @author acer
 */
public class TpOperatorServiceImpl extends UnicastRemoteObject implements TpOparatorService,Subject{
    private TpOperatorRepositry rep;
    private TelBO bo;
    private static ArrayList<lk.ijse.dinamore.observer.Observer> obList = new ArrayList<>();
    private static Queue<lk.ijse.dinamore.observer.Observer> obListQueue = new PriorityQueue<>();

    public TpOperatorServiceImpl() throws RemoteException {
        bo = (TelBO) BOFactory.getInstance().getBOType(BOFactory.BOType.TEL);
        rep = (TpOperatorRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.TP);
    }
    
    
    @Override
    public boolean saveOperator(TelOperatorDTO tPOperatorDTO, TelOperatorLoginDTO tpDto) throws Exception {
        Connection connection = DBConnection.getConnection();
        rep.setConnection(connection);
        try {
            connection.setAutoCommit(false);
            TelOparator tel = new TelOparator(tPOperatorDTO.getTid(), tPOperatorDTO.getTelName(), tPOperatorDTO.getTelContract(), tPOperatorDTO.getTelAddress());
            TelOperatorLogin log = new TelOperatorLogin(tpDto.getTid(), tpDto.getUserName(), tpDto.getPassword());
            if (rep.save(tel)) {
                if (rep.saveLogin(log)) {
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
    public boolean searchLogin(String userName, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastId() throws Exception {
        Connection connection = DBConnection.getConnection();
        rep.setConnection(connection);
        return rep.lastId();
    }

    @Override
    public TelOperatorLoginDTO findLogin(String name) throws Exception {
        Connection connection = DBConnection.getConnection();
        rep.setConnection(connection);
        TelOperatorLogin log = rep.findLogin(name);
        if (log != null) {
            return new TelOperatorLoginDTO(log.getTid(), log.getUserName(), log.getPassword());
        }
        return null;
    }

    @Override
    public ArrayList<TelOperatorDTO> telReport(String name) throws Exception {
        return bo.telReport(name);
    }

    @Override
    public ArrayList<TelOperatorDTO> view() throws Exception {
        return bo.view();
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        System.out.println("add observer : " + observer);
        obList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        System.out.println("remove observer : " + observer);
        obList.remove(observer);
    }

    @Override
    public void notifyAllObserversProcess(String oid) throws Exception {
        new Thread(() -> {
            for (lk.ijse.dinamore.observer.Observer observer : obList) {
                //System.out.println("all ob List");
                try {
                    observer.updateProcess(oid);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public void notifyAllObserverDeliver(String oid) throws Exception {
        new Thread(() -> {
            for (lk.ijse.dinamore.observer.Observer observer : obList) {
                //System.out.println("all ob warning");
                try {
                    observer.updateDelivered(oid);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public void notifyAllRefreshTable(OrdersDTO oid) throws Exception {
        System.out.println("okkk");
        new Thread(() -> {
            for (lk.ijse.dinamore.observer.Observer observer : obList) {
                try {
                    observer.updateTable(oid);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public void notifyAllChefs(String oid) throws Exception {
        new Thread(() -> {
            for (lk.ijse.dinamore.observer.Observer observer : obList) {
                try {
                    observer.notifyOrderAdd(oid);
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public void registerObserverQueue(Observer aThis) throws Exception {
        obListQueue.add(aThis);
        System.out.println("okkkkk");
    }

    @Override
    public void unRegisterObserverQueue() throws Exception {
        if (!obListQueue.isEmpty()) {
            System.out.println("okk");
            Observer b=obListQueue.poll();
            unregisterObserver(b);
        } else {

        }
    }
    
}
