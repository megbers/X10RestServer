package org.egbers.home.x10.service;

import org.egbers.home.x10.dao.X10MacroDAO;
import org.egbers.home.x10.domain.X10Macro;
import org.egbers.home.x10.macro.X10MacroExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MacroManagerService {
    @Autowired
    private X10MacroDAO x10MacroDAO;
    @Autowired
    private X10MacroExecutor macroExecutor;

    public X10Macro save(X10Macro macro) {
        return x10MacroDAO.save(macro);
    }

    public List<X10Macro> listAll() {
        return x10MacroDAO.getAll();
    }

    public Boolean delete(Long id) {
        try{
            X10Macro macro = new X10Macro();
            macro.setId(id);
            x10MacroDAO.delete(macro);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public void run(Long id) throws Exception {
        X10Macro macro = x10MacroDAO.find(id);
        macroExecutor.execute(macro);
    }
}
