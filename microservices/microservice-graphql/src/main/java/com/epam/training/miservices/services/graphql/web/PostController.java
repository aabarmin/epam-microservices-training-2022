package com.epam.training.miservices.services.graphql.web;

import com.epam.training.miservices.services.graphql.post.Post;
import com.epam.training.miservices.services.graphql.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@SchemaMapping(typeName = "Post")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @QueryMapping(name = "allPosts")
    public Collection<Post> findAll() {
        return postRepository.findAll();
    }

    @MutationMapping(name = "renamePost")
    public Post renamePost(@Argument("id") long id, @Argument("title") String title) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(title);
                    return post;
                })
                .map(postRepository::save)
                .orElseThrow(() -> new RuntimeException("Can't find post"));
    }
}
