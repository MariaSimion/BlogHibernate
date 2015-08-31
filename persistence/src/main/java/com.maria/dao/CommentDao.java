package com.maria.dao;

import com.maria.model.Comment;

import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public interface CommentDao extends GenericDao<Comment> {

    public boolean saveComment(Comment comment, int id);

    public List<Comment> getAllCommentsFromAnArticle(int id);

    public boolean deleteComment(Comment comment);
}
