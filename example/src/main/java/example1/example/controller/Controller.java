package example1.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example1.example.model.Model;
import example1.example.service.Service1;

@RestController
public class Controller
{
    @Autowired
    Service1 userService;

    @PostMapping("api/user/post")
    public ResponseEntity<Model>createUser(@RequestBody Model user)
    {
        Model createdUser=userService.create(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @GetMapping("api/user/getdetails")
    public ResponseEntity<List<Model>> show()
    {
        List<Model>obj=userService.getAllUsers();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PutMapping("/api/user/{userid}")
    public ResponseEntity<Model> updateUser(@PathVariable("userid") int id,@RequestBody Model updateRequest)
    {
        if(userService.updateDetails(id, updateRequest)==true)
        {
            return new ResponseEntity<>(updateRequest,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/user/{userid}")
    public ResponseEntity<Boolean>delete(@PathVariable("userid") int id)
    {
        if(userService.deleteUser(id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
