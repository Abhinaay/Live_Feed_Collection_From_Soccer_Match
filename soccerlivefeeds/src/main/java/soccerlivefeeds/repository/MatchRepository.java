package soccerlivefeeds.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import soccerlivefeeds.collection.Matches;

public interface MatchRepository extends MongoRepository<Matches, String>{

}
