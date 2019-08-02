package com.kapped.msspbrewary.services;

import com.kapped.msspbrewary.web.model.BeerDTO;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeerDTO(BeerDTO beerDTO);

    void updateBeerDTO(UUID beerId, BeerDTO beerDTO);

    void deleteBeerDTOById(UUID beerId);
}
