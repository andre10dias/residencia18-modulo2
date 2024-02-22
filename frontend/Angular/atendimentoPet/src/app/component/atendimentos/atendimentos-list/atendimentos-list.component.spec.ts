import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtendimentosListComponent } from './atendimentos-list.component';

describe('AtendimentosListComponent', () => {
  let component: AtendimentosListComponent;
  let fixture: ComponentFixture<AtendimentosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AtendimentosListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtendimentosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
