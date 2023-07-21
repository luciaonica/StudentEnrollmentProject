import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { StudentListComponent } from './student-list/student-list.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path:'admin-add-course', component: AddCourseComponent},
  {path: 'admin-courses', component: CourseListComponent},
  {path: 'admin-update-course/:id', component: UpdateCourseComponent},
  {path: 'home', component: HomeComponent},
  {path: 'admin-students', component: StudentListComponent},
  {path: 'admin-update-student/:id', component: UpdateStudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
