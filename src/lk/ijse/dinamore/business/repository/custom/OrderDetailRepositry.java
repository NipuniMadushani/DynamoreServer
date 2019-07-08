/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom;

import java.util.List;
import lk.ijse.dinamore.business.repository.SuperRepository;
import lk.ijse.dinamore.entity.OrderDetail;

/**
 *
 * @author acer
 */
public interface OrderDetailRepositry extends SuperRepository<OrderDetail, String> {

    public boolean saveOrderDetail(OrderDetail od) throws Exception;

    public List<OrderDetail> searchOrder(String oid) throws Exception;
}
