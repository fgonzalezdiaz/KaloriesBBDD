package com.kalories.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kalories.demo.logging.CustomLogging;
import com.kalories.demo.model.User;
import com.kalories.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        CustomLogging.info("Consultant tots els users", "UserService", "findAll");
        return userRepository.findAll();
    }

    public User findById(Long id) {
        CustomLogging.info("Consultant user per id", "UserService", "findById");
        List<User> users = userRepository.findById(id);
        if (users.isEmpty()) {
            CustomLogging.error("L'usuari amb id = " + id + " no existeix", "UserSerice", "findOne");
        }
        return users.get(0);
    }

    public String uploadCsvUsers(MultipartFile csvFile) throws Exception{
        int usersCreats = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] arguments = line.split(",");
                // Cambiar el formato de las entradas arguments
                usersCreats += userRepository.save();
            }
        } catch{

        }
    }
}
