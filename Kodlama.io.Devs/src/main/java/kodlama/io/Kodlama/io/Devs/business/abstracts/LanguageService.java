package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponse getById(int id) throws Exception;
	void add(CreateLanguageRequest createlanguageRequest) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	void delete(int id) throws Exception;
	
}
