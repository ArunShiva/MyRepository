package com.tcs.webapp.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tcs.webapp.model.UserDetails;
import com.tcs.webapp.service.impl.RetriveUserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @WebAppConfiguration
 * 
 * @ContextConfiguration
 * 
 * @ComponentScan(basePackages = {"com"})
 */
public class WebAppControllerTest {

	private MockMvc mockMvc;

	@Mock
	private RetriveUserDetails retriveUserDetails;

	@InjectMocks
	private WebAppController controller;

	List<UserDetails> userList = new ArrayList<UserDetails>();

	@Before
	public void testsetUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

		UserDetails user1 = new UserDetails("1", "Arun", "Chennai", "arun@gmail.com");
		UserDetails user2 = new UserDetails("2", "Ajith", "Chennai", "arun@gmail.com");
		UserDetails user3 = new UserDetails("3", "Arjith", "Chennai", "arun@gmail.com");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}

	@Test
	public void testSimpleJson() throws Exception {
		mockMvc.perform(get("/services/json").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testGetUserList() throws Exception {

		when(retriveUserDetails.retriveUserDetails()).thenReturn(userList);

		mockMvc.perform(get("/services/getUserList").contentType(MediaType.APPLICATION_JSON).accept("application/json"))
				.andExpect(status().is(200)).andExpect(jsonPath("$.status", Matchers.is("Success")));

	}

	@Test
	public void testSomething() {
		assertTrue(true);
	}

}
