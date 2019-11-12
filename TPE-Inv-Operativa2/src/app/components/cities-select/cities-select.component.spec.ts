import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CitiesSelectComponent } from './cities-select.component';

describe('CitiesSelectComponent', () => {
  let component: CitiesSelectComponent;
  let fixture: ComponentFixture<CitiesSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CitiesSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CitiesSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
