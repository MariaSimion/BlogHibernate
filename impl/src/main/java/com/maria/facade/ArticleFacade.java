package com.maria.facade;

import com.maria.api.IArticleFacade;
import com.maria.daoImpl.ArticleDaoImpl;
import com.maria.model.Article;
import com.maria.model.User;


import java.util.List;

/**
 * Created by msimion on 8/27/2015.
 */
public class ArticleFacade implements IArticleFacade{

    ArticleDaoImpl articleDao;

    public Article getArticle(int id) {

        return articleDao.get(id);
    }

    public List<Article> getArticles() {
        return articleDao.getAll();
    }

    public List<Article> getAllArticlesForOneUser(int idUser) {
        return articleDao.getAllArticlesForOneUser(idUser);
    }

    public Article createArticle(Article article, User user) {
        return articleDao.saveArticle(article, user);
    }

    public Article getOneArticleForOneUser(int idUser, int idArticle) {
        return articleDao.getOneArticleForOneUser(idUser, idArticle);
    }

    public void deleteArticle(Article article) throws RuntimeException{
        articleDao.delete(article, article.getId());
    }

    public ArticleDaoImpl getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }
}
