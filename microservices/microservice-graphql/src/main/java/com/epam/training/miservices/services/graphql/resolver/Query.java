package com.epam.training.miservices.services.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.epam.training.miservices.services.graphql.post.Post;
import com.epam.training.miservices.services.graphql.post.PostRepository;
import com.epam.training.miservices.services.graphql.service.DrugModel;
import com.epam.training.miservices.services.graphql.service.DrugServiceFeignClient;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
  private final PostRepository postRepository;

  private final DrugServiceFeignClient drugService;

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Collection<DrugModel> getAllDrugs() {
    return drugService.findAll().getContent();
  }
}
