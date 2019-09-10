package br.com.estima.restaurante.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.estima.restaurante.model.Prato;
import br.com.estima.restaurante.model.Restaurante;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Restaurante.class);
		config.exposeIdsFor(Prato.class);
	}

}
