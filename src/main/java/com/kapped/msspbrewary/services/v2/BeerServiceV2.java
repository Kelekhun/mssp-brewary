package com.kapped.msspbrewary.services.v2;

import com.kapped.msspbrewary.web.model.BeerDTO;
import com.kapped.msspbrewary.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDTOV2 getBeerById(UUID beerId);

    BeerDTOV2 saveNewBeerDTO(BeerDTOV2 beerDTOV2);

    void updateBeerDTO(UUID beerId, BeerDTOV2 beerDTOV2);

    void deleteBeerDTOById(UUID beerId);
}
