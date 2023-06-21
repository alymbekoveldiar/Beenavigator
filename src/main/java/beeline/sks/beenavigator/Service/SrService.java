package beeline.sks.beenavigator.Service;

import beeline.sks.beenavigator.Entity.Privet;
import beeline.sks.beenavigator.Entity.ServiceRequest;
import beeline.sks.beenavigator.Repository.PrivetRepository;
import beeline.sks.beenavigator.Repository.SrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SrService {
    private final   SrRepository srRepository;
    public SrService(SrRepository srRepository) {
        this.srRepository = srRepository;
    }


    public String saveSR(ServiceRequest serviceRequest) {
        ServiceRequest serviceRequestObject = new ServiceRequest();
        serviceRequestObject.setId(serviceRequest.getId());
        serviceRequestObject.setName(serviceRequest.getName());
        srRepository.save(serviceRequestObject);
        return "Пользователь " + serviceRequest.getName() + " добавлен в базу";
    }

    public List<ServiceRequest> getAll() {
        return srRepository.findAll();
    }

    public ServiceRequest getById(Long id) {
        return srRepository.findById(id).get();
    }

    public String deleteById(Long id) {
        srRepository.deleteById(id);
        return "Пользователь " + id + " успешно удалён";
    }

    public ServiceRequest update(Long id, ServiceRequest serviceRequest) {
        Optional<ServiceRequest> service = srRepository.findById(id);
        if (service.isEmpty()) return null;
        service.get().setName(serviceRequest.getName());
        return srRepository.save(service.get());
    }


    public List<ServiceRequest> getParam(String name) {
        return srRepository.getAllByName("%" + name + "%");
    }


}
