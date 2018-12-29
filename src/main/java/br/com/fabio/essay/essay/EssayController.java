package br.com.fabio.essay.essay;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/essay")
public class EssayController {
	
	@Autowired
	private EssayRepository repository;
	
    @RequestMapping("formEssay")
    public String formEssay(){
        return "formEssay";
    }
    
    @RequestMapping("list")
    public String listEssays(Model model) {
    	List<Essay> listEssays = repository.findAll();
    	model.addAttribute("essays", listEssays);
    	return "essays";
    }
    
    @RequestMapping(value= "insert", method = RequestMethod.POST)
    public String insert(@RequestParam("name") String name, @RequestParam("content") String content, @RequestParam("grade") Float grade){

        Essay essay = new Essay(name, content, grade);
        Calendar now = Calendar.getInstance();
        essay.setData(now);
        repository.save(essay);

        return "redirect:/essay/list";
    }
   
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") String id){
		Optional<Essay> essay = repository.findById(id);
        repository.delete(essay.get());
        return "redirect:/essay/list";
    }
    
    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("grade") Float grade
    		, @RequestParam("content") String content){
		Optional<Essay> essay = repository.findById(id);
		essay.get().setContent(content);
		essay.get().setName(name);
		essay.get().setGrade(grade);
		Calendar now = Calendar.getInstance();
        essay.get().setData(now);
		repository.save(essay.get());
        return "redirect:/essay/list";
    }
    
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String show(@PathVariable String id, Model model){
		Optional<Essay> essay = repository.findById(id);
		model.addAttribute("essay", essay.get());
        return "formUpdateEssay";
    }
    
}
