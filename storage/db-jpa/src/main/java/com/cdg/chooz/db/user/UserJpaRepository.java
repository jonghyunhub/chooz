package com.cdg.chooz.db.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long Id);

    Optional<UserEntity> findByProviderId(String providerId);

    Boolean existsByProviderId(String providerId);
}
