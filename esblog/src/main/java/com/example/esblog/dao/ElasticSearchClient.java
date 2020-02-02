package com.example.esblog.dao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public interface ElasticSearchClient {

    /**
     * 单条查询
     * @param indexName
     * @param queryarams
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/{indexName}/_search",consumes = "application/json")
    Map search(@PathVariable(name = "indexName",required = false) String indexName, Map queryarams);
}
