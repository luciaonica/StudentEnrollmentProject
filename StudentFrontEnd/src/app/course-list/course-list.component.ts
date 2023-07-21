import { Component, OnInit } from '@angular/core';
import { Course } from '../services/Data-Types';
import { CourseService } from '../services/course.service';
import { faTrash, faEdit } from '@fortawesome/free-solid-svg-icons';
import { DataGatewayService } from '../services/data-gateway.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courseList: undefined | Course[];
  courseMessage: undefined | string;
  iconDelete = faTrash;
  iconEdit = faEdit;
  userId: undefined | number;

  constructor(private courseService: CourseService, private loginService: DataGatewayService) {
    this.userId = loginService.userId;
  }

  ngOnInit(): void {
    this.list();
  }

  deleteCourse(courseId: number) {
    this.courseService.deleteCourse(courseId).subscribe((result) => {
      if (result) {
        this.courseMessage = "Course Deleted";
        this.list();
      }
      console.warn(result);

    });
    setTimeout(() => {
      this.courseMessage = undefined;
    }, 2000);
  }

  list() {
    this.courseService.courseList().subscribe((result) => {

      if (result) {
        this.courseList = result;
      }
    })
  }

  enrollCourse(courseId: number) {

    this.userId && this.courseService.isStudentAlreadyEnrolled(courseId, this.userId).subscribe((result: any) => {
      if (result.message !== 'Enrolled') {
        this.userId && this.courseService.enrollCourse(courseId, this.userId);
        //alert("You has successfully enrolled")
        this.courseMessage = "You has successfully enrolled!";
        setTimeout(() => {
          this.courseMessage = undefined;
        }, 2000);
      } else {
        //alert("You already enrolled in this course!")
        this.courseMessage = "You are already enrolled in this course!";
        setTimeout(() => {
          this.courseMessage = undefined;
        }, 2000);
      }
    });


  }

  isAdmin(): boolean {
    return this.loginService.userRole == 'ADMIN';
  }



}
