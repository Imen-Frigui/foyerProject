import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniversityTableComponent } from './university-table.component';

describe('UniversityTableComponent', () => {
  let component: UniversityTableComponent;
  let fixture: ComponentFixture<UniversityTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UniversityTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UniversityTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
