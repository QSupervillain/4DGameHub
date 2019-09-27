$(function(){

	//评论投票
	function wy_area_jian(){

		var w = $(".item1 .lista .bj").width()
		var n = $(".item1 .lista font").text()
		var _width=$(".item1 .lista .processingbar").width()*2;
		var postion=-Math.floor(n) * _width + "px";
		//$(".item1 .lista .processingbar").css("background-positionX", postion);
		if(n>= 9.8){
			//$(".item1 .lista .processingbar").css("background-positionX", "-1008px");
			$(".item1 .lista .processingbar").addClass('p_on'+Math.floor(10));
		}else{
			$(".item1 .lista .processingbar").addClass('p_on'+Math.floor(n));
		}
		var z = true
		$(".item1 .lista").mousemove(function(event) {
			if (z == true) {
				var x = event.offsetX;
				var y = event.offsetY;
				var a = (x / 163) * 10
				a = a.toFixed(1)
				$(".item1 p i").text(a);
				$(".item1 .lista .bj").css("width", x + "px")
			}
		});
		$(".item1 .lista").mouseout(function(event){
			if (z == true) {
				var x = event.offsetX;
				var y = event.offsetY;
				$(".item1 .lista .bj").css("width", w + "px")
				$(".item1 p i").text(n);
			}
		});
		$(".item1 .lista").click(function() {
			if (z == true) {
				var x = event.offsetX;
				var y = event.offsetY;
				var a = (x / 163) * 10
				a = a.toFixed(1)
				$(".item1 p i").text(a);
				$(".item1 .lista .bj").css("width", x + "px")
			}
			z = false
		})

	}
	//wy_area_jian()

	//点击期待显示的数字加加
	function abst(){
		var z=  $(".item1 .texta .ls1 span").text()
		var tex=$(".item1 .texta .data_span").text()
		if(tex=="公测"){
			$(".item1 .texta .ls1 a").text("喜欢+")
			$(".item1 .texta .ls1 a").css({"background": "#F0412A"})
		}
		/*$(".item1 .texta .ls1 a").click(function(){
			z++
			$(".item1 .texta .ls1 span").text(z)
		})*/
	}
	abst()

})

 function show_score(){

    $('.data_pf').each(function(){ 
		
        var that = $(this);
        var ypf = $(this).attr("data-dp");
        var a =$(this).find('.scorewrap');
        var	b=a.find('.score');
        var	c=a.find('.processingbar');
        var d=a.find('.txt');

        var w = c.children().first()
        var n = c.children().first().text();

        var h = a.find('.hover');
        //var d = c.find('span');
        var e = d.find('u');

        var i_nuber = e.find('i');

        h.unbind("mousemove")
        h.unbind("mouseleave")
        h.unbind("click")
		
        if(n>=10){n==10}
        var _w = c.width()*2;

        var postion=-Math.floor(n) * _w + "px";

         if(n>= 9.8){
           // c.css("background-positionX", -c.width()*19);
			 c.addClass('p_on10');
        }else{
           // c.css("background-positionX", postion);
			  c.addClass('p_on'+Math.floor(n) );
        }
        b.children().first().css('width',n*10 +'%')

        if(ypf != undefined && ypf != 0){
            e.text('您的评分为'+ ypf +'分');
        }

        h.mousemove(function(event) {
            if ( ypf == 0 || ypf == undefined || ypf =="" ) {
				console.log(ypf)
                var x = event.offsetX;
                var f = (x / b.width()) * 10
                f = f.toFixed(1)
                e.html('您的评分为'+ '<i>'+f+'</i>' +'分');
                e.attr("data-sc",f)
                $(this).children().first().css("width", x + "px")

            }
        });
        h.mouseleave(function(event){
            if ( ypf == 0 || ypf == undefined || ypf =="" ) {
                var x = event.offsetX;
                b.children().first().css("width", n*10 +'%')
                e.text('您还未评分！');
            }
        });
        h.click(function(){
			
            if ( $('.username').size()>=1 && ypf == 0 ){
                var x = event.offsetX;
                var f = (x / b.width()) * 10
                f = f.toFixed(1)
                e.html('您的评分为'+ '<i>'+f+'</i>' +'分');
                e.attr("data-sc",f)
                that.attr("data-dp",f)
				ypf = that.attr("data-dp");
				//layer.msg('评分成功！')
            } else {
               // e.attr("data-sc",f)
			   //layer.msg('您已评分')
            }
        })
    })

}

show_score()