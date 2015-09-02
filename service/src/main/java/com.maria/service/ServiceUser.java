package com.maria.service;

import com.maria.api.IServiceUser;
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
public class ServiceUser implements IServiceUser{

    private final UserFacade userFacade;

    private final ArticleFacade articleFacade;

    private final CommentFacade commentFacade;

    @Autowired
    public ServiceUser(UserFacade userFacade, ArticleFacade articleFacade, CommentFacade commentFacade) {
        this.userFacade = userFacade;
        this.articleFacade = articleFacade;
        this.commentFacade = commentFacade;
    }

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
}
