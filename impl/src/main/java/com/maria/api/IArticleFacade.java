package com.maria.api;

import com.maria.daoImpl.ArticleDaoImpl;
import com.maria.model.Article;
import com.maria.model.User;

import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IArticleFacade {

    Article getArticle(int id);

    List<Article> getArticles();

    List<Article> getAllArticlesForOneUser(int idUser);

    Article createArticle(Article article, User user);

    Article getOneArticleForOneUser(int idUser, int idArticle);

    void deleteArticle(Article article) throws RuntimeException;

    void delete(int idUser, int idArticle);

    ArticleDaoImpl getArticleDao();

    void setArticleDao(ArticleDaoImpl articleDao);
}
