package hw41.service;

import hw41.dao.AutoDAO;
import hw41.dao.AutoDAOImpl;
import hw41.model.Auto;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Log4j
public class AutoServiceImpl implements AutoService {

    private AutoDAO autoDAO = new AutoDAOImpl();

    @Override
    public List<Auto> allAuto() {
        return autoDAO.allAuto();
    }

    @Override
    public void add(Auto auto) {
        {
            autoDAO.add(auto);
        }
    }

    @Override
    public void delete(Auto auto) {
        autoDAO.delete(auto);
    }

    @Override
    public void edit(Auto auto) {
//log.info(autoDAO.getById(auto.getId()));
        autoDAO.edit(auto);

    }

    @Override
    public Auto getById(int id) {
        return autoDAO.getById(id);
    }

    @Override
    public void registration(String vin, String brand, Integer year) {
    //    log.info("vin => %s, brand => %s, year => %d".formatted(vin, brand, year));
      //  if (vin.length() != 10) {
       //     throw new CustomException("not true VIN");
      //  }
    }
}
