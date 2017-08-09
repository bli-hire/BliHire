package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.OnlineTestEntity.ProblemGenerator;
import com.empatkepala.service.ProblemGeneratorService;
import com.empatkepala.service.impl.problemGenerator.EasyPermutasiKombinasi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<ProblemGenerator> getProblemGeneratorEasy()
    {
        EasyPermutasiKombinasi easyPermutasiKombinasi = new EasyPermutasiKombinasi();
        List<ProblemGenerator> problemGeneratorList = new ArrayList<>();

        problemGeneratorList.addAll(easyPermutasiKombinasi.generateProblem());

        return problemGeneratorList;
    }

}
