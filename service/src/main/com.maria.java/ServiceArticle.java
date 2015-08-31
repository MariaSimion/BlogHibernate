import com.maria.ArticleFacade;
import com.maria.CommentFacade;
import com.maria.model.Article;
import com.maria.model.Comment;

import javax.jws.WebParam;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

@Path("/")
public class ServiceArticle {


    ArticleFacade articleFacade;


    @GET
    @Path("/articles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticles() {

        List<Article> articles = this.articleFacade.getArticles();
        return articles;
    }

    @GET
    @Path("/articles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") int id) {
        return articleFacade.getArticle(id);
    }


    @PUT
    @Path("/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveArticle(Article article) {
        return articleFacade.createArticle(article);
    }

    @DELETE
    @Path("/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteArticle(Article article) {
        return articleFacade.deleteArticle(article);
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

}
