package com.maria.dao;

import com.maria.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

public class ArticleDaoImpl implements ArticleDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {

        this.entityManager = entityManager;

    }


    public boolean saveArticle(Article article) {

        
        return false;
    }


    public Article getArticle(int id) {
        return null;
    }


    public List<Article> getAllArticles() {
        List<Article> articleList = this.entityManager.createQuery("from Article").getResultList();
        return articleList;
    }


    public boolean deleteArticle(Article article) {
        return false;
    }
}
