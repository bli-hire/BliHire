package com.empatkepala.utility;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.OnlineTestEntity.ProblemGenerator;
import com.empatkepala.entity.User;

import com.empatkepala.enumeration.ProblemDifficulty;
import com.empatkepala.repository.OnlineTestRepository.EssayRepository;
import com.empatkepala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ARDI on 8/7/2017.
 */
@Component
public class Helper {

    @Autowired
    UserRepository userRepository;
    @Autowired
    protected AuthenticationManager authenticationManager;


    public boolean isLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken) ;
    }

    public User getCurrentUser() {
        if (isLoggedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(authentication.getName());
            return userRepository.findByUsername(authentication.getName());
        }
        System.out.println("not logged in");
        return null;
    }


    // TODO PICK AND RANDOMIZE LIST ESSAY
    public static List<Essay> pickAndRandomEssay(List<Essay> list, int numObject) {
        List<Essay> copy = new ArrayList<Essay>(list);
        Collections.shuffle(copy);
        return copy.subList(0, numObject);
    }

    // TODO PICK AND RANDOMIZE LIST MULTIPLE CHOICES
    public static List<MultipleChoices> pickAndRandomMultipleChoices(List<MultipleChoices> list, int numObject) {
        List<MultipleChoices> copy = new ArrayList<MultipleChoices>(list);
        Collections.shuffle(copy);
        return copy.subList(0, numObject);
    }

    // TODO PICK AND RANDOMIZE LIST MULTIPLE CHOICES GENERATED
    public static List<ProblemGenerator> pickAndRandomProblemGenerator(List<ProblemGenerator> list, int numObject) {
        List<ProblemGenerator> copy = new ArrayList<ProblemGenerator>(list);
        Collections.shuffle(copy);
        return copy.subList(0, numObject);
    }

    // TODO PARSE APPLICANT ANSWER
    public List<String> parseAnswer(String answer)
    {
        List<String> answerList = new ArrayList<>();

        for(String answerTrim : answer.split("\\|"))
        {
            answerList.add(answerTrim);
        }

        return answerList;
    }

}
