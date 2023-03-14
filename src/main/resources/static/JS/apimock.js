//@author hcadavid

apimock=(function(){

	var mockdata=[];

	mockdata["Edwar Lozano"]=	[{author:"Edwar Lozano","points":[{"x":150,"y":120},{"x":215,"y":115}],"name":"house"},
	 {author:"Edwar Lozano","points":[{"x":340,"y":240},{"x":15,"y":215}],"name":"gear"}];
	mockdata["Daniela Garcia"]=[{author:"Daniela Garcia","points":[{"x":140,"y":140},{"x":115,"y":115}],"name":"house2"},
	 {author:"Daniela Garcia","points":[{"x":140,"y":140},{"x":115,"y":115}],"name":"gear2"}];
	mockdata["Fabian Florez"]=	[{author:"Fabian Florez","points":[{"x":134,"y":86},{"x":125,"y":165}],"name":"house"},
     {author:"Fabian Florez","points":[{"x":75,"y":12},{"x":210,"y":167}],"name":"gear"}];
    mockdata["Daniela Romero"]=[{author:"Daniela Romero","points":[{"x":137,"y":82},{"x":123,"y":161}],"name":"house2"},
     {author:"Daniela Romero","points":[{"x":75,"y":12},{"x":210,"y":167}],"name":"gear2"}];


	return {
		getBlueprintsByAuthor:function(authname,callback){
			callback(
				mockdata[authname]
			);
		},

		getBlueprintsByNameAndAuthor:function(authname,bpname,callback){

			callback(
				mockdata[authname].find(function(e){return e.name===bpname})
			);
		}
	}	

})();

