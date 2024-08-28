package org.ordereasy.services.implementations;


import org.ordereasy.models.OrdrDetail;
import org.ordereasy.repository.IOrdrDetailRepository;
import org.ordereasy.services.interfaces.IOrdrDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdrDetailService implements IOrdrDetailService {

    @Autowired
    private IOrdrDetailRepository ordrDetailRepository;

    @Override
    public Page<OrdrDetail> findAll(Pageable pageable) {
        return ordrDetailRepository.findAll(pageable);
    }

    @Override
    public List<OrdrDetail> getAll() {
        return ordrDetailRepository.findAll();
    }

    @Override
    public Optional<OrdrDetail> findOneById(Integer orderdetailid) {
        return ordrDetailRepository.findById(orderdetailid);
    }

    @Override
    public OrdrDetail createOrEditOne(OrdrDetail ordrdetail) {
        return ordrDetailRepository.save(ordrdetail);
    }

    @Override
    public void deleteOneById(Integer ordrdetailid) {
        ordrDetailRepository.deleteById(ordrdetailid);
    }
}
