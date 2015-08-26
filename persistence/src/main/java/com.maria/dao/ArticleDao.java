package com.maria.dao;
import com.maria.model.Article;

import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */
public interface ArticleDao {

    public boolean saveArticle(Article article);

    public Article getArticle(int id);

    public List getAllArticles();

    public boolean updateArticle(Article article);

    public boolean deleteArticle(Article article);

}