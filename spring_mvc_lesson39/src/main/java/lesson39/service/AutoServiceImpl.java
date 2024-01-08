package lesson39.service;

import lesson39.dao.AutoDAO;
import lesson39.dao.AutoDAOImpl;
import lesson39.exception.CustomException;
import lesson39.model.Auto;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
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

        autoDAO.edit(auto);
    }

    @Override
    public Auto getById(int id) {
        return autoDAO.getById(id);
    }

    @Override
    public void registration(String vin, String brand, Integer year) {
        log.info("vin => %s, brand => %s, year => %d".formatted(vin, brand, year));
        if (vin.length() != 10) {
            throw new CustomException("not true VIN");
        }
    }
}
