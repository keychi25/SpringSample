package contoroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Name;
import service.NameService;

@Controller
public class NameController {

  @Autowired
  private NameService nameService;

  @GetMapping
  public String index(Model model) {
      List<Name> names = nameService.findAll();
      model.addAttribute("names", names);
      return "names/index";
  }

  @GetMapping("new")
  public String newname(Model model) {
      return "names/new";
  }

  @GetMapping("{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
      Optional<Name> name = nameService.findOne(id);
      model.addAttribute("name", name);
      return "names/edit";
  }

  @GetMapping("{id}")
  public String show(@PathVariable Long id, Model model) {
      Optional<Name> name = nameService.findOne(id);
      model.addAttribute("name", name);
      return "names/show";
  }

  @PostMapping
  public String create(@ModelAttribute Name name) {
      nameService.save(name);
      return "redirect:/names";
  }

  @PutMapping("{id}")
  public String update(@PathVariable Long id, @ModelAttribute Name name) {
      name.setId(id);
      nameService.save(name);
      return "redirect:/names";
  }

  @DeleteMapping("{id}")
  public String destroy(@PathVariable Long id) {
      nameService.delete(id);
      return "redirect:/names";
  }
}