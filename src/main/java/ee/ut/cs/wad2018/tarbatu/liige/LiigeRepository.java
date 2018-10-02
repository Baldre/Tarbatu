package ee.ut.cs.wad2018.tarbatu.liige;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LiigeRepository extends JpaRepository<Liige, String> {

    @Override
    List<Liige> findAll();

    @Query(value = "SELECT * FROM liikmed WHERE e_post = :e_post",
            nativeQuery = true)
    Liige findByE_post(@Param("e_post") String e_post);

    @Query(value = "select count(e_post) from liikmed", nativeQuery = true)
    int hulk();
}