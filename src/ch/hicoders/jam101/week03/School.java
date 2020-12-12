package ch.hicoders.jam101.week03;
import ch.hicoders.jam101.week03.Person.Student;
import java.util.*;

public class School {
    public static void main(String[] args) {
        System.out.println("deneme");
        ArrayList<Student> studentList = School.loadStudentsData();
        School.renderArray(studentList);
        float averageList[]= School.averageStudentNote(studentList);
        School.renderAverageNote(averageList);

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
}
