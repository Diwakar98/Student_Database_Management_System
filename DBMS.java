import java.util.Iterator;
import java.io.*;
class LinkedList<T> implements LinkedList_<T>{
     Position<T> head;
     Position<T> tail;
     int size;
     LinkedList(){
          this.size=0;
          this.head=null;
          this.tail=null;
     }
     public String getStringofcourses(Student s){
          Position<T> position=head;
          String temp="";
          Course c;
          while(position.after()!=null){
               c=(Course)position.value();
               temp+=c.coursenum()+" "+c.getgrade()+" ";
               position=position.after();
          }
          c=(Course)position.value();
          temp+=c.coursenum()+" "+c.getgrade();
          return temp;
     }
     public int count(){
          return size;
     }
     public void add(T e){
          Position<T> node=new Position<T>(e);
          if(head==null){
               this.head=node;
               this.tail=node;
          }
          else{
               this.tail.setnext(node);
               this.tail=node;
          }
          this.size++;
     }
     public Student getStudentObject(String data){
          Position<T> position=head;
          Student student=null;
          while(position.after()!=null){
               student=(Student)position.value();
               if(Character.isDigit(data.charAt(0))){
                    if((student.getentryno()).equals(data)){
                         break;
                    }
               }
               else if(Character.isLetter(data.charAt(0))){
                    if((student.name()).equals(data)){
                         break;
                    }
               }
               position=position.after();
          }
          student=(Student)position.value();
          return student;
     }
     public Hostel getHostelObject(String tobesearched){
          Position<T> position=head;
          Hostel h=null;
          while(position.after()!=null){
               h=(Hostel)position.value();
               if((h.name()).equals(tobesearched)){
                    break;
               }
               position=position.after();
          }
          h=(Hostel)position.value();
          return h;
     }
     public Course getCourseObject(String coursenum){
          Position<T> position=head;
          Course course=null;
          while(position.after()!=null){
               course=(Course)position.value();
               if((course.coursenum()).equals(coursenum)){
                    break;
               }
               position=position.after();
          }
          course=(Course)position.value();
          return course;
     }
     public Department getDepartmentObject(String department){
          Position<T> position=head;
          Department d=null;
          while(position.after()!=null){
               d=(Department)position.value();
               if((d.name()).equals(department)){
                    break;
               }
               position=position.after();
          }
          d=(Department)position.value();
          return d;
     }
     public boolean checkifalreadypresent(T e){
          Position<T> position=head;
          boolean found=false;
          Position<T> obj=new Position<T>(e);
          if(head!=null){
               if((obj.value().getClass().getName()).equals("Hostel")){
                    while(position.after()!=null){
                         String str1=((Hostel)position.value()).name();
                         String str2=((Hostel)obj.value()).name();
                         if(str1.equals(str2)){
                              found=true;
                              break;
                         }
                         position=position.after();
                    }
                    String str1=((Hostel)position.value()).name();
                    String str2=((Hostel)obj.value()).name();
                    if(str1.equals(str2)){
                         found=true;
                    }
               }
               if((obj.value().getClass().getName()).equals("Student")){
                    while(position.after()!=null){
                         String str1=((Student)position.value()).name();
                         String str2=((Student)obj.value()).name();
                         if(str1.equals(str2)){
                              found=true;
                              break;
                         }
                         position=position.after();
                    }
                    String str1=((Student)position.value()).name();
                    String str2=((Student)obj.value()).name();
                    if(str1.equals(str2)){
                         found=true;
                    }
               }
               if((obj.value().getClass().getName()).equals("Department")){
                    while(position.after()!=null){
                         String str1=((Department)position.value()).name();
                         String str2=((Department)obj.value()).name();
                         if(str1.equals(str2)){
                              found=true;
                              break;
                         }
                         position=position.after();
                    }
                    String str1=((Department)position.value()).name();
                    String str2=((Department)obj.value()).name();
                    if(str1.equals(str2)){
                         found=true;
                    }
               }
               if((obj.value().getClass().getName()).equals("Course")){
                    while(position.after()!=null){
                         String str1=((Course)position.value()).coursenum();
                         String str2=((Course)obj.value()).coursenum();
                         if(str1.equals(str2)){
                              found=true;
                              break;
                         }
                         position=position.after();
                    }
                    String str1=((Course)position.value()).coursenum();
                    String str2=((Course)obj.value()).coursenum();
                    if(str1.equals(str2)){
                         found=true;
                    }
               }
          }
          return found;
     }
     public String print(){
          Position<T> position=head;
          String str="";
          if((position.value().getClass().getName()).equals("Student")){
               Student s=(Student)position.value();
               while(position.after()!=null){
                    s=(Student)position.value();
                    str+=s.getentryno()+" ";
                    position=position.after();
               }
               s=(Student)position.value();
               str+=s.getentryno()+" ";
          }
          return str.trim();
     }
}
class Position<T> implements Position_<T>{
     public T data;
     public Position<T> next;
     public Position() {
          this.data = null;
          this.next = null;
	}

	public Position(T obj) {
		this.data = obj;
		this.next = null;
	}

	public T value() {
		return this.data;
	}

	public Position<T> after() {
		return this.next;
	}

	public void setnext(Position<T> next) {
		this.next = next;
	}
}
class Student implements Student_{
     public String name;
     public String entryno;
     public String hostel;
     public String department;
     public String completedCredits;
     public String cgpa;
     public int noofcourses;

     LinkedList<Course> allCourses=new LinkedList<Course>();
     Student(){
          this.completedCredits="";
          this.allCourses=null;
          this.name="";
          this.department="";
          this.entryno="";
          this.hostel="";
          this.cgpa="";
          this.noofcourses=0;
     }
     Student(String name,String entryno, String hostel, String department){
          this.allCourses=new LinkedList<Course>();
          this.name=name;
          this.entryno=entryno;
          this.hostel=hostel;
          this.department=department;
          this.completedCredits="";
          this.cgpa="";
          this.noofcourses=0;
     }
     public int getnoofcourses(){
          return this.noofcourses;
     }
     public String getallcoursesofstudent(){
          return allCourses.getStringofcourses(this);
     }
     public LinkedList getlistofcourses(){
          return this.allCourses;
     }
     public void addcourse(Course c){
          this.noofcourses++;
          this.allCourses.add(c);
     }
     public void setname(String name){
          this.name=name;
     }
     public String name(){
          return this.name;
     }
     public void setentryno(String entryno){
          this.entryno=entryno;
     }
     public String getentryno(){
          return this.entryno;
     }
     public void sethostel(String hostel){
          this.hostel=hostel;
     }
     public String hostel(){
          return this.hostel;
     }
     public void setdepartment(String department){
          this.department=department;
     }
     public String getdepartment(){
          return this.department;
     }
     public void updatecompletedCredits(String newcredits){
          //int credit1=Integer.parseInt(newcredits);
          this.completedCredits+=newcredits+" ";
     }
     public String getcompletedcredits(){
          return this.completedCredits;
     }
     public String getcgpa(){
          return this.cgpa;
     }
     public void calculatecgpa(){
          GradeInfo_.LetterGrade gradepoint=null;
          String arr[]=(this.completedCredits).split(" ");
          int credits=0;
          for(int i=0; i<arr.length; i++){
               switch(arr[i]){
                    case "A":
                         credits+=10;
                         break;
                    case "Aminus":
                         credits+=9;
                         break;
                    case "B":
                         credits+=8;
                         break;
                    case "Bminus":
                         credits+=7;
                         break;
                    case "C":
                         credits+=6;
                         break;
                    case "Cminus":
                         credits+=5;
                         break;
                    case "D":
                         credits+=4;
                         break;
                    default:
                         credits+=0;

               }
          }
          float tempcgpa=credits/(float)arr.length;
          tempcgpa=tempcgpa*100;
          tempcgpa=Math.round(tempcgpa);
          tempcgpa=tempcgpa/100;
          this.cgpa= tempcgpa+"";
     }

}
class Hostel implements Entity_{
     String name=null;
     LinkedList<Student> allstudents=new LinkedList<Student>();
     Hostel(String name){
          this.name=name;
     }
     public String name(){
          return this.name;
     }
     public Iterator<Student_> studentList(){
          return null;
     }
     public void addstudent(Student s){
          this.allstudents.add(s);
     }
     public LinkedList getlist(){
          return this.allstudents;
     }
     public String printstudents(){
          return this.allstudents.print();
     }
}
class Department implements Entity_{
     String name;
     LinkedList<Student> allstudents=new LinkedList<Student>();
     Department(String name){
          this.name=name;
          allstudents=new LinkedList<Student>();
     }
     public Iterator<Student_> studentList(){
          return null;
     }
     public String name(){
          return this.name;
     }
     public LinkedList getlist(){
          return this.allstudents;
     }
     public void addstudent(Student s){
          this.allstudents.add(s);
     }
     public String printstudents(){
          return this.allstudents.print();
     }
}
class Course implements CourseGrade_{
     String num=null;
     String title=null;
     String grade="";
     int noofcourses=0;
     LinkedList<Student> allstudents=new LinkedList<Student>();
     Course(String num){
          this.num=num;
          this.title="";
          this.grade="";
          this.noofcourses=0;
     }
     Course(String title,String num){
          this.num=num;
          this.title=title;
          this.grade="";
          this.noofcourses=0;
     }
     Course(String title,String num,String grade){
          this.num=num;
          this.title=title;
          this.grade=grade;
          this.noofcourses=0;
     }
     public String coursenum(){
          return this.num;
     }
     public Iterator<Student_> studentList(){
          return null;
     }
     public void addstudent(Student s){
          this.allstudents.add(s);
          this.noofcourses++;
     }
     public LinkedList getlist(){
          return this.allstudents;
     }
     public String coursetitle(){
          return this.title;
     }
     public String getgrade(){
          return this.grade;
     }
     public int getnoofcoursesofstudent(Student s){
          return this.noofcourses;
     }
     public String printstudents(){
          return this.allstudents.print();
     }
}
public class DBMS {
     public static LinkedList<Hostel> allHostels=new LinkedList<Hostel>();
     public static LinkedList<Department> allDepartments=new LinkedList<Department>();
     public static LinkedList<Course> allCourses=new LinkedList<Course>();
     public static LinkedList<Student> allstudents=new LinkedList<Student>();
     public static String output="";
     private static void answerQueries(File student_query_file)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(student_query_file));
          String str="";
          while((str=br.readLine())!=null){
               String arr[]=str.split(" ");
               String keyword=arr[0];

               if(keyword.equals("INFO")){
                    String entryno=arr[1];
                    Student s=(Student)allstudents.getStudentObject(entryno);
                    s.calculatecgpa();
                    String arr1[]=new String[s.getnoofcourses()];
                    String arr2[]=(s.getallcoursesofstudent()).split(" ");
                    int j=0;
                    for(int i=0; i<arr2.length-1; i=i+2){
                         arr1[j++]=arr2[i]+" "+arr2[i+1];
                    }
                    String info=s.getentryno()+" "+s.name()+" "+s.getdepartment()+" "+s.hostel()+" "+s.getcgpa()+" "+(sort(arr1));
                    output=info+"\n"+output;
               }
               else if(keyword.equals("COURSETITLE")){
                    String coursenum=arr[1];
                    Course c=allCourses.getCourseObject(coursenum);
                    output=c.coursetitle()+"\n"+output;
               }
               else if(keyword.equals("SHARE")){
                    String entryno=arr[1];
                    String entity=arr[2];
                    Department d=new Department(entity);
                    Course c=new Course(entity);
                    Hostel h=new Hostel(entity);
                    if(allHostels.checkifalreadypresent(h)){
                         h=allHostels.getHostelObject(entity);
                         String str1=" "+h.printstudents()+" ";
                         int index=str1.indexOf(entryno);
                         String str2=str1.substring(0,index-1)+" "+str1.substring(index+11);
                         String arr1[]=str2.split(" ");
                         output=sort(arr1).trim()+"\n"+output;
                    }
                    else if(allCourses.checkifalreadypresent(c)){
                         c=allCourses.getCourseObject(entity);
                         String str1=" "+c.printstudents()+" ";
                         int index=str1.indexOf(entryno);
                         String str2=str1.substring(0,index-1)+" "+str1.substring(index+10);
                         String arr1[]=str2.split(" ");
                         output=sort(arr1).trim()+"\n"+output;
                    }
                    else if(allDepartments.checkifalreadypresent(d)){
                         d=allDepartments.getDepartmentObject(entity);
                         String str1=" "+d.printstudents()+" ";
                         int index=str1.indexOf(entryno);
                         String str2=str1.substring(0,index-1)+" "+str1.substring(index+11);
                         String arr1[]=str2.split(" ");
                         System.out.print(sort(arr1).trim());
                         output=sort(arr1).trim()+"\n"+output;
                    }
               }
          }
          br.close();
	}
     public static String sort(String arr[]){
          String sortedString="";
          for(int i=0; i<arr.length; i++){
               for(int j=0; j<arr.length; j++){
                    if(arr[i].compareTo(arr[j])<0){
                         String temp=arr[i];
                         arr[i]=arr[j];
                         arr[j]=temp;
                    }
               }
          }
          for(int i=0; i<arr.length; i++){
               sortedString+=arr[i]+" ";
          }
          return sortedString.trim();
     }
	private static void getData(File student_record_file,File course_record)throws IOException{

		BufferedReader br1=new BufferedReader(new FileReader(student_record_file));
          BufferedReader br2=new BufferedReader(new FileReader(course_record));
		String str="";
          while((str=br1.readLine())!=null){
               String arr[]=str.split(" ");
               Hostel h=new Hostel(arr[3]);
               Student s=new Student(arr[1],arr[0],arr[3],arr[2]);
               Department d=new Department(arr[2]);
               h.addstudent(s);
               d.addstudent(s);
               allstudents.add(s);
               if(allHostels.checkifalreadypresent(h)){
                    Hostel h1=allHostels.getHostelObject(h.name());
                    h1.addstudent(s);
               }
               else{
                    allHostels.add(h);
               }

               if(allDepartments.checkifalreadypresent(d)){
                    Department d1=allDepartments.getDepartmentObject(d.name());
                    d1.addstudent(s);
               }
               else{
                    allDepartments.add(d);
               }
          }

          while((str=br2.readLine())!=null){
               String entryno="";
               String title="";
               String num="";
               String grade="";
               entryno=str.substring(0,10);
               num=str.substring(11,17);
               if((str.substring(19,20)).equals(" ")){
                    grade=str.substring(18,19);
                    title=str.substring(20);
               }
               else{
                    grade=str.substring(18,24);
                    title=str.substring(25);
               }

               LinkedList<Course> l1=null;
               Course c=new Course(title,num);
               Course c1=new Course(title,num,grade);
               Student s=(Student)allstudents.getStudentObject(entryno);
               c.addstudent(s);
               s.addcourse(c1);
               if(allCourses.checkifalreadypresent(c)){
                    Course c2=allCourses.getCourseObject(c1.coursenum());
                    c2.addstudent(s);
               }
               else{
                    allCourses.add(c);
               }
               s.updatecompletedCredits(grade);
          }
          br1.close();
          br2.close();
	}
	public static void main(String args[])throws IOException{
          //If you want to give comman line argument
		//File student_record_file=new File(args[0]);
		//File course_record=new File(args[1]);
		//File student_query_file=new File(args[2]);

          //If you want to give input as a file
		File student_record_file=new File("Sample_Input_Output/student_record_file.txt");
		File course_record=new File("Sample_Input_Output/course_file.txt");
		File student_query_file=new File("Sample_Input_Output/student_query_file.txt");
	  getData(student_record_file,course_record);
          answerQueries(student_query_file);
          output=output.trim();
          	FileWriter writer=new FileWriter("Sample_Input_Output/Output.txt");
          writer.write(output);
          writer.close();
	}
}
