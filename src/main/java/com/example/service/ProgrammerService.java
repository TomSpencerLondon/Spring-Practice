package com.example.service;

import com.example.database.Database;
import com.example.entity.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class ProgrammerService {
    @Autowired
    private Database database;

    public Programmer getProgrammerById(int id){
        return this.database.getProgrammerById(id);
    }
    public void deleteProgrammerById(int id) throws IOException {
        this.database.deleteProgrammerById(id);
    }

    public Collection<Programmer> getProgrammers(){
        return this.database.getProgrammers();
    }
    public void PutProgrammer(Programmer ProgrammerObject) throws IOException {
        this.database.PutProgrammer(ProgrammerObject);
    }
    public void ChangeProgrammer(Programmer ProgrammerObject) throws IOException {
        this.database.ChangeProgrammer(ProgrammerObject);
    }
}
