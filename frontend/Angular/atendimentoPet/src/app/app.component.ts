import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from './service/auth.service';

// import { RacaService } from './service/raca.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  hideNavbar: boolean = false;
  title = 'atendimentoPet';

  constructor(
    private router: Router, 
    private service: AuthService
  ) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.hideNavbar = (event.url === '/login') || (event.url === '/');
      }
    });
  }

  ngOnInit() {
    this.service.autoLogin();
  }

    // this.router.events.subscribe((event) => {
    //   if (event instanceof NavigationEnd) {
    //     this.hideNavbar = (event.url === '/login') || (event.url === '/');
    //   }
    // });
  }

  // constructor(private service: RacaService) {
    
  // }

  // ngOnInit(): void {
  //   console.log('[app.component] ngOnInit');
  //   this.service.receberDadosFormulario({});
  // }


// }
