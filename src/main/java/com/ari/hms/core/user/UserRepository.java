package com.ari.hms.core.user;

import com.ari.hms.core.user.dto.response.ProfileUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    boolean existsUserByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.deletedAt = CURRENT_TIMESTAMP WHERE u.id = :id")
    void softDeleteById(@Param("id") Long id);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") Role role);

    @Query("Select New com.ari.hms.core.user.dto.response.ProfileUserDto"
            + "(CONCAT(u.firstname, ' ',u.lastname), u.username, u.role) "
            + "From User u Where u.username = :username")
    Optional<ProfileUserDto> getProfileUserById(@Param("username") String username);
}