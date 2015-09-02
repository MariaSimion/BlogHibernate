package service;

import com.maria.ArticleFacade;
import com.maria.CommentFacade;
import com.maria.UserFacade;
import com.maria.model.Article;
import com.maria.model.Comment;
import com.maria.model.User;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/31/2015.
 */
@Path("/user")
public class ServiceUser {

    UserFacade userFacade;

    ArticleFacade articleFacade;

    CommentFacade commentFacade;

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
    public List<Comment> getCommentsFromAnArticle(@PathParam("idUser") int idUser, @PathParam("idArticle") int idArticle){
        return commentFacade.getCommentsFromAnArticleForOneUser(idArticle, idUser);
    }

    @POST
    @Transactional
    @Path("/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public Article saveArticle( Article article) {

        //User user = userFacade.getUser(idUser);
       // return articleFacade.createArticle(article, user);
        return null;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }


    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    public CommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
