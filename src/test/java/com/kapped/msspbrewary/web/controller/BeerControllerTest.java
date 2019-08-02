package com.kapped.msspbrewary.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapped.msspbrewary.services.BeerService;
import com.kapped.msspbrewary.web.model.BeerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
@RunWith(SpringRunner.class)
public class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDTO validBeerDTO;

    @Before
    public void setUp(){
        validBeerDTO = BeerDTO
                .builder()
                .id(UUID.randomUUID())
                .beerName("Beer One")
                .beerStyle("PALE_ALE")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeerDTO);


        mockMvc.perform(get("/api/v1/beer/" + validBeerDTO.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validBeerDTO.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer One")))
                .andExpect(jsonPath("$.beerStyle", is("PALE_ALE")));

    }

    @Test
    public void handlePost() throws Exception {
        //given
        BeerDTO beerDTO = validBeerDTO;
        beerDTO.setId(null);
        BeerDTO savedBeerDTO = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.saveNewBeerDTO(any())).willReturn(savedBeerDTO);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        BeerDTO beerDTO = validBeerDTO;
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        //when
        mockMvc.perform(put("/api/v1/beer/" + validBeerDTO.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeerDTO(any(), any());

    }

}
