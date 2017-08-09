package com.empatkepala.view;

import com.empatkepala.entity.CV;
import com.empatkepala.enumeration.Department;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan Bagus Susilo on 8/8/2017.
 */
public class MyPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CV> cvs = (List<CV>) model.get("cv");
        List<String> cvValue = new ArrayList<>();
        List<String> namaAtribut = new ArrayList<>();

        namaAtribut.add("ID CV :"); cvValue.add(Long.toString(cvs.get(0).getIdCV()));
        namaAtribut.add("Uid :"); cvValue.add(cvs.get(0).getUid());
        namaAtribut.add("Title :"); cvValue.add(cvs.get(0).getTitle());
        namaAtribut.add("Department :"); cvValue.add(cvs.get(0).getDepartment().toString());
        namaAtribut.add("Job Title :"); cvValue.add(cvs.get(0).getJobTitle());
        namaAtribut.add("Full Name :"); cvValue.add(cvs.get(0).getFullName());
        namaAtribut.add("Place Date Of Birth :"); cvValue.add(cvs.get(0).getPlaceDateOfBirth());
        namaAtribut.add("Id Card Number :"); cvValue.add(cvs.get(0).getIdCardNumber());
        namaAtribut.add("Driving License :"); cvValue.add(cvs.get(0).getDrivingLicense().toString());

        namaAtribut.add("Email :"); cvValue.add(cvs.get(0).getEmailAddress());
        namaAtribut.add("twitter :"); cvValue.add(cvs.get(0).getTwitter());
        namaAtribut.add("facebook :"); cvValue.add(cvs.get(0).getFacebook());
        namaAtribut.add("linkedIn :"); cvValue.add(cvs.get(0).getLinkedIn());
        namaAtribut.add("blog :"); cvValue.add(cvs.get(0).getBlog());
        namaAtribut.add("handphone :"); cvValue.add(cvs.get(0).getHandphone());
        namaAtribut.add("religion :"); cvValue.add(cvs.get(0).getReligion());
        namaAtribut.add("ethnicty :"); cvValue.add(cvs.get(0).getEthnicity());

        namaAtribut.add("Marital Status :"); cvValue.add(cvs.get(0).getMaritalStatus());
        namaAtribut.add("Current Address :"); cvValue.add(cvs.get(0).getCurrentAddress());
        namaAtribut.add("Home Address :"); cvValue.add(cvs.get(0).getHomeAddress());
        namaAtribut.add("Home Phone :"); cvValue.add(cvs.get(0).getHomePhone());
        namaAtribut.add("Emergency Call :"); cvValue.add(cvs.get(0).getEmergencyCall());
        namaAtribut.add("Father Name :"); cvValue.add(cvs.get(0).getFatherName());
        namaAtribut.add("Father Birthday :"); cvValue.add(cvs.get(0).getFatherBirthday());
        namaAtribut.add("Father Latest Education :"); cvValue.add(cvs.get(0).getFatherLatestEducation());
        namaAtribut.add("Father CurrentJob :");cvValue.add(cvs.get(0).getFatherCurrentJob());
        namaAtribut.add("Mother Name :");cvValue.add(cvs.get(0).getMotherName());
        namaAtribut.add("Mother Birthday :");cvValue.add(cvs.get(0).getMotherBirthday());
        namaAtribut.add("Mother Latest Education :");cvValue.add(cvs.get(0).getMotherLatestEducation());
        namaAtribut.add("Mother Current Job :");cvValue.add(cvs.get(0).getmotherCurrentJob());
        namaAtribut.add("Spouse Name :");cvValue.add(cvs.get(0).getSpouseName());
        namaAtribut.add("Spouse BirthDay :");cvValue.add(cvs.get(0).getSpousebirthDay());
        namaAtribut.add("SpouseLatestEducation :");cvValue.add(cvs.get(0).getSpouseLatestEducation());
        namaAtribut.add("SpouseCurrentJob() :");cvValue.add(cvs.get(0).getSpouseCurrentJob());
        namaAtribut.add("Responsibilities :");cvValue.add(cvs.get(0).getResponsibilities());
        namaAtribut.add("Responsibilities Type :");cvValue.add(cvs.get(0).getResponsibilitiesType());

        namaAtribut.add("School :");cvValue.add(cvs.get(0).getSchool().get(0).getSchoolName());
        namaAtribut.add("Major :");cvValue.add(cvs.get(0).getSchool().get(0).getMajor());
        namaAtribut.add("City :");cvValue.add(cvs.get(0).getSchool().get(0).getCity());
        namaAtribut.add("Periode :");cvValue.add(cvs.get(0).getSchool().get(0).getPeriode());
        namaAtribut.add("GPA :");cvValue.add(cvs.get(0).getSchool().get(0).getGpa().toString());
        namaAtribut.add("School :");cvValue.add(cvs.get(0).getSchool().get(1).getSchoolName());
        namaAtribut.add("Major :");cvValue.add(cvs.get(0).getSchool().get(1).getMajor());
        namaAtribut.add("City :");cvValue.add(cvs.get(0).getSchool().get(1).getCity());
        namaAtribut.add("Periode :");cvValue.add(cvs.get(0).getSchool().get(1).getPeriode());
        namaAtribut.add("GPA :");cvValue.add(cvs.get(0).getSchool().get(1).getGpa().toString());


        namaAtribut.add("Reason Major :");cvValue.add(cvs.get(0).getReasonMajor());
        namaAtribut.add("mother titleThesis :");cvValue.add(cvs.get(0).getTitleThesis());



        namaAtribut.add("Non Formal Course");cvValue.add(cvs.get(0).getNonFrmlCrs().get(0).getNameOfCourse());
        namaAtribut.add("Organizer");cvValue.add(cvs.get(0).getNonFrmlCrs().get(0).getOrganizer());
        namaAtribut.add("Year");cvValue.add(String.valueOf(cvs.get(0).getNonFrmlCrs().get(0).getYear()));
        namaAtribut.add("Notes");cvValue.add(cvs.get(0).getNonFrmlCrs().get(0).getNotes());
        namaAtribut.add("Non Formal Course");cvValue.add(cvs.get(0).getNonFrmlCrs().get(1).getNameOfCourse());
        namaAtribut.add("Organizer");cvValue.add(cvs.get(0).getNonFrmlCrs().get(0).getOrganizer());
        namaAtribut.add("Year");cvValue.add(String.valueOf(cvs.get(0).getNonFrmlCrs().get(1).getYear()));
        namaAtribut.add("Notes");cvValue.add(cvs.get(0).getNonFrmlCrs().get(1).getNotes());
        namaAtribut.add("Non Formal Course");cvValue.add(cvs.get(0).getNonFrmlCrs().get(2).getNameOfCourse());
        namaAtribut.add("Organizer");cvValue.add(cvs.get(0).getNonFrmlCrs().get(2).getOrganizer());
        namaAtribut.add("Year");cvValue.add(String.valueOf(cvs.get(0).getNonFrmlCrs().get(2).getYear()));
        namaAtribut.add("Notes");cvValue.add(cvs.get(0).getNonFrmlCrs().get(2).getNotes());


        namaAtribut.add("Achievements");cvValue.add(cvs.get(0).getAchievements().get(0).getAchievement());
        namaAtribut.add("year");cvValue.add(String.valueOf(cvs.get(0).getAchievements().get(0).getYear()));
        namaAtribut.add("notes");cvValue.add(cvs.get(0).getAchievements().get(0).getNotes());

        namaAtribut.add("Achievements");cvValue.add(cvs.get(0).getAchievements().get(1).getAchievement());
        namaAtribut.add("year");cvValue.add(String.valueOf(cvs.get(0).getAchievements().get(1).getYear()));
        namaAtribut.add("notes");cvValue.add(cvs.get(0).getAchievements().get(1).getNotes());



        namaAtribut.add("Social Activity");cvValue.add(cvs.get(0).getSocialact().get(0).getNameOrganization());
        namaAtribut.add("FieldOfOrganization");cvValue.add(String.valueOf(cvs.get(0).getSocialact().get(0).getFieldOfOrganization()));
        namaAtribut.add("AttendancePeriod");cvValue.add(String.valueOf(cvs.get(0).getSocialact().get(0).getAttendancePeriod()));
        namaAtribut.add("Notes");cvValue.add(cvs.get(0).getSocialact().get(0).getNotes());

        namaAtribut.add("Social Activity");cvValue.add(cvs.get(0).getSocialact().get(1).getNameOrganization());
        namaAtribut.add("FieldOfOrganization");cvValue.add(String.valueOf(cvs.get(0).getSocialact().get(1).getFieldOfOrganization()));
        namaAtribut.add("AttendancePeriod");cvValue.add(String.valueOf(cvs.get(0).getSocialact().get(1).getAttendancePeriod()));
        namaAtribut.add("Notes");cvValue.add(cvs.get(0).getSocialact().get(1).getNotes());



        namaAtribut.add("Language");cvValue.add(cvs.get(0).getLanguage().get(0).getNameOfLanguage());
        namaAtribut.add("spokenLanguage");cvValue.add(String.valueOf(cvs.get(0).getLanguage().get(0).getspokenLanguage()));
        namaAtribut.add("writtenLanguage");cvValue.add(String.valueOf(cvs.get(0).getLanguage().get(0).getwrittenLanguage()));


        namaAtribut.add("Reason Interested In GDN :");cvValue.add(cvs.get(0).getReasonInterestedInGDN());
        namaAtribut.add("Reason Apply On That Position :");cvValue.add(cvs.get(0).getReasonApplyOnThatPosition());
        namaAtribut.add("Factor Encourage You On That Job :");cvValue.add(cvs.get(0).getFactorEncourageYouOnThatJob());
        namaAtribut.add("Kind Of Environtment :");cvValue.add(cvs.get(0).getKindOfEnvirontment());
        namaAtribut.add("LifeValue :");cvValue.add(cvs.get(0).getLifeValue());
        namaAtribut.add("SpesificSkill :");cvValue.add(cvs.get(0).getSpesificSkill());
        namaAtribut.add("Hobbies :");cvValue.add(cvs.get(0).getHobbies());
        namaAtribut.add("Describe About You :");cvValue.add(cvs.get(0).getDescribeAboutYou());
        namaAtribut.add("PlaceGetInformationGDN :");cvValue.add(cvs.get(0).getPlaceGetInformationGDN());
        namaAtribut.add("Relative Working On GDN :");cvValue.add(cvs.get(0).getRelativeWorkingOnGDN());
        namaAtribut.add("Have Applied On GDN :");cvValue.add(cvs.get(0).getHaveAppliedOnGDN());
        namaAtribut.add("Have Part Time Job :");cvValue.add(cvs.get(0).getHavePartTimejob());
        namaAtribut.add("Time Start Work :");cvValue.add(cvs.get(0).getTimeStartWork());
        namaAtribut.add("Applicant Status :");cvValue.add(cvs.get(0).getApplicantStatus());

        namaAtribut.add("Children");cvValue.add(cvs.get(0).getChil().get(0).getChildrenName());
        namaAtribut.add("Children Birthday");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChildrenBirthday()));
        namaAtribut.add("Children Current Job");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChildrenCurrentJob()));
        namaAtribut.add("Children Last Education");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChilLatestEdu()));

        namaAtribut.add("Children");cvValue.add(cvs.get(0).getChil().get(0).getChildrenName());
        namaAtribut.add("Children Birthday");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChildrenBirthday()));
        namaAtribut.add("Children Current Job");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChildrenCurrentJob()));
        namaAtribut.add("Children Latest Education");cvValue.add(String.valueOf(cvs.get(0).getChil().get(0).getChilLatestEdu()));


        namaAtribut.add("Brothers");cvValue.add(String.valueOf(cvs.get(0).getBro().get(0).getBrothersName()));
        namaAtribut.add("Brother Birthday");cvValue.add(String.valueOf(cvs.get(0).getBro().get(0).getBrothersBirthday()));
        namaAtribut.add("Brother Latest Education");cvValue.add(String.valueOf(cvs.get(0).getBro().get(0).getBrotherLatestEducation()));
        namaAtribut.add("Brother Current Job");cvValue.add(String.valueOf(cvs.get(0).getBro().get(0).getBrotherCurrentJob()));

        namaAtribut.add("Work Experience");cvValue.add(cvs.get(0).getWorkExp().get(0).getCompanyName());
        namaAtribut.add("Company Field");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getCompanyField()));
        namaAtribut.add("Position");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getPosition()));
        namaAtribut.add("Period");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getPeriod()));
        namaAtribut.add("Work Experience");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getJobDescription()));
        namaAtribut.add("Reason to Leave");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getReasonToLeave()));
        namaAtribut.add("References Name");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getReferenceName()));
        namaAtribut.add("Reference Position");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getReferencePosition()));
        namaAtribut.add("Reference Phone Number");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getReferencePhoneNumber()));
        namaAtribut.add("Organization Chart");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(0).getOrganizationalChart()));

        namaAtribut.add("Work Experience");cvValue.add(cvs.get(0).getWorkExp().get(1).getCompanyName());
        namaAtribut.add("Company Field");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getCompanyField()));
        namaAtribut.add("Position");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getPosition()));
        namaAtribut.add("Period");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getPeriod()));
        namaAtribut.add("Work Experience");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getJobDescription()));
        namaAtribut.add("Reason to Leave");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getReasonToLeave()));
        namaAtribut.add("References Name");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getReferenceName()));
        namaAtribut.add("Reference Position");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getReferencePosition()));
        namaAtribut.add("Reference Phone Number");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getReferencePhoneNumber()));
        namaAtribut.add("Organization Chart");cvValue.add(String.valueOf(cvs.get(0).getWorkExp().get(1).getOrganizationalChart()));

//

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(85);
        table.setWidths(new int[] {3, 4});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        for (CV cv : cvs) {
            for (int i=0; i< namaAtribut.size(); i++) {
                PdfPCell hcell;
                hcell = new PdfPCell(new Phrase("  "+namaAtribut.get(i), headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("   "+cvValue.get(i)));
                hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(hcell);





            }
        }

//        PdfPTable table = new PdfPTable(1);
//        table.setWidthPercentage(60);
//        table.setWidths(new int[] {4});
//
//        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

//        PdfPCell hcell;
//        hcell = new PdfPCell(new Phrase("Data", headFont));
//        hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(hcell);


        for (CV cv : cvs) {

//            PdfPCell cell;
//
//            cell = new PdfPCell(new Phrase("ID CV :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(Long.toString(cv.getIdCV())));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Uid :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getUid()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Title :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getTitle()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Job Title :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getJobTitle()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Full Name :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFullName()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Place Date Of Birth :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getTitle()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("idCardNumber :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getIdCardNumber()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Driving License :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            ArrayList<String> sim = new ArrayList<String>();
//            sim = cv.getDrivingLicense();
//            cell = new PdfPCell(new Phrase(sim.toString()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Email :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEmailAddress()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("twitter :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getTwitter()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("facebook :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFacebook()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("linkedIn :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getLinkedIn()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("blog :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getBlog()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("handphone :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getHandphone()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("religion :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getReligion()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("ethnicty :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEthnicity()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Marital Status :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getMaritalStatus()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Content Address :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getCurrentAddress()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Home Address :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEmailAddress()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Home Phone :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getHomePhone()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("emergency Call :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEmergencyCall()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Father Name :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFatherName()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Father Birthday :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFatherBirthday()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Father Latest Education :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFatherLatestEducation()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Father Current Job :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getFatherCurrentJob()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Mother Name :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getMotherName()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Mother Birthday :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getMotherBirthday()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Mother Latest Education :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEmailAddress()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Mother Current Job :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getEmailAddress()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Spouse name :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getSpouseName()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Spouse Birthday :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getSpousebirthDay()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Spouse Latest Education :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getSpouseLatestEducation()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Spouse Current Job :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getSpouseCurrentJob()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Responsibilities :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getResponsibilities()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Responsibilities Type :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getResponsibilitiesType()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Responsibilities :"));
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(cv.getResponsibilities()));
//            cell.setPaddingLeft(5);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//            table.addCell(cell);



        }

        document.add(table);
    }
}