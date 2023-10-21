package com.epam.training.miservices.services.graphql.web;

import com.epam.training.miservices.services.graphql.post.Post;
import com.epam.training.miservices.services.graphql.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@GraphQlTest(PostController.class)
class PostControllerTest {
    @Autowired
    GraphQlTester tester;

    @MockBean
    PostRepository postRepository;

    @Test
    void check_contextStarts() {
        assertThat(tester).isNotNull();
    }

    @Test
    void findAll_returnPosts() {
        when(postRepository.findAll()).thenReturn(List.of(
                Post.builder()
                        .id(1L)
                        .title("Test title")
                        .build()
        ));

        tester.documentName("allPosts")
                .execute()
                .path("allPosts")
                .entityList(Post.class)
                .hasSizeGreaterThan(0);
    }

    @Test
    void renamePost_updatesPost() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(
                Post.builder()
                        .title("Old title")
                        .build()
        ));

        tester.documentName("renamePost")
                .variable("id", 1L)
                .variable("title", "New title")
                .execute();

        final ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);
        verify(postRepository, times(1)).save(postCaptor.capture());

        assertThat(postCaptor.getValue().getTitle()).isEqualTo("New title");
    }
}