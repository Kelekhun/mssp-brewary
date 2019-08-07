package com.kapped.msspbrewary.web.controller.v2;

import com.kapped.msspbrewary.services.BeerService;
import com.kapped.msspbrewary.services.v2.BeerServiceV2;
import com.kapped.msspbrewary.web.model.BeerDTO;
import com.kapped.msspbrewary.web.model.v2.BeerDTOV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    @RequestMapping(method = RequestMethod.GET, path = "/{beerId}")
    public ResponseEntity<BeerDTOV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDTOV2 beerDTOV2){

        log.debug("in handle post...");
        val savedBeerDTO = beerServiceV2.saveNewBeerDTO(beerDTOV2);

        val headers = new HttpHeaders();

        headers.add("Location", "/api/v2/beer/" + savedBeerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public  ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTOV2 beerDTOV2) {

        beerServiceV2.updateBeerDTO(beerId, beerDTOV2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerDTOById(beerId);
    }
}
