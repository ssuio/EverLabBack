import { Component } from '@angular/core';


@Component({
  selector: 'welcome-everlab',
  template: `
  		<div style="position:relative" [style.height.px]="height">
	  		<iframe width="560" height="315"
				onload="this.width=window.innerWidth;this.height=window.innerHeight - window.innerHeight/3;"
				src="http://www.youtube.com/embed/6pHcCTGGrsc?autoplay=1&iv_load_policy=3&nologo=1&loop=1&playlist=6pHcCTGGrsc&controls=0&disablekb=1&showinfo=0" 
				frameborder="0" volume="0" allowfullscreen>
			</iframe>
			<div class="blocker" [style.top.px]="0" [style.left.px]="0" [style.height.px]="height"></div>
		</div>
  `,
  styles:['.blocker {background: white; position:absolute; z-index:10;width:100%; opacity:0.1;}']
})

export class WelcomeComponent {
	width: number;
	height: number;
	topHeight: number;
	
	constructor(){
		this.height = window.innerHeight - window.innerHeight/3;
		this.width = window.innerWidth;
		this.topHeight = 0 - this.height;
	}
}
