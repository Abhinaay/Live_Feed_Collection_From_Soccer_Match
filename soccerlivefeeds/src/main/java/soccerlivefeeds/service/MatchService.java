package soccerlivefeeds.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soccerlivefeeds.collection.Matches;
import soccerlivefeeds.dto.MatchDto;
import soccerlivefeeds.repository.MatchRepository;

@Service
public class MatchService {

	@Autowired
	MatchRepository matchRepository;
	
	
	public List<MatchDto> showAllPosts() {
		
		List<Matches> matches = matchRepository.findAll();
		
		Collections.reverse(matches);
		return matches.stream().map(this::mapFromMatchToDto).collect(Collectors.toList());
	}
	
	private MatchDto mapFromMatchToDto(Matches match)
	{
		MatchDto matchDto = new MatchDto();
		matchDto.setId(match.getId());
		matchDto.setLeagueName(match.getLeagueName());
		matchDto.setHomeTeamName(match.getHomeTeamName());
		matchDto.setAwayTeamName(match.getAwayTeamName());
		matchDto.setHomeTeamScore(match.getHomeTeamScore());
		matchDto.setAwayTeamScore(match.getAwayTeamScore());
		matchDto.setMatchDate(match.getMatchDate());
		matchDto.setMatchTime(match.getMatchTime());
		matchDto.setMatchStatus(match.getMatchStatus());
		matchDto.setHomeTeamBadge(match.getHomeTeamBadge());
		matchDto.setAwayTeamBadge(match.getAwayTeamBadge());
		return matchDto;
	}
	/*
public List<Matches> showAllPosts() {
		
		List<Matches> matches = matchRepository.findAll();
		
		
		return matches;
	}*/
}
