package test45.repository;


import org.springframework.data.repository.CrudRepository;
import test45.Post;

public interface PostRepository extends CrudRepository
        <Post, Long> {
}
