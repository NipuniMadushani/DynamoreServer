/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.dinamore.business.BOFactory;
import lk.ijse.dinamore.business.custom.OrdersBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.OrdersRepositry;
import lk.ijse.dinamore.dto.ItemDTO;
import lk.ijse.dinamore.dto.OrdersDTO;
import lk.ijse.dinamore.dto.ReportDTO;
import lk.ijse.dinamore.resource.DBConnection;
import lk.ijse.dinamore.service.custom.OrdersService;

/**
 *
 * @author acer
 */
public class OrdersServiceImpl extends UnicastRemoteObject implements OrdersService{
    
    private OrdersRepositry ordersRepository;
    private OrdersBO bo;
    
     public OrdersServiceImpl()throws RemoteException{
        ordersRepository=(OrdersRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.ORDERS);
        bo=(OrdersBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ORDERS);
    }
    
    @Override
    public boolean saveOrder(OrdersDTO orderDTO, ArrayList<ItemDTO> itemList) throws Exception {
        return bo.saveOrder(orderDTO,itemList);
    }

    @Override
    public int lastId() throws Exception {
        Connection connection=DBConnection.getConnection();
        ordersRepository.setConnection(connection);
        return ordersRepository.lastId();
    }

    @Override
    public ArrayList<OrdersDTO> searchThisOrder(String id) throws Exception {
        return bo.searchThisOrder(id);
    }

    @Override
    public ArrayList<OrdersDTO> view() throws Exception {
        return bo.view();
    }

    @Override
    public OrdersDTO takeOrder() throws Exception {
        OrdersDTO dto=bo.takeOrder();
        return dto;
    }

    @Override
    public boolean addOrder(OrdersDTO orderDto) throws Exception {
        return bo.addOrder(orderDto);
    }

    @Override
    public boolean update(OrdersDTO dto) throws Exception {
        return bo.update(dto);
    }

    @Override
    public OrdersDTO find(String i) throws Exception {
        return bo.find(i);
    }

    @Override
    public OrdersDTO checkPendingOrder(String id) throws Exception {
        return bo.checkPendingOrder(id);
    }

    @Override
    public boolean saveReport(ReportDTO dto) throws Exception {
        return bo.saveReport(dto);
    }

    @Override
    public OrdersDTO todayReport(String a, String text) throws Exception {
        return bo.todayReport(a,text);
    }

    @Override
    public OrdersDTO OrderReport(String date, String id, String i) throws Exception {
        return bo.OrderReport(date,id,i);
    }

    @Override
    public ArrayList<OrdersDTO> getQueueData() throws Exception {
        return bo.getQueueData();
    }

    @Override
    public ArrayList<OrdersDTO> getProcessData() throws Exception {
        return bo.getProcessData();
    }
    
}
