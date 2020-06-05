package soccerlivefeeds.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soccerlivefeeds.collection.Matches;
import soccerlivefeeds.dto.MatchDto;
import soccerlivefeeds.service.MatchService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<MatchDto>> showAllPosts() {
		return new ResponseEntity<>(matchService.showAllPosts(), HttpStatus.OK);
	}
	
	/*
	@GetMapping("/all")
	public List<Matches> showAllPosts() {
		System.out.println("Hello");
		return matchService.showAllPosts();
	}
*/
}
