import { Component } from '@angular/core';
 
@Component({
	selector:'everlab-app',
	template:`
   	<router-outlet></router-outlet>
	`
})

export class ELAppComponent{
	title = 'Everlab switch'; 
}