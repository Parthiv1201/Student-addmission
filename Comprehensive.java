/*For the reference
Assume there are only 2 seats available for the each institute , student with highest merit will get addmission first */


import java.util.*;

interface university
{
    String name_university="Nirma University";
    String adderess="Sarkhej-Gandhinagar Hwy,Gota,\nAhmedabad,Gujrat 382481";
    boolean check_addmission(double cut_of,double m,double s);
}

class student implements university
{
    Scanner sc=new Scanner(System.in);
    public static String name_student[]=new String[50];
    public static double merit[]=new double[50];
    public static String address[]=new String[50];
    public static String institute[]=new String[50];
    public static String dob[]=new String[50];
    public static int total_student=0;
    

    void set(String student_name,String db,String add,double m,String inst)
    {
        name_student[total_student]=student_name;
        dob[total_student]=db;
        address[total_student]=add;
        institute[total_student]=inst;
        merit[total_student]=m;

        total_student++;
    }

    int check_present(String student_name,String db,String add,String insti,double cut_off,int seat,double merit)
    {
        boolean bool=true;
        int c1=1,c2=1,c3=1;
        for(int i=0;i<total_student;i++)
        {
            if(student_name.compareToIgnoreCase(name_student[i])==0)
            c1=0;
            if(db.compareToIgnoreCase(dob[i])==0)
            c2=0;
            if(add.compareToIgnoreCase(address[i])==0)
            c3=0;

            if(c1==0 && c2==0 && c3==0)
            {
                bool=false;
            }
        }
        if(bool)
        {
            System.out.println("______________________________________________________________\n______________________________________________________________\n");
            if(seat<2)         //Direct check addmission with seat(59) assume it as only 2
            {
            boolean b=check_addmission(cut_off,merit,seat);
            if(b)
            {
                seat++;
                print_addmitted_student(student_name,db,add,merit,cut_off,insti,seat);
            }
            else
            {
                print_student_detail(student_name,db,add,merit,cut_off,insti);
                System.out.println("You are not eligible for this institute");
            }
                
            }
            else
            {
                print_student_detail(student_name,db,add,merit,cut_off,insti);
                System.out.println("No seats available for technology\nTry for second institute");
            }
        }
        else
        {
            print_student_detail(student_name,db,add,merit,cut_off,insti);
           System.out.println("You already got addmission in our University"); 
        }

        return seat;
    }

    public boolean check_addmission(double cut_of,double m,double s) //for check addmission
    {
        if(m>=cut_of)
        {
            return true;
        }
        else
        return false;
    }

    void print_addmitted_student(String student_name,String db,String add,double m,double cut_of,String inst,int s) //print student detail
    {
        set(student_name,db,add,m,inst);
        System.out.println("Name : "+student_name+"\nDate of birth : "+db+"\nAdderess : "+add+"\nMerit : "+m);
        System.out.println("Cut off for "+inst+" is "+cut_of+"\nAvailable seats : "+(60-s));
        System.out.println("\n=============================================================================================");
        System.out.println("Congratulation "+student_name+" you got addmission in "+inst+"\n=============================================================================================\n\nHave a great year ahead !\n"+name_university+"\n"+adderess);
        System.out.println("________________________________________________________________\n");
    }
    void print_student_detail(String student_name,String db,String add,double m,double cut_of,String inst)
    {
        System.out.println("Name : "+student_name+"\nDate of birth : "+db+"\nAdderess : "+add+"\nMerit : "+m);
        System.out.println("Cut off for "+inst+" is "+cut_of);
        System.out.println("\n=============================================================================================");
    }

}


class technology extends student
{
    Scanner sc=new Scanner(System.in);
    final double cut_off=87.5;
    static int seat=0;
    int flag=0;

    technology()
    {
        System.out.println("\n\t\t=================== RESULT ==================\n");
    }
    void check_student(String student_name,String dob,String address,double merit)  
    {
        int x=check_present(student_name,dob,address,"Technology",cut_off,seat,merit); //IF same name dob add student is present or not
        seat=x;
    }
}


class management extends student
{
    final double cut_off=77.5;
    static int seat=0;
    int flag=0;
    
    management()
    {
        System.out.println("\n\t\t=========== RESULT ============\n");
    }
    
    void check_student(String student_name,String dob,String address,double merit)  
    {
        int x=check_present(student_name,dob,address,"Management",cut_off,seat,merit); //IF same name dob add student is present or not
        seat=x;
    }

}
class science extends student
{
    final double cut_off=80.5;
    static int seat=0;
    int flag=0;
    science()
    {
        System.out.println("\n\t\t=========== RESULT ============\n");
    }
    void check_student(String student_name,String dob,String address,double merit)  
    {
        int x=check_present(student_name,dob,address,"Science",cut_off,seat,merit); //IF same name dob add student is present or not
        seat=x;
    }
}
class Pharmacy extends student
{
    final double cut_off=80.0;
    static int seat=0;
    int flag=0;
    Pharmacy()
    {
        System.out.println("\n\t\t=========== RESULT ============\n");
    }
    void check_student(String student_name,String dob,String address,double merit)  
    {
        int x=check_present(student_name,dob,address,"Pharmacy",cut_off,seat,merit); //IF same name dob add student is present or not
        seat=x;
    }
}
class Commerce extends student
{
    final double cut_off=90.0;
    static int seat=0;
    int flag=0;
    Commerce()
    {
        System.out.println("\n\t\t=========== RESULT ============\n");
    }
    void check_student(String student_name,String dob,String address,double merit)  
    {
        int x=check_present(student_name,dob,address,"Commerce",cut_off,seat,merit); //IF same name dob add student is present or not
        seat=x;
    }

}


public class Comprehensive
{
    public static void main(String args[])
    {
        int t1=0,t2=0,t3=0,t4=0,t5=0,form_number=0,i0=0,i1=1,i2=2,i3=3,i4=4,choice=0;
        String name_s[]=new String[50];
     double me[]=new double[50];
      String addr[]=new String[50];
     String insti[]=new String[50];
    String date[]=new String[50];
        

        technology t[]=new technology[50];
       management m[]=new management[50];
       science s[]=new science[50];
       Pharmacy p[]=new Pharmacy[50];
       Commerce c[]=new Commerce[50];


        System.out.println("\n\n=============================================================================================\n");
        
        System.out.println("-----------------------------\tSTUDENT MANAGEMENT SYSTEM\t-----------------------------");
        
        System.out.println();
        Scanner sc=new Scanner(System.in);
	System.out.println("-----------------------------\tFILL UP FORM FOR 7 STUDENTS\t-----------------------------");
        
        while(form_number<7)            //Maximum 10 student can apply
        {
            form_number++;

        System.out.println("=============================================================================================\n\t\t\t\t  PLEASE FILL OUT FORM\n=============================================================================================");
        System.out.print("\nEnter your name : ");
         String student_name=sc.next();
        

         System.out.print("\nEnter date of birth : ");
         String dob=sc.next();
    

         System.out.print("\nEnter address : ");
         String address=sc.next();
         

         System.out.print("\nEnter merit : ");
         double merit=sc.nextDouble();

         System.out.println("\nSelect institute");
         System.out.print("1.Technology  2.Management  3.Science  4.Pharmacy  5.Commerce\n\n--->");
         choice=sc.nextInt();

       

        if(choice==1)
        {
            name_s[i0]=student_name;
            date[i0]=dob;
            addr[i0]=address;
            me[i0]=merit;
            i0=i0+5;
          
        }
        else if(choice==2)
        {
            name_s[i1]=student_name;
            date[i1]=dob;
            addr[i1]=address;
            me[i1]=merit;
            i1=i1+5;
         
        }
        else if(choice==3)
        {
            name_s[i2]=student_name;
            date[i2]=dob;
            addr[i2]=address;
            me[i2]=merit;
            i2=i2+5;
        }
        else if(choice==4)
        {
            name_s[i3]=student_name;
            date[i3]=dob;
            addr[i3]=address;
            me[i3]=merit;
            i3=i3+5; 
        }
        else if(choice==5)
        {
            name_s[i4]=student_name;
            date[i4]=dob;
            addr[i4]=address;
            me[i4]=merit;
            i4=i4+5;
        }
    }
    int k=0;
    while(k<5)
    {
    for(int i=k;i<50;i=i+5)
    {
          for(int j=i+5;j<50;j=j+5)
          {
              if(me[i]<me[j])
              {
                  String temp_name=name_s[i];double temp_merit=me[i];String temp_add=addr[i];String temp_inst=insti[i];String temp_date=date[i];
                  name_s[i]=name_s[j];me[i]=me[j];addr[i]=addr[j];insti[i]=insti[j];date[i]=date[j];
                  name_s[j]=temp_name;me[j]=temp_merit;addr[j]=temp_add;insti[j]=temp_inst;date[j]=temp_date;
              }
          } 
    }
    k++;
    }

    for(int i=0;i<50;i++)
    {

    if(i%5==0)
    choice=1;
    else if(i%5==1)
    choice=2;
    else if(i%5==2)
    choice=3;
    else if(i%5==3)
    choice=4;
    else if(i%5==4)
    choice=5;

    switch(choice)
        {
            case 1:
            if(me[i]!=0){
            t[t1]=new technology();
            t[t1].check_student(name_s[i], date[i], addr[i], me[i]);
            t1++;
            }
            
            break;

            case 2:
            if(me[i]!=0){
            m[t2]=new management();
            m[t2].check_student(name_s[i], date[i], addr[i], me[i]);
            t2++;}
            break;

            case 3:
            if(me[i]!=0){
            s[t3]=new science();
            s[t3].check_student(name_s[i], date[i], addr[i], me[i]);
            t3++;}
            break;

            case 4:
            if(me[i]!=0){
            p[t4]=new Pharmacy();
            p[t4].check_student(name_s[i], date[i], addr[i], me[i]);
            t4++;}
            break;

            case 5:
            if(me[i]!=0){
            c[t5]=new Commerce();
            c[t5].check_student(name_s[i], date[i], addr[i], me[i]);
            t5++;}
            break;
        }
    }
    System.out.println("\n______________________________________________________________");
}

        
}


