package com.maria.dao;

import com.maria.model.Article;
import com.maria.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */
public interface ArticleDao extends GenericDao<Article> {

    List<Article> getAllArticlesForOneUser(int idUser);

    Article persist(Article article, User user);

    Article getOneArticleForOneUser(int idUser, int idArticle);

    void deleteArticle(int idUser, int idArticle);
}
