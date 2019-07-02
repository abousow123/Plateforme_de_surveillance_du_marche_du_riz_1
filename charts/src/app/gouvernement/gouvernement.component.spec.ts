import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GouvernementComponent } from './gouvernement.component';

describe('GouvernementComponent', () => {
  let component: GouvernementComponent;
  let fixture: ComponentFixture<GouvernementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GouvernementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GouvernementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
