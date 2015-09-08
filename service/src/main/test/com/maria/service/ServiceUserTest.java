package com.maria.service;

import com.maria.api.IArticleFacade;
import com.maria.api.ICommentFacade;
import com.maria.api.IServiceUser;
import com.maria.api.IUserFacade;
import com.maria.model.Article;
import com.maria.model.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msimion on 9/3/2015.
 */
public class ServiceUserTest {

    @Mock
    IUserFacade userFacade;

    @Mock
    IArticleFacade articleFacade;

    @Mock
    ICommentFacade commentFacade;

    IServiceUser serviceUser;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        serviceUser = new ServiceUser(userFacade, articleFacade, commentFacade);
    }

    @Test
    public void testGetArticles() {

        int id = 0;
        List<Article> articles = new ArrayList<Article>();
        Mockito.doReturn(articles).when(articleFacade).getAllArticlesForOneUser(id);

        List<Article> resultArticles = serviceUser.getAllArticlesForOneUser(id);
        Mockito.verify(articleFacade).getAllArticlesForOneUser(id);
        Mockito.verifyNoMoreInteractions(articleFacade);

        Assert.assertEquals(articles, resultArticles);

    }

    @Test
    public void testGetArticle() {

        int idArticle = 0;
        int idUser = 0;

        Article article = new Article();
        Mockito.doReturn(article).when(articleFacade).getOneArticleForOneUser(idUser, idArticle);

        Article resultArticle = serviceUser.getArticle(idUser, idArticle);
        Mockito.verify(articleFacade).getOneArticleForOneUser(idUser, idArticle);
        Mockito.verifyNoMoreInteractions(articleFacade);

        Assert.assertEquals(article, resultArticle);

    }

    @Test
    public void testGetComments() {

        int idArticle = 0;
        int idUser = 0;

        List<Comment> comments = new ArrayList<Comment>();
        Mockito.doReturn(comments).when(commentFacade).getCommentsFromAnArticleForOneUser(idArticle, idUser);

        List<Comment> resultComments = serviceUser.getCommentsFromAnArticle(idUser, idArticle);
        Mockito.verify(commentFacade).getCommentsFromAnArticleForOneUser(idArticle, idUser);
        Mockito.verifyNoMoreInteractions(commentFacade);

        Assert.assertEquals(comments, resultComments);

    }
}
