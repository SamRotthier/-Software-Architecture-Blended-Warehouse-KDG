package be.kdg.sa.warehouse.controller;

import be.kdg.sa.warehouse.controller.dto.IngredientDto;
import be.kdg.sa.warehouse.domain.Enum.ExpZone;
import be.kdg.sa.warehouse.domain.Enum.FireZone;
import be.kdg.sa.warehouse.domain.Enum.TempZone;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.repositories.IngredientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final Logger logger = LoggerFactory.getLogger(IngredientControllerTest.class);

    private UUID ingredient_id;

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    @BeforeEach
    public void setUp(){
        ingredient_id = UUID.randomUUID();
        logger.info("Create ingredient");
        IngredientDto ingredientDto = new IngredientDto(ingredient_id, "test ingredient", 10 );

        ingredient = new Ingredient();
        ingredient.setIngredientId(ingredientDto.getingredientId());
        logger.info("ingredient.setIngredientId(ingredientDto.getingredientId()): {}", ingredient.getIngredientId());
        ingredient.setName(ingredientDto.getingredientName());
        logger.info("ingredient.setName(ingredientDto.getingredientName()): {}", ingredient.getName());
        ingredient.setQuantity(ingredientDto.getingredientQuantity());
        logger.info("ingredient.setQuantity(ingredientDto.getingredientQuantity()): {}", ingredient.getQuantity());
        ingredientRepository.saveAndFlush(ingredient);
        logger.info("Test data created: {}", ingredientRepository.findIngredientByIngredientId(ingredient_id));
    }

    @AfterEach
    public void tearDown(){
        ingredientRepository.deleteById(ingredient_id);
    }

    @Test
    void changeTemperatureZoneOfIngredient() throws Exception {
        mockMvc.perform(patch("/ingredients/{id}/tempzone", ingredient_id).accept(APPLICATION_JSON)
                        .param("tempzone", "BEVROREN"))
                .andExpect(status().isOk())
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON.toString()))
                .andDo(result -> logger.info(result.getResponse().getContentAsString()));

       Ingredient savedIngredientTempZone = ingredientRepository.getIngredientByIngredientId(ingredient_id);
        assertEquals(TempZone.BEVROREN, savedIngredientTempZone.getTemperatureZone());
    }

    @Test
    void changeExperationZoneOfIngredient() throws Exception {
        mockMvc.perform(patch("/ingredients/{id}/expzone", ingredient_id).accept(APPLICATION_JSON)
                        .param("expzone", "THT"))
                .andExpect(status().isOk())
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON.toString()))
                .andDo(result -> logger.info(result.getResponse().getContentAsString()));

        Ingredient savedIngredientExpZone = ingredientRepository.getIngredientByIngredientId(ingredient_id);
        assertEquals(ExpZone.THT, savedIngredientExpZone.getExperationZone());
    }

    @Test
    void changeFireZoneOfIngredient() throws Exception {
        mockMvc.perform(patch("/ingredients/{id}/firezone", ingredient_id).accept(APPLICATION_JSON)
                        .param("firezone", "WATER"))
                .andExpect(status().isOk())
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON.toString()))
                .andDo(result -> logger.info(result.getResponse().getContentAsString()));

        Ingredient savedIngredientFireZone = ingredientRepository.getIngredientByIngredientId(ingredient_id);
        assertEquals(FireZone.WATER, savedIngredientFireZone.getFireZone());
    }
}