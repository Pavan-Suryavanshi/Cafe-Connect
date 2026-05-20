package com.yash.cafe_connect.service.impl;

import com.yash.cafe_connect.entity.Thali;
import com.yash.cafe_connect.repository.ThaliRepository;
import com.yash.cafe_connect.service.ThaliService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThaliServiceImpl implements ThaliService {

    private final ThaliRepository thaliRepository;

    public ThaliServiceImpl(ThaliRepository thaliRepository) {

        this.thaliRepository = thaliRepository;
    }

    @Override
    public Thali createThali(Thali thali) {

        return thaliRepository.save(thali);
    }

    @Override
    public List<Thali> getAllThali() {

        return thaliRepository.findAll();
    }
}