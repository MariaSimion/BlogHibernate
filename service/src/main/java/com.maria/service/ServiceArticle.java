package com.maria.service;

import com.maria.facade.ArticleFacade;

import com.maria.api.IServiceArticle;
import com.maria.exceptions.CustomException;
import com.maria.model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */
@Path("/articles")
public class ServiceArticle implements IServiceArticle {



    private final ArticleFacade articleFacade;



    public ServiceArticle(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticles() {
        return articleFacade.getArticles();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") int id) {
        return articleFacade.getArticle(id);
    }

    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteArticle(Article article) {
        Article persisted = getArticle(article.getId());
        if (persisted != null) {
            articleFacade.deleteArticle(persisted);
        } else {
            throw new CustomException(String.format("Article with id %s cannot be found.", article.getId()));
        }

    }


}
