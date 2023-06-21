package beeline.sks.beenavigator.Controller;

import beeline.sks.beenavigator.AppError;
import beeline.sks.beenavigator.Entity.Privet;
import beeline.sks.beenavigator.Entity.ServiceRequest;
import beeline.sks.beenavigator.Repository.PrivetRepository;
import beeline.sks.beenavigator.Service.PrivetService;
import beeline.sks.beenavigator.Service.SrService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Tag(name = "ServiceRequest")
@RequestMapping("/ServiceRequest")
public class SRController {
  private final SrService srService;

    public SRController(SrService srService) {
        this.srService = srService;
    }

    @GetMapping("getAll")
    List<ServiceRequest> getAll() {
        return srService.getAll();
    }

    @PostMapping("create")
    public String create(@RequestBody ServiceRequest serviceRequest) {
        srService.saveSR(serviceRequest);
        return "Пользователь " + serviceRequest.getName() + " сохранен";
    }

    @GetMapping("getById/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            ServiceRequest s = srService.getById(id);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "такой "+id+" не существует"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            String serviceRequest = srService.deleteById(id);
            return new ResponseEntity<>(serviceRequest,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "такой "+id+" не существует"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("update/{id}/")
    ResponseEntity<?> update(@PathVariable Long id , @RequestBody ServiceRequest serviceRequest) {
        try {
            ServiceRequest serviceRequest1 = srService.update(id, serviceRequest);
            return new ResponseEntity<>(serviceRequest1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "такой "+id+" не существует"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("meaning/{name}")
    List<ServiceRequest> getAllParam(@PathVariable String name) {
        return srService.getParam(name);
    }


}
