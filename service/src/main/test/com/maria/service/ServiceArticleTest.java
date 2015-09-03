package com.maria.service;

import com.maria.facade.ArticleFacade;
import com.maria.api.IServiceArticle;
import com.maria.model.Article;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by msimion on 9/2/2015.
 */
public class ServiceArticleTest {

    @Mock
    private ArticleFacade articleFacade;

    private IServiceArticle serviceArticle;


    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        serviceArticle = new ServiceArticle();
        serviceArticle.setArticleFacade(articleFacade);
    }

    @Test
    public void testGetArticle() {
        //prepare
        int id = 0;
        Article article = new Article();
        //mock scenario
        Mockito.doReturn(article).when(articleFacade).getArticle(id);
        //call
        Article result = serviceArticle.getArticle(id);
        //check
        Mockito.verify(articleFacade).getArticle(id);
        Mockito.verifyNoMoreInteractions(articleFacade);
        Assert.assertEquals(article, result);

    }

}