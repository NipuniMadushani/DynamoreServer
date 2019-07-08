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
import lk.ijse.dinamore.business.custom.ItemBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.ItemRepositry;
import lk.ijse.dinamore.dto.ItemDTO;
import lk.ijse.dinamore.entity.Item;
import lk.ijse.dinamore.resource.DBConnection;
import lk.ijse.dinamore.service.custom.ItemService;

/**
 *
 * @author acer
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{
    
    private ItemRepositry itemRepositry;
    private ItemBO itemBO;
    
    public ItemServiceImpl()throws RemoteException{
        itemRepositry=(ItemRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.ITEM);
        itemBO=(ItemBO) BOFactory.getInstance().getBOType(BOFactory.BOType.ITEM);
    }
    
    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemBO.saveItem(dto);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {
        Connection connection=DBConnection.getConnection();
        itemRepositry.setConnection(connection);
        ArrayList<Item> list=itemRepositry.getAllItem();
        ArrayList<ItemDTO> dtoList=new ArrayList<>();
        for (Item item : list) {
            ItemDTO dto=new ItemDTO(item.getIid(),item.getItemName(),item.getItemPrice());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public ItemDTO find(String name) throws Exception {
        return itemBO.find(name);
    }
    
}
