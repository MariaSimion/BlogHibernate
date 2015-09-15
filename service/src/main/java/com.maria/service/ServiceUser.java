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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.security.Principal;
import java.util.List;

/**
 * Created by msimion on 8/31/2015.
 */
@Path("/articles/my-articles")
public class ServiceUser implements IServiceUser {


    private IUserFacade userFacade;


    private IArticleFacade articleFacade;


    private ICommentFacade commentFacade;

    public ServiceUser() {
    }

    public ServiceUser(IUserFacade userFacade, IArticleFacade articleFacade, ICommentFacade commentFacade) {
        this.userFacade = userFacade;
        this.articleFacade = articleFacade;
        this.commentFacade = commentFacade;
    }


    public void saveUser(User user) {

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticlesForOneUser(int idUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();
        User user = userFacade.getUser(username);
        return articleFacade.getAllArticlesForOneUser(user.getId());
    }


    public Article getArticle(int idUser, int idArticle) {
        return null;
    }


    public List<Comment> getCommentsFromAnArticle(int idUser, int idArticle) {
        return null;
    }


    public Article saveArticle(int idUser, Article article) {
        return null;
    }
}
