package auto.service;


import auto.dao.AutoDAO;
import auto.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AutoServiceImpl implements AutoService {

    private AutoDAO autoDAO;

    @Autowired
    public void setAutoDAO(AutoDAO autoDAO) {
        this.autoDAO = autoDAO;
    }

    @Override
    @Transactional
    public List<Auto> allAutos(int page) {
        return autoDAO.allAutos(page);
    }

    @Override
    @Transactional
    public void add(Auto auto) {
        autoDAO.add(auto);
    }

    @Override
    @Transactional
    public void delete(Auto auto) {
        autoDAO.delete(auto);
    }

    @Override
    @Transactional
    public void edit(Auto auto) {
        autoDAO.edit(auto);
    }

    @Override
    @Transactional
    public Auto getById(int id) {
        return autoDAO.getById(id);
    }

    @Override
    @Transactional
    public int autosCount() {
        return autoDAO.autosCount();
    }

    @Override
    @Transactional
    public boolean checkVin(String vin) {
        return autoDAO.checkVin(vin);
    }
}