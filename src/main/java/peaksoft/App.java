package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        HibernateConfig.getEntityManager();

        CourseRepService courseRepService = new CoursePerServiceImpl();
        InstructorRepService instructorRepService = new InstructorRepServiceImpl();
        LessonRepoService lessonRepoService = new LessonRepServiceImpl();
        TaskReposService taskReposService = new TaskRepServiceImpl();

        Course course = new Course("Java",365, LocalDate.of(2021,9,1),"photo","programming");
        Course course2 = new Course("js",31, LocalDate.of(2022,4,2),"photo","programming");
        Course course3 = new Course("python",363, LocalDate.of(2020,1,11),"photo","programming");

        Instructor instructor = new Instructor("Aijamal","Asangazieva","Aijamal@gmail.com", 219318318);
        Instructor instructor1 = new Instructor("Rahim","Kurbanov","Rahim@gmail.com", 119311318);
        Instructor instructor3 = new Instructor("Muhammed","Toichubaev","Muhammed@gmail.com", 329318318);

        Lesson lesson = new Lesson("YouTube","Java");
        Lesson lesson1 = new Lesson("LMS","Js");
        Lesson lesson2 = new Lesson("Google","Python");

        Task task = new Task("JDBC",LocalDate.of(2022,8,1),"Hibernate");
        Task task1 = new Task("Hibernate",LocalDate.of(2020,2,3),"JDBC");
        Task task2 = new Task("OOP",LocalDate.of(2021,9,5),"Interface");


        while (true) {
            System.out.println("""
                                 ======COURSE COMMANDS======
                                 1.SAVE COURSE : 
                                 2.GET COURSE BY ID :
                                 3.GET ALL COURSE :
                                 4.UPDATE COURSE :
                                 5.DELETE COURSE BY ID :
                                 6.GET COURSE BY NAME :
                                 ======INSTRUCTOR COMMANDS======
                                 7.SAVE INSTRUCTOR :
                                 8.UPDATE INSTRUCTOR :
                                 9.GET INSTRUCTOR BY ID :
                                 10.GET INSTRUCTOR BY COURSE ID :
                                 11.DELETE INSTRUCTOR BY ID :
                                 12.ASSIGN INSTRUCTOR TO COURSE :
                                 ======LESSON COMMANDS======
                                 13.SAVE LESSON :
                                 14.UPDATE LESSON :
                                 15.GET LESSON BY ID :
                                 16.GET LESSON BY COURSE ID :
                                 ======TASK COMMANDS======
                                 17.SAVE TASK :
                                 18.UPDATE TASK :
                                 19.GET ALL TASK BY LESSON ID :
                                 20.DELETE TASK BY ID : 
                                 =====   ENTER BY COMMANDS: """);
            int choose=new Scanner(System.in).nextInt();
            switch (choose){
                case 1 -> courseRepService.saveCourse(course);
                case 2 -> {
                    System.out.println("Enter by course id: ");
                    System.out.println(courseRepService.getCourseById(course.getId()));
                }
                case 3 -> System.out.println(courseRepService.getAllCourse());
                case 4 ->{
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    courseRepService.update(courseId, course2);
                }
                case 5 -> {
                    System.out.println("Enter by course id:");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(courseRepService.deleteCourseById(courseId));
                }
                case 6 -> {
                    System.out.println("Enter by course name");
                    String courseName = new Scanner(System.in).nextLine();
                    System.out.println(courseRepService.getByCourseName(courseName));
                }
                case 7 -> System.out.println(instructorRepService.saveInstructor(instructor1));
                case 8 -> {
                    System.out.println("Enter by instructor id :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    instructorRepService.updateInstructor(instructorId, instructor3);
                }
                case 9 -> {
                    System.out.println("Enter by instructor id :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    System.out.println(instructorRepService.getInstructorById(instructorId));
                }
                case 10 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(instructorRepService.getInstructorByCourseId(courseId));
                }
                case 11 -> {
                    System.out.println("Enter by instructorId :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    System.out.println(instructorRepService.getInstructorById(instructorId));
                }
                    case 12 -> {
                        System.out.println("Enter by instructor id :");
                        Long id = new Scanner(System.in).nextLong();
                        System.out.println("Enter by course id :");
                        Long courseId = new Scanner(System.in).nextLong();
                        instructorRepService.assignInstructorToCourse(instructor.getId(), courseId);
//
                    }
                    case 13 -> {
                        System.out.println("Enter by course id :");
                        Long courseId = new Scanner(System.in).nextLong();
                        System.out.println(lessonRepoService.saveLesson(courseId, lesson1));
                    }
                    case 14 -> {
                        System.out.println("Enter by lesson id :");
                        Long lessonId = new Scanner(System.in).nextLong();
                        System.out.println(lessonRepoService.updateLesson(lessonId, lesson));
                    }
                    case 15 -> {
                        System.out.println("Enter by lesson id :");
                        Long lessonId = new Scanner(System.in).nextLong();
                        System.out.println(lessonRepoService.getLessonById(lessonId));
                    }
                    case 16 -> {
                        System.out.println("Enter by course id :");
                        Long courseId = new Scanner(System.in).nextLong();
                        System.out.println(lessonRepoService.getLessonsByCourseId(courseId));
                    }
                    case 17 -> {
                        System.out.println("Enter by lesson id :");
                        Long lessonId = new Scanner(System.in).nextLong();
                        System.out.println(taskReposService.saveTask(task1,lessonId));
                    }
                    case 18 -> {
                        System.out.println("Enter by task id :");
                        Long taskId = new Scanner(System.in).nextLong();
                        System.out.println(taskReposService.updateTask(taskId, task2));
                    }
                    case 19 -> {
                        System.out.println("Enter by lesson id :");
                        Long lessonId = new Scanner(System.in).nextLong();
                        System.out.println(taskReposService.getAllTaskByLessonId(lessonId));
                    }
                    case 20 -> {
                        System.out.println("Enter by task id :");
                        Long taskId = new Scanner(System.in).nextLong();
                        System.out.println(taskReposService.deleteTaskById(taskId));
                }
            }
        }



    }
}
