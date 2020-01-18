package com.example.controller;

import com.example.entity.Programmer;
import com.example.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping("/programmers")
public class Controller {
    @Autowired
    private ProgrammerService service;
    private Programmer programmerObject;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Programmer getProgrammerById(@PathVariable("id") int id){

        return this.service.getProgrammerById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Programmer> getProgrammers(){

        return this.service.getProgrammers();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void PutProgrammer(@RequestBody Programmer ProgrammerObject) throws IOException {
        this.service.PutProgrammer(ProgrammerObject);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void ChangeProgrammer(@RequestBody Programmer ProgrammerObject) throws IOException {
        programmerObject = ProgrammerObject;
        this.service.ChangeProgrammer(ProgrammerObject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProgrammerById(@PathVariable("id") int id) throws IOException {
        this.service.deleteProgrammerById(id);
    }
}
