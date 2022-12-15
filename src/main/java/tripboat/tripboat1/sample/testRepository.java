package tripboat.tripboat1.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tripboat.tripboat1.User.Domain.SiteUser;

@Repository
public interface testRepository extends JpaRepository<SiteUser, Long> {
    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
}

