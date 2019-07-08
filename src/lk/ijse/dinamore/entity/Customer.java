/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author acer
 */
@Entity
public class Customer {
    @Id
    private int cusId;
    private String name;
    private String contract;
    private String address;

    public Customer() {
    }

    public Customer(int cusId, String name, String contract, String address) {
        this.cusId = cusId;
        this.name = name;
        this.contract = contract;
        this.address = address;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusId=" + cusId + ", name=" + name + ", contract=" + contract + ", address=" + address + '}';
    }
    
    
}
