package com.maria;

import com.maria.dao.ArticleDaoImpl;
import com.maria.model.Article;

import java.util.List;

/**
 * Created by msimion on 8/27/2015.
 */
public class ArticleFacade {

    ArticleDaoImpl articleDao;

    public List<Article> getArticles(){
        return articleDao.getAllArticles();
    }

    public ArticleDaoImpl getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }
}
