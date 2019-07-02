import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionImportComponent } from './gestion-import.component';

describe('GestionImportComponent', () => {
  let component: GestionImportComponent;
  let fixture: ComponentFixture<GestionImportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionImportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionImportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
