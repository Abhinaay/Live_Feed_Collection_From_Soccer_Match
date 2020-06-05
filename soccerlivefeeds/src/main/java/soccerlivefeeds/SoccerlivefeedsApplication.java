package soccerlivefeeds;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import soccerlivefeeds.repository.MatchRepository;

@SpringBootApplication
public class SoccerlivefeedsApplication {

	@Autowired
	MatchRepository matchRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SoccerlivefeedsApplication.class, args);
	}


}
