package com.Elastic.search.prop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestClient {
    
	private String hostname;
    private String scheme;
    private int port;
}
