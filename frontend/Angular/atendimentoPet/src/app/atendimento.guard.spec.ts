import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { atendimentoGuard } from './atendimento.guard';

describe('atendimentoGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => atendimentoGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
