package com.example.movie_api;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.example.movie_api.model.Genre;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MovieApiApplicationTests {
	@Autowired
	private TestRestTemplate testRestTemplate;
	private String  base ="http//localhost:8080";

	@Test
	void createGenre() {
		//localhost:8080/genres
		Genre genre = new Genre("horror");
		URI new_genre_loaction = testRestTemplate.postForLocation(base+"/genres", genre, Void.class);
		assertNotNull(new_genre_loaction);
		ResponseEntity<Genre> response =  testRestTemplate.getForEntity(new_genre_loaction, Genre.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getMovies()).isEqualTo("Horror");
	}


}
