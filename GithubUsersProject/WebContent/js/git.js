$(document).ready(function() {
	$.ajax({
		url: "https://api.github.com/users"
	}).then(function(data) {
		//console.log(data);
		var table=$("#usersTable");
		var contents = "";
		$.each(data, function(idx) {
			contents += "<tr>";
			contents += "<td>" + data[idx].id + "</td>";
			contents += "<td>" + data[idx].login + "</td>";
			contents += "<td><div class='link'>" + data[idx].followers_url + "</div></td>";
			contents += "<td id='count"+ data[idx].id +"'>" + 0 + "</td>";
			contents += "<td><img src='" + data[idx].avatar_url + "' width=50 height=50/></td>";
			contents += "</tr>";
		})
		//console.log(contents);
		table.append(contents);
		$("#usersTable").on('click','.link',function(){
	         // get the current row
	         var currentRow=$(this).closest("tr");
	         var id = currentRow.find("td:eq(0)").text();
	         var link=currentRow.find("td:eq(2)").text(); // get current row 3rd TD
	         console.log(link);
	         $.ajax({
	        	 url: link
	         }).then(function(data) {
	        	 //console.log(data);
	        	 console.log("#count" + id);
	        	 var rid = "#count" + id;
	        	 $(rid).html(data.length);
	         })
	    });
	});
});
