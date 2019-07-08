/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.dinamore.business.repository.custom.impl.TpOperatorRepositryImpl;
import lk.ijse.dinamore.service.ServiceFactory;
import lk.ijse.dinamore.service.SuperService;
import lk.ijse.dinamore.service.custom.impl.ChefServiceImpl;
import lk.ijse.dinamore.service.custom.impl.CustomerServiceImpl;
import lk.ijse.dinamore.service.custom.impl.ItemServiceImpl;
import lk.ijse.dinamore.service.custom.impl.OrderDetailServiceImpl;
import lk.ijse.dinamore.service.custom.impl.OrdersServiceImpl;
import lk.ijse.dinamore.service.custom.impl.TpOperatorServiceImpl;

/**
 *
 * @author acer
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    
    private static ServiceFactory serviceFactory;
    
    public ServiceFactoryImpl()throws RemoteException{
        
    }
    public static ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory==null) {
            serviceFactory= new ServiceFactoryImpl();
        }
        return serviceFactory;
    }
    
    @Override
    public SuperService getServiceType(ServiceType type) throws Exception {
        switch(type){
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case TEL_OP:
                return new TpOperatorServiceImpl();
            case OD:
                return new OrderDetailServiceImpl();
            case ORDERS:
                return new OrdersServiceImpl();
            case CHEF:
                return new ChefServiceImpl();
                default:return null;
        }
    }
    
}
