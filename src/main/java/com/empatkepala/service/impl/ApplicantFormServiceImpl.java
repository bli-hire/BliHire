package com.empatkepala.service.impl;

import com.empatkepala.entity.ApplicantForm;
import com.empatkepala.repository.ApplicantFormRepository;
import com.empatkepala.service.ApplicantFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicantFormServiceImpl implements ApplicantFormService {

    @Autowired
    ApplicantFormRepository applicantFormRepository;

    @Override
    public ApplicantForm trackApplicationById(Long id){
        ApplicantForm applicantForm =  applicantFormRepository.findOne(id);
        return applicantForm;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveApplication(ApplicantForm applicantForm) {
        applicantFormRepository.save(applicantForm);
    }

}
