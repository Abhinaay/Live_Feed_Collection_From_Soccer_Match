import { Component, OnInit } from '@angular/core';
import {MatchPayload} from '../match-payload';
import {MatchServiceService} from '../match-service.service';
import {Observable} from 'rxjs';

function openPage(pageName) {
  // Hide all elements with class="tabcontent" by default */
  // tslint:disable-next-line:one-variable-per-declaration
  let i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName('tabcontent');
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = 'none';
  }

  // Remove the background color of all tablinks/buttons
  tablinks = document.getElementsByClassName('tablink');
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = '';
  }

  // Show the specific tab content
  document.getElementById(pageName).style.display = 'block';

  // Add the specific color to the button used to open the tab content
}
function hello() {
  alert('Savdhan!!');
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  matches: Observable<Array<MatchPayload>>;
  constructor(private matchService: MatchServiceService) { }

  ngOnInit(): void {
    openPage('results');
    document.getElementById('defaultOpen').click();
    this.matches = this.matchService.getAll();
  }
  openPage1(name: string) {

    openPage(name);
  }
}
