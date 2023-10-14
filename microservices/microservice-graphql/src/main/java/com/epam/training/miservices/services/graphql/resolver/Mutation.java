package com.epam.training.miservices.services.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.epam.training.miservices.services.graphql.post.Post;
import com.epam.training.miservices.services.graphql.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
  private final PostRepository postRepository;

  public Post renamePost(Integer id, String title) {
    final Post post = postRepository.findById(id.longValue()).get();
    post.setTitle(title);
    return postRepository.save(post);
  }
}
