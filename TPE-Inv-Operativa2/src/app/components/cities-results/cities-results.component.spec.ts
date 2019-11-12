import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CitiesResultsComponent } from './cities-results.component';

describe('CitiesResultsComponent', () => {
  let component: CitiesResultsComponent;
  let fixture: ComponentFixture<CitiesResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CitiesResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CitiesResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
