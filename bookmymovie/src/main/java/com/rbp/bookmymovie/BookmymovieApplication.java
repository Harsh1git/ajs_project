package com.rbp.bookmymovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.rbp.bookmymovie.models.ERole;
import com.rbp.bookmymovie.models.Movie;
import com.rbp.bookmymovie.models.Role;
import com.rbp.bookmymovie.repository.MovieRepository;
import com.rbp.bookmymovie.repository.RoleRepository;

import java.util.List;

@SpringBootApplication
public class BookmymovieApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MongoTemplate mongoTemplate;


	public static void main(String[] args) {
		SpringApplication.run(BookmymovieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mongoTemplate.dropCollection("roles");
		mongoTemplate.dropCollection("ticket");
		mongoTemplate.dropCollection("users");
		mongoTemplate.dropCollection("movie");

		Movie movie1 = new Movie("KGF","Geetanjali",200,200,"AVAILABLE");
	 	Movie movie2 = new Movie("RRR","Ashoka",150,150,"AVAILABLE");
	 	Movie movie3 = new Movie("Kantara","Pushpanjali",100,100,"AVAILABLE");
	 	Movie movie4 = new Movie("Bahubali","MovieTimes",20,20,"AVAILABLE");
	 	Movie movie5 = new Movie("Bahubali","Inox",10,10,"AVAILABLE");

	 	movieRepository.saveAll(List.of(movie1, movie2, movie3, movie4, movie5));

		Role admin = new Role(ERole.ROLE_ADMIN);
		Role user = new Role(ERole.ROLE_USER);

		roleRepository.saveAll(List.of(admin,user));
	}
}
