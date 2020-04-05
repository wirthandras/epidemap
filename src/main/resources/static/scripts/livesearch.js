function livesearchCity(pattern) {
	$.ajax({
				url : '/api/livesearch/city',
				method : 'POST',
				dataType : 'json',
				async : true,
				cache : false,
				timeout : 5000,
				data : {
					"pattern" : pattern
				},
				success : function(response) {
					$("#cities").empty();
					console.log(response);
					response.forEach(function(response) {
						$("#cities").append("<option value=" + response + ">");
					});
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {

				}
			});
};