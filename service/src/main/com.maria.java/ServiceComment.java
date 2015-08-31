import com.maria.CommentFacade;
import com.maria.model.Comment;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
@Path("/articles/{id}/comments")
public class ServiceComment {

    CommentFacade commentFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id) {
        return commentFacade.getCommentsFromAnArticle(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveComment(Comment comment, @PathParam("id") int id) {
        return commentFacade.saveComment(comment, id);
    }

    @DELETE
    @Path("/{idComment}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteComment(Comment comment, @PathParam("idComment") int id){

        return commentFacade.deleteComment(comment);
    }

    public CommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
