package auto.service;

import auto.dao.AutoDAO;
import auto.model.Auto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoDAO autoDAO;
    private final RestTemplate restTemplate;

    @Override
    public List<Auto> allCars() {
        return autoDAO.getAllAuto();
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
    public Auto getById(int id) {
        return autoDAO.getById(id);
    }

    @Override
    @Transactional
    public void edit(Auto auto) {
        autoDAO.edit(auto);
    }

    @Override
    @Transactional
    public boolean checkVin(String vin) {
        return autoDAO.checkVin(vin);
    }

    @Override
    @SneakyThrows
    public List<Auto> allCarsHttp() {
        return restTemplate.getForObject(new URI("http://localhost:8080/api/auto"), List.class);
    }
}