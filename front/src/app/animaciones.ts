import { trigger, state, style, animate, transition } from '@angular/animations';

export const overlayContentAnimation = trigger('overlayContentAnimation', [
  state('start', style({
    transform: 'translateY(0)'
  })),
  state('end', style({
    transform: 'translateY(-100%)'
  })),
  transition('start => end', [
    animate('300ms ease-in')
  ]),
  transition('end => start', [
    animate('300ms ease-out')
  ])
]);
