package lesson39.dao;

import lesson39.model.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
}
