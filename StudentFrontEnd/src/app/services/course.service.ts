import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from './Data-Types';
import { BehaviorSubject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:8080'
  

  constructor(private http: HttpClient) { }

  addCourse(data:Course) {
    return this.http.post(`${this.apiUrl}/api/v1/admin/savecourse`,data, {responseType: 'text'});
  }

  courseList() {
    return this.http.get<Course[]>(`${this.apiUrl}/api/v1/admin/courses`);
  }

  deleteCourse(id:number) {
    return this.http.delete(`${this.apiUrl}/api/v1/admin/deletecourse/${id}`, {responseType: 'text'});
  }

  getCourse(id:string) {
    return this.http.get<Course>(`${this.apiUrl}/api/v1/admin/courses/${id}`)
  }

  updateCourse(course:Course) {
    return this.http.put<Course>(`${this.apiUrl}/api/v1/admin/savecourse`, course);
  }

  enrollCourse(courseId:number, userId:number){
    let bodyData:any;
    console.log(courseId);
    console.log(userId);
    this.http.post(`${this.apiUrl}/api/v1/admin/savecoursestudent/${courseId}/${userId}`, bodyData, {responseType: 'text'})
    .subscribe((result) => {
      console.log(result);
    });    
  }

  isStudentAlreadyEnrolled(courseId:number, userId: number) {
    
    return this.http.get(`${this.apiUrl}/api/v1/admin/isstudentenrolled/${courseId}/${userId}`);
    
  }
}
