package com.example.queue.web;

import com.example.queue.domain.Order;
import com.example.queue.service.OrderCreatedService;
import com.example.queue.service.dto.OrderCreatedDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {


    private MockMvc mockMvc;

    @MockBean
    private OrderCreatedService orderCreatedService;

    @BeforeEach
    public void init() {

        mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(orderCreatedService))
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();

    }


    @Test
    public void create_ok() throws Exception {

        ObjectMapper om = new ObjectMapper();

        OrderCreatedDTO.Request dto = new OrderCreatedDTO.Request("test");

        OrderCreatedDTO.Response mock = new OrderCreatedDTO.Response(new Order(1L, dto.getName()));

        given(orderCreatedService.created(any()))
                .willReturn(mock);

        ResultActions action = mockMvc.perform(
                        MockMvcRequestBuilders.post("/order")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(om.writeValueAsString(dto))
                )
                .andDo(print());

        action.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mock.getId()))
                .andExpect(jsonPath("$.name").value(mock.getName()));
    }
}