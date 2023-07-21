import { Component, Output, EventEmitter } from '@angular/core';
import { AccountRegistration } from '../services/AccountRegistration';
import { DataGatewayService } from '../services/data-gateway.service';
import { Router } from '@angular/router';
import { FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userFirstName!: string;
  userLastName!: string;
  email!: string;
  password!: string;
  role: string = "STUDENT";
  registrationMessage: string | undefined;
  errorMessage: string | undefined;


  constructor(private router: Router, private dataService: DataGatewayService) {

  }

  save() {
    if (!this.userFirstName || !this.userLastName || !this.email || !this.password || !this.role) {
      //alert('Please enter required information.')
      this.errorMessage = "All the fields are required";
      setTimeout(() => {
        this.errorMessage = undefined;

      }, 2000);
      return;
    }
    let email: string = this.email;
    console.log(email);

    const EMAIL_REGEXP = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

    if (!EMAIL_REGEXP.test(email)) {
      //alert("Enter valid email!");
      this.errorMessage = "Enter valid email!";
      setTimeout(() => {
        this.errorMessage = undefined;
      }, 2000);
    } else {

      const accountRegistration: AccountRegistration = {
        userFirstName: this.userFirstName,
        userLastName: this.userLastName,
        email: this.email,
        password: this.password,
        role: this.role
      };

      console.log(accountRegistration);

      let resultData: any =
        this.dataService.getAccountRegistered(accountRegistration).subscribe((accountRegistration) => resultData);

      this.registrationMessage = "Registered Successfully";

      setTimeout(() => {
        this.registrationMessage = undefined;
        this.router.navigateByUrl('/login');
      }, 2000);
    }
    //console.log(resultData);

  }

}

/*
save(){
    let bodyData = {
      "userFirstName" : this.firstname,
      "userLastName" : this.lastname,
      "email" : this.email,
      "password" : this.password,
      "role" : this.role
    };
    this.http.post("http://localhost:8080/api/v1/user/save", bodyData, {responseType: 'text'}).subscribe((resultData: any) =>
    {
      console.log(resultData);
      alert("student registered successfully");
    });
  }
*/
