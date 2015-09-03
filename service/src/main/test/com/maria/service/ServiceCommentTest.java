package com.maria.service;

import com.maria.api.IServiceComment;
import com.maria.facade.CommentFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by msimion on 9/3/2015.
 */
public class ServiceCommentTest {

    @Mock
    private CommentFacade commentFacade;

    private IServiceComment serviceComment;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        serviceComment = new ServiceComment();
        serviceComment.setCommentFacade(commentFacade);
    }

    @Test
    public void testGetCommentsForArticle() {
        int idArticle = 0;


    }
}
