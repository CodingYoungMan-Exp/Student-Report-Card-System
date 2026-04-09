import java.util.Scanner;
public class StudentReportCardSystem
{
    //declaring a few variables to understand

    //integer variaables
    /**
     * UId : Unique ID of the student
     * marks : marks obtained in each subject
     * avgn : average number of subjects taken by the student
     * nump : numerator for calculating the average marks obtained by the student
     * denom : denominator for calculating the average marks obtained by the student
     * maxMarks : maximum marks for each subject
     */
    int UId = 0, marks = 0, avgn=0, nump = 0, denomp = 0, maxMarks = 0;

    //double variables
    /**
     * avgm : average marks obtained by the student
     * ap : value of A+ grade
     * a : value of A grade
     * am : value of A- grade
     * bp : value of B+ grade
     * b : value of B grade
     * bm : value of B- grade
     * cp : value of C+ grade
     * c : value of C grade
     * cm : value of C- grade
     * dp : value of D+ grade
     * d : value of D grade
     * dm : value of D- grade
     * f : value of F grade
     */
    double avgm, ap, a, am, bp, b, bm, cp, c, cm, dp, d, dm, f;

    //string variables
    /**
     * name : name of the student
     * grd : grade obtained by the student in each subject (used for storing the grade in case of Alphabetical grade system)
     * gtype : type of grade system chosen by the student
     */
    String name="", grd = "",gtype ="";
    String subm[] = new String[avgn]; //array to store the subjects taken by the student
    
    Scanner sc = new Scanner(System.in);
    
//we will get to know the array size (1D) during the input phase : done
    
    StudentReportCardSystem() //Intialising the values of grades when they are entered in charcters
    {
        //defining the list on which the assingments or exams are attested on :
        /**
         A+ above 4.0
         A 4.0
         A- above 3.5 but below 4.0
         B+ above 3.0 but below 3.5
         B 3.0
         B- above 2.7 but below 3.0
         C+ above 2.0 but below 2.5
         C 2.0
         C- above 1.7 but below 2.0
         D+ above 1.0 but below 1.5
         D 1.0
         D- above 0.0 but below 1.0
         F 0.0
         */

         //since the list has been attested, I will be adding my own specific values for each letter and its type

         ap=4.2;
         a=4.0;
         am=3.8;
         bp=3.3;
         b=3.0;
         bm=2.8;
         cp=2.3;
         c=2.0;
         cm=1.8;
         dp=1.3;
         d=1.0;
         dm=0.5;
         f=0.0;

         //other

         avgm=0.0;
    }

    public void input_Main_Details()
    {
        System.out.println("Calculate marks, percentage, and grade easily.");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("Enter your Name :");
        name = sc.nextLine();
        System.out.println();
        System.out.println("Enter your unique ID if any :");
        UId = sc.nextInt();
        System.out.print("Enter the number of grades//majors you have taken :"); 
        avgn=sc.nextInt();
        System.out.println();
        System.out.println("Enter your grade accoring to the following instructions : ");
        System.out.println("Enter [N] for Numerical \t [A] for Alphabetical");
        gtype = sc.next();
        sc.nextLine(); //to consume the newline character after nextInt() and next()
        subm = new String[avgn];
    }

    public void input_Grades()
    {
        System.out.println("Enter the subjects//majors you have taken :");
        for(int i=0; i<avgn;i++)
        {
            System.out.print("Subject "+(i+1)+" : ");
            subm[i]=sc.nextLine();
        }

        //now all subjects are inside the array which is good

        //now inputiing the marks/grades based on the character they have chosen above - using switch case construct

        switch(gtype)
        {
            case "N" -> {
                for(int i=0; i<avgn;i++)
                {
                    System.out.print("Marks obtained in "+subm[i]+" : ");
                    marks = sc.nextInt();
                    System.out.println("Enter the maximum marks for "+subm[i]+" : ");
                    maxMarks = sc.nextInt();
                    nump = nump + marks;
                    denomp = denomp + maxMarks;
                }
                avgm = (double)nump/denomp*100; //calculating the average marks obtained by the student in percentage
            }
            
            case "A" -> {
                for(int i=0; i<avgn;i++)
                {
                    System.out.print("Grade obtained in "+subm[i]+" : ");
                    grd = sc.next();                        
                    switch(grd)
                    {
                        case "A+" -> avgm = avgm + ap;
                        case "A" -> avgm = avgm + a;
                        case "A-" -> avgm = avgm + am;
                        case "B+" -> avgm = avgm + bp;
                        case "B" -> avgm = avgm + b;
                        case "B-" -> avgm = avgm + bm;
                        case "C+" -> avgm = avgm + cp;
                        case "C" -> avgm = avgm + c;
                        case "C-" -> avgm = avgm + cm;
                        case "D+" -> avgm = avgm + dp;
                        case "D" -> avgm = avgm + d;
                        case "D-" -> avgm = avgm + dm;
                        case "F" -> avgm = avgm + f;
                        default -> {
                            System.out.println("Invalid grade entered");
                            System.exit(0);
                        }
                    }
                }
                avgm = avgm/avgn;
            }

            default -> {
                System.out.println("Invalid grade type entered");
                System.exit(0);                    
            }

        }
    }

    public static void main(String[] args) 
{
    StudentReportCardSystem object = new StudentReportCardSystem();

    // Header
    System.out.println("==================================================");
    System.out.println("            STUDENT REPORT CARD SYSTEM            ");
    System.out.println("==================================================");

    object.input_Main_Details();
    object.input_Grades();

    // Output Card
    System.out.println("\n==================================================");
    System.out.println("                    REPORT CARD                   ");
    System.out.println("==================================================");

    System.out.printf("| %-45s |\n", "Name: " + object.name);

    System.out.printf("| %-45s |\n", "Unique ID: " + object.UId);

    System.out.println("|-----------------------------------------------|");

    System.out.println("| Subjects Entered:                      |");
        for(int i = 0; i < object.avgn; i++) 
            {
                System.out.printf("| - %-42s |\n", object.subm[i]);
            
            }
    System.out.printf("| %-45s |\n", "Average Score: " + String.format("%.2f", object.avgm));

    System.out.println("==================================================");
}
}
