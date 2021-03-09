package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Name;
import repo.NameRepo;

@Service
public class NameService {
    @Autowired
    private NameRepo nameRepo;

    public List<Name> findAll() {
        return nameRepo.findAll();
    }

    public Optional<Name> findOne(Long id) {
        return nameRepo.findById(id);
    }
    public Name save(Name name) {
        return nameRepo.save(name);
    }

    public void delete(Long id) {
        nameRepo.deleteById(id);
    }
}