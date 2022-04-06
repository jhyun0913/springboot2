package springboot.domain.posts;




import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import springboot.domain.posts.Posts;
//
//import java.util.List;
//
//public interface PostsRepository extends JpaRepository<Posts,Long> {
//
//    @Query("SELCT p from Posts p ORDER BY p.id DESC")
//    List<Posts> findAllDesc();
//}