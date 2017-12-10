package com.Elastic.search.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("app")
@Getter
@Setter
public class ConfigProps {

	@NestedConfigurationProperty
    private RestClient restClient = new RestClient();

    @NestedConfigurationProperty
    private Index index = new Index();

	public RestClient getRestClient() {
		return restClient;
	}

	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}
}
