package com.eg.ecommerce_v1.common.config;

import com.eg.ecommerce_v1.entity.Country;
import com.eg.ecommerce_v1.entity.Product;
import com.eg.ecommerce_v1.entity.ProductCategory;
import com.eg.ecommerce_v1.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnSupportedActions = {  HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE };

        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        disableHttpMethods(Product.class, config, theUnSupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnSupportedActions);
        disableHttpMethods(Country.class, config, theUnSupportedActions);
        disableHttpMethods(State.class, config, theUnSupportedActions);

        // call an internal helper method
        exposeIds(config);

    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity type
        List<Class> entityClasses = new ArrayList<>();

        // -get the entity type for the entities
        for (EntityType<?> entityType : entities) {
            entityClasses.add(entityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}
