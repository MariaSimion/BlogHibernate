package com.maria.api;

import com.maria.daoImpl.ArticleDaoImpl;
import com.maria.daoImpl.CommentDaoImpl;
import com.maria.daoImpl.UserDaoImpl;
import com.maria.model.Comment;

import java.util.List;

/**
 * Created by msimion on 9/2/2015.
 */
public interface ICommentFacade {

    Comment saveComment(Comment comment, int id);

    void deleteComment(Comment comment);

    List<Comment> getCommentsFromAnArticle(int id);

    List<Comment> getCommentsFromAnArticleForOneUser(int idArticle, int idUser);

    CommentDaoImpl getCommentDao();

    void setCommentDao(CommentDaoImpl commentDao);

    ArticleDaoImpl getArticleDao();

    void setArticleDao(ArticleDaoImpl articleDao);

    UserDaoImpl getUserDao();

    void setUserDao(UserDaoImpl userDao);
}
