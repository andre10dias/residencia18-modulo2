import { Component, OnInit } from '@angular/core';
import { RacaService } from './service/raca.service';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  hideNavbar: boolean = false;
  title = 'atendimentoPet';

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.hideNavbar = (event.url === '/login') || (event.url === '/');
      }
    });
  }

  // constructor(private service: RacaService) {
    
  // }

  // ngOnInit(): void {
  //   console.log('[app.component] ngOnInit');
  //   this.service.receberDadosFormulario({});
  // }


}
