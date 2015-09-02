package com.maria.api;

import com.maria.model.Comment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IServiceComment {

    List<Comment> getAllCommentFromAnArticle(@PathParam("id") int id);

    Comment saveComment(Comment comment, @PathParam("id") int id);

    void deleteComment(Comment comment, @PathParam("idComment") int id);
}
