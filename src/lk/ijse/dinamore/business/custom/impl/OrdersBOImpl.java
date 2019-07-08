/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import lk.ijse.dinamore.business.custom.OrdersBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.OrderDetailRepositry;
import lk.ijse.dinamore.business.repository.custom.OrdersRepositry;
import lk.ijse.dinamore.dto.ItemDTO;
import lk.ijse.dinamore.dto.OrdersDTO;
import lk.ijse.dinamore.dto.ReportDTO;
import lk.ijse.dinamore.entity.OrderDetail;
import lk.ijse.dinamore.entity.Orders;
import lk.ijse.dinamore.entity.Report;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class OrdersBOImpl implements OrdersBO{
    
    private OrdersRepositry orderRepository;
    private OrderDetailRepositry odRepository;

    public static ArrayList<OrdersDTO> allOrderList = new ArrayList<>();
    public static ArrayList<OrdersDTO> processList = new ArrayList<>();
    public static Queue<OrdersDTO> orderQueue = new PriorityQueue<>();

    public OrdersBOImpl() {
        orderRepository = (OrdersRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.ORDERS);
        odRepository = (OrderDetailRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.OD);
    }
    
    @Override
    public boolean saveOrder(OrdersDTO ordersDTO, ArrayList<ItemDTO> itemList) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);
        odRepository.setConnection(connection);
        try {
            connection.setAutoCommit(false);

            Orders orders = new Orders(ordersDTO.getOid(), ordersDTO.getTid(), ordersDTO.getPrice(), ordersDTO.getCusId(), ordersDTO.getDateTime());
            ArrayList<OrderDetail> od = new ArrayList<>();

            if (orderRepository.save(orders)) {
                System.out.println("orders save");

                for (ItemDTO i : itemList) {

                    OrderDetail entity = new OrderDetail(ordersDTO.getOid(), i.getIid(), i.getQty());
                    odRepository.saveOrderDetail(entity);
                }
                System.out.println("od save");
                connection.commit();
                return true;
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
    public ArrayList<OrdersDTO> searchThisOrder(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        ArrayList<Orders> od = orderRepository.searchThisOrder(id);
        ArrayList<OrdersDTO> oDto = new ArrayList<>();
        for (Orders orders : od) {
            OrdersDTO dto = new OrdersDTO(orders.getOid(), orders.getTid(), orders.getPrice(), orders.getCusId(), orders.getDateTime());
            oDto.add(dto);
        }
        return oDto;
    }

    @Override
    public ArrayList<OrdersDTO> view() throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        List<Orders> od = orderRepository.view();

        ArrayList<OrdersDTO> oDto = new ArrayList<>();
        for (Orders orders : od) {
            OrdersDTO dto = new OrdersDTO(orders.getOid(), orders.getTid(), orders.getPrice(), orders.getCusId(), orders.getDateTime());
            oDto.add(dto);
        }
        return oDto;
    }

    @Override
    public OrdersDTO takeOrder() throws Exception {
        OrdersDTO dto = null;

        if (!orderQueue.isEmpty()) {
            dto = orderQueue.poll();
            processList.add(dto);

        }
        return dto;

    }

    @Override
    public boolean addOrder(OrdersDTO dto) throws Exception {
        System.out.println("add Order : " + dto);
        orderQueue.add(dto);
        return true;
    }

    @Override
    public boolean update(OrdersDTO dto) throws Exception {
        System.out.println("ok : ");

        System.out.println("ok : " + dto.getStatus());
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        Orders b = new Orders(dto.getOid(), dto.getPrice(), dto.getCusId(), dto.getTid(), dto.getStatus(), dto.getDateTime(), dto.getQty(), dto.getList());
        return orderRepository.update(b);
    }

    @Override
    public OrdersDTO find(String i) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        Orders dto = orderRepository.find(i);
        // System.out.println("ohh : "+dto.getPrice());
        if (dto != null) {
            return new OrdersDTO(dto.getOid(), dto.getPrice(), dto.getCusId(), dto.getTid(), dto.getStatus(), dto.getDateTime(), dto.getOid(), dto.getList());
        } else {
            return null;
        }
    }

    @Override
    public OrdersDTO checkPendingOrder(String oid) throws Exception {
        if (!orderQueue.isEmpty()) {
            for (OrdersDTO ordersDTO : orderQueue) {
                System.out.println("all pending : " + ordersDTO.getOid());
                String id = ordersDTO.getOid() + "";
                if (id.equalsIgnoreCase(oid)) {
                    System.out.println("this pending : " + ordersDTO.getOid());
                    return ordersDTO;

                }
            }

            return null;
        } else {
            return null;
        }

    }

    @Override
    public boolean saveReport(ReportDTO dto) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        Report r = new Report(dto.getCid(), dto.getCusId(), dto.getTid(), dto.getOid(), dto.getDate(), dto.getProcessTime(), dto.getQty());
        return orderRepository.saveReport(r);
    }

    @Override
    public OrdersDTO todayReport(String a, String text) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        Orders r = orderRepository.todayOrderReport(a, text);
        return new OrdersDTO(r.getOid(), r.getTid(), r.getPrice());
    }

    @Override
    public OrdersDTO OrderReport(String date, String id, String i) throws Exception {
        Connection connection = DBConnection.getConnection();
        orderRepository.setConnection(connection);

        Orders r = orderRepository.OrderReport(date, id, i);
        return new OrdersDTO(r.getOid(), r.getTid(), r.getPrice());
    }

    @Override
    public ArrayList<OrdersDTO> getQueueData() throws Exception {
         ArrayList<OrdersDTO> list = new ArrayList<>();
        for (OrdersDTO t : orderQueue) {
            //System.out.println("getQueueData : "+ t);
           // OrdersDTO dto = new OrdersDTO(t.getOid(), t.getPrice(), t.getCusId(), t.getTid(), t.getStatus(), t.getDateTime());
            list.add(t);
        }
        return list;
    }

    @Override
    public ArrayList<OrdersDTO> getProcessData() throws Exception {
        ArrayList<OrdersDTO> list = new ArrayList<>();
        for (OrdersDTO t : processList) {
            //System.out.println("getProcessData : "+ t);
           // OrdersDTO dto = new OrdersDTO(t.getOid(), t.getPrice(), t.getCusId(), t.getTid(), t.getStatus(), t.getDateTime());
            list.add(t);
        }
        return list;
    }
    
}
