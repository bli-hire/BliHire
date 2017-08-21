package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.MppDetail;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.MppDetailRequest;
import com.empatkepala.repository.MppDetailRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.MppDetailService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juan on 8/4/17.
 */

@Service
public class MppDetailServiceImpl implements MppDetailService{


    @Autowired
    MppDetailRepository mppDetailRepository;

    @Autowired
    MppRepository mppRepository;

    @Override
    public boolean editMppDetail(Long mppDetailId, MppDetailRequest mppDetailRequest, User editor) {
        MppDetail toEdit = mppDetailRepository.findOne(mppDetailId);

        toEdit.setJanuaryExpect(mppDetailRequest.getExpectJoin().getJanuaryExpect());
        toEdit.setFebruaryExpect(mppDetailRequest.getExpectJoin().getFebruaryExpect());
        toEdit.setMarchExpect(mppDetailRequest.getExpectJoin().getMarchExpect());
        toEdit.setAprilExpect(mppDetailRequest.getExpectJoin().getAprilExpect());
        toEdit.setMayExpect(mppDetailRequest.getExpectJoin().getMayExpect());
        toEdit.setJuneExpect(mppDetailRequest.getExpectJoin().getJuneExpect());
        toEdit.setJulyExpect(mppDetailRequest.getExpectJoin().getJulyExpect());
        toEdit.setAugustExpect(mppDetailRequest.getExpectJoin().getAugustExpect());
        toEdit.setSeptemberExpect(mppDetailRequest.getExpectJoin().getSeptemberExpect());
        toEdit.setOctoberExpect(mppDetailRequest.getExpectJoin().getOctoberExpect());
        toEdit.setNovemberExpect(mppDetailRequest.getExpectJoin().getNovemberExpect());
        toEdit.setDecemberExpect(mppDetailRequest.getExpectJoin().getDecemberExpect());

        toEdit.setPosition(mppDetailRequest.getPosition());
        toEdit.setEducation(mppDetailRequest.getEducation());
        toEdit.setEmployeeStatus(mppDetailRequest.getEmployeeStatus());

        toEdit.setExpectedJoinAndNumberOfPersonTotal();

        toEdit.setKnowledge(mppDetailRequest.getKnowledge());
        toEdit.setMainResponsibility(mppDetailRequest.getMainResponsibility());
        toEdit.setPcAmmount(mppDetailRequest.getPcAmmount());
        toEdit.setPcSpec(mppDetailRequest.getPcSpec());
        toEdit.setReason(mppDetailRequest.getReason());

        Mpp parentMpp = toEdit.getMpp();
        parentMpp.setEditedDate(new DateTime());
        parentMpp.setEditedBy(editor);
        mppRepository.save(parentMpp);

        mppDetailRepository.save(toEdit);


        return true;
    }
}
