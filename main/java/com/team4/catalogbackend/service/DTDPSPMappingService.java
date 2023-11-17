package com.team4.catalogbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.catalogbackend.dao.DTDPMappingRepository;
import com.team4.catalogbackend.dao.DTDPSPMappingRepository;
import com.team4.catalogbackend.dao.ProcessRepository;
import com.team4.catalogbackend.model.DTDPMapping;
import com.team4.catalogbackend.model.DTDPSPMapping;
import com.team4.catalogbackend.model.DTMapping;
import com.team4.catalogbackend.model.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import com.team4.catalogbackend.model.Process;
@Service
public class DTDPSPMappingService {

    private DTDPSPMappingRepository dtdpspMappingRepository;
    private ProcessRepository processRepository;
    
    public List<DTDPSPMapping> getAllDTDPSPMappings() {
        return dtdpspMappingRepository.findAll();
    }

    public Optional<DTDPSPMapping> getDTDPSPMappingById(Long id) {
        return dtdpspMappingRepository.findById(id);
    }

    public DTDPSPMapping saveDTDPSPMapping(DTDPSPMapping dtdpspMapping) {
        return dtdpspMappingRepository.save(dtdpspMapping);
    }

    public void deleteDTDPSPMapping(Long id) {
        dtdpspMappingRepository.deleteById(id);
    }

	public List<HashMap<String, String>> GetMappedSubProcess(long processid) {
		// TODO Auto-generated method stub
		
		Process process = processRepository.findById(processid).get();
		List<DTDPMapping> DtdpMappings = dtdpspMappingRepository.findByDtdpMappingId(process);
		
		ArrayList<HashMap<String, String>>technologies = new ArrayList<>();
		
		for(int i  = 0 ; i<DtMappings.size() ; i++) {
			
			HashMap<String, String>technology = new HashMap<String, String>();
			
			Long tech_id = DtMappings.get(i).getDtMappingId();
			
			String tech_name = DtMappings.get(i).getTechnology().getTechnologyName();
			technology.put("id", tech_id.toString());
			String technology_temp = "technology";
			technology.put(technology_temp, tech_name);
			
			technologies.add(technology);
			
		}
		return technologies;
	}
    
    
}
