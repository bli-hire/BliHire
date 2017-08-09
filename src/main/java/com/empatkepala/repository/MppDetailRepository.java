package com.empatkepala.repository;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.MppDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Juan on 8/4/17.
 */
@Repository
public interface MppDetailRepository extends JpaRepository<MppDetail, Long> {
    Collection<MppDetail> findByMpp(Mpp mpp);
    Collection<MppDetail> findByMpp_Id(Long id);
}
