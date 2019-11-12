import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-cities-results',
  templateUrl: './cities-results.component.html',
  styleUrls: ['./cities-results.component.css']
})
export class CitiesResultsComponent implements OnInit {
  @Input()
  results : any;

  constructor() { }

  ngOnInit() {
  }

}
