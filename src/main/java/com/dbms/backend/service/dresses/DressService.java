package com.dbms.backend.service.dresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.dbms.backend.models.dresses.DressDetails;
import com.dbms.backend.repo.dresses.DressRepo;

@Service
public class DressService {

    @Autowired
    DressRepo dressRepo;


    public void addDress(DressDetails dressDetails) {
        try{
            dressRepo.addDress(dressDetails);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateDress(int id, DressDetails dressDetails) {
        try{
            dressRepo.updateDress(id, dressDetails);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<DressDetails> getDress() {
        try{
            return dressRepo.getDress();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
