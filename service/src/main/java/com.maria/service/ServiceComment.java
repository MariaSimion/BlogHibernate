package service;

import com.maria.CommentFacade;
import com.maria.model.Comment;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
@Path("/articles/{id}/comments")
@Transactional
public class ServiceComment {

    CommentFacade commentFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id) {
        return commentFacade.getCommentsFromAnArticle(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Comment saveComment(Comment comment, @PathParam("id") int id) {
        return commentFacade.saveComment(comment, id);
    }

    @DELETE
    @Transactional
    @Path("/{idComment}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteComment(Comment comment, @PathParam("idComment") int id) {

        commentFacade.deleteComment(comment);
    }

    public CommentFacade getCommentFacade() {
        return commentFacade;
    }

    public void setCommentFacade(CommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }
}
