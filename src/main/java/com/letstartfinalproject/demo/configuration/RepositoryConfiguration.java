package com.letstartfinalproject.demo.configuration;

import com.letstartfinalproject.demo.model.Cart;
import com.letstartfinalproject.demo.model.Client;
import com.letstartfinalproject.demo.model.Furniture;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@EnableCaching
@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        config.exposeIdsFor(Cart.class);
        config.exposeIdsFor(Furniture.class);
        config.exposeIdsFor(Client.class);

    }
}
