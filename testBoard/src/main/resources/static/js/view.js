$(document).ready(function(){
	page();
	//https://webclub.tistory.com/189 참조
	$(".clickPop").click(function(){
		var move = $(this).attr('href'); //clickPop의 href 값 가져오기(#layer)
		layer_popup(move);
	});
	
	function layer_popup(mo){
		var la = $(mo); 
		var dim = la.prev().hasClass('dimBg');
			dim ? $('.writePop').fadeIn() : la.fadeIn();
		var $laWidth = ~~(la.outerWidth()),
        	$laHeight = ~~(la.outerHeight()),
        	docWidth = $(document).width(),
        	docHeight = $(document).height();
		
		//alert($laWidth+","+$laHeight+","+docWidth+","+docHeight);
		if ($laHeight < docHeight || $laWidth < docWidth) {
			la.css({
				 marginTop: -$laHeight /2,
	             marginLeft: -$laWidth/2 
			})
		}else {
			la.css({top: 0, left: 0});
        }
		
		//닫기
		$("#popClose").click(function(){
			dim ? $('.writePop').fadeOut() : la.fadeOut();
			return false;
		});
	}
	
	
	//쓰기
	$("#writeGo").click(function(){	
		//유효성 검사
		
		//
		$.ajax({
			type : 'post',
			contentType: 'application/json; charset=UTF-8',
			data : JSON.stringify($('form[name="contentForm"]').serializeComponent()),
			url  : '/board/write',
			dataType   : 'json',
			success:function(data){
				if(data == 1 ) {
		            alert('저장 하였습니다.');
		            location.reload();                   
		        } else {
		            alert('저장중 오류가 발생 하였습니다.');
		            return;
		        }
			}
		})
	});
	
	
	
})
//동적 페이징 적용해보기
	function page(){
		//https://soye0n.tistory.com/118 참조
		
		var row_number = 12; //한페이지에 출력할 숫자
		var uTr = jQuery('tbody tr'); 
		var totalRow = uTr.length/2; //총게시물 숫자
		//alert(totalRow);
		var pagesNum = 0;
		if(totalRow % row_number == 0){ //총게시물 숫자 % 한페이지 출력할 숫자가 0이면
			pagesNum = totalRow / row_number; 
		}else{
			pagesNum = (totalRow / row_number)+1;
			pagesNum = Math.floor(pagesNum++); //소수점 버리기
		}
		var calNum = 0;
		
		//
		jQuery('#pageArea').append("<li class=\"page-item\"><a class=\"page-link\" id=\"prev\" style=\"cursor:pointer\">Prev</a></li>");
		for(var i=1; i<=pagesNum;i++){
			jQuery('#pageArea').append("<li class=\"page-item\"><a class=\"page-link\" style=\"cursor:pointer\">"+i+"</a></li>");
			jQuery('#pageArea li:nth-child(2)').attr("id","active");
			jQuery('#pageArea a').attr("id","pageLink");
		}
		jQuery("#pageArea").append("<li class=\"page-item\"><a class=\"page-link\" id=\"next\" style=\"cursor:pointer\">Next</a></li>");
		
		test(0);
		function test(num){
			//alert(num+","+num+2);
			uTr.each(function(i){
				//jQuery(this).hide();
				var className =  jQuery(this).attr("class");
				if((i+1)>=row_number*num && (i+1)+1<=row_number*(num+2)){
					if(className=="mainTr"){
						uTr.eq(i).show();	
					}else if(className=="subTr"){
						uTr.eq(i).hide();
					}
				}else{
					uTr.eq(i).hide();
				}
			}); //now_number 를뺀 나머지는 hide
		}
	
		jQuery("#pageArea a").click('#pageLink',function(e){
			//e.preventDefault(); //이벤트 중지 메서드
			//uTr.hide();
			var page = jQuery(this).text();
			var temp = page-1;
			if(parseInt(page)==1){
				test(parseInt(page)-1);
			}else{
				test(parseInt(page));
			}
			
			var start = temp*row_number;
			var current_link = temp;
			/*
			jQuery("#pageArea li").remove("active");
			jQuery(this).parent().attr("id","active");
			for(var i=0;i<row_number;i++){
				
			}*/
		});
		//
		
	}






