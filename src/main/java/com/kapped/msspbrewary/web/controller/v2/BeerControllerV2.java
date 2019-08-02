package com.kapped.msspbrewary.web.controller.v2;

import com.kapped.msspbrewary.services.BeerService;
import com.kapped.msspbrewary.services.v2.BeerServiceV2;
import com.kapped.msspbrewary.web.model.BeerDTO;
import com.kapped.msspbrewary.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{beerId}")
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId),
                HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTOV2 beerDTOV2){

        BeerDTOV2 savedBeerDTO = beerServiceV2.saveNewBeerDTO(beerDTOV2);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v2/beer/" + savedBeerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public  ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTOV2 beerDTOV2) {

        beerServiceV2.updateBeerDTO(beerId, beerDTOV2);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerDTOById(beerId);
    }
}
