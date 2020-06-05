package soccerlivefeeds.dto;

public class MatchDto {

	private String id;
	private String leagueName;
	private String homeTeamName;
	private String awayTeamName;
	private String homeTeamScore;
	private String awayTeamScore;
	private String matchDate;
	private String matchTime;
	private String matchStatus;
	private String homeTeamBadge;
	private String awayTeamBadge;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getHomeTeamName() {
		return homeTeamName;
	}
	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}
	public String getAwayTeamName() {
		return awayTeamName;
	}
	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}
	public String getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public String getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public String getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	public String getHomeTeamBadge() {
		return homeTeamBadge;
	}
	public void setHomeTeamBadge(String homeTeamBadge) {
		this.homeTeamBadge = homeTeamBadge;
	}
	public String getAwayTeamBadge() {
		return awayTeamBadge;
	}
	public void setAwayTeamBadge(String awayTeamBadge) {
		this.awayTeamBadge = awayTeamBadge;
	}
}
