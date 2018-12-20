package com.qa.soph.springGarage1App.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.soph.springGarage1App.model.MySpringGarage1Model;

public interface vehicleRepository extends JpaRepository<MySpringGarage1Model,Long>{




	
 List<MySpringGarage1Model> findByVehicleType(String vehicleType);

List<MySpringGarage1Model> findByColour(String colour);

//List<MySpringGarage1Model> findByYearOfManufacture(Integer yearofManufacture);

 
}
	
	
	
	
	



