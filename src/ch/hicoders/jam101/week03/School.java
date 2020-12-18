package ch.hicoders.jam101.week03;
import ch.hicoders.jam101.week03.Person.Student;
import java.util.*;

public class School {
    public static void main(String[] args) {
        ArrayList<Student> studentList = School.loadStudentsData();
        School.renderArray(studentList);
        double averageList[]= School.averageStudentNote(studentList);
        School.renderAverageNote(averageList);
        ArrayList<Student> successMathStudentsList = School.successMathStudentsData(studentList,averageList[0]);
        School.renderArray(successMathStudentsList);
        ArrayList<Student> unsuccessMathStudentsList = School.unsuccessMathStudentsData(studentList,averageList[0]);
        School.renderArray(unsuccessMathStudentsList);
        ArrayList<Student> successGermanStudentsList = School.successGermanStudentsData(studentList,averageList[1]);
        School.renderArray(successGermanStudentsList);
        ArrayList<Student> unsuccessGermanStudentsList = School.unsuccessGermanStudentsData(studentList,averageList[1]);
        School.renderArray(unsuccessGermanStudentsList);
        ArrayList<Student> mostSuccessStudentsList= School.findMaxMathNote(studentList);
        School.renderArray(mostSuccessStudentsList);
        ArrayList<Student> minMathNoteStudentsList= School.findMinMathNote(studentList);
        School.renderArray(minMathNoteStudentsList);
        ArrayList<Student> mostSuccessGermanStudentsList= School.findMaxGermanNote(studentList);
        School.renderArray(mostSuccessGermanStudentsList);
        ArrayList<Student> minGermanNoteStudentsList= School.findMinGermanNote(studentList);
        School.renderArray(minGermanNoteStudentsList);

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
        System.out.println("Butun ogrencilerin Listesi:");
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
   public static double[] averageStudentNote(ArrayList<Student> pStudentList){
        double totalMathNote=0;
        double totalGermanNote=0;
        for(Student student:pStudentList)
        {
           totalMathNote+=student.mathNote;
           totalGermanNote+=student.germanNote;
        }
        double averageMathNote=totalMathNote/pStudentList.size();
        double averageGermanNote=totalGermanNote/pStudentList.size();
        return  new double[] {averageMathNote, averageGermanNote};

    }
    // ogrencilerin not ortalamsini ekrana yazdiran method
    public static void renderAverageNote(double[] pArray){
        System.out.println("average Math grades:"+pArray[0]);
        System.out.println("Average German Grades: "+pArray[1]);

    }
    /*en yuksek matematik notu alan ogrencileri bulan method
    * oncelikle en yukek not tespit edildi. Daha sonra bu notu olan ogrencilerden yeni bir dizi olusturuldu.
    */
    public static ArrayList<Student>  findMaxMathNote(ArrayList<Student> pStudentList){
        ArrayList<Student>mostSuccessStudentsList = new ArrayList<Student>();
        int maxNote=pStudentList.get(0).mathNote;
        for(Student student:pStudentList)
        {
            if(student.mathNote>maxNote){
               maxNote=student.mathNote;
           }
        }
        for(Student student:pStudentList){
            if(student.mathNote==maxNote){
                mostSuccessStudentsList.add(student);
            }
        }
        System.out.println("Matematikten enyuksek Not: "+maxNote);
        System.out.println("Matematikten enyuksek Notu alan ogrenciler");
        return mostSuccessStudentsList;
    }
    /*en dusuk matematik notu alan ogrencileri bulan method
     * oncelikle en dusuk not tespit edildi. Daha sonra bu notu olan ogrencilerden yeni bir dizi olusturuldu.
     */
    public static ArrayList<Student>  findMinMathNote(ArrayList<Student> pStudentList){
        ArrayList<Student>minMathNoteStudentsList = new ArrayList<Student>();
        int minNote=pStudentList.get(0).mathNote;
        for(Student student:pStudentList)
        {
            if(student.mathNote<minNote){
                minNote=student.mathNote;
            }
        }
        for(Student student:pStudentList){
            if(student.mathNote==minNote){
                minMathNoteStudentsList.add(student);
            }
        }
        System.out.println("Matematikten endusuk Not: "+minNote);
        System.out.println("Matematikten endusuk Notu alan ogrenciler");
        return minMathNoteStudentsList;
    }
    /*en yuksek Almanca notu alan ogrencileri bulan method
     * oncelikle en yukek not tespit edildi. Daha sonra bu notu olan ogrencilerden yeni bir dizi olusturuldu.
     */
    public static ArrayList<Student>  findMaxGermanNote(ArrayList<Student> pStudentList){
        ArrayList<Student>mostSuccessGermanStudentsList = new ArrayList<Student>();
        int maxNote=pStudentList.get(0).germanNote;
        for(Student student:pStudentList)
        {
            if(student.germanNote>maxNote){
                maxNote=student.germanNote;
            }
        }
        for(Student student:pStudentList){
            if(student.germanNote==maxNote){
                mostSuccessGermanStudentsList.add(student);
            }
        }
        System.out.println("Almanca enyuksek Not: "+maxNote);
        System.out.println("Almancadan enyuksek Notu alan ogrenciler");
        return mostSuccessGermanStudentsList;
    }
    /*en dusuk Almanca notu alan ogrencileri bulan method
     * oncelikle en dusuk not tespit edildi. Daha sonra bu notu olan ogrencilerden yeni bir dizi olusturuldu.
     * */
    public static ArrayList<Student>  findMinGermanNote(ArrayList<Student> pStudentList){
        ArrayList<Student>minGermanNoteStudentsList = new ArrayList<Student>();
        int minNote=pStudentList.get(0).germanNote;
        for(Student student:pStudentList)
        {
            if(student.germanNote<minNote){
                minNote=student.germanNote;
            }
        }
        for(Student student:pStudentList){
            if(student.germanNote==minNote){
                minGermanNoteStudentsList.add(student);
            }
        }
        System.out.println("Almancada en dusuk Not: "+minNote);
        System.out.println("Almancadan en dusuk Notu alan ogrenciler");
        return minGermanNoteStudentsList;
    }
    //Matamatikten gecen ogrenciler
    public static ArrayList<Student> successMathStudentsData(ArrayList<Student> pStudentList,double pAverage){
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
    public static ArrayList<Student> unsuccessMathStudentsData(ArrayList<Student> pStudentList,double pAverage){
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

    public static ArrayList<Student> successGermanStudentsData(ArrayList<Student> pStudentList,double pAverage){
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

    public static ArrayList<Student> unsuccessGermanStudentsData(ArrayList<Student> pStudentList,double pAverage){
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
