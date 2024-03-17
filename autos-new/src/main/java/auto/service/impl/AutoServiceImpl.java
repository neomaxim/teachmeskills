package auto.service.impl;

import auto.dto.AutoDto;
import auto.exception.AutoNotFoundException;
import auto.mapper.AutoMapper;
import auto.model.Auto;
import auto.repository.AutoRepository;
import auto.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AutoDto> getAll() {
        return autoRepository.findAll().stream().map(autoMapper::toAutoDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutoDto> getAll(Pageable pageable) {

        Page<Auto> all = autoRepository.findAll(pageable);
        return autoMapper.toDtoList(all.getContent());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutoDto> findByVin(String vin) {
        return autoMapper.toDtoList(autoRepository.findByVin(vin));

    }

    @Override
    @Transactional(readOnly = true)
    public AutoDto getById(Long id) {
        return autoRepository.findById(id)
                .map(autoMapper::toAutoDto)
                .orElseThrow(AutoNotFoundException::new);
    }


    @Override
    @Transactional
    public AutoDto save(AutoDto autoDto) {
        Auto auto = autoMapper.toAuto(autoDto);
        autoRepository.save(auto);
        return autoMapper.toAutoDto(auto);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        autoRepository.deleteById(id);
    }
}