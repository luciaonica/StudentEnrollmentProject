import { Component } from '@angular/core';
import { CourseService } from '../services/course.service';
import { Course } from '../services/Data-Types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent {
  addCourseMessage:string|undefined;
  constructor(private courseService: CourseService, private router: Router){
  }

  submit(data: Course){
    console.log(data);
    this.courseService.addCourse(data).subscribe((result) => {
      console.log(result);
      if(result){
        this.addCourseMessage="Course was added successfully";
      }
    });

    setTimeout(() => {
      this.addCourseMessage=undefined;
      this.router.navigateByUrl('/admin-courses');
    }, 2000);
  }

}
