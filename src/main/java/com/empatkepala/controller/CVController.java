package com.empatkepala.controller;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.entity.request.UpdateStatusApplicantRequest;
import com.empatkepala.entity.response.CVResponse;
import com.empatkepala.service.CVService;
import com.empatkepala.service.JobVacancyService;
import com.empatkepala.service.UserService;
import com.empatkepala.view.MyPdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
@RestController
@RequestMapping(value = "/cv")
@CrossOrigin(origins = "*")
public class CVController {
    @Autowired
    private CVService cvService;

    @Autowired
    private Environment env;

    @Autowired
    private JobVacancyService jobVacancyService;


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public CVResponse getAllCV() {
        CVResponse result = new CVResponse();
        Collection<CV> data =new ArrayList<>();
        data = cvService.getAllCV();
        result.setData(data);
        result.setTotalData(data.size());
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMethod(HttpMethod.GET.name());
        result.setMessage("Success");
        return result;
    }

//    @RequestMapping(value = "/updateStatusApplicant", method = RequestMethod.POST)
//    public CVResponse updateStatusApplicant(
//            @RequestBody String uid,
//            @RequestBody CVFormRequest cvFormRequest ){
//        try {
//            cvService.updateStatusApplicant(cvFormRequest,uid);
//            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);
//        }catch(Exception ex){
//            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
//        }
//
//    }

    @RequestMapping(value = "/getCVByUid", method = RequestMethod.GET)
    public CVResponse getCVByUid(
            @RequestHeader String uid){
        try {
            List<CV> resultCv = new ArrayList<>();
            resultCv.add(cvService.findByUid(uid));
            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Get Data ",resultCv,resultCv.size());
        }catch(Exception ex){
            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
        }

    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public CVResponse sendCv(@RequestBody CVFormRequest addCVFormRequest)
    {
        CV addedCv = cvService.addCV(addCVFormRequest);
        ArrayList<CV> list = new ArrayList<>();
        list.add(addedCv);
        return new CVResponse("400","Success Send CV", list, 1);
    }

//    @RequestMapping(value = "/getLastUid", method = RequestMethod.GET)
//    public CVResponse getLastCv()
//    {
//        List<CV> result = new ArrayList<>();
//        result.add(cvService.getLastAddedCv());
//        return new CVResponse("400","Success get last data CV", result, 1);
//    }

// <<<<<<< feature/mpp
//     @RequestMapping(path = "/reportCV/{uid}", method = RequestMethod.GET)
//     public ModelAndView report(@PathVariable("uid") String uid) {

//         Map<String, Object> model = new HashMap<>();
//         CV cv= cvService.getCVByUid(uid);
//         List<CV> cvList = new ArrayList<>();
//         cvList.add(cv);
//         model.put("cv", cvList);

// =======
    @RequestMapping(path = "/reportCV", method = RequestMethod.GET)
    public ModelAndView report(@RequestHeader String uid) {

        Map<String, Object> model = new HashMap<>();
        CV cvCollection= cvService.findByUid(uid);
        model.put("cv", cvCollection);
// >>>>>>> dev
        return new ModelAndView(new MyPdfView(), model);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {

        try {
            // Get the filename and build the local file path
            String filename = uploadfile.getOriginalFilename();
            String directory = env.getProperty("netgloo.paths.uploadedFiles");
            String filepath = Paths.get(directory, filename).toString();

            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile


    @RequestMapping(value = "/updateStatusApplicant", method = RequestMethod.POST, produces = "application/json")
    public CVResponse updateStatusApplicant(
            @RequestBody UpdateStatusApplicantRequest updateStatusApplicantRequest){
        cvService.updateStatusApplicant(updateStatusApplicantRequest.getStatusApplicant(),updateStatusApplicantRequest.getUid());
        return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);

//        try {
//            cvService.updateStatusApplicant(applicantStatus,uid);
//            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);
//        }catch(Exception ex){
//            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
//        }

    }
    @RequestMapping(value = "/acceptCandidate", method = RequestMethod.POST, produces = "application/json")
    public CVResponse acceptCandidate(
            @RequestBody UpdateStatusApplicantRequest updateStatusApplicantRequest){
        cvService.updateStatusApplicant(updateStatusApplicantRequest.getStatusApplicant(),updateStatusApplicantRequest.getUid());
        jobVacancyService.decreaseAmmount(cvService.getCVByUid(updateStatusApplicantRequest.getUid()).getJobTitle());
        return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);

//        try {
//            cvService.updateStatusApplicant(applicantStatus,uid);
//            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);
//        }catch(Exception ex){
//            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
//        }

    }

}
