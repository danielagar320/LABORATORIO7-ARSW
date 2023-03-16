//@author hcadavid

apimock=(function(){

	var mockdata=[];

	mockdata["EdwarLozano"]=	[{author:"EdwarLozano","points":[{"x":150,"y":120},{"x":215,"y":115}],"name":"house"},
    	 {author:"EdwarLozano","points":[{"x":340,"y":240},{"x":15,"y":215}],"name":"gear"},
    	 {author:"EdwarLozano","points":[{"x":34,"y":76},{"x":190,"y":71}],"name":"apto"}];
    mockdata["maryweyland"]=[{author:"maryweyland","points":[{"x":140,"y":140},{"x":115,"y":115}],"name":"house2"},
    	 {author:"maryweyland","points":[{"x":140,"y":140},{"x":115,"y":115}],"name":"gear2"},
    	 {author:"maryweyland","points":[{"x":123,"y":89},{"x":10,"y":111}],"name":"apto2"}];
    mockdata["DanielaGarcia"] = [{author: "DanielaGarcia", "points":[{"x":134,"y":86},{"x":125,"y":165}], "name": "house3"},
    	{author: "DanielaGarcia", "points":[{"x":75,"y":12},{"x":210,"y":167}], "name": "gear3"}];
    mockdata["johnconnor"] = [{author: "johnconnor", "points":[{"x":137,"y":82},{"x":123,"y":161}], "name": "house4"},
            	{author: "johnconnor", "points":[{"x":75,"y":12},{"x":210,"y":167}], "name": "gear4"}];


	return {

		getBlueprintsByAuthor:function(authname,callback){

			callback(
				mockdata[authname]
			);
		},

		getBlueprintByAuthorAndName:function(authname,bpname,callback){

			callback(
				mockdata[authname].find(function(e){return e.name===bpname})
			);
		}
	}

})();

