import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtendimentosDialogComponent } from './atendimentos-dialog.component';

describe('AtendimentosDialogComponent', () => {
  let component: AtendimentosDialogComponent;
  let fixture: ComponentFixture<AtendimentosDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AtendimentosDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtendimentosDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
