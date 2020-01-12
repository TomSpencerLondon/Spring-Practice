package com.example.database;

import com.example.entity.Programmer;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Database {
//    private static final Map<Integer, Programmer> programmers = new HashMap<Integer, Programmer>();
//    static {
//        programmers.put(1, new Programmer("Tom", 1));
//        programmers.put(2, new Programmer("Alex", 2));
//        programmers.put(3, new Programmer("Joe", 3));
//        programmers.put(4, new Programmer("David", 4));
//        programmers.put(5, new Programmer("James", 5));
//    }
    private static Map<Integer, Programmer> programmers;

    static {
        TextDatabase.retrieveData();
        programmers = TextDatabase.getProgrammers();
    }

    public Programmer getProgrammerById(int id){
        return programmers.get(id);
    }

    public void PutProgrammer(Programmer ProgrammerObject) throws IOException {
//        programmers.put(ProgrammerObject.getId(), ProgrammerObject);
        TextDatabase.putData(ProgrammerObject);
        programmers = TextDatabase.getProgrammers();
    }

    public void ChangeProgrammer(Programmer ProgrammerObject) throws IOException {
//        programmers.put(ProgrammerObject.getId(), ProgrammerObject);
        TextDatabase.putData(ProgrammerObject);
        programmers = TextDatabase.getProgrammers();
    }

    public void deleteProgrammerById(int id) throws IOException {
//        return programmers.remove(id);
        TextDatabase.deleteDataById(id);
        programmers = TextDatabase.getProgrammers();
    }


    public Collection<Programmer> getProgrammers(){
        return programmers.values();
    }

}
