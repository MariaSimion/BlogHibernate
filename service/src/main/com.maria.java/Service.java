import com.maria.ArticleFacade;
import com.maria.dao.ArticleDaoImpl;
import com.maria.model.Article;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/25/2015.
 */

@Path("/")
public class Service {


    ArticleFacade articleFacade;

    @GET
    @Path("/articles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getAllArticles(){

        List<Article> articles = this.articleFacade.getArticles();
        return articles;
    }

    @PUT
    @Path("/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveArticle(Article article){
        return articleFacade.createArticle(article);
    }

    @DELETE
    @Path("/articles")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteArticle(Article article){
        return articleFacade.deleteArticle(article);
    }

    public ArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }
}
