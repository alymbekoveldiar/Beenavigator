package beeline.sks.beenavigator.Service;

import beeline.sks.beenavigator.Entity.Privet;
import beeline.sks.beenavigator.Repository.PrivetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PrivetService {
   private final PrivetRepository privetRepository;

    public PrivetService(PrivetRepository privetRepository) {
        this.privetRepository = privetRepository;
    }

    public List<Privet> getParamTitle(String name) {
        return privetRepository.getAllByName(name);
    }

    public Privet create(Privet privet) {
        setPrivet(privet);
        return privet;
    }

    public List<Privet> getAllPrivet() {
        return privetRepository.findAll();
    }

    public Optional<Privet> getByIdPrivet(Long id) {
        return privetRepository.findById(id);
    }

    public String deletePrivetById(Long id) {
        privetRepository.deleteById(id);
        return "Пользователь" + id + " удален из базы";
    }

    public Privet updatePrivet( Long id, Privet privet) {
        Optional<Privet> privet1 = privetRepository.findById(privet.getId());
        if (privet1.isEmpty()) return null;
        privet1.get().setCode(privet.getCode());
        privet1.get().setAuthor(privet.getAuthor());
        privet1.get().setTitle(privet.getTitle());
        privet1.get().setGenre(privet.getGenre());
        return privetRepository.save(privet1.get());
    }

    public Privet setPrivet(Privet privet) {
        Privet privet1 = new Privet();
        privet1.setAuthor(privet.getAuthor());
        privet1.setCode(privet.getCode());
        privet1.setTitle(privet.getTitle());
        privet1.setGenre(privet.getGenre());
        return privetRepository.save(privet);
    }

}
