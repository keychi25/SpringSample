package contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Name;
import repo.NameRepo;

@Controller
public class NameController {

  @Autowired // This means to get the bean called nameRepo
  private NameRepo nameRepo;

  @PostMapping("/add")
  public @ResponseBody String addNewName (@RequestParam String name) {

    Name n = new Name();
    n.setName(name);
    nameRepo.save(n);
    return "Saved";
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<Name> getAllName() {
    // This returns a JSON or XML with the users
    return nameRepo.findAll();
  }
}