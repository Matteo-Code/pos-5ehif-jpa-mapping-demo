package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, PersonRole.PersonRoleId> {}
