import java.util.Scanner;

public class Student {    
    private String ID;
    private static int idCounter = 0;
    private String contactInformation;
    private String[] enrolledCourses;
    private int coursePrice = 600;
    public String studentFirstName;
    public String studentLastName;
    public String gradeYear;

    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.studentFirstName = sc.nextLine();

        System.out.print("Enter student last name: ");
        this.studentLastName = sc.nextLine();

        System.out.print("Enter grade year: Freshman Sophomore Junior Senior\n");
        this.gradeYear = sc.nextLine();

        System.out.print("Enter your phone number: (999)-999-");
        this.contactInformation = sc.nextLine();

        String id = this.generateID(studentFirstName, studentLastName, gradeYear);
        System.out.println("Your student ID is: " + id);

        enrollCourse();
          }
    
    private static String generateID(String studentFirstName, String studentLastName, String gradeYear) {
        String firstNameAbbreviation = studentFirstName.substring(0, 1).toUpperCase();
        String lastNameAbbreviation = studentLastName.substring(0, 1).toUpperCase();
        String gradeLevel = gradeYear.substring(0, 1).toUpperCase();
        int uniqueNumber = idCounterNumber();
        return firstNameAbbreviation + lastNameAbbreviation + gradeLevel + uniqueNumber;
    }

    private static int idCounterNumber() {
        int counter = idCounter;
        idCounter++;
        return counter;
    }

    
    public void enrollCourse() {
        Enroll newEnroll = new Enroll();
        this.enrolledCourses = newEnroll.enrollCourses();
    }
 class Enroll {
        public String[] enrollCourses() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nWould you like to enroll into your courses: YES NO");
            String enrollment = sc.nextLine();
    
            if (enrollment.toLowerCase().equals("yes"))
            {
                System.out.print("Enter the number of courses you would like to enroll: ");
                int numberOfCourses = sc.nextInt();   
                sc.nextLine();
    
                String[] enrolledCourses = new String[numberOfCourses];
    
                System.out.println("Enter the course you would like to enroll: PHYS180 BIO120");
                for (int i = 0; i < numberOfCourses; i++)
                {
                    enrolledCourses[i] = sc.nextLine();
                }
                System.out.println("\nYou've successfully enrolled in " + enrolledCourses.length + " courses.");
                return enrolledCourses;    
            }
            else
            {
                return new String[0];
            }
        }
        
    }


public double calculateTuition(String[] enrolledCourses) {
        if (enrolledCourses.length == 0)
        {
            System.out.print("You've yet enrolled in any courses yet...");
            return 0.0;
        }
        else
        {
            return enrolledCourses.length * coursePrice;
        }
    }
    
 public void checkStatus() {
        if (enrolledCourses == null)
        {
            enrollCourse();
        }
        double tuition = calculateTuition(enrolledCourses);
        if (tuition == 0.0)
        {
            if (studentFirstName == null || studentLastName == null)
            {
                Student stud = new Student();
                stud.enrollCourse();
            }
            enrollCourse();
        }
        else
        {
            String id = generateID(studentFirstName, studentLastName, gradeYear);
            System.out.println("\nYour id is: " + id);
            System.out.println("Your tuition amount is: $" + tuition);
            System.out.println("The courses you've enrolled in are: " );
            for (int i = 0; i < enrolledCourses.length; i++)
            {
                System.out.println(enrolledCourses[i]);
            }
        }
       
    }
}