package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.School;
import app.core.reposotories.SchoolRepository;

@Service
@Transactional
public class MyService {

	@Autowired
	private SchoolRepository schoolRepository;

	// save school (will also save the address)
	public int createSchool(School school) {
		if (!schoolRepository.existsById(school.getId())) {
			school = schoolRepository.save(school);
			return school.getId();
		} else {
			throw new RuntimeException("createSchool failed - already exists: " + school.getId());
		}
	}

	// fetch school (will also fetch the address)
	public School getSchoole(int id) {
		return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("getSchoole failed - not found"));
	}

	// update school (will also update the address)
	public void updateSchool(School school) {
		if (schoolRepository.existsById(school.getId())) {
			school = schoolRepository.save(school);
		} else {
			throw new RuntimeException("updateSchool failed - not exists: " + school.getId());
		}
	}
	// delete school (will also delete the address)

}
