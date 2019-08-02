package com.kapped.msspbrewary.web.controller;

import com.kapped.msspbrewary.services.BeerService;
import com.kapped.msspbrewary.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId),
                HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO){

        BeerDTO savedBeerDTO = beerService.saveNewBeerDTO(beerDTO);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/beer/" + savedBeerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public  ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {

        beerService.updateBeerDTO(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerDTOById(beerId);
    }
}
