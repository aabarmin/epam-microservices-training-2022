package com.epam.training.miservices.services.graphql.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.InputStream;
import java.util.List;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostLoader implements CommandLineRunner {
  private final ObjectMapper objectMapper;

  private final PostRepository postRepository;

  private final AuthorRepository authorRepository;

  @Override
  public void run(String... args) throws Exception {
    @Cleanup final InputStream contentStream = new ClassPathResource("content.json").getInputStream();
    final ObjectReader reader = objectMapper.readerForListOf(DataModel.class);
    final List<DataModel> items = reader.readValue(contentStream);
    for (DataModel item : items) {
      final Author author = new Author();
      author.setFirstName(item.getFirstName());
      author.setLastName(item.getLastName());

      final Author savedAuthor = authorRepository.save(author);

      final Post post = new Post();
      post.setAuthor(savedAuthor);
      post.setTitle(item.getTitle());
      post.setText(item.getText());

      postRepository.save(post);
    }
  }
}
