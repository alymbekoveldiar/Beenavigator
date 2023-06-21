package beeline.sks.beenavigator.Controller;

import beeline.sks.beenavigator.AppError;
import beeline.sks.beenavigator.Entity.SMS;
import beeline.sks.beenavigator.Service.SMS_Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Tag(name = "SMS")
@RequestMapping("/SMS")
public class SMSController {
   private final SMS_Service smsService;

    public SMSController(SMS_Service smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/getAll")
    List<SMS> getAllSMS() {
        return smsService.getAllSMS();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById_SMS(@PathVariable Long id) {
        try {
            SMS sms = smsService.getByIdSMS(id).get();
            return new ResponseEntity<>(sms, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "номер "+id+" не найдено"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    SMS createSMS(@RequestBody SMS sms) {
      return  smsService.createSMS(sms);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SMS sms) {
        try {
            SMS result = smsService.updateSMS(id, sms);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "  " +id+ " не обновился"),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteSMS(@PathVariable Long id) {
        try {
            String s = smsService.deleteSms(id);
            return new ResponseEntity<>(s, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    " номер " +id+ " не найден в базе"),HttpStatus.NOT_FOUND);
        }
    }
}
