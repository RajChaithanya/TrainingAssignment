package com.training.customermanagmentsystem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.training.customermanagmentsystem.dto.CustomerDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerManagmentSystemApplicationTests {

	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockmvc;

	@Before
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addCustomerTest() throws Exception {
		System.out.println("post test: randomServerPort: " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/customersystem/insert";
		URI uri = new URI(baseUrl);
		CustomerDTO dto = new CustomerDTO("Roopika", "8765342618", "roopika@gmail.com", "Female", "Mangalore");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(dto);
		System.out.println("post requestJson: " + requestJson);
		mockmvc.perform(post(uri).contentType("application/json").accept("*/*").content(requestJson))
				.andExpect(status().isOk());
	}

	@Test
	public void getCustomerTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/customersystem/get";
		URI uri = new URI(baseUrl);
		mockmvc.perform(get(uri).contentType("application/json").accept("*/*")).andExpect(status().isOk());
	}

	@Test
	public void deleteCustomerTest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/customersystem/delete?id=6";
		URI uri = new URI(baseUrl);
		mockmvc.perform(delete(uri).contentType("application/json").accept("*/*")).andExpect(status().isOk());
	}

	@Test
	public void updateCustomerest() throws Exception {
		final String baseUrl = "http://localhost:" + randomServerPort + "/customersystem/update";
		URI uri = new URI(baseUrl);
		CustomerDTO dto = new CustomerDTO(2,"Rahul", "8765342618", "roopika@gmail.com", "Female", "Udupi");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(dto);
		mockmvc.perform(put(uri).contentType("application/json").accept("*/*").content(requestJson))
				.andExpect(status().isOk());
	}

	
}
