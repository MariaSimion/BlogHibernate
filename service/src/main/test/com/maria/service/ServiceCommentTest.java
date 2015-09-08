package com.maria.service;

import com.maria.api.ICommentFacade;
import com.maria.api.IServiceComment;
import com.maria.model.Comment;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msimion on 9/3/2015.
 */
public class ServiceCommentTest {

    @Mock
    private ICommentFacade commentFacade;

    private IServiceComment serviceComment;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        serviceComment = new ServiceComment(commentFacade);

    }

    @Test
    public void testGetCommentsForArticle() {

        int idArticle = 0;

        List<Comment> comments = new ArrayList<Comment>();

        Mockito.doReturn(comments).when(commentFacade).getCommentsFromAnArticle(idArticle);

        List<Comment> result = serviceComment.getAllCommentFromAnArticle(idArticle);

        Mockito.verify(commentFacade).getCommentsFromAnArticle(idArticle);
        Mockito.verifyNoMoreInteractions(commentFacade);
        Assert.assertEquals(comments, result);
    }
}
