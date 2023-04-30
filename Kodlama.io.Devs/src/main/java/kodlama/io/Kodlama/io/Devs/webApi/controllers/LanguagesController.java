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


import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
	
	private LanguageService languagesService;
	
	@GetMapping()
	public List<GetAllLanguageResponse> getAll(){
		return languagesService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdLanguageResponse getById(@PathVariable int id) throws Exception{
		return languagesService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateLanguageRequest createlanguageRequest) throws Exception{
		languagesService.add(createlanguageRequest);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest )throws Exception{
		languagesService.update(updateLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)throws Exception{
		languagesService.delete(id);
	}
}
