package br.com.fabio.essay.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class EssayRepositoryImpl 	implements EssayRepositoryCustom{
	@Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int updateEssay(String essay) {
		return 0;
    }
}
