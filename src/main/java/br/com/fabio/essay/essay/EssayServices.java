package br.com.fabio.essay.essay;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class EssayServices implements HealthIndicator {
   
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return null;
	}
}
