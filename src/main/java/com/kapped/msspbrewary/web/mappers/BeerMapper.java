package com.kapped.msspbrewary.web.mappers;

import com.kapped.msspbrewary.domain.Beer;
import com.kapped.msspbrewary.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTO BeerToBeerDTO(Beer beer);

    Beer BeerDTOToBeer(BeerDTO dto);


}
