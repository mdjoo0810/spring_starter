package kr.jmd.spring_starter.application;

import kr.jmd.spring_starter.infrastructure.persistent.UserJpaRepo;
import kr.jmd.spring_starter.interfaces.config.advice.CUserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}
