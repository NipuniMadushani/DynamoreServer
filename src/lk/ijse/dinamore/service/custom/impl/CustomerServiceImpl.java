/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.dinamore.business.BOFactory;
import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.business.repository.custom.CustomerRepositry;
import lk.ijse.dinamore.dto.CustomerDTO;
import lk.ijse.dinamore.service.custom.CustomerService;

/**
 *
 * @author acer
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService{
    private CustomerBO customerBO;
    private CustomerRepositry customerRepositry;
    
    public CustomerServiceImpl() throws RemoteException{
    
        customerBO=(CustomerBO) BOFactory.getInstance().getBOType(BOFactory.BOType.CUSTOMER);
        
    
    }
    
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        System.out.println("djdj");
        return customerBO.saveCustomer(customerDTO);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        return customerBO.searchCustomer(id);
    }
    
}
