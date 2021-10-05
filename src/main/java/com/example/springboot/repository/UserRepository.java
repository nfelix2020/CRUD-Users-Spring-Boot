package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.User;


//Un repository provides CRUD methods après injection de dépendance dans le controlleur. 
//Il est utilisé comme les services en Angular 

@Repository   //Annotation pour rendre cette interface un Repository
public interface UserRepository extends JpaRepository<User,Long> {  //entre <ClassType, ID type>

	
	
}
