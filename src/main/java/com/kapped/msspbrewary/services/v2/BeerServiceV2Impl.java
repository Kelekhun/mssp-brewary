package com.kapped.msspbrewary.services.v2;

import com.kapped.msspbrewary.services.v2.BeerServiceV2;
import com.kapped.msspbrewary.web.model.BeerDTO;
import com.kapped.msspbrewary.web.model.v2.BeerDTOV2;
import com.kapped.msspbrewary.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName("Cosmos Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeerDTO(BeerDTOV2 beerDTOV2) {
        return BeerDTOV2
                .builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeerDTO(UUID beerId, BeerDTOV2 beerDTOV2) {
        // todo impl - would add a real imple to update BeerDTO
    }

    @Override
    public void deleteBeerDTOById(UUID beerId) {
        log.debug("Deleting a BeerDTO...");
    }
}
