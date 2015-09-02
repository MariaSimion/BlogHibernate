package com.maria.facade;

import com.maria.api.ICommentFacade;
import com.maria.daoImpl.ArticleDaoImpl;
import com.maria.daoImpl.CommentDaoImpl;
import com.maria.daoImpl.UserDaoImpl;
import com.maria.model.Article;
import com.maria.model.Comment;
import com.maria.model.User;

import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public class CommentFacade implements ICommentFacade{

    CommentDaoImpl commentDao;

    ArticleDaoImpl articleDao;

    UserDaoImpl userDao;

    public Comment saveComment(Comment comment, int id) {
        return commentDao.saveComment(comment, id);
    }

    public void deleteComment(Comment comment) {

    }

    public List<Comment> getCommentsFromAnArticle(int id) {
        return commentDao.getAllCommentsFromAnArticle(id);
    }

    public List<Comment> getCommentsFromAnArticleForOneUser(int idArticle, int idUser) {
        Article article = articleDao.get(idArticle);
        User user = userDao.get(idUser);
        if (article.getUser().equals(user)) {
            return commentDao.getAllCommentsFromAnArticle(idArticle);
        }
        return null;
    }

    public CommentDaoImpl getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDaoImpl commentDao) {
        this.commentDao = commentDao;
    }

    public ArticleDaoImpl getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
