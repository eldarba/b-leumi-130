package app.core.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
