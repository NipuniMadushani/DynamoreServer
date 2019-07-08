/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.repository.SuperRepository;
import lk.ijse.dinamore.entity.Orders;
import lk.ijse.dinamore.entity.Report;

/**
 *
 * @author acer
 */
public interface OrdersRepositry extends SuperRepository<Orders, String> {

    public int lastId() throws Exception;

    public ArrayList<Orders> searchThisOrder(String id) throws Exception;

    public ArrayList<Orders> getPendingOrders() throws Exception;

    public boolean saveReport(Report t) throws Exception;

    public Orders todayOrderReport(String date, String id) throws Exception;

    public Orders OrderReport(String date, String id, String i) throws Exception;
}
