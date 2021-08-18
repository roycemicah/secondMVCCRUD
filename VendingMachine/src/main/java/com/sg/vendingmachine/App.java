/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDaoPersistenceException;
import com.sg.vendingmachine.servicelayer.InsufficientFundsException;
import com.sg.vendingmachine.servicelayer.NoItemInventoryException;
import com.sg.vendingmachine.servicelayer.VendingMachineServiceLayer;
import com.sg.vendingmachine.servicelayer.VendingMachineServiceLayerFileImpl;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 * FINAL COPY
 * @author Royce Rabanal
 * GitHub: https://github.com/roycemicah
 * Email: royce.rabanal93@gmail.com
 * Date: August 18th, 2021
 * Purpose: Milestone 3 Assessment: Vending Machine Exercise
 */
public class App {
    
    public static void main(String[] args) throws VendingMachineDaoPersistenceException, 
            NoItemInventoryException, 
            InsufficientFundsException {
        
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao audit = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerFileImpl(dao, audit);
        
        UserIO io = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(io);
        
        VendingMachineController controller = new VendingMachineController(service, view);
        controller.run();

    }
    
}
