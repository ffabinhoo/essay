package br.com.fabio.essay.essay;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface EssayRepository extends MongoRepository<Essay, String> {
	
	
}
