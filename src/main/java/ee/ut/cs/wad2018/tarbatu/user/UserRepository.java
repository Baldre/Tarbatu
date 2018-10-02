package ee.ut.cs.wad2018.tarbatu.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * FROM users
    List<User> findAll();

    @Query(value = "SELECT * FROM users WHERE userid = :userid", nativeQuery = true)
    User findByUserId(@Param("userid") Long userid);
}