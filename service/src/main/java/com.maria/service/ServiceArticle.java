package com.maria.service;

import com.maria.api.IArticleFacade;
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

    private IArticleFacade articleFacade;

    public ServiceArticle() {
    }

    public ServiceArticle(IArticleFacade articleFacade) {
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
        Article persisted = articleFacade.getArticle(id);
        if (persisted != null) {
            return articleFacade.getArticle(id);
        } else {
            throw new CustomException(String.format("Article with id %s does not exist.", id), "BAD_REQUEST");
        }
    }
}
