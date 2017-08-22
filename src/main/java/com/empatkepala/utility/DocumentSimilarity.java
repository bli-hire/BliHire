package com.empatkepala.utility;

/*
import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DocumentSimilarity {

    public Set<String> getDictionary() throws IOException {
        Set<String> dictionary = new HashSet<String>();
        InputStream in = Lemmatizer.class.getResourceAsStream("/document-similarity/kata-dasar-indonesia.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = br.readLine()) != null)
        {
            dictionary.add(line);
        }

        return dictionary;
    }

    public void setup() throws IOException {
        Set<String> dictionary = getDictionary();
        Lemmatizer lemmatizer = new DefaultLemmatizer(dictionary);
    }

    public String stemming(String text) throws IOException {

        text = text.toLowerCase();
        Lemmatizer lemmatizer = new DefaultLemmatizer(getDictionary());
        return null;
    }


    public void countSimilarity() throws IOException {

        URL url = getClass().getResource("/document-similarity/1.txt");
        File file1 = new File(url.getPath());

        url = getClass().getResource("/document-similarity/2.txt");
        File file2 = new File(url.getPath());

        String command = "python /document-similarity/document-similarity.py 2 ";
        String file1Str = file1.getName();
        String file2Str = file2.getName();

        String s = null;

        command = command + file1Str + " " + file2Str;

        Process p = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        System.out.println("Output: \n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
    }

}
*/