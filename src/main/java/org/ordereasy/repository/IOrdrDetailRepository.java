package org.ordereasy.repository;

import org.ordereasy.models.OrdrDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdrDetailRepository extends JpaRepository<OrdrDetail, Integer> {
}
