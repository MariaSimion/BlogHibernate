package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.dao.GenericDao;
import com.maria.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

public class ArticleDaoImpl extends GenericDaoImpl<Article> implements ArticleDao {

    private EntityManager entityManager;

    public ArticleDaoImpl() {
    }


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Transactional
    public boolean saveArticle(Article article) {

        if (article != null) {
            article.setDate(new Date());
            entityManager.persist(article);
            return true;
        }

        return false;
    }


    public Article getArticle(int id) {

        return this.entityManager.find(Article.class, id);
    }


    public List<Article> getAllArticles() {
        List<Article> articleList = this.entityManager.createQuery("from Article").getResultList();
        return articleList;
    }

    @Transactional
    public boolean deleteArticle(Article article) {

        if (article != null) {
            article = entityManager.find(Article.class, article.getId());
            entityManager.remove(article);

            return true;
        }

        return false;
    }
}
