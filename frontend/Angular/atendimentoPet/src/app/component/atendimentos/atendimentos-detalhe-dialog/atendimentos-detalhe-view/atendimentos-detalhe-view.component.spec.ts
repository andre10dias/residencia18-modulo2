import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtendimentosDetalheViewComponent } from './atendimentos-detalhe-view.component';

describe('AtendimentosDetalheViewComponent', () => {
  let component: AtendimentosDetalheViewComponent;
  let fixture: ComponentFixture<AtendimentosDetalheViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AtendimentosDetalheViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AtendimentosDetalheViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
