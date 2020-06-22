package com.letstartfinalproject.demo.tests;

import com.letstartfinalproject.demo.model.Cart;
import com.letstartfinalproject.demo.repository.CartRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringJUnitWebConfig(locations = "test-servlet-context2.xml")
public class CartControllerTest {

    MockMvc mockMvc;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CartRepository cartRepository;


    @Before
    public void setUp() throws Exception
    {
        List<Cart> cart = Arrays.asList(
                new Cart(1,"20","Eur"),
                new Cart(2,"20","Eur"),
                new Cart(3,"20","Eur")
        );
        cartRepository.saveAll(cart);
    }
    @After
    public void tearDown() throws Exception{
        cartRepository.deleteAll();
    }

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
   public void getAccount() throws Exception {
        this.mockMvc.perform(get("/cart/1") ///1
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.amount").value("20"));
    }



  /*  @Test
    public void testFindAll()
    {
        List<Cart> all = cartRepository.findAll();

        assertEquals(3, all.size());

    }*/

}
