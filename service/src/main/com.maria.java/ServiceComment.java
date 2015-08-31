import com.maria.CommentFacade;
import com.maria.model.Comment;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
@Path("/article")
public class ServiceComment {

    CommentFacade commentFacade;

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id) {
        return commentFacade.getCommentsFromAnArticle(id);
    }

    @PUT
    @Path("/{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean saveComment(Comment comment, @PathParam("id") int id) {
        return commentFacade.saveComment(comment, id);
    }

    @DELETE
    @Path("/{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteComment(Comment comment, @PathParam("id") int id){

        return commentFacade.deleteComment(comment);
    }

    public CommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
