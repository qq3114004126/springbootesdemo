package com.example.esblog.controller;

import com.example.esblog.dao.ElasticSearchClient;
import com.example.esblog.dao.EsBlogRepository;
import com.example.esblog.entity.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Autowired
    ElasticSearchClient elasticSearchClient;

    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title",required = false,defaultValue ="") String title,@RequestParam(value = "summary",required = false,defaultValue = "")String summary,@RequestParam(value = "content",required = false,defaultValue = "") String content,
                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0") int pageIndex,@RequestParam(value = "pageSize",required = false,defaultValue = "1") int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<EsBlog> page = esBlogRepository.findByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        List<EsBlog> content1 = page.getContent();
        return content1;
    }

    @PostMapping("/post")
    public Boolean addEsBlog(@RequestParam(value = "title")String title,@RequestParam(value = "summary",required = false,defaultValue = "")String summary,@RequestParam(value = "content") String content) {
        EsBlog blog = new EsBlog(title, summary, content);
        EsBlog esBlog = esBlogRepository.save(blog);
        return true;
    }

}
