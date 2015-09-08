package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.dao.UserDao;
import com.maria.model.Article;
import com.maria.model.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
;
import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 9/4/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/dao/article-dao.xml", "classpath*:META-INF/spring/spring-jpa.xml", "classpath*:META-INF/dao/user-dao.xml"})
public class ArticleDaoImplIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    UserDao userDao;

    @Test
    public void testFindById() {

        Article article = articleDao.get(2);
        Assert.assertEquals("Second", article.getTitle());
    }

    @Test
    public void testFindAll() {
        Assert.assertEquals(6, articleDao.getAll().size());
    }

    @Test
    public void testGetArticlesForUser() {
        List<Article> articles = articleDao.getAllArticlesForOneUser(4);

        Assert.assertFalse(articles.size() != 0);
    }

    @Test
    public void testGetOneArticleForUser() {

        Article article = articleDao.getOneArticleForOneUser(1, 2);

        Assert.assertNotNull(article);
    }

    @Test
    public void testInsertArticle() {

        List<Article> before = articleDao.getAll();
        Article article = new Article("test", "test", "test");
        User user = userDao.get(1);
        articleDao.persist(article, user);

        List<Article> after = articleDao.getAll();
        Assert.assertTrue(before.size() < after.size());
    }

    @Test
    public void testDeleteArticle() {

        articleDao.deleteArticle(1, 8);

        Article deletedArticle = articleDao.get(8);
        Assert.assertNull(deletedArticle);
    }

}
