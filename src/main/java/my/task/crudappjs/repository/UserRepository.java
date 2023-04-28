package my.task.crudappjs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import my.task.crudappjs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u FROM User u join fetch u.roles where u.username =:username")
    User findByUsername(@Param("username") String username);

    default void merge(User user) {
        save(user);
    }
}

