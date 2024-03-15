package com.example.demo.service;

import com.example.demo.dto.response.KitchenResponse;
import com.example.demo.entity.Kitchen;
import com.example.demo.mapper.KitchenMapperImpl;
import com.example.demo.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class KitchenServiceImpl implements KitchenService {

    private final KitchenRepository kitchenRepository;
    private final KitchenMapperImpl dtoMapperKitchen;


    @Override
    public KitchenResponse saveKitchen(Kitchen kitchen) {
        Kitchen savedKitchen = kitchenRepository.save(kitchen);
        return dtoMapperKitchen.fromKitchen(savedKitchen);
    }

    @Override
    public List<KitchenResponse> getKitchens() {
        return kitchenRepository.findAll().stream().map(dtoMapperKitchen::fromKitchen).collect(Collectors.toList());
    }

    @Override
    public KitchenResponse getKitchenById(Long kitchenId) {
        Kitchen kitchen = kitchenRepository.findById(kitchenId).orElseThrow(null);
        return dtoMapperKitchen.fromKitchen(kitchen);
    }


}
