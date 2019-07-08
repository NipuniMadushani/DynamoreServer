/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.CustomerRepositry;
import lk.ijse.dinamore.dto.CustomerDTO;
import lk.ijse.dinamore.entity.Customer;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class CustomerBOImpl implements CustomerBO{
    private CustomerRepositry customerRepositry;

    public CustomerBOImpl() {
        customerRepositry=(CustomerRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.CUSTOMER);
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        Connection connection=DBConnection.getConnection();
        customerRepositry.setConnection(connection);
        return customerRepositry.save(
                new Customer(customerDTO.getCusId(), customerDTO.getName(), customerDTO.getContract(), customerDTO.getAddress())
        );
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Connection connection=DBConnection.getConnection();
        customerRepositry.setConnection(connection);
        Customer customer=customerRepositry.find(id);
        if(customer!=null){
            return new CustomerDTO(customer.getCusId(), customer.getName(), customer.getContract(), customer.getAddress());
        }
        return null;
    }
    
    
    
}
