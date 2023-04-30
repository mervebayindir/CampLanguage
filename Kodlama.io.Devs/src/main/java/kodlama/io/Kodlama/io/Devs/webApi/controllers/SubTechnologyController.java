package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetAllSubTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetByIdSubTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subtechnoloy")
@AllArgsConstructor
public class SubTechnologyController {
	
	private SubTechnologyService subTechbologyService;
	
	@GetMapping()
	public List<GetAllSubTechnologyResponse> getAll(){
		return subTechbologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdSubTechnologyResponse getById(@PathVariable int id)  throws Exception{
		return subTechbologyService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		subTechbologyService.add(createSubTechnologyRequest);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		subTechbologyService.update(updateSubTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) throws Exception {
		subTechbologyService.delete(id);
	}
	
	
}
