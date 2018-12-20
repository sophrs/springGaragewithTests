package integration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.soph.springGarage1App.SpringGarage1Application;
import com.qa.soph.springGarage1App.model.MySpringGarage1Model;
import com.qa.soph.springGarage1App.repository.vehicleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringGarage1Application.class })
@AutoConfigureMockMvc
public class IntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private vehicleRepository repository;

	@Before
	public void clearDB() {
		repository.deleteAll();
	}

	@Test
	public void findingAndRetrievingVehicleFromDatabaseTest() throws Exception {
		repository.save(new MySpringGarage1Model("car", 2005, "red"));
		mvc.perform(get("/api/vehicle").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].vehicleType", is("car")));

	}

	@Test
	public void addVehicleToDatabaseTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.post("/api/vehicle").contentType(MediaType.APPLICATION_JSON)
				.content("{\"vehicleType\" : \"van\",\"yearofManufacture\" : 2005, \"colour\" : \"red\"}"))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.vehicleType", is("van")));

	}

	@Test
	public void deleteVehicleFromDatabase() throws Exception {
		MySpringGarage1Model car = new MySpringGarage1Model("car", 2005, "red");
		repository.save(car);
		mvc.perform(delete("/api/vehicle/"+ car.getId())).andExpect(status().isOk());
		
	
	}

	 
	@Test
	public void updateVehicleOnDatabaseTest() throws Exception{
		MySpringGarage1Model test = new MySpringGarage1Model("car",2005, "red");
		repository.save(test);
		mvc.perform(put("/api/vehicle/"+test.getId()).contentType(MediaType.APPLICATION_JSON)
				.content("{\"vehicleType\" : \"van\",\"yearofManufacture\" : 2005, \"colour\" : \"red\"}"))
		.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.vehicleType", is("van")));
				
	}
}
