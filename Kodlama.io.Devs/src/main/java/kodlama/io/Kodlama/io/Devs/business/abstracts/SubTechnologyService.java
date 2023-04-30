package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subTechnologyRequest.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetAllSubTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subTechnologyResponse.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	List<GetAllSubTechnologyResponse> getAll();
	GetByIdSubTechnologyResponse getById(int id);
	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest ) throws Exception;
	void delete(int id) throws Exception;
}
