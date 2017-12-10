package com.Elastic.search.ELKOPERATION;

import java.net.InetSocketAddress;

import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.node.Node;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.Elastic.search.Controller")
@EnableAutoConfiguration
//@SpringBootApplication
public class SpringElasticApplication 
{
    public static void main( String[] args )
    {
    	 SpringApplication.run(SpringElasticApplication.class, args);
    }
}
