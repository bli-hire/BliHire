package com.empatkepala.service.impl.problemGenerator;

import com.empatkepala.entity.OnlineTestEntity.ProblemGenerator;
import com.empatkepala.enumeration.ProblemDifficulty;
import com.empatkepala.repository.OnlineTestRepository.ProblemGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class EasyPermutasiKombinasi {

    List<ProblemGenerator> listSoalGenerator;

    public List<ProblemGenerator> generateProblem()
    {
        List<ProblemGenerator> problemGeneratorList = new ArrayList<ProblemGenerator>();

        problemGeneratorList.add(generateSoalType_1());
        problemGeneratorList.add(generateSoalType_2());
        problemGeneratorList.add(generateSoalType_3());
        problemGeneratorList.add(generateSoalType_4());
        problemGeneratorList.add(generateSoalType_5());
        problemGeneratorList.add(generateSoalType_6());
        problemGeneratorList.add(generateSoalType_7());
        problemGeneratorList.add(generateSoalType_8());
        problemGeneratorList.add(generateSoalType_9());

        return problemGeneratorList;
    }

    private ProblemGenerator generateSoalType_1() {

        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%10)+2;
        int b = Math.abs(random.nextInt()%10)+2;
        while(a==b) b = Math.abs(random.nextInt()%10)+2;
        int c = Math.abs(random.nextInt()%10)+2;
        while(a==c || b==c) c = Math.abs(random.nextInt()%10)+2;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String c_text = String.valueOf(c);
        String soal = "Suatu hari disaat Bono akan pergi ke suatu pesta"
                +", Bono ingin berpenampilan sebaik mungkin. Saat dia membuka lemari bajunya, terdapat "
                +a_text+" pilihan baju, "+b_text+" pilihan celana, dan juga "
                +c_text+" pilihan sepatu. Adapun dia pasti memakai baju, celana, sepatu masing masing hanya satu." +
                "\nAda berapa banyak cara Bono berpakaian untuk ke pesta?\n";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(String.valueOf(a*b*c));
        listJawaban.add(String.valueOf(a+b+c));
        listJawaban.add(String.valueOf(a*b+c));
        listJawaban.add(String.valueOf(a*b+c));
        listJawaban.add(String.valueOf(a*c+b));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private ProblemGenerator generateSoalType_2() {

        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;
        String[] listCity = new String[4];
        listCity[0] = "Bandung";
        listCity[1] = "Semarang";
        listCity[2] = "Surabaya";
        listCity[3] = "jakarta";
        Random random = new Random();
        int a = Math.abs(random.nextInt()%10)+2;
        int b = Math.abs(random.nextInt()%10)+2;
        while(a==b) b = Math.abs(random.nextInt()%10)+2;
        int c = Math.abs(random.nextInt()%10)+2;
        while(a==c || b==c) c = Math.abs(random.nextInt()%10)+2;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String c_text = String.valueOf(c);
        String soal = "Dari kota "+listCity[0]+" ke kota "+listCity[1]+" dilayani oleh "+a_text+" bus dan dari "+listCity[1]+" ke "+listCity[2]+" oleh "+b_text+" bus. Dari kota "+listCity[2]+" ke kota "+listCity[3]+" dilayani oleh "+c_text+". Seseorang berangkat dari kota "+listCity[0]+" ke kota "+listCity[3]+" melalui "+listCity[1]+" kemudian "+listCity[2]+". Maka banyak cara perjalanan orang tersebut adalah";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(String.valueOf(a*b*c));
        listJawaban.add(String.valueOf(a+b+c));
        listJawaban.add(String.valueOf(a*b+c));
        listJawaban.add(String.valueOf(a*b+c));
        listJawaban.add(String.valueOf(a*c+b));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private ProblemGenerator generateSoalType_3() {
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%6)+4;
        String a_text = String.valueOf(a);
        String soal = "Dari angka angka 1,2, sampai "+a_text+" akan dibentuk suatu bilangan ganjil yang terdiri atas 3 angka. Maka banyaknya bilangan yang tersusun dengan tidak ada angka yang berulang adalah";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_3("A",a));
        listJawaban.add(generateJawabanType_3("B",a));
        listJawaban.add(generateJawabanType_3("C",a));
        listJawaban.add(generateJawabanType_3("D",a));
        listJawaban.add(generateJawabanType_3("E",a));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_3(String pilihan , int a){
        String answer="";
        int tmp;
        switch (pilihan){
            case "A":
                tmp=a/2;
                if(a%2==1) tmp++;
                answer = String.valueOf(tmp*(a-1)*(a-2));
                break;

            case "B":
                tmp=a/2;
                if(a%2==0) tmp++;
                answer = String.valueOf(tmp*(a-1)*(a-2));
                break;

            case "C":
                answer = String.valueOf(a*(a-1)*(a-2));
                break;

            case "D":
                tmp=a/2;
                if(a%2==1) tmp++;
                answer = String.valueOf(tmp*a*a);
                break;

            case "E":
                answer = String.valueOf(a*a*a);
                break;

            default:
                answer = "";
        }

        return answer;
    }

    private ProblemGenerator generateSoalType_4() {
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%10)+5;
        int b = Math.abs(random.nextInt()%5)+3;
        while(b>=a) b = Math.abs(random.nextInt()%5)+3;
        while(a-b<=2) a++;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String soal = a_text+ " siswa di sekolah akan dipilih secara acak "+b_text+ " untuk mengikuti Upacara Hari Pendidikan Nasional. \nBanyak cara pemilihan tersebut ada";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_4("A",a,b));
        listJawaban.add(generateJawabanType_4("B",a,b));
        listJawaban.add(generateJawabanType_4("C",a,b));
        listJawaban.add(generateJawabanType_4("D",a,b));
        listJawaban.add(generateJawabanType_4("E",a,b));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_4(String pilihan, int a, int b){
        String answer_text="";
        int maks=Math.max(a-b,b);
        int mins=Math.min(a-b,b);
        int answer=1;

        switch(pilihan){
            case "A" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer_text = String.valueOf(answer);
                break;
            case "B" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                answer_text = String.valueOf(answer);
                break;
            case "C" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=10;
                answer_text = String.valueOf(answer);
                break;
            case "D" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=20;
                answer_text = String.valueOf(answer);
                break;
            case "E" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=30;
                answer_text = String.valueOf(answer);
                break;
            default :
                answer_text = "";
        }

        return answer_text;
    }

    private ProblemGenerator generateSoalType_5(){
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%10)+5;
        int b = Math.abs(random.nextInt()%5)+3;
        if(a<b){
            int tmp=a;
            a=b;
            b=tmp;
        }
        while(a-b<=2) a++;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String soal = "Banyak segi-" +b_text+ " yang dapat dibentuk dari " +a_text+ " titik yang tersedia, dengan tidak ada 3 titik yang segaris adalah";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_5("A",a,b));
        listJawaban.add(generateJawabanType_5("B",a,b));
        listJawaban.add(generateJawabanType_5("C",a,b));
        listJawaban.add(generateJawabanType_5("D",a,b));
        listJawaban.add(generateJawabanType_5("E",a,b));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_5(String pilihan, int a, int b){
        String answer_text="";
        int maks=Math.max(a-b,b);
        int mins=Math.min(a-b,b);
        int answer=1;

        switch(pilihan){
            case "A" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer_text = String.valueOf(answer);
                break;
            case "B" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                answer_text = String.valueOf(answer);
                break;
            case "C" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=10;
                answer_text = String.valueOf(answer);
                break;
            case "D" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=20;
                answer_text = String.valueOf(answer);
                break;
            case "E" :
                for(int i=maks+1;i<=a;i++){
                    answer*=i;
                }
                for(int i=1;i<=mins;i++){
                    answer/=i;
                }
                answer+=30;
                answer_text = String.valueOf(answer);
                break;
            default :
                answer_text = "";
        }
        return answer_text;
    }

    private ProblemGenerator generateSoalType_6(){
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Medium;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%5)+2;
        int b = Math.abs(random.nextInt()%5)+2;
        int c = Math.abs(random.nextInt()%5)+2;
        int d = Math.abs(random.nextInt()%5)+2;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String c_text = String.valueOf(c);
        String d_text = String.valueOf(d);
        String soal = "Seorang anak ingin membuat sebuah komputer untuk keperluan gaming. Komputer yang dia bangung masih kurang monitor, mouse, speaker, dan keyboard. Adapun dia mempunyai beberapa opsi untuk setiap bagiannya. Untuk monitor, dia mempunyai "+a_text+ " pilihan monitor. Untuk mouse, dia mempunyai "+b_text+" pilihan, untuk speaker ada "+c_text+" pilihan, dan keyboard ada "+d_text+" pilihan. Maka ada berapa cara dia dapat memilih barang-barang yang dibutuhkan untuk membangun komputer dia?";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_6("A",a,b,c,d));
        listJawaban.add(generateJawabanType_6("B",a,b,c,d));
        listJawaban.add(generateJawabanType_6("C",a,b,c,d));
        listJawaban.add(generateJawabanType_6("D",a,b,c,d));
        listJawaban.add(generateJawabanType_6("E",a,b,c,d));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_6(String pilihan, int a, int b, int c, int d){
        String answer_text = "";
        switch(pilihan){
            case "A" :
                answer_text = String.valueOf(a*b*c*d);
                break;
            case "B" :
                answer_text = String.valueOf(a*b*c*d - 10);
                break;
            case "C" :
                answer_text = String.valueOf(a*b*c*d + 10);
                break;
            case "D" :
                answer_text = String.valueOf(a*b*c*d + 20);
                break;
            case "E" :
                answer_text = String.valueOf(a*b*c*d + 30);
                break;
            default :
                answer_text = "";
        }
        return answer_text;
    }

    private ProblemGenerator generateSoalType_7(){
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Medium;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%5)+2;
        int b = Math.abs(random.nextInt()%3)+7;
        int c = Math.abs(random.nextInt()%5)+2;
        int d = Math.abs(random.nextInt()%3)+7;
        String a_text = String.valueOf(a);
        String b_text = String.valueOf(b);
        String c_text = String.valueOf(c);
        String d_text = String.valueOf(d);
        String soal = "Seorang siswa ingin meminjam buku-buku dari perpustakaan. Dia ingin meminjam "+a_text+ " buku Matematika dan "+c_text+" buku Komputer. Pada perpustakaan tersebut, terdapat "+b_text+" buku Matematika dan "+d_text+" buku Komputer. Diketahui bahwa semua buku tersebut berbeda antara satu sama lain. Maka berapa banyak kemungkinan buku yang dipinjam siswa tersebut?";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_7("A",a,b,c,d));
        listJawaban.add(generateJawabanType_7("B",a,b,c,d));
        listJawaban.add(generateJawabanType_7("C",a,b,c,d));
        listJawaban.add(generateJawabanType_7("D",a,b,c,d));
        listJawaban.add(generateJawabanType_7("E",a,b,c,d));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_7(String pilihan, int a, int b, int c, int d){
        String answer_text;
        int maks, mins, answer, x, y;
        switch(pilihan){
            case "A" :
                maks = Math.max(b - a, a);
                mins = Math.min(b - a, a);
                x = 1;
                for(int i=maks+1;i<=b;i++) x*=i;
                for(int i=1;i<=mins;i++) x/=i;
                maks = Math.max(d-c,c);
                mins = Math.min(d-c,c);
                y = 1;
                for(int i=maks+1;i<=d;i++) y*=i;
                for(int i=1;i<=mins;i++) y/=i;
                answer = x*y;
                answer_text = String.valueOf(answer);
                break;
            case "B" :
                maks = Math.max(b - a, a);
                mins = Math.min(b - a, a);
                x = 1;
                for(int i=maks+1;i<=b;i++) x*=i;
                for(int i=1;i<=mins;i++) x/=i;
                maks = Math.max(d-c,c);
                mins = Math.min(d-c,c);
                y = 1;
                for(int i=maks+1;i<=d;i++) y*=i;
                for(int i=1;i<=mins;i++) y/=i;
                answer = x + y;
                answer_text = String.valueOf(answer);
                break;
            case "C" :
                maks = Math.max(b - a, a);
                mins = Math.min(b - a, a);
                x = 1;
                for(int i=maks+1;i<=b;i++) x*=i;
                for(int i=1;i<=mins;i++) x/=i;
                maks = Math.max(d-c,c);
                mins = Math.min(d-c,c);
                y = 1;
                for(int i=maks+1;i<=d;i++) y*=i;
                for(int i=1;i<=mins;i++) y/=i;
                answer = x * y;
                answer+=10;
                answer_text = String.valueOf(answer);
                break;
            case "D" :
                maks = Math.max(b - a, a);
                mins = Math.min(b - a, a);
                x = 1;
                for(int i=maks+1;i<=b;i++) x*=i;
                for(int i=1;i<=mins;i++) x/=i;
                maks = Math.max(d-c,c);
                mins = Math.min(d-c,c);
                y = 1;
                for(int i=maks+1;i<=d;i++) y*=i;
                for(int i=1;i<=mins;i++) y/=i;
                answer = x * y;
                answer-=10;
                answer_text = String.valueOf(answer);
                break;
            case "E" :
                maks = Math.max(b - a, a);
                mins = Math.min(b - a, a);
                x = 1;
                for(int i=maks+1;i<=b;i++) x*=i;
                for(int i=1;i<=mins;i++) x/=i;
                maks = Math.max(d-c,c);
                mins = Math.min(d-c,c);
                y = 1;
                for(int i=maks+1;i<=d;i++) y*=i;
                for(int i=1;i<=mins;i++) y/=i;
                answer = x * y * 2;
                answer_text = String.valueOf(answer);
                break;
            default :
                answer_text = "";
        }
        return answer_text;
    }

    private ProblemGenerator generateSoalType_8(){
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Easy;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%5)+3;
        String a_text = String.valueOf(a);
        String soal = "Banyak cara "+a_text+" orang duduk pada suatu meja bundar adalah";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_8("A",a));
        listJawaban.add(generateJawabanType_8("B",a));
        listJawaban.add(generateJawabanType_8("C",a));
        listJawaban.add(generateJawabanType_8("D",a));
        listJawaban.add(generateJawabanType_8("E",a));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_8(String pilihan, int a){
        String answer_text = "";
        int answer;
        switch(pilihan){
            case "A" :
                answer=1;
                for(int i=1;i<=a-1;i++) answer*=i;
                answer_text = String.valueOf(answer);
                break;
            case "B" :
                answer=1;
                for(int i=1;i<=a;i++) answer*=i;
                answer_text = String.valueOf(answer);
                break;
            case "C" :
                answer=1;
                for(int i=1;i<=a-1;i++) answer*=i;
                answer*=2;
                answer_text = String.valueOf(answer);
                break;
            case "D" :
                answer=1;
                for(int i=1;i<=a-1;i++) answer*=i;
                answer*=4;
                answer_text = String.valueOf(answer);
                break;
            case "E" :
                answer=1;
                for(int i=1;i<=a-1;i++) answer*=i;
                answer*=8;
                answer_text = String.valueOf(answer);
                break;
            default :
                answer_text = "";
        }
        return answer_text;
    }

    private ProblemGenerator generateSoalType_9(){
        ProblemDifficulty problemDifficulty = ProblemDifficulty.Medium;

        Random random = new Random();
        int a = Math.abs(random.nextInt()%5)+3;
        String a_text = String.valueOf(a);
        String soal = "Banyak cara "+a_text+" orang duduk pada suatu kursi lurus adalah";

        List<String> listJawaban = new ArrayList<>();
        listJawaban.add(generateJawabanType_9("A",a));
        listJawaban.add(generateJawabanType_9("B",a));
        listJawaban.add(generateJawabanType_9("C",a));
        listJawaban.add(generateJawabanType_9("D",a));
        listJawaban.add(generateJawabanType_9("E",a));

        String jawaban = listJawaban.get(0);
        Collections.shuffle(listJawaban);
        ProblemGenerator problemGenerator = new ProblemGenerator(soal,listJawaban.indexOf(jawaban),listJawaban, problemDifficulty);

        return problemGenerator;
        //problemGeneratorRepository.save(problemGenerator);
    }

    private String generateJawabanType_9(String pilihan, int a){
        String answer_text = "";
        int answer;
        switch(pilihan){
            case "A" :
                answer=1;
                for(int i=1;i<=a;i++) answer*=i;
                answer_text = String.valueOf(answer);
                break;
            case "B" :
                answer=1;
                for(int i=1;i<=a-1;i++) answer*=i;
                answer_text = String.valueOf(answer);
                break;
            case "C" :
                answer=1;
                for(int i=1;i<=a;i++) answer*=i;
                answer*=2;
                answer_text = String.valueOf(answer);
                break;
            case "D" :
                answer=1;
                for(int i=1;i<=a;i++) answer*=i;
                answer*=4;
                answer_text = String.valueOf(answer);
                break;
            case "E" :
                answer=1;
                for(int i=1;i<=a;i++) answer*=i;
                answer*=8;
                answer_text = String.valueOf(answer);
                break;
            default :
                answer_text = "";
        }
        return answer_text;
    }

}