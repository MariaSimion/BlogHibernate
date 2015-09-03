package com.maria.api;

import com.maria.facade.CommentFacade;
import com.maria.model.Comment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IServiceComment {

    /**
     *
     * @param id
     * @return all comments from the article with @param id
     */
    List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id);

    /**
     * This method save @comment in database at article with @id
     * @param comment
     * @param id
     * @return
     */
    Comment saveComment(Comment comment, @PathParam("id") int id);

    /**
     * Delete @comment with @param id
     * @param comment
     * @param id
     */
    void deleteComment(Comment comment, @PathParam("idComment") int id);

    /**
     *
     * @param commentFacade
     */
    void setCommentFacade(CommentFacade commentFacade);
}
