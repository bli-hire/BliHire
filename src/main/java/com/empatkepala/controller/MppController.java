package com.empatkepala.controller;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.MppDetail;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.ApproveRejectMppRequest;
import com.empatkepala.entity.request.MppDetailRequest;
import com.empatkepala.entity.response.MppResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.JobVacancyService;
import com.empatkepala.service.MppDetailService;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@RestController
@RequestMapping(value = "/mpp")
@CrossOrigin(origins = "*")
public class MppController {
    @Autowired
    private MppService mppService;

    @Autowired
    private UserService userService;

    @Autowired
    private MppDetailService mppDetailService;

    @Autowired
    private JobVacancyService jobVacancyService;

    //************ BASIC ENDPOINTS ****************
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public MppResponse addMpp(
            @RequestBody AddMppRequest addMppRequest){
        mppService.addMpp(addMppRequest);
        return new MppResponse(HttpStatus.ACCEPTED.toString(),"Success Add Mpp",null, 1, "POST", addMppRequest.getRequestBody(), addMppRequest.getHeaderContentType());

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findAll(){
        return mppService.getAllMpp();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findById(@PathVariable Long id, HttpServletResponse response){
        Mpp mpp = mppService.getMppById(id);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);
        return new MppResponse(Integer.toString(response.getStatus()), "Success Get Mpp By Id", data, data.size());

    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findByDepartment(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/editMppDetail", method = RequestMethod.POST, produces = "application/json")
    public MppResponse editMpp(
            @RequestBody MppDetailRequest mppDetailRequest,
            @RequestHeader long idEditor,
            @RequestHeader long idMppDetail, HttpServletResponse response){
        mppDetailService.editMppDetail(idMppDetail, mppDetailRequest, userService.getUser(idEditor));
        return new MppResponse(Integer.toString(response.getStatus()),"Success Update Mpp",null);
    }
    //************ END BASIC ENDPOINTS ************



    //************ HRD's endpoint *****************

    //endpoint example = localhost:8080/mpp/hrd/byDepartment/toProcess?page=1&size=5&sort=createdDate,desc
    @RequestMapping(value = "/hrd/byDepartment/toProcess", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppToProccessByHrd(@RequestHeader Department department, Pageable pageable, HttpServletResponse response){
        Page<Mpp> data = mppService.getMppToProccessedByHrdByDepartment(department, pageable);
        return new MppResponse(Integer.toString(response.getStatus()), "Success Get Mpp to Proccess by HRD", data, true);
    }

    @RequestMapping(value = "/hrd/byDepartment/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findAcceptedMppByHrdAcceptorAndDepartment(@RequestHeader Long userId, Pageable pageable, @RequestHeader Department department){
        Page<Mpp> data = mppService.getAcceptedMppByHrdAcceptorAndDepartment(userService.getUser(userId), department, pageable);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted Mpp By Acceptor",data, true);
    }

    @RequestMapping(value = "/hrd/byDepartment/rejected", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findRejectedMppByHrdRejectorAndDepartment(@RequestHeader Long userId, Pageable pageable, @RequestHeader Department department){
        Page<Mpp> data = mppService.getRejectedMppByHrdRejectorAndDepartment(userService.getUser(userId), department, pageable);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Rejected Mpp By Rejector",data, true);
    }

    @RequestMapping(value = "/hrd/approve", method = RequestMethod.POST, produces = "application/json")
    public MppResponse approveHrdMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest, HttpServletResponse response){

        if(mppService.approveHrdMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(Integer.toString(response.getStatus()), "Success Approve Mpp By HRD", null);

        }
        else{
            return new MppResponse(Integer.toString(response.getStatus()), "Failed Approve Mpp By HRD", null);

        }
    }

    @RequestMapping(value = "/hrd/reject", method = RequestMethod.POST, produces = "application/json")
    public MppResponse rejectHrdMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest, HttpServletResponse response){

        if(mppService.rejectHrdMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(Integer.toString(response.getStatus()), "Success Reject Mpp By HRD", null);

        }
        else{
            return new MppResponse(Integer.toString(response.getStatus()), "Failed Reject Mpp By HRD", null);

        }
    }
    //************** END HRD's ENDPOINT **************




    //************** CEO's ENDPOINT ******************
    @RequestMapping(value = "/ceo/approve", method = RequestMethod.POST, produces = "application/json")
    public MppResponse approveMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest, HttpServletResponse response){

        if(mppService.approveMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(Integer.toString(response.getStatus()), "Success Approve Mpp", null);

        }
        else{
            return new MppResponse(Integer.toString(response.getStatus()), "Failed Approve Mpp", null);

        }
    }

    @RequestMapping(value = "/ceo/reject", method = RequestMethod.POST, produces = "application/json")
    public MppResponse rejectMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest, HttpServletResponse response){
        if(mppService.rejectMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(Integer.toString(response.getStatus()), "Success Reject Mpp", null);

        }
        else{
            return new MppResponse(Integer.toString(response.getStatus()), "Failed Reject Mpp", null);

        }

    }

    @RequestMapping(value = "/ceo/byDepartment/toProcess", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppToProccessByCEO(@RequestHeader Department department, Pageable pageable, HttpServletResponse response){
        Page<Mpp> data = mppService.getMppToProccessedByCEOByDepartment(department, pageable);
        return new MppResponse(Integer.toString(response.getStatus()), "Success Get Mpp to Proccess by CEO", data,true);
    }

    @RequestMapping(value = "/ceo/byDepartment/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findAcceptedMppByAcceptorAndDepartment(@RequestHeader Long userId, Pageable pageable,@RequestHeader Department department){
        Page<Mpp> data = mppService.getAcceptedMppByAcceptorAndDepartment(userService.getUser(userId), department, pageable);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted Mpp By Acceptor",data , true);
    }

    @RequestMapping(value = "/ceo/byDepartment/rejected", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findRejectedMppByRejectorAndDepartment(@RequestHeader Long userId, Pageable pageable,@RequestHeader Department department){
        Page<Mpp> data = mppService.getRejectedMppByRejectorAndDepartment(userService.getUser(userId), department, pageable);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Rejected Mpp By Rejector",data,true);
    }
    //************* END CEO's ENDPOINT ******************




    @RequestMapping(value = "/byDepartment/active", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentActive(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppActiveByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }





    @RequestMapping(value = "/byDepartment/history", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentHistory(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppHistoryByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentAccepted(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppAcceptedByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/acceptedNotPublished", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentAcceptedNotPublished(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppAcceptedByDepartmentNotPublished(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted but Not published Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findByRequestedBy(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedBy(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());

    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
//    public MppResponse editMpp(@RequestBody MppFormRequest mppFormRequest, Long id, Long mppId){
//        mppService.editMpp(mppFormRequest, userService.getUser(id), mppService.getMppById(mppId));
//        return new MppResponse(HttpStatus.ACCEPTED.toString(),"Success Edit Mpp",null);
//
//    }

    @RequestMapping(value = "/byRequested/pending", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedPending(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByPending(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }

    @RequestMapping(value = "/byRequested/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedAccepted(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByAccepted(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }

    @RequestMapping(value = "/byRequested/rejected", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedRejected(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByRejected(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }


    @RequestMapping(value = "/publishFromMpp", method = RequestMethod.POST, produces = "application/json")
    public MppResponse publishJobVacancy(@RequestBody ApproveRejectMppRequest approveRejectMppRequest){
        if(mppService.publishMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){

            for(MppDetail mppDetail: mppService.getMppById(approveRejectMppRequest.getIdMpp()).getMppDetails()) {

                jobVacancyService.addPersonNeeded(mppService.getMppById(approveRejectMppRequest.getIdMpp()).getDepartment(), (int) mppDetail.getNumberOfPerson(), mppDetail.getPosition());

            }
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Success Publish Mpp", null);

        }
        else{
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Gagal", null);

        }

    }

    @RequestMapping(value = "/byDepartment/published", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentPublished(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getPublishedMppByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Published Mpp By Department",data,data.size());
    }

}
