package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.model.Article;
import com.maria.model.User;

import javax.persistence.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

public class ArticleDaoImpl extends GenericDaoImpl<Article> implements ArticleDao {

    public ArticleDaoImpl() {
        super(Article.class);
    }


    public Article persist(Article article, User user) {
        if (article.getId() != 0) {
            entityManager.merge(article);
        } else {
            article.setDate(new Date());
            article.setUser(user);
            persist(article);
        }
        return article;
    }

    public List<Article> getAllArticlesForOneUser(int idUser) {
        Query query = this.entityManager.createQuery("from Article where idUser=:idUser");
        query.setParameter("idUser", idUser);
        return query.getResultList();
    }

    public Article getOneArticleForOneUser(int idUser, int idArticle) {
        Article article = entityManager.find(Article.class, idArticle);
        User user = entityManager.find(User.class, idUser);
        if (user.equals(article.getUser())) {
            return article;
        }
        return null;
    }

    public void deleteArticle(int idUser, int idArticle) {
        Article article = entityManager.find(Article.class, idArticle);
        User user = entityManager.find(User.class, idUser);
        if (user.equals(article.getUser())) {
            delete(idArticle);
        }
    }
}
