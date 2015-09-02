package com.maria.api;

import com.maria.model.Article;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IServiceArticle {
// TODO maria  doccument this.
    List<Article> getAllArticles();


    Article getArticle(@PathParam("id") int id);

    void deleteArticle(Article article);
}
