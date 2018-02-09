angular.module("recipes").controller("recipeController", function($scope, $http) {
	
	$scope.app = "Recipes";
	$scope.recipes = [];
	console.log("teste");
	
	function loadRecipes() {
		
		$http.get("/recipes/").then(function(response) {
		    $scope.recipes = response.data;
		    console.log($scope.recipes);
		  }, function(err) {
		    console.log(err);
		 });
		
		//$scope.contatos.push({nome: "Eli Lima", telefone: "9999-8888", data: new Date(), operadora: $scope.operadoras[1]});
		/**
		contatosAPI.getContatos().success(function(data, status) {
			$scope.contatos = data;
		}).error(function(status) {
			console.log("ue");
			$scope.contatos.push({nome: "Eli Lima", telefone: "9999-8888", data: new Date(), operadora: $scope.operadoras[1]});
		});
		**/
	};
	
	loadRecipes();
});