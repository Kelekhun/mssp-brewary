package com.kapped.msspbrewary.services;

import com.kapped.msspbrewary.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO saveNewBeerDTO(BeerDTO beerDTO) {
        return BeerDTO
                .builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeerDTO(UUID beerId, BeerDTO beerDTO) {
        // todo impl - would add a real imple to update BeerDTO
    }

    @Override
    public void deleteBeerDTOById(UUID beerId) {
        log.debug("Deleting a BeerDTO...");
    }
}
