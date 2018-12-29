package br.com.javaee.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaee.domain.Time;
import br.com.javaee.repository.TimeRepository;
import br.com.javaee.exception.TimeNotFoundException;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class TimeControllerApi {
	@Autowired
	TimeRepository timeRepository;

	@GetMapping("/times")
	public List<Time> getAllTimes() {
		return timeRepository.findAll();
	}

	@GetMapping("/times/{id}")
	public Time getTimeById(@PathVariable(value = "id") Long id) {
		return timeRepository.findById(id)
				.orElseThrow(() -> new TimeNotFoundException("Time", "id", id));
	}

	@PostMapping("/times")
	public Time createTime(@Valid @RequestBody Time time) {
		return timeRepository.save(time);
	}

	@PutMapping("/times/{id}")
	public Time updateTime(@PathVariable(value = "id") Long id, @Valid @RequestBody Time timeDetails) {

		Time time = timeRepository.findById(id)
				.orElseThrow(() -> new TimeNotFoundException("Time", "id", id));

		time.setNome(timeDetails.getNome());
		time.setTecnico(timeDetails.getTecnico());
		

		Time updatedTime = timeRepository.save(time);
		return updatedTime;
	}

	@DeleteMapping("/times/{id}")
	public ResponseEntity<Time> deleteTime(@PathVariable(value = "id") Long id) {

		Time time = timeRepository.findById(id)
				.orElseThrow(() -> new TimeNotFoundException("Time", "id", id));

		timeRepository.delete(time);
		return ResponseEntity.ok().build();
	}
}
