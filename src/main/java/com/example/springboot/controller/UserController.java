package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.User;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.UserRepository;
import java.util.List;

@RestController  //Annotation utilisée pour créer les API REST
@RequestMapping("/api/users")  //Créer l'URL 
public class UserController {

	@Autowired  //Annotation pour l'injection de dépendance du Repository créé
	private UserRepository userRepository;  //Créer une instance du Repository et l'utiliser pour accéder aux methodes CRUD
	
	//Get All Users
	
	@GetMapping  //Annotation pour la méthode Get
	public List<User> getAllUsers() {
	
		return this.userRepository.findAll();  //Methode pour afficher tous les Users
		
	}
	
	
	//Get User By Id
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with userId: "+ userId));				
	//Find l'User avec l'Id = UserId, sinon throw a new error avec le message ci-dessus
	}
	
	
	//Create a New User
	@PostMapping
	public User createUser( @RequestBody User user) {  //The json will map directly to the user annotation
		
		return this.userRepository.save(user);
	}
	
	//Update User
	
	@PutMapping("/{id}")
	public User updateuser(@RequestBody User user, @PathVariable("id") long userId) {
		
		//Retrieving existing object d'abord
		
		User existingUser=this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with the id: "+ userId));
		
		//Changer les anciennes données
		
		existingUser.setFirstName(user.getFirstName());   //On accède l'ancien nom du existingUser et on le change pour faire un nouvel objet user
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		return this.userRepository.save(existingUser); //On enregistre l'existingUser en intégrant des infos modifiées
		
	}
	
	
	
	//Deleting user
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId){
		
		User existingUser = this.userRepository.findById(userId)
							.orElseThrow(()-> new ResourceNotFoundException("User not found with the id:"+ userId));
		
		this.userRepository.delete(existingUser);
		
		return ResponseEntity.ok().build();   //Return a http response (l'objet est supprimé)
				
	
	}
}


