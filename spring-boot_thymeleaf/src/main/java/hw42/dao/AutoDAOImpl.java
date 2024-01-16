package hw42.dao;


import hw42.model.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository
public class AutoDAOImpl implements AutoDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Auto> stockAuto = new HashMap<>();

    static {
        Auto auto1 = new Auto();
        auto1.setId(AUTO_ID.getAndIncrement());
        auto1.setVin("123");
        auto1.setYear(2023);
        auto1.setBrand("BMW");
        stockAuto.put(auto1.getId(), auto1);

        Auto auto2 = new Auto();
        auto2.setId(AUTO_ID.getAndIncrement());
        auto2.setVin("456");
        auto2.setYear(2024);
        auto2.setBrand("Mercedes");
        stockAuto.put(auto2.getId(), auto2);

        Auto auto3 = new Auto();
        auto3.setId(AUTO_ID.getAndIncrement());
        auto3.setVin("789");
        auto3.setYear(2022);
        auto3.setBrand("Nissan");
        stockAuto.put(auto3.getId(), auto3);
    }

    @Override
    public List<Auto> allAuto() {
        return new ArrayList<>(stockAuto.values());
    }

    @Override
    public void add(Auto auto) {
        auto.setId(AUTO_ID.getAndIncrement());
        stockAuto.put(auto.getId(), auto);
    }

    @Override
    public void delete(Auto auto) {
        stockAuto.remove(auto.getId());
    }

    @Override
    public void edit(Auto auto) {
        stockAuto.put(auto.getId(), auto);
    }

    @Override
    public Auto getById(int id) {
        return stockAuto.get(id);
    }

    @Override
    public void registration(String vin, String brand, Integer year) {

    }


}
