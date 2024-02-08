package auto.service;

import auto.dto.AutoDto;
import auto.exception.AutoNotFoundException;
import auto.mapper.AutoMapper;
import auto.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;
    private AutoMapper autoMapper;


    @Override
    public List<AutoDto> allCars() {
        return autoRepository.findAll().stream().map(autoMapper::toAutoDto).toList();
    }

    @Override
    public AutoDto getById(Long id) {
        return autoRepository.findById(id)
                .map(autoMapper::toAutoDto)
                .orElseThrow(AutoNotFoundException::new);
    }

    @Override
    public AutoDto save(AutoDto autoDto) {
        return autoMapper.toAutoDto(autoRepository.save(autoMapper.toAuto(autoDto)));
    }

    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }
}