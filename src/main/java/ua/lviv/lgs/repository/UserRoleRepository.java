package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
//    @Query("select a.name from user_roles a, user b where b.name=?1 and a.user_id=b.id")

    @Query(value = "select r.name from user_roles r, user u where u.name=? and r.user_id=u.id", nativeQuery = true)
    List<String> findRoleByUserName(String username);
}
