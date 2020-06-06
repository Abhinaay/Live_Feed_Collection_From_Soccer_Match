package soccerlivefeeds.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import soccerlivefeeds.collection.Matches;
import soccerlivefeeds.dto.MatchDto;
import soccerlivefeeds.repository.MatchRepository;
import soccerlivefeeds.service.MatchService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@Autowired
	MatchRepository matchRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<MatchDto>> showAllPosts() {
		deleteAll();
		// addSampleData();
		
		String url="https://apiv2.apifootball.com/?action=get_events&from=2020-03-1&to=2020-03-17&league_id=148&APIkey=53d19ce2c5ce9e9ea24e647707cd3fcbe523b79d73022b861d0aadec85a59d30";
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(url, String.class);

		JsonParser springParser = JsonParserFactory.getJsonParser();

		List<Object> list = springParser.parseList(resp);

		for(Object o : list) {
			Matches match=new Matches();
			if(o instanceof Map) {
				Map<String,Object> map = (Map<String,Object>) o;
				System.out.println("Items found: " + map.size());

				int i = 0;
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("match_id"))
					{
						match.setId(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("league_name"))
					{
						match.setLeagueName(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_date"))
					{
						match.setMatchDate(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_status"))
					{
						match.setMatchStatus(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_time"))
					{
						match.setMatchTime(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_hometeam_name"))
					{
						match.setHomeTeamName(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_hometeam_score"))
					{
						match.setHomeTeamScore(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_awayteam_name"))
					{
						match.setAwayTeamName(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("match_awayteam_score"))
					{
						match.setAwayTeamScore(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("team_home_badge"))
					{
						match.setHomeTeamBadge(entry.getValue().toString());
					}
					if(entry.getKey().equalsIgnoreCase("team_away_badge"))
					{
						match.setAwayTeamBadge(entry.getValue().toString());
					}
					
					i++;
				}

			}
			matchRepository.save(match);
			System.out.println("Completed...");
		}
		

		
		return new ResponseEntity<>(matchService.showAllPosts(), HttpStatus.OK);
	}
	private void deleteAll() {
		
		System.out.println("Deleting All...");
		matchRepository.deleteAll();
		
	}
	
}
