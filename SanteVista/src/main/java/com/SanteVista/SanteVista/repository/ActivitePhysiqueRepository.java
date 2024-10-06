package com.SanteVista.SanteVista.repository;

import com.SanteVista.SanteVista.domain.ActivitePhysique;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivitePhysiqueRepository extends JpaRepository<ActivitePhysique, Long> {
//    List<ActivitePhysique> findByUserId(String userId);
//    @Query("SELECT a FROM ActivitePhysique a JOIN a.userIds u WHERE u = :userId")
//    List<ActivitePhysique> findByUserIdInList(@Param("userId") String userId);
//    @Query("SELECT a FROM ActivitePhysique a JOIN a.userIds u WHERE u IN :userIds")
//    List<ActivitePhysique> findByUserIds(@Param("userIds") String[] userIds);

    @Query("SELECT a FROM ActivitePhysique a JOIN a.userIds u WHERE u = :userId")
    List<ActivitePhysique> findByUserId(@Param("userId") String userId);

}
