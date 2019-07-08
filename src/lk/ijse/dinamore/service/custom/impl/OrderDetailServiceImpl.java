/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.dinamore.business.BOFactory;
import lk.ijse.dinamore.business.custom.OrderDetailBO;
import lk.ijse.dinamore.dto.OrderDetailDTO;
import lk.ijse.dinamore.service.custom.OrderDetailService;

/**
 *
 * @author acer
 */
public class OrderDetailServiceImpl extends UnicastRemoteObject implements OrderDetailService{
    
    private OrderDetailBO bo;
    
    public OrderDetailServiceImpl()throws RemoteException{
         bo=(OrderDetailBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ITEM);
    }
    
    @Override
    public boolean addOrder(OrderDetailDTO orderDetailDTO) throws RemoteException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailDTO> searchOrder(String oid) throws Exception {
        return bo.searchOrder(oid);
    }
    
}
