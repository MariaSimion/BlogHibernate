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
@Path("/articles")
public class ServiceArticle {


    ArticleFacade articleFacade;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticles() {

        List<Article> articles = this.articleFacade.getArticles();
        return articles;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(@PathParam("id") int id) {
        return articleFacade.getArticle(id);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveArticle(Article article) {
        return articleFacade.createArticle(article);
    }

    @DELETE
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
