package com.maria.api;

import com.maria.facade.ArticleFacade;
import com.maria.facade.CommentFacade;
import com.maria.facade.UserFacade;
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

    /**
     * This method insert @user in database
     * @param user
     */
    void saveUser(User user);

    /**
     *
     * @return all articles written by user with @id
     */
    List<Article> getAllArticlesForOneUser(int idUser);

    /**
     *
     * @param idUser
     * @param idArticle
     * @return article with @idArticle from user with @idUser
     */
    Article getArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle);

    /**
     *
     * @param idUser
     * @param idArticle
     * @return all comments from an article with @idArticle
     *          this article is from one user with @idUser
     */
    List<Comment> getCommentsFromAnArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle);

    /**
     *
     * @param idUser
     * @param article
     * @return article inserted in database for user with @idUser
     */
    Article saveArticle(@PathParam("idUser") int idUser, Article article);
}
