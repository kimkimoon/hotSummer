$(document).ready(function(){
	//https://webclub.tistory.com/189 참조
	var mode = "default";
	var boardNO = 0;
	$(".clickPop").click(function(){
		var move = $(this).attr('href'); //clickPop의 href 값 가져오기(#layer)
		var id = $(this).attr('id');
		var name = $(this).attr('name');
		mode = id; //수정,댓글
		layer_popup(move,id,name);
	});
	
	
	function layer_popup(mo,type,NO){
		var la = $(mo); 
		var dim = la.prev().hasClass('dimBg');
			dim ? $('.writePop').fadeIn() : la.fadeIn();
		var $laWidth = ~~(la.outerWidth()),
        	$laHeight = ~~(la.outerHeight()),
        	docWidth = $(document).width(),
        	docHeight = $(document).height();
		
		if ($laHeight < docHeight || $laWidth < docWidth) {
			la.css({
				 marginTop: -$laHeight /2,
	             marginLeft: -$laWidth/2 
			})
		}else {
			la.css({top: 0, left: 0});
        }
		
		//수정일때
		if(type=="modifyBtn"){
			
			var title = $("#title"+NO).text();
			var useName = $("#usName"+NO).text();
			var content = $("#content"+NO).text();
			boardNO = NO;
			$("#CNTT").val(content);
			$("#WRT_NM").val(useName);
			$("#TITL").val(title);
			$("#NO").val(NO);
		}else if(type=="replyBtn"){ //댓글
			boardNO = NO;
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
		var url = '/board/write';
	    if(mode=="modifyBtn"){
			url = '/board/modify';
		}else if(mode=="replyBtn"){
			url = '/board/reply'
		}
	    
	    
	    var TITL = $("#TITL").val();
	    var CNTT = $("#CNTT").val();
	    var WRT_NM = $("#WRT_NM").val();
	    var datas={TITL:TITL,
	    		   CNTT:CNTT,
	    		   WRT_NM:WRT_NM,
	    		   NO:boardNO};

		$.ajax({
			type : 'POST',
			contentType: 'application/json; charset=UTF-8',
			data : JSON.stringify(datas),
			url  : url,
			dataType   : 'json',
			success:function(data){
				alert("저장되었습니다.");
				location.reload();
			}
		})
	});	
	
	
})



