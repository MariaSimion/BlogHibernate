package service;

import com.maria.ArticleFacade;
import com.maria.CommentFacade;
import com.maria.model.Article;
import com.maria.model.Comment;

import javax.jws.WebParam;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */
@Path("/articles")
public class ServiceArticle {


    ArticleFacade articleFacade;

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
        if (persisted != null){
            articleFacade.deleteArticle(persisted);
        } else{
            throw new RuntimeException(String.format("Article with id %s cannot be found.", article.getId()));
        }

    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

}
