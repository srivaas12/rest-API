package example1.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example1.example.model.Model;
import example1.example.repository.Repository;

@Service
public class Service1
{
    @Autowired
    Repository ab;

    public Model create(Model user)
    {
        return ab.save(user);
    }

    public List<Model> getAllUsers()
    {
        return ab.findAll();
    }

    public Model getModelById(int id)
    {
        return ab.findById(id).orElse(null);
    }
    
    public boolean updateDetails(int id,Model u)
    {
        if(this.getModelById(id)==null)
        {
            return false;
        }
        try{
            ab.save(u);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    public boolean deleteUser(int id)
    {
        if(this.getModelById(id)==null)
        {
            return false;
        }
        ab.deleteById(id);
        return true;
    }
}
