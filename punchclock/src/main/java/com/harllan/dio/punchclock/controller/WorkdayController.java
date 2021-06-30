package com.harllan.dio.punchclock.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.punchclock.entity.Workday;
import com.harllan.dio.punchclock.service.WorkdayService;

@RestController
@RequestMapping("/workday")
public class WorkdayController implements WorkdayControllerDocs {
	
	@Autowired
	WorkdayService workdayService;
	
	@GetMapping
	public List<Workday> getWorkdayList(){
	    return workdayService.findAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Workday> getWorkdayById(@PathVariable("id") Long id) throws Exception {
        return  ResponseEntity.ok(workdayService.getById(id).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }
	
	@PostMapping
    public Workday create(@RequestBody Workday workday){
        return workdayService.save(workday);
    }

    @PutMapping
    public Workday update(@RequestBody Workday workday){
        return workdayService.update(workday);
    }

	@DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) throws Exception {
       try {
    	   workdayService.delete(id);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

}
