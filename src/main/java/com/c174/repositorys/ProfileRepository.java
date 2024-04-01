package com.c174.repositorys;

import com.c174.models.user.ProfileEntity;
import com.c174.models.user.ProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
