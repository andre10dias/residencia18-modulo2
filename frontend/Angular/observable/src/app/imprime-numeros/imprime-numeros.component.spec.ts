import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImprimeNumerosComponent } from './imprime-numeros.component';

describe('ImprimeNumerosComponent', () => {
  let component: ImprimeNumerosComponent;
  let fixture: ComponentFixture<ImprimeNumerosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ImprimeNumerosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ImprimeNumerosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
