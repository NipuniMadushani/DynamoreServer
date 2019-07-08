/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.repository.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.repository.SuperRepository;
import lk.ijse.dinamore.entity.TelOparator;
import lk.ijse.dinamore.entity.TelOperatorLogin;

/**
 *
 * @author acer
 */
public interface TpOperatorRepositry extends SuperRepository<TelOparator, String> {

    public int lastId() throws Exception;

    public boolean saveLogin(TelOperatorLogin t) throws Exception;

    public TelOperatorLogin findLogin(String name) throws Exception;

    public ArrayList<TelOparator> telReport(String name) throws Exception;
}
