import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CicdService } from '../service/cicd.service';

@Component({
  selector: 'app-digital-watch',
  templateUrl: './digital-watch.component.html',
  styleUrls: ['./digital-watch.component.css']
})
export class DigitalWatchComponent implements OnInit {

  test:String = "text";
  env:String = "Env";
  

  constructor(private cicdService : CicdService,
    private route: Router) { }

  ngOnInit(): void {
  }

  getTestApi() {
    this.test = "";
    this.cicdService.getTest().subscribe(
      (data) => {
        console.log(data);
        this.test = data.msg +"! current status="+data.code;
      }
    );
  }

  getEnvApi() {
    this.env = "";
    this.cicdService.getEnv().subscribe(
      (data) => {
        console.log(data);
        this.env = data.msg +"! status="+data.code;
      }
    );
  }


}
