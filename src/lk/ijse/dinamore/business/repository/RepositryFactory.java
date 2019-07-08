/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository;

import lk.ijse.dinamore.business.repository.custom.impl.ChefRepositryImpl;
import lk.ijse.dinamore.business.repository.custom.impl.CustomerRepositryImpl;
import lk.ijse.dinamore.business.repository.custom.impl.ItemrepositryImpl;
import lk.ijse.dinamore.business.repository.custom.impl.OrderDetailRepositryImpl;
import lk.ijse.dinamore.business.repository.custom.impl.OrdersRepositryImpl;
import lk.ijse.dinamore.business.repository.custom.impl.TpOperatorRepositryImpl;

/**
 *
 * @author acer
 */
public class RepositryFactory {
    
    private static RepositryFactory repositryFactory;
    
    private RepositryFactory(){
        
    }
    public enum RepositryType{
        CUSTOMER,ORDERS,ITEM,TP,CHEF,OD
    }
    public static RepositryFactory getInstance(){
        if(repositryFactory==null){
            repositryFactory=new RepositryFactory();
        }
        return repositryFactory;
    }
    public SuperRepository getRepository(RepositryType type){
        switch(type){
            case CHEF:
                return new ChefRepositryImpl();
            case CUSTOMER:
                return new CustomerRepositryImpl();
            case ORDERS:
                return new OrdersRepositryImpl();
            case ITEM:
                return new ItemrepositryImpl();
            case TP:
                return new TpOperatorRepositryImpl();
            case OD:
                return new OrderDetailRepositryImpl();
                default:return null;
                
        }
    }
    
}
