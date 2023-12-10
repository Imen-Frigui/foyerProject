import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUniversityFormComponent } from './add-university-form.component';

describe('AddUniversityFormComponent', () => {
  let component: AddUniversityFormComponent;
  let fixture: ComponentFixture<AddUniversityFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddUniversityFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddUniversityFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
