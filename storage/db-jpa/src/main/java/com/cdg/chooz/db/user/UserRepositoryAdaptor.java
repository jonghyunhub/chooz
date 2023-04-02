package com.cdg.chooz.db.user;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserRepositoryAdaptor implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existsByProviderId(String providerId) {
        return false;
    }

    @Override
    public void register(User user) {
        UserEntity userEntity = new UserEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public User findByProviderId(String providerId) {
        return userJpaRepository.findByProviderId(providerId)
                .map(UserEntity::toDomain)
                .orElse(null);
    }
}