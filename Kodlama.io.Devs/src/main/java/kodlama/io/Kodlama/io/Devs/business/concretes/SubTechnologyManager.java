package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetAllSubTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetByIdSubTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.SubTechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {
	
	private SubTechnologyRepository subTechnologyRepository;
	
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();//findAll=>GetAll, findAll(Example<S> example) =>filtreleme, existsById(ınteger)=>Id varmı yokmu findById=>Id ye gore getirme count=>sayısını verır, getById=>belli bir şarta göre bir tane bulmayı
		
		List<GetAllSubTechnologyResponse> subTechnologyResponse = subTechnologies.stream()
			.map(subTechnology -> this.modelMapperService.forResponse()
				.map(subTechnology, GetAllSubTechnologyResponse.class)).collect(Collectors.toList());
		return subTechnologyResponse;
	}

	@Override
	public GetByIdSubTechnologyResponse getById(int id) {
		
		SubTechnology subTechnology = subTechnologyRepository.findById(id).orElseThrow();
		
		GetByIdSubTechnologyResponse subTechnologyResponse = this.modelMapperService.forResponse()
				.map(subTechnology, GetByIdSubTechnologyResponse.class);
		return subTechnologyResponse;
		
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = modelMapperService.forRequest().map(createSubTechnologyRequest, SubTechnology.class);	
		if(subTechnologyRepository.equals(subTechnology.getName())) throw new Exception("Programlama alt dalları tekrar edilemez..!");
		subTechnologyRepository.save(subTechnology);
		
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = modelMapperService.forRequest().map(updateSubTechnologyRequest, SubTechnology.class);
		
		if(!subTechnologyRepository.existsById(subTechnology.getId()))  throw new Exception ("Id tekrar edemez");
		if (subTechnologyRepository.equals(subTechnology.getName())) throw new Exception ("Programlama alt dalları tekrar edilemez..!");
		subTechnologyRepository.save(subTechnology);
	}

	@Override
	public void delete(int id) throws Exception {
		subTechnologyRepository.deleteById(id);
		
	}

}
