import { Component } from '@angular/core'

@Component({
	selector:'el-news',
	template:`
		<div  class="news row col-md-6 col-md-offset-3 rounded" >
				<div class="col-md-3 col-md-offset-2 no-float">
					<img src="assets/images/notebook.png" class="img-rounded" width="85%">
				</div>
				<div class="col-md-6" no-float>
					<span class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;EL-Note</span>
					<p class="small pull-left">An online note book for recording lab stuff, protocal ,procedure and anything in research.</p>
				</div>
			</div>
	`,
	styles:[
		'.news {margin-top:3%; margin-bot:3%;}',

	]

})

export class ELNewsComponent{

}