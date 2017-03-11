package com.empatkepala.service;

import com.empatkepala.entity.ApplicantForm;


public interface ApplicantFormService {

    ApplicantForm trackApplicationById(Long id);

    void saveApplication(ApplicantForm applicantForm);

}
