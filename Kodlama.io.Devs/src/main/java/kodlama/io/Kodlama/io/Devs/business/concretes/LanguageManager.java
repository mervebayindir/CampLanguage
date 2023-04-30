package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.languagesRequest.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.languageResponse.GetByIdLanguageResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<Language> languages=languageRepository.findAll();
		
		List<GetAllLanguageResponse> languagesResponse = languages.stream()
				.map(language -> this.modelMapperService.forResponse()
						.map(language, GetAllLanguageResponse.class)).collect(Collectors.toList());
		return languagesResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) throws Exception {
		
		Language language = this.languageRepository.findById(id).orElseThrow();
		GetByIdLanguageResponse languageResponse = this.modelMapperService.forResponse()
				.map(language, GetByIdLanguageResponse.class);
		return languageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createlanguageRequest) throws Exception {
		
		Language language = modelMapperService.forRequest().map(createlanguageRequest, Language.class);
		
//		if(isIdExist(language.getId())) throw new Exception("Id tekrar edemez");
//		if (isNameExist(language)) throw new Exception("Programlama dilleri tekrar edemez..!");
//		languageRepository.save(language);
		
		if (languageRepository.equals(language.getName()))throw new Exception("Programlama dilleri tekrar edilemez..!");
		languageRepository.save(language);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		Language language = modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
		
//		if (!isIdExist(language.getId())) throw new Exception("Id bulunamadı.");
//		Language languages= languageRepository.findById(language.getId()).get();
//		if (isNameExist(languages)) throw new Exception("Programlama dili tekrar edilemez..!");
//		languageRepository.save(languages);
		
		if(!languageRepository.existsById(language.getId())) throw new Exception("Id bulunamadı");
		if (languageRepository.equals(language.getName())) throw new Exception("Programlama dilleri tekrar edilemez..!");
		languageRepository.save(language);
	}

	@Override
	public void delete(int id) throws Exception {
		languageRepository.deleteById(id);
		
	}
	
//	public boolean isNameExist(Language language) {
//		for(Language language1: languageRepository.findAll()) {
//			if (language.getName().equals((language1.getName()))) {
//				return true;
//			}
//		}
//		return false;
//	}
////	
//	public boolean isIdExist(int id) {
//		for(Language language1: languageRepository.findAll()) {
//			if (language1.getId() == id) {
//				return true;
//			}
//		}
//		return false;
//	}
}
