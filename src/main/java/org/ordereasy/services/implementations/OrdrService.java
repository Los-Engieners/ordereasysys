package org.ordereasy.services.implementations;

import org.ordereasy.models.Ordr;
import org.ordereasy.repository.IOrdrRepository;
import org.ordereasy.services.interfaces.IOrdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdrService implements IOrdrService {
    @Autowired
    private IOrdrRepository ordrRepository;

    @Override
    public Page<Ordr> findAll(Pageable pageable) {
        return ordrRepository.findAll(pageable);
    }

    @Override
    public List<Ordr> getAll() {
        return ordrRepository.findAll();
    }

    @Override
    public Optional<Ordr> findOneById(Integer ordrid) {
        return ordrRepository.findById(ordrid);
    }

    @Override
    public Ordr createOrEditOne(Ordr ordr) {
        return ordrRepository.save(ordr);
    }

    @Override
    public void deleteOneById(Integer ordrid) {
        ordrRepository.deleteById(ordrid);
    }
}
