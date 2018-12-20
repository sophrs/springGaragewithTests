package repo;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.soph.springGarage1App.SpringGarage1Application;
import com.qa.soph.springGarage1App.model.MySpringGarage1Model;
import com.qa.soph.springGarage1App.repository.vehicleRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SpringGarage1Application.class})
@ContextConfiguration(classes = {SpringGarage1Application.class})
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private vehicleRepository MyRepo;
	
	
	@Test
	public void retrieveByIdTest() {
		MySpringGarage1Model model1 = new MySpringGarage1Model("car", 2005, "red");
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(MyRepo.findById(model1.getId()).isPresent());
		
	}

	@Test
	public void retrieveByVehicleType() {
		MySpringGarage1Model model1 = new MySpringGarage1Model("van", 2013, "blue");
		entityManager.persist(model1);
		entityManager.flush();
		assertFalse(MyRepo.findByVehicleType("van").isEmpty());
	}
	
	@Test
	public void retrieveByColour() {
		MySpringGarage1Model model1 = new MySpringGarage1Model("lorry", 2003, "silver");
		entityManager.persist(model1);
		entityManager.flush();
		assertFalse(MyRepo.findByColour("silver").isEmpty());
	}
//	
//	@Test
//	public void retrieveByYearOfManufacture() {
//		MySpringGarage1Model model1 = new MySpringGarage1Model("lorry", 2003, "silver");
//		entityManager.persist(model1);
//		entityManager.flush();
//		assertFalse(MyRepo.findByYearOfManufacture(2003).isEmpty());
//	
//	}
	
}
