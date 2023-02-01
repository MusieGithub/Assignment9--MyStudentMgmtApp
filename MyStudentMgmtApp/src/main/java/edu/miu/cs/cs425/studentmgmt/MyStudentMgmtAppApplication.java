package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TranscriptService transcriptService;
	@Autowired
	private ClassroomService classroomService;
	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s1 = new Student(null, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019,5, 24));
	var savedS1= createNewStudent(s1);

	var cl= new Classroom(null, "V11", "Verill" );
	//s1.setClassroom(c1);
	Transcript t1 = new Transcript(null, "t101",s1);
	Course c1= new Course(null, "CS425", "Software Engineering");
var students = getAllStudents();
students.forEach(System.out::println);
	}
	private Student createNewStudent(Student student)
	{
		return studentService.saveStudent(student);
	}

	private Course addCourse(Course course)
	{
		return courseService.saveCourse(course);
	}
	private Transcript addTranscript(Transcript transcript)
	{
		return transcriptService.saveTranscript(transcript)

	}
	private Classroom addClassroom(Classroom classroom)
	{
		return classroomService.saveClassroom(classroom);
	}

	public Iterable<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
}
