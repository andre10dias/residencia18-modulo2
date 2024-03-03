import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtendimentosDetalheDialogComponent } from './atendimentos-detalhe-dialog.component';

describe('AtendimentosDetalheDialogComponent', () => {
  let component: AtendimentosDetalheDialogComponent;
  let fixture: ComponentFixture<AtendimentosDetalheDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AtendimentosDetalheDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtendimentosDetalheDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
