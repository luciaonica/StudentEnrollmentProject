import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { UpdateCourseComponent } from './update-course/update-course.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DataGatewayService } from './services/data-gateway.service';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AddCourseComponent,
    CourseListComponent,
    UpdateCourseComponent,
    UpdateStudentComponent,
    StudentListComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule
  ],
  providers: [DataGatewayService],
  bootstrap: [AppComponent]
})
export class AppModule { }
