/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinamore.dto.CustomerDTO;

/**
 *
 * @author acer
 */
public interface CustomerBO extends SuperBO{
    public boolean saveCustomer(CustomerDTO customerDTO)throws Exception;
    
    public CustomerDTO searchCustomer(String id)throws Exception;
}
