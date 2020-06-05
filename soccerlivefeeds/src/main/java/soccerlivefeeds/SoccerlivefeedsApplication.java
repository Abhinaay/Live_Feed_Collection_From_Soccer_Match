package soccerlivefeeds;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import soccerlivefeeds.collection.Matches;
import soccerlivefeeds.repository.MatchRepository;

@SpringBootApplication
public class SoccerlivefeedsApplication implements CommandLineRunner{

	@Autowired
	MatchRepository matchRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SoccerlivefeedsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		deleteAll();
		// addSampleData();
		
		String url="https://apiv2.apifootball.com/?action=get_events&from=2019-04-01&to=2019-04-03&league_id=148&APIkey=53d19ce2c5ce9e9ea24e647707cd3fcbe523b79d73022b861d0aadec85a59d30";
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
		
	}
/*
	private void addSampleData() {
		
		System.out.println("Adding Sample Data...");
		Matches match=new Matches();
		match.setId("0");
		match.setLeagueName("Personal League");
		match.setHomeTeamName("Team 1");
		match.setAwayTeamName("Team 2");
		match.setHomeTeamScore("3");
		match.setAwayTeamScore("2");
		match.setMatchDate("2020-04-2");
		match.setMatchTime("21:00");
		match.setMatchStatus("Finished");
		match.setHomeTeamBadge("homeTeamBadge.com");
		match.setAwayTeamBadge("awayTeamBadge.com");
		
		matchRepository.save(match);
		System.out.println("Completed...");
	}
*/
	private void deleteAll() {
		
		System.out.println("Deleting All...");
		matchRepository.deleteAll();
		
	}

}
