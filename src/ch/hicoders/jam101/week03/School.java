package ch.hicoders.jam101.week03;
import ch.hicoders.jam101.week03.Person.Student;
import java.util.*;

public class School {
    public static void main(String[] args) {
        ArrayList<Student> studentList = School.loadStudentsData();
        School.renderArray(studentList);
        float averageList[]= School.averageStudentNote(studentList);
        School.renderAverageNote(averageList);
        //School.findMaxMinMathNote(studentList);
        ArrayList<Student> successMathStudentsList = School.successMathStudentsData(studentList,averageList[0]);
        School.renderArray(successMathStudentsList);
        ArrayList<Student> unsuccessMathStudentsList = School.unsuccessMathStudentsData(studentList,averageList[0]);
        School.renderArray(unsuccessMathStudentsList);
        ArrayList<Student> successGermanStudentsList = School.successGermanStudentsData(studentList,averageList[1]);
        School.renderArray(successGermanStudentsList);
        ArrayList<Student> unsuccessGermanStudentsList = School.unsuccessGermanStudentsData(studentList,averageList[1]);
        School.renderArray(unsuccessGermanStudentsList);


    }
// ogrenci bilgilerini olusturan ve diziye ekleyen method.
    public static ArrayList<Student> loadStudentsData(){
        Random randomNumber = new Random();
        int studentsNumber = randomNumber.nextInt(50);
        ArrayList<Student> studentsList = new ArrayList<Student>(studentsNumber);
        for(int i = 0; i <= studentsNumber; i++){
            int mathScore = randomNumber.nextInt(7);
            int germanScore = randomNumber.nextInt(7);
            Student student = new Student( "Student "+i, mathScore, germanScore);
            studentsList.add(student);
        }
        return studentsList;
    }
    // Ogrenci bilgilerini ekrana yazdiran method.
    public static void renderArray(ArrayList<Student> pStudentList){
        for(Student student:pStudentList)
        {
            System.out.println(student.studentName + " " + "Maths note : " + student.mathNote + " " + " German Note : " + student.germanNote);
        }
    }
    // ögrencilerin not ortalmasini bulan method
    public static float[] averageStudentNote(ArrayList<Student> pStudentList){
        float totalMathNote=0;
        float totalGermanNote=0;
        for(Student student:pStudentList)
        {
           totalMathNote+=student.mathNote;
           totalGermanNote+=student.germanNote;
        }
        float averageMathNote=totalMathNote/pStudentList.size();
        float averageGermanNote=totalGermanNote/pStudentList.size();
        return  new float[] {averageMathNote, averageGermanNote};

    }
    // ogrencilerin not ortalamsini ekrana yazdiran method
    public static void renderAverageNote(float[] pArray){
        System.out.println("average Math grades:"+pArray[0]);
        System.out.println("Average German Grades: "+pArray[1]);

    }
    // en yuksek ve en dusuk alan ogrencileri bulan method
    public static void  findMaxMinMathNote(ArrayList<Student> pStudentList){
        int maxNote=pStudentList.get(0).mathNote;
        int minNote=pStudentList.get(0).mathNote;
        for(Student student:pStudentList)
        {
           if(student.mathNote>maxNote){
               maxNote=student.mathNote;
           }
           if(student.mathNote<minNote){
               minNote=student.mathNote;
           }
        }
        System.out.println(maxNote);
        System.out.println(minNote);
    }
    //Matamatikten gecen ogrenciler
    public static ArrayList<Student> successMathStudentsData(ArrayList<Student> pStudentList, float pAverage){
        ArrayList<Student>successStudentsList = new ArrayList<Student>();
        for(Student student:pStudentList){
           if(student.mathNote>=pAverage){
               successStudentsList.add(student);
           }
        }
        System.out.println("matematik dersinde basarili olan ogrenciler: ");

        return successStudentsList;
    }
    //Matamatikten kalan ogrenciler
    public static ArrayList<Student> unsuccessMathStudentsData(ArrayList<Student> pStudentList, float pAverage){
        ArrayList<Student>unsuccessStudentsList = new ArrayList<Student>();
        for(Student student:pStudentList){
            if(student.mathNote<pAverage){
                unsuccessStudentsList.add(student);
            }
        }
        System.out.println("matematik dersinde kalan ogrenciler: ");

        return unsuccessStudentsList;
    }
    //Almancadan gecen ogrenciler

    public static ArrayList<Student> successGermanStudentsData(ArrayList<Student> pStudentList, float pAverage){
        ArrayList<Student> successGermanStudentList = new ArrayList<Student>();
        for(Student student:pStudentList){
            if(student.germanNote>=pAverage){
                successGermanStudentList.add(student);
            }
        }
        System.out.println("Almanca dersinde basarili olan ogrenciler: ");

        return successGermanStudentList;
    }
    //Almancadan kalan ogrenciler

    public static ArrayList<Student> unsuccessGermanStudentsData(ArrayList<Student> pStudentList, float pAverage){
        ArrayList<Student> unsuccessGermanStudentList = new ArrayList<Student>();
        for(Student student:pStudentList){
            if(student.germanNote<pAverage){
                unsuccessGermanStudentList.add(student);
            }
        }
        System.out.println("Almanca dersinden kalan ogrenciler: ");

        return unsuccessGermanStudentList;
    }

}
