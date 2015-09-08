package com.maria.daoImpl;

import com.maria.dao.ArticleDao;
import com.maria.dao.CommentDao;
import com.maria.model.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by msimion on 9/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/dao/article-dao.xml", "classpath*:META-INF/spring/spring-jpa.xml", "classpath*:META-INF/dao/comment-dao.xml"})
public class CommentDaoImplIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    CommentDao commentDao;

    @Autowired
    ArticleDao articleDao;

    @Test
    public void testGetComments() {

        List<Comment> commentList = commentDao.getAllCommentsFromAnArticle(2);

        Assert.assertNotNull(commentList);
    }

    @Test
    public void testCreateComment() {

        List<Comment> before = commentDao.getAllCommentsFromAnArticle(2);
        Comment comment = new Comment();
        comment.setArticle(articleDao.get(2));
        comment.setCommentator("test");
        comment.setCommentContent("test");
        commentDao.saveComment(comment, 2);
        List<Comment> after = commentDao.getAllCommentsFromAnArticle(2);

        Assert.assertTrue(before.size() < after.size());
    }

    @Test
    public void testDeleteComment() {

        commentDao.delete(2);
        Comment deletedComment = commentDao.get(2);

        Assert.assertNull(deletedComment);
    }

}
