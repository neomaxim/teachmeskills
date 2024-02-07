package auto.service;





import auto.dao.AutoDAO;
import auto.dto.AutoDto;
import auto.mapper.AutoMapper;
import auto.model.Auto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
   // private final AutoMapper autoMapper;
    private  final AutoDAO autoDAO;



    /*public CarDto save(CarDto carDto) {
        return carMapper.toDTO(carDao.saveCar(carMapper.toModel(carDto)));
    }*/



    @Override
    @Transactional
    public Auto getById(int id) {
        return autoDAO.getById(id);
    }
     @Override
    @Transactional
    public void add(Auto auto) {
        autoDAO.add(auto);
    }

    @Override
    public List<Auto> allCars() {
        return autoDAO.getAllAuto();
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
}