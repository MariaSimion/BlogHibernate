package com.maria.service;

import com.maria.api.IArticleFacade;
import com.maria.api.ICommentFacade;
import com.maria.api.IServiceUser;
import com.maria.api.IUserFacade;
import com.maria.exceptions.CustomException;
import com.maria.facade.ArticleFacade;
import com.maria.facade.CommentFacade;
import com.maria.facade.UserFacade;
import com.maria.model.Article;
import com.maria.model.Comment;
import com.maria.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/31/2015.
 */
@Path("/user")
public class ServiceUser implements IServiceUser {

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private IArticleFacade articleFacade;

    @Autowired
    private ICommentFacade commentFacade;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveUser(User user) {
        userFacade.saveUser(user);
    }

    @GET
    @Path("/{idUser}/articles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticlesForOneUser(@PathParam("idUser") int idUser) {
        return articleFacade.getAllArticlesForOneUser(idUser);
    }

    @GET
    @Path("/{idUser}/articles/{idArticle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle) {
        return articleFacade.getOneArticleForOneUser(idUser, idArticle);
    }

    @GET
    @Path("/{idUser}/articles/{idArticle}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getCommentsFromAnArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle) {
        return commentFacade.getCommentsFromAnArticleForOneUser(idArticle, idUser);
    }

    @POST
    @Transactional
    @Path("/{idUser}/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public Article saveArticle(@PathParam("idUser") int idUser, Article article) {

        User user = userFacade.getUser(idUser);
        return articleFacade.createArticle(article, user);
    }

    @DELETE
    @Transactional
    @Path("/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("idUser") int idUser){
        User userPersisted = userFacade.getUser(idUser);
        if(userPersisted != null){
            userFacade.deleteUser(userPersisted);
        }else{
            throw new CustomException(String.format("User with id %s cannot be found.", idUser));
        }
    }

    @DELETE
    @Transactional
    @Path("/{idUser}/articles/{idArticle}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle) {
        Article persisted = getArticle(idUser, idArticle);
        if (persisted != null) {
            articleFacade.delete(idUser, idArticle);
        } else {
            throw new CustomException(String.format("Article with id %s cannot be found.", idArticle));
        }

    }


    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    public void setCommentFacade(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
