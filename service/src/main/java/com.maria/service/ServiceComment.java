package com.maria.service;

import com.maria.api.ICommentFacade;
import com.maria.api.IServiceComment;
import com.maria.facade.CommentFacade;
import com.maria.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
@Path("/articles/{id}/comments")
@Transactional
public class ServiceComment implements IServiceComment{


    private ICommentFacade commentFacade;

    public ServiceComment() {
    }

    public ServiceComment(ICommentFacade commentFacade) {
        this.commentFacade = commentFacade;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id) {
        return commentFacade.getCommentsFromAnArticle(id);
    }

    @PUT
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



}
