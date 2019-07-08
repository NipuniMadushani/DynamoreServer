/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.repository.SuperRepository;
import lk.ijse.dinamore.entity.Item;

/**
 *
 * @author acer
 */
public interface ItemRepositry extends SuperRepository<Item, String> {

    public ArrayList<Item> getAllItem() throws Exception;
}
