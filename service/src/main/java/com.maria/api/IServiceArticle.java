package com.maria.api;

import com.maria.facade.ArticleFacade;
import com.maria.model.Article;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IServiceArticle {

    /**
     * @return all articles from database
     */
    List<Article> getAllArticles();

    /**
     * @param id
     * @return the article with @param id
     */
    Article getArticle(@PathParam("id") int id);


}
