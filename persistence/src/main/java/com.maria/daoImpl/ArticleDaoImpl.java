package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.dao.GenericDao;
import com.maria.model.Article;
import com.maria.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

public class ArticleDaoImpl extends GenericDaoImpl<Article> implements ArticleDao {

    public ArticleDaoImpl() {
        super(Article.class);
    }


    public Article saveArticle(Article article, User user) {

        article.setDate(new Date());
        article.setUser(user);
        save(article);
        return article;

    }

    public List<Article> getAllArticlesForOneUser(int idUser){
        Query query = this.entityManager.createQuery("from Article where idUser=:idUser");
        query.setParameter("idUser", idUser);
        return query.getResultList();
    }

    public Article getOneArticleForOneUser(int idUser, int idArticle){
        Article article = entityManager.find(Article.class, idArticle);
        User user = entityManager.find(User.class, idUser);
        if(user.equals(article.getUser())){
            return article;
        }
        return null;
    }

    public void deleteArticle(int idUser, int idArticle) {
        Article article = entityManager.find(Article.class, idArticle);
        User user = entityManager.find(User.class, idUser);
        if(user.equals(article.getUser())){
            delete(article, idArticle);
        }
    }
}
