package kr.jmd.spring_starter.infrastructure.persistent;

import kr.jmd.spring_starter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {
}
