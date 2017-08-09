package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.service.ProblemGeneratorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProblemGeneratorServiceImpl implements ProblemGeneratorService{

    public void generateProblem(MultipleChoices multipleChoices)
    {
        Map<String, Integer> vars = new HashMap<String, Integer>();

        String problem = multipleChoices.getProblem();

        int varCounter = 0;
        for(int i=0;i<problem.length();i++){
            if(problem.charAt(i) == '%'){
                if(problem.charAt(i+1)>='a' && problem.charAt(i+1)<='z'){
                    vars.put(String.valueOf(problem.charAt(i+1)), 0);
                    varCounter++;
                }
            }
        }


    }

}
