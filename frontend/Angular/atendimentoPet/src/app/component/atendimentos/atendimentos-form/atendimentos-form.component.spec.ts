import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtendimentosFormComponent } from './atendimentos-form.component';

describe('AtendimentosFormComponent', () => {
  let component: AtendimentosFormComponent;
  let fixture: ComponentFixture<AtendimentosFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AtendimentosFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtendimentosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
