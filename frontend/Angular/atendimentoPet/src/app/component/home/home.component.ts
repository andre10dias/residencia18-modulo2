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
  slides: any; //NodeListOf<Element> = document.querySelectorAll('.slide');
  totalSlides: any; //number = this.slides.length;

  ngAfterViewInit() {
    // Selecionar os slides após a visualização da view
    this.slides = document.querySelectorAll('.slide');
    this.totalSlides = this.slides.length;
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
    console.log('Antes de chamar showSlide:', this.currentIndex);
    // this.currentIndex -= 1;
    this.showSlide(this.currentIndex - 1);
    console.log('Depois de chamar showSlide:', this.currentIndex);
  }

  nextSlide() {
    console.log('Antes de chamar showSlide:', this.currentIndex);
    // this.currentIndex += 1;
    this.showSlide(this.currentIndex + 1);
    console.log('Depois de chamar showSlide:', this.currentIndex);
  }

}
