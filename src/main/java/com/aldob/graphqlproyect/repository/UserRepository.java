package com.aldob.graphqlproyect.repository;

import com.aldob.graphqlproyect.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByUsuario(String usuario);

}
