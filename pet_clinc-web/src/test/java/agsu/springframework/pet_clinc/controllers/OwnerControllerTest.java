package agsu.springframework.pet_clinc.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.beans.HasProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;
    MockMvc mockMVC;

    @BeforeEach
    void setUp(){
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testFindOwners() throws Exception{
        mockMVC.perform(get("/owners/find")).andExpect(status().isOk())
            .andExpect(view().name("notimplemented"));
    }

    @Test
    void testListOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMVC.perform(get("/owners")).andExpect(status().isOk())
            .andExpect(view().name("owners/owners"))
            .andExpect(model().attribute("owners", hasSize(2) ));

    }

    @Test
    void showOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMVC.perform(get("/owners/123")).andExpect(status().isOk())
            .andExpect(view().name("owners/ownerDetails"))
            .andExpect(model().attribute("owner",  hasProperty("id", is(1L) )));

    }
}
