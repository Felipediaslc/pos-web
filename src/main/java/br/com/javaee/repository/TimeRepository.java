package br.com.javaee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javaee.domain.Time;


/**
 * This use JpaRepository that extends the PagingAndSortingRepository that extends CRUDRepository.
 */
@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
	
}