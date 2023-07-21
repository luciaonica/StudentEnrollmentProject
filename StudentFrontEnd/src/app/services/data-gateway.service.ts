import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginInfo } from './LoginInfo';
import { AccountRegistration } from './AccountRegistration';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class DataGatewayService {
  private apiUrl = 'http://localhost:8080'
  userId: undefined | number;
  userFullName: undefined | string;
  userRole: undefined | string;
  isLoggedIn!: boolean;
  errorMessage: string | undefined;

  constructor(private http: HttpClient, private router: Router) { }

  getLoginStatus(loginData: LoginInfo) {
    console.log(loginData);

    //return this.http.post(`${this.apiUrl}/api/v1/login/log`, loginData);
    this.http.post(`${this.apiUrl}/api/v1/login/log`, loginData).subscribe((resultData: any) => {
      //console.log(resultData);

      if (resultData.message == "Email does not exist") {
        alert("Email does not exist");
        this.errorMessage = "Email does not exist";
        setTimeout(() => {
          this.errorMessage = undefined;
        }, 2000);
      }
      else if (resultData.message == "Login Success") {
        this.userId = resultData.id;
        this.userFullName = resultData.fullName;
        this.userRole = resultData.role;
        this.isLoggedIn = true;
        //console.log(this.isLoggedIn +  "   hgsadjhgshdjfgh");
        /*console.log(resultData.fullName);
        console.log(resultData.id);
        console.log(resultData.role);*/
        this.router.navigateByUrl('/home');
      }
      else {
        alert("Incorrect email or password");
        this.errorMessage = "Incorrect email or password";
        setTimeout(() => {
          this.errorMessage = undefined;
        }, 2000);
      }
    });

  }

  getAccountRegistered(accountRegistration: AccountRegistration): Observable<any> {
    console.log(accountRegistration);
    return this.http.post(`${this.apiUrl}/api/v1/user/save`, accountRegistration, { responseType: 'text' });
  }

  logout() {
    this.userId = undefined;
    this.userFullName = undefined;
    this.userRole = undefined;
    this.isLoggedIn = false;
    this.router.navigateByUrl('/login');
  }
}
