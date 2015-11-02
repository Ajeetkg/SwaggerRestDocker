package com.illumina.controller;


import com.mangofactory.swagger.configuration.JacksonScalaSupport;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.configuration.SpringSwaggerModelConfig;
import com.mangofactory.swagger.configuration.SwaggerGlobalSettings;
import com.mangofactory.swagger.core.SwaggerApiResourceListing;
import com.mangofactory.swagger.scanners.ApiListingReferenceScanner;
import com.wordnik.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.mangofactory.swagger")
public class SwaggerConfig {

    public static final List<String> DEFAULT_INCLUDE_PATTERNS = Arrays.asList("/ont/.*");
    public static final String SWAGGER_GROUP = "ontology-api";

    @Value("${app.docs}")
    private String docsLocation;

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;
    @Autowired
    private SpringSwaggerModelConfig springSwaggerModelConfig;

    @Bean
    public JacksonScalaSupport jacksonScalaSupport() {
        JacksonScalaSupport jacksonScalaSupport = new JacksonScalaSupport();
        jacksonScalaSupport.setRegisterScalaModule(true);
        return jacksonScalaSupport;
    }

    @Bean
    public SwaggerGlobalSettings swaggerGlobalSettings() {
        SwaggerGlobalSettings swaggerGlobalSettings = new SwaggerGlobalSettings();
        swaggerGlobalSettings.setGlobalResponseMessages(springSwaggerConfig.defaultResponseMessages());
        swaggerGlobalSettings.setIgnorableParameterTypes(springSwaggerConfig.defaultIgnorableParameterTypes());
        swaggerGlobalSettings.setParameterDataTypes(springSwaggerModelConfig.defaultParameterDataTypes());
        return swaggerGlobalSettings;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Ontology API", "", "", "", "", "");
        return apiInfo;
    }

    @Bean
    public SwaggerApiResourceListing swaggerApiResourceListing() {
        SwaggerApiResourceListing swaggerApiResourceListing = new SwaggerApiResourceListing(springSwaggerConfig.swaggerCache(), SWAGGER_GROUP);
        swaggerApiResourceListing.setSwaggerGlobalSettings(swaggerGlobalSettings());
        swaggerApiResourceListing.setSwaggerPathProvider(apiPathProvider());
        swaggerApiResourceListing.setApiInfo(apiInfo());
        swaggerApiResourceListing.setAuthorizationTypes(authorizationTypes());
        swaggerApiResourceListing.setApiListingReferenceScanner(apiListingReferenceScanner());
        return swaggerApiResourceListing;
    }

    @Bean
    public ApiPathProvider apiPathProvider() {
        ApiPathProvider apiPathProvider = new ApiPathProvider(docsLocation);
        apiPathProvider.setDefaultSwaggerPathProvider(springSwaggerConfig.defaultSwaggerPathProvider());
        return apiPathProvider;
    }


    private List<AuthorizationType> authorizationTypes() {
        ArrayList<AuthorizationType> authorizationTypes = new ArrayList<AuthorizationType>();
        List<AuthorizationScope> authorizationScopeList = new ArrayList();
        authorizationScopeList.add(new AuthorizationScope("global", "access all"));
        List<GrantType> grantTypes = new ArrayList();
        LoginEndpoint loginEndpoint = new LoginEndpoint(apiPathProvider().getAppBasePath() + "/user/authenticate");
        grantTypes.add(new ImplicitGrant(loginEndpoint, "access_token"));
        return authorizationTypes;
    }

    @Bean
    public ApiListingReferenceScanner apiListingReferenceScanner() {
        ApiListingReferenceScanner apiListingReferenceScanner = new ApiListingReferenceScanner();
        apiListingReferenceScanner.setRequestMappingHandlerMapping(springSwaggerConfig.swaggerRequestMappingHandlerMappings());
        apiListingReferenceScanner.setExcludeAnnotations(springSwaggerConfig.defaultExcludeAnnotations());
        apiListingReferenceScanner.setResourceGroupingStrategy(springSwaggerConfig.defaultResourceGroupingStrategy());
        apiListingReferenceScanner.setSwaggerPathProvider(apiPathProvider());
        apiListingReferenceScanner.setSwaggerGroup(SWAGGER_GROUP);
        apiListingReferenceScanner.setIncludePatterns(DEFAULT_INCLUDE_PATTERNS);
        return apiListingReferenceScanner;
    }
}
