/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinamore.dto.TelOperatorDTO;

/**
 *
 * @author acer
 */
public interface TelBO extends SuperBO {

    public ArrayList<TelOperatorDTO> telReport(String name) throws Exception;

    public ArrayList<TelOperatorDTO> view() throws Exception;
}
