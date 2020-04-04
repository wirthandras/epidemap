function UpdateStatus() {
	$.ajax({
				url : '/api/mapdata/',
				method : 'POST',
				dataType : 'json',
				async : true,
				cache : false,
				timeout : 5000,
				success : function(response) {
					console.log(response);
					response.forEach(function(response) {
						var marker = L.marker([response.lat, response.lng]).addTo(mymap);
						marker.bindPopup(response.name);
					});
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {

				}
			});
};