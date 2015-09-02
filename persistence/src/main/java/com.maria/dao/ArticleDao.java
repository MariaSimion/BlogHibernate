package com.maria.dao;
import com.maria.model.Article;
import com.maria.model.User;

import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */
public interface ArticleDao extends GenericDao<Article> {

    public List<Article> getAllArticlesForOneUser(int idUser);

    public Article saveArticle(Article article, User user);

    public Article getOneArticleForOneUser(int idUser, int idArticle);
}
