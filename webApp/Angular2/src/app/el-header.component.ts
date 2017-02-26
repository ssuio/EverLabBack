import { Component } from '@angular/core';

@Component({
	selector: 'el-header',
	template:`
		<header class="navbar navbar-default">
		 	<div class="container-fluid">
				<div class="navbar-header">
					<div class="navbar-left vcenter">
					<img src="assets/images/lab.png" class="img-rounded" width="20" height="20">
					</div>
			      	<a class="navbar-brand vcenter pull-left" href="#">EverLab</a>
			    </div>
			    <div class="navbar-right vcenter menuIcon">
			    	<img class="" src="assets/images/menu.png" class="img-rounded " width="20" height="21">
		    	</div>
			    <ul class="nav navbar-nav pull-right">
			      <li><a href="#">Sign in</a></li>
			      <li><a href="#">Sign up</a></li>
			    </ul>
		  	</div>
		</header>
	`,
	styles:[
		'.vcenter {display: inline-block; vertical-align: middle; float: none; min-height: 8vh; display: flex; align-items: center;}',
		'.menuIcon{margin:0.3% 0% 0% 0.8%; cursor:pointer;}'
	]
})

export class ELHeaderComponent{

}