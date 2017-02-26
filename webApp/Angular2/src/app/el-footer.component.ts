import { Component } from '@angular/core'

@Component({
	selector: 'el-footer',
	template:`
		<div class="container-full">
			<div  class="footer-copyright col-md-12">
				<div class="col-md-8 col-md-offset-2">
					<span style="font-size:50%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Copyright 2017</span>
				</div>
			</div>
		<div>
	`,
	styles:[
		'.footer-copyright {background:#f5f5f5; padding:5px; margin-top:5%; margin-bot:3px;}',
		//'.footer-news {border:2px solid; border-color:#EBE5E3; border-radius:10px; margin-top:3%; margin-bot:3%; padding:2%;}',

	]
})


export class ELFooterComponent{

}