package tripboat.tripboat1.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import tripboat.tripboat1.User.Domain.SiteUser;

import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);

}