package beeline.sks.beenavigator.Controller;

import beeline.sks.beenavigator.AppError;
import beeline.sks.beenavigator.Entity.Privet;
import beeline.sks.beenavigator.Service.PrivetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Tag(name = "Privet")
@RequestMapping("/privet")
public class PrivetController {
   private final PrivetService privetService;

    public PrivetController(PrivetService privetService) {
        this.privetService = privetService;
    }

    @GetMapping("/getAll")
    List<Privet> getAll() {
        return privetService.getAllPrivet();
    }

    @GetMapping("title/{name}")
    List<Privet> getAllParamTitle(@PathVariable String name) {
        return privetService.getParamTitle(name);
    }
    @GetMapping("/getById/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Optional<Privet> result = privetService.getByIdPrivet(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "такой "+id+" не существует"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public Privet create(@RequestBody Privet privet) {
        return privetService.create(privet);
    }


    @PostMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            String result = privetService.deletePrivetById(id);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "номер "+id+" не существует"), HttpStatus.OK);
        }
    }

    @PostMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable Long id,@RequestBody Privet privet) {
        try {
            Privet result = privetService.updatePrivet(id,privet);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    " "+privet.getId()+" не обновился"), HttpStatus.OK);
        }
    }

}
