package com.baeldung.crawler4j;

import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.baeldung.common.config.CommonConfig;
import com.baeldung.common.config.MyApplicationContextInitializer;
import com.baeldung.crawler4j.config.Crawler4jMainCofig;
import com.baeldung.crawler4j.controller.CodeCrawlerController;
import com.baeldung.crawler4j.controller.TutorialsRepoCrawlerController;

@ContextConfiguration(classes = { CommonConfig.class, Crawler4jMainCofig.class }, initializers = MyApplicationContextInitializer.class)
@ExtendWith(SpringExtension.class)
public class BaseCrawler4JTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());        
    
    @Autowired
    protected TutorialsRepoCrawlerController tutorialsRepoCrawlerController; 
    
    @Autowired
    protected CodeCrawlerController codeSnippetCrawlerController;        

}
