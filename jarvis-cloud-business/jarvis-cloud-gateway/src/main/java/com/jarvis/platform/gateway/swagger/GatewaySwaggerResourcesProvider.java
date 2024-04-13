package com.jarvis.platform.gateway.swagger;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-13 16:07:56
 */
@Component
@Primary
public class GatewaySwaggerResourcesProvider implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    public GatewaySwaggerResourcesProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     *
     * @see java.util.function.Supplier#get()
     */
    @Override
    public List<SwaggerResource> get() {
        final List<SwaggerResource> resources = new ArrayList<>();
        final Set<String> duplications = new HashSet<>();
        routeLocator.getRoutes().filter(route -> {
            final String path = route.getUri().getHost();
            final boolean pass = path.contains("GATEWAY");
            return !pass;
        }).subscribe(route -> {
            final String location = String.format("/%s/v3/api-docs", route.getUri().getHost().toLowerCase());
            if (!duplications.contains(location)) {
                resources.add(swaggerResource(route.getId().split("_")[1], location));
                duplications.add(location);
            }
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        final SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

}
