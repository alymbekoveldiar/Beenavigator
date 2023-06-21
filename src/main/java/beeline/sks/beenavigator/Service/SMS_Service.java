package beeline.sks.beenavigator.Service;

import beeline.sks.beenavigator.Entity.SMS;
import beeline.sks.beenavigator.Repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SMS_Service {
   private final SMSRepository smsRepository;

    public SMS_Service(SMSRepository smsRepository) {
        this.smsRepository = smsRepository;
    }
    public List<SMS> getAllSMS(){
        return smsRepository.findAll();
    }
    public Optional<SMS> getByIdSMS(Long id){
        return smsRepository.findById(id);
    }
    public SMS createSMS(SMS sms){
        SMS smsObject = new SMS();
        smsObject.setTime(sms.getTime());
        smsObject.setSubject(sms.getSubject());
        smsObject.setTextRu(sms.getTextRu());
        smsObject.setTextKg(sms.getTextKg());
        smsObject.setSubscriber(sms.getSubscriber());
        smsObject.setComments(sms.getComments());
        return smsRepository.save(smsObject);
    }
    public String deleteSms(Long id){
         smsRepository.deleteById(id);
         return "sms"+id+" удален";
    }
    public SMS updateSMS(Long id, SMS sms){
        Optional<SMS> smsOptional = smsRepository.findById(id);
        if (!smsOptional.isEmpty()){
            smsOptional.get().setTime(sms.getTime());
            smsOptional.get().setSubject(sms.getSubject());
            smsOptional.get().setTextRu(sms.getTextRu());
            smsOptional.get().setTextKg(sms.getTextKg());
            smsOptional.get().setSubscriber(sms.getSubscriber());
            smsOptional.get().setComments(sms.getComments());
            return smsRepository.save(smsOptional.get());
        }
        return null;
    }
}
