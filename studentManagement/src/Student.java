import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = " ";
    private int tutitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor prompts user to enter student's name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\n Enter student grade: ");
        this.gradeYear = in.nextInt();
        setStudentID();



    }

    // Generate an ID
private void setStudentID(){
        //Gradeyear + ID
    id++;
    this.studentID = gradeYear + "" + id;

}

    // Enroll in Courses
public void enroll(){
//Get inside a loop, user hits 0 when done enrolling
    do {
        System.out.print("Enter course to enroll(Q for quit): ");
        Scanner in = new Scanner(System.in);
        String course = in.nextLine();
        if (!course.equals("Q")) {
            courses = courses + "\n " + course;
            tutitionBalance = tutitionBalance + costOfCourse;
        }
else{break;}
    }while(1 != 0);




    }
    //View Balance
    public void viewBalance(){
        System.out.println("Your Balance is: $" + tutitionBalance);
    }
 //Pay tution
    public void payTution(){
        viewBalance();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your payment: $");
        int payment = in.nextInt();
        tutitionBalance = tutitionBalance-payment;
        System.out.println("Thank you for your payment of: $" + payment);
        viewBalance();
    }

    // Show status
    public String toString(){
return "Name: " + firstName +" " + lastName +
        "\nGrade Level: " + gradeYear +
        "\nStudent ID: " + studentID +
        "\nCourses Enrolled :" + courses +
        "\nBalance: $" + tutitionBalance;
    }
}
