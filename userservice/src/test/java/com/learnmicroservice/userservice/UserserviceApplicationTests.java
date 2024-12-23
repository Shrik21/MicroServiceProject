package com.learnmicroservice.userservice;

import com.learnmicroservice.userservice.entities.Ratings;
import com.learnmicroservice.userservice.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserserviceApplicationTests {

	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Ratings ratings = Ratings.builder().rating(10).userId("").hotelId("").feedback("This is created by feign client").build();
		Ratings saveRatings =ratingService.createRating(ratings);
		System.out.println("Rating created ### "+saveRatings.toString());
	}

}
