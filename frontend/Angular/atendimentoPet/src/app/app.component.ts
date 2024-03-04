import { Component, OnInit } from '@angular/core';
import { RacaService } from './service/raca.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'atendimentoPet';

  // constructor(private service: RacaService) {
    
  // }

  // ngOnInit(): void {
  //   console.log('[app.component] ngOnInit');
  //   this.service.receberDadosFormulario({});
  // }


}
