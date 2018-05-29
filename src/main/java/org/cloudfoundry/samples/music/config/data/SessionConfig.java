package org.cloudfoundry.samples.music.config.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

//@Profile("session")
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
	
	@Value("${spring.redis.host}")
	String host;
	
	@Value("${spring.redis.port}")
	int port;
	
	 @Bean
     public LettuceConnectionFactory connectionFactory() {
             LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
             connectionFactory.setHostName(host);
             connectionFactory.setPort(port);
             return connectionFactory;
     }
}
