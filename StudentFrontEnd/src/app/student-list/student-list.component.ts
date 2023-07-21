import { Component, OnInit } from '@angular/core';
import { faTrash, faEdit } from '@fortawesome/free-solid-svg-icons';
import { Student } from '../services/Data-Types';
import { StudentService } from '../services/student.service';
import { DataGatewayService } from '../services/data-gateway.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{
  studentList: undefined | Student[];
  studentMessage:undefined|string;
  iconDelete=faTrash;
  iconEdit=faEdit;

  constructor(private studentService: StudentService, private loginService: DataGatewayService){}

  ngOnInit(): void {
    this.list();
    console.log(this.studentList);    
  }

  list() {
    this.studentService.studentList().subscribe((result) => {      
      if(result) { 
        this.studentList=result;
      }
    });
  }

  deleteStudent(studentId:number){
    if (this.loginService.userRole == 'ADMIN') {
      this.studentService.deleteStudent(studentId).subscribe((result) => {
        if(result){
          this.studentMessage="Student Deleted";
          this.list();
        }
        console.warn(result);
        
      });
      setTimeout(() => {
        this.studentMessage=undefined;
      }, 2000);
    } else {
      alert("You don't have permission to access this page")
    }
  }

}
