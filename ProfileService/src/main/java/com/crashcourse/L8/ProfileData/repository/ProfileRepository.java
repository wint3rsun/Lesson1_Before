package com.crashcourse.L8.ProfileData.repository;

import com.crashcourse.L8.ProfileData.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}
