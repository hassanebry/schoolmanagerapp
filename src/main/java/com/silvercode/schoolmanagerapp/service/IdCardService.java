package com.silvercode.schoolmanagerapp.service;


import com.silvercode.schoolmanagerapp.model.IdCard;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.repository.IdCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IdCardService {

    private final IdCardRepository idCardRepository;

    public List<IdCard> getAllCards(){
        return idCardRepository.findAll();
    }

    public IdCard getCardByStudentId(Long studentId){
        return idCardRepository.findByStudentId(studentId);
    }

    public void deleteIdCard(Long id){
        idCardRepository.deleteById(id);
    }
}
