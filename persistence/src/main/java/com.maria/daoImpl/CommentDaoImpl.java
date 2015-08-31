package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.dao.CommentDao;
import com.maria.model.Article;
import com.maria.model.Comment;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

    ArticleDaoImpl articleDaoImpl = new ArticleDaoImpl();

    public CommentDaoImpl() {
    }

    @Transactional
    public boolean saveComment(Comment comment, int id) {

        Article article;
        if (comment != null) {
            comment.setDate(new Date());
            article = entityManager.find(Article.class, id);
            comment.setArticle(article);
            entityManager.persist(comment);
            return true;
        }
        return false;
    }


    public List<Comment> getAllCommentsFromAnArticle(int id) {
        Query query = this.entityManager.createQuery("from Comment where idArticle=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Transactional
    public boolean deleteComment(Comment comment) {

        if (comment != null) {
            comment = entityManager.find(Comment.class, comment.getId());
            entityManager.remove(comment);
            return true;
        }
        return false;
    }

    public ArticleDaoImpl getArticleDaoImpl() {
        return articleDaoImpl;
    }

    public void setArticleDaoImpl(ArticleDaoImpl articleDaoImpl) {
        this.articleDaoImpl = articleDaoImpl;
    }
}
