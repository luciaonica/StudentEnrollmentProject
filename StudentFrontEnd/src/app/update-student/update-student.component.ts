import { Component, OnInit } from '@angular/core';
import { Student } from '../services/Data-Types';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit{
  studentData: undefined | Student;
  studentMessage: undefined | string;

  constructor(private route: ActivatedRoute, private studentService:StudentService,
    private router: Router){}

  ngOnInit(): void {
    let studentId = this.route.snapshot.paramMap.get('id');
    console.log(studentId);
    studentId && this.studentService.getStudent(studentId).subscribe((data) => {
      console.warn(data);
      this.studentData=data;
    });
  }

  submit(data:any) {
    
    if (this.studentData) {
      data.userId=this.studentData.userId;
    }
    this.studentService.updateStudent(data).subscribe((result) => {
      if (result) {
        console.log(result);
        this.studentMessage="Student Updated";
      }
    });

    setTimeout(() => {
      this.studentMessage=undefined;
      this.router.navigateByUrl('/admin-students');
    }, 2000);
  }
}
