package com.Kaveendra.projects.AuthorizationServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	private String clientId = "kaveendra";
	private String clientSecret = "my-secret";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAoOxPOETx3JMiYGt4+ySIpB/7yP3womYe61DJrX+HEe60mjaS\r\n"
			+ "ylCGGNWFZ967VZEja8Hfkn429E6N3WTZ0eRM53eFZ9lpup3pYiRs362st9bsQLS8\r\n"
			+ "hu1QMdYZwRHaduXTvDuFwrykaUGESB65wcYdAZ9DG6WTuQ7TVWIn7v02jkfjEHo/\r\n"
			+ "89lBdo2hioD0l/8I/R3jnWBkqoBoTi6iUCGtobSjavRER8ySGQavqomM/OSZi68T\r\n"
			+ "KPXhRJSSvMehcsJu/OYbw2QHuJjfFtj31hL1OjRdbqJyTz7G/X8wqzHxL9xDZFy4\r\n"
			+ "tBfY5UZXOh06Z6qkIZPNS5QjOF+kMlbBWiqg8wIDAQABAoIBACZfEqi9L9rDrr/F\r\n"
			+ "AK0J0hcolTYg7x8aMKc1tVFMhl2NSL045Bmfx8nmKBBTeOH3YLXSHchllh79GDDB\r\n"
			+ "WnsE8B2FT2cq3V4lR0AipV9Un0ma0uy+6/FUZvnrLmruIeSV+r34h3We26lJeQxl\r\n"
			+ "Xy/IWKRJYIwYGDhZQ6UpaZJACKE2PCuv5xygho8zRrLVFNc1MgqLtP6l3S4msaLJ\r\n"
			+ "XEahZc11cWAJKPB40oY+SEvyT0GUDxTPWClVk5YJy4ZbQIRDqnkxkhGQzBVUg7cx\r\n"
			+ "s6ZSM717QaEQkBU8eVD+ihN1GFSnYyiynR0QPE+jbNtqNbiKOMF2JYRtXJ2429Ku\r\n"
			+ "XSc2UVECgYEAzrWUaO5rOMcYt+I25MmYHrqlpUSkAZmKk8Y+r/Qz4RTbpQs+0Yug\r\n"
			+ "dAg7DzzpYVXKxC/5qVhlLvPneFX7fue04110M8I013cF2VBIMsjjYGnOZD/a4bJr\r\n"
			+ "QLiwmbuXVDuhB1WBwaN1K8qCiYZyalKvErAAo+hKP69HXvLa21ok6usCgYEAx0u+\r\n"
			+ "TBxBeNtUgs9dHodiyGLYLvl+asP3pu6rE3/1QxeMl1cZeftcehTpEo6kQz6YeJsm\r\n"
			+ "FqpZvI9lcICaQQ3gNGAHpiF5qpgX/mRl92SJXphbHEBJ5Zru5+4VZBpboM7R2lat\r\n"
			+ "ZMvXlWbpihBF5eghRkGDDwDq0uxDWJHdke9jEBkCgYEApIORpV2zilGy046/v6DO\r\n"
			+ "aA6GjR0vJnLL/sZ119YUgBv4n8dubJmizxZJ4tvIpoYARdok6mmGxjKqU3SjH6JL\r\n"
			+ "rfUP6a20HpQE3KrvezO0+2PaNqE3lA9LGwyiyQeq7ggzJcIg7jsoovyendOaNhKu\r\n"
			+ "ccIQEGNszHi05dWE57U70pcCgYBpygcFl6oZYTOHDFO9tNf2zqE6ri0wtz1qWx5s\r\n"
			+ "h2vFZWa3nwBjA86e7yKZOyZum3eL7a9WMK7ZrLSH93vqNFdi9eaZhQN0Tq/N1bVa\r\n"
			+ "kP9qOy2B3Y5cVtWiP3sTW/pvbdlvMLtx2dJh9/LX2rN/yqx/Ap9zA2Wi+M724Nbg\r\n"
			+ "dFX9YQKBgBMDDe76/FCgIgx6YZ7V9WQxHGTUU7wLhtpZt6UINhr/Zl3cjlOd51vG\r\n"
			+ "DCr57oEE1CMbj+qV2kYvxWw6usVS0d8AZ7ZRx+lmJj2ZBgxcUqIbm2sUs834G8qL\r\n"
			+ "4BefHzdMLZSm8wna9igcR+t5Ya9h44F8n1Ivd08OH6Y87gK/1NtJ\r\n" + "-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoOxPOETx3JMiYGt4+ySI\r\n"
			+ "pB/7yP3womYe61DJrX+HEe60mjaSylCGGNWFZ967VZEja8Hfkn429E6N3WTZ0eRM\r\n"
			+ "53eFZ9lpup3pYiRs362st9bsQLS8hu1QMdYZwRHaduXTvDuFwrykaUGESB65wcYd\r\n"
			+ "AZ9DG6WTuQ7TVWIn7v02jkfjEHo/89lBdo2hioD0l/8I/R3jnWBkqoBoTi6iUCGt\r\n"
			+ "obSjavRER8ySGQavqomM/OSZi68TKPXhRJSSvMehcsJu/OYbw2QHuJjfFtj31hL1\r\n"
			+ "OjRdbqJyTz7G/X8wqzHxL9xDZFy4tBfY5UZXOh06Z6qkIZPNS5QjOF+kMlbBWiqg\r\n" + "8wIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient(clientId).secret(clientSecret).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
				.refreshTokenValiditySeconds(20000);

	}

}
