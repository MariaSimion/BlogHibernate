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
        super(Comment.class);
    }


    public Comment saveComment(Comment comment, int id) {

        if (comment.getId() != 0) {
            entityManager.merge(comment);
        } else {
            Article article;
            comment.setDate(new Date());
            article = entityManager.find(Article.class, id);
            comment.setArticle(article);
            persist(comment);
        }

        return comment;
    }


    public List<Comment> getAllCommentsFromAnArticle(int id) {
        Query query = this.entityManager.createQuery("from Comment where idArticle=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }


    public ArticleDaoImpl getArticleDaoImpl() {
        return articleDaoImpl;
    }

    public void setArticleDaoImpl(ArticleDaoImpl articleDaoImpl) {
        this.articleDaoImpl = articleDaoImpl;
    }
}
