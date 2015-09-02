package com.maria.api;

import com.maria.model.Article;
import com.maria.model.Comment;
import com.maria.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IServiceUser {

    void saveUser(User user);

    List<Article> getAllArticlesForOneUser(@PathParam("idUser") int idUser);

    Article getArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle);

    List<Comment> getCommentsFromAnArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle);

    Article saveArticle(@PathParam("idUser") int idUser, Article article);
}
