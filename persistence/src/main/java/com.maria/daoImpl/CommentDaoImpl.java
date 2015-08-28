package com.maria.daoImpl;

import com.maria.dao.CommentDao;
import com.maria.model.Comment;


import javax.persistence.*;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

    public CommentDaoImpl() {
    }

    public boolean saveComment(Comment comment) {
        return false;
    }


    public List<Comment> getAllCommentsFromAnArticle(int id) {
      Query query = this.entityManager.createQuery("from Comment where idArticle=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public boolean deleteComment(Comment comment) {
        return false;
    }
}
