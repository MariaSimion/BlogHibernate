package com.maria;

import com.maria.daoImpl.ArticleDaoImpl;
import com.maria.model.Article;

import java.util.List;

/**
 * Created by msimion on 8/27/2015.
 */
public class ArticleFacade {

    ArticleDaoImpl articleDao;

    public Article getArticle(int id){
       return articleDao.getArticle(id);
    }

    public List<Article> getArticles(){
        return articleDao.getAllArticles();
    }

    public boolean createArticle(Article article){
        return articleDao.saveArticle(article);
    }

    public boolean deleteArticle(Article article){
        return articleDao.deleteArticle(article);
    }

    public ArticleDaoImpl getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }
}
