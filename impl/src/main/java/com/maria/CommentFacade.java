package com.maria;

import com.maria.dao.CommentDao;
import com.maria.daoImpl.CommentDaoImpl;
import com.maria.model.Comment;

import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public class CommentFacade {

    CommentDaoImpl commentDao;

    public List<Comment> getCommentsFromAnArticle(int id){
        return commentDao.getAllCommentsFromAnArticle(id);
    }

    public CommentDaoImpl getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }
}
