import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from './Data-Types';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { } 

  studentList() {
    return this.http.get<Student[]>(`${this.apiUrl}/api/v1/admin/students`);
  }

  deleteStudent(id:number) {
    return this.http.delete(`${this.apiUrl}/api/v1/admin/deletestudent/${id}`, {responseType: 'text'});
  }

  getStudent(id:string) {
    return this.http.get<Student>(`${this.apiUrl}/api/v1/admin/users/${id}`)
  }

  updateStudent(student:Student) {
    return this.http.put<Student>(`${this.apiUrl}/api/v1/admin/saveuser`, student);
  }
}
