package com.example.esblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/elasticsearch")
public class ElasticSearchController {

    private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchController.class);

}
