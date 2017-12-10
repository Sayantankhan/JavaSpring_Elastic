package com.Elastic.search.dao;
/*
 * Created by Sayantan on 10/12/2017
 */

import java.io.IOException;
import java.util.*;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Elastic.search.entity.Document;
import com.Elastic.search.prop.ConfigProps;
import com.google.gson.Gson;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

@Component
public class QueryDao {
	
	@Autowired
	private RestHighLevelClient client;
	
	@Autowired
	private SearchSourceBuilder sourceBuilder;
	
    @Autowired
	private ConfigProps props;
	
	@Autowired 
	private Gson gson;
	
	public List<Document> matchAllQuery(){
        List<Document> result = new ArrayList();

        try {
            result = getDocuments(QueryBuilders.matchAllQuery());
        } catch (Exception ex){
            //log.error("The exception was thrown in matchAllQuery method." + ex);
        }

        return result;
	}

	private SearchRequest getSearchRequest(){
	        SearchRequest searchRequest = new SearchRequest(props.getIndex().getName());
	        searchRequest.source(sourceBuilder);
	        return searchRequest;
    }
	
	
	private List<Document> getDocuments(AbstractQueryBuilder builder) throws IOException {
		List<Document> result = new ArrayList();

        sourceBuilder.query(builder);
        SearchRequest searchRequest = getSearchRequest();

        SearchResponse searchResponse =  client.search(searchRequest);
        SearchHits hits = null;
		try {
			hits = searchResponse.getHits();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Document doc = gson.fromJson(hit.getSourceAsString(), Document.class);
            doc.setId(hit.getId());
            result.add(doc);
        }
        return result;
	
	}
}
