import { AfterViewInit, Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements AfterViewInit {
  slide1: string = './assets/slide1.webp';
  slide2: string = './assets/slide2.webp';
  slide3: string = './assets/slide3.webp';

  currentIndex = 0;
  slides: any;
  totalSlides: any;
  intervalId: any;

  ngAfterViewInit() {
    // Selecionar os slides após a visualização da view
    this.slides = document.querySelectorAll('.slide');
    this.totalSlides = this.slides.length;
    this.startInterval();
  }

  startInterval() {
    this.intervalId = setInterval(() => {
      this.nextSlide();
    }, 5000); // Mudança a cada 5 segundos
  }

  showSlide(index: number) {
    if (index < 0) {
      index = this.totalSlides - 1;
    } 
    else if (index >= this.totalSlides) {
      index = 0;
    }

    const offset = -index * 100;
    const slidesElement = document.querySelector('.slides') as HTMLElement;
    if (slidesElement) {
      slidesElement.style.transform = `translateX(${offset}%)`;
    }

    this.currentIndex = index;
  }

  prevSlide() {
    this.showSlide(this.currentIndex - 1);
  }

  nextSlide() {
    this.showSlide(this.currentIndex + 1);
  }

}
