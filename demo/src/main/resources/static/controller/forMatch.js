var app = angular.module("myApp", [ 'ui.router', 'siTable', 'LocalStorageModule','service',
    'loginCtr','registCtr','homeCtr','accountCtr'])

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
	$urlRouterProvider.otherwise("/");
	$stateProvider.state("app", {
		url : "/",
		views : {
			'header' : {
			},
			'content' : {
				templateUrl : "page/login.html",
				controller : "loginCtr"
			},
			'footer' : {
			}
		}
	}).state("app.home", {
		url : "home",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'userInfo@app.home' : {
				templateUrl : "page/userInfo.html"
			},
			'content@' : {
				templateUrl : "page/home.html",
				controller : "homeCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.detail", {
		url : "detail",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/detail.html",
				controller : "detailCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.regist", {
		url : "regist",
		views : {
			'content@' : {
				templateUrl : "page/regist.html",
				controller : "registCtr"
			}
		}
	}).state("app.error", {
		url : "error",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/error.html"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.noPermission", {
		url : "noPermission",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/noPermission.html"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.checkingAccountDetail", {
		url : "checkingAccountDetail",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'userInfo@app.checkingAccountDetail' : {
				templateUrl : "page/userInfo.html"
			},
			'content@' : {
				templateUrl : "page/checkingAccountDetail.html",
				controller: "checkingAccountCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.savingsAccountDetail", {
		url : "savingsAccountDetail",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'userInfo@app.savingsAccountDetail' : {
				templateUrl : "page/userInfo.html"
			},
			'content@' : {
				templateUrl : "page/savingsAccountDetail.html",
				controller :"savingsAccountCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.creditAccountDetail", {
		url : "creditAccountDetail",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'userInfo@app.creditAccountDetail' : {
				templateUrl : "page/userInfo.html"
			},
			'content@' : {
				templateUrl : "page/creditAccountDetail.html",
				controller :"creditAccountCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.userList", {
		url : "userList",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/adminOp.html",
				controller : "userListCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.userUpdate", {
		url : "userUpdate",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/userUpdate.html",
				controller : "userUpdateCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	}).state("app.order", {
		url : "order",
		views : {
			'header@' : {
				templateUrl : "header.html",
				controller : "headerCtr"
			},
			'content@' : {
				templateUrl : "page/organize.html",
				controller : "orderCtr"
			},
			'footer@' : {
				templateUrl : "footer.html",
				controller : "footerCtr"
			}
		}
	})
});


//detail page controller
app.controller("orderCtr", function($scope, $state, $window, $rootScope, HttpService) {
	$scope.data = {};
	var address;
	var lng;
	var lat;

    $scope.showMap = function() {
        var frameSrc = "/baidu/locate.html";  
        $("#map").attr("src", frameSrc);  
        $('#myModal').modal({ show: true, backdrop: 'static' });  
    };  
    
    $scope.closeMap = function() {
        $('#myModal').modal('hide');

        address = $("#map")[0].contentWindow.myValue;
        lng = $("#map")[0].contentWindow.lng;
        lat = $("#map")[0].contentWindow.lat;
        
        
        $scope.data.address = address;
        $scope.data.lng = lng;
        $scope.data.lat = lat;
    };  
    
	$scope.saveOrg = function() {
		HttpService.post('http://localhost:8080/party', $scope.data).then(
				function(response) {
					$scope.respData = {};

					$scope.respData = angular.fromJson(response.data);
					if ('00' == $scope.respData.responseCode) {
						// $("#success").modal();
						
						$scope.infoData.complete = true;
						$timeout(function(){
							$state.go("app.home");
						},2000);
					}
				},
				function(response) {
					HttpService.error(response.data,response.status,$scope);

					$scope.responseMessage = response.data;
					$scope.respData = angular.fromJson(response.data);
					if ('11' == $scope.respData.responseCode
							|| '21' == $scope.respData.responseCode) {
						$scope.errorData = $scope.respData.errors;
					}
				});
	};
	
	
});

// detail page controller
app.controller("detailCtr", function($scope, $http, $state, $window) {
	$http.get('../Json/writeoff.json').then(function(res) {
		$scope.items = res.data;
	});
	$scope.cancelBtn = function() {
		$state.go("app.home")
	}
	$scope.todayDate = new Date().toLocaleDateString()

});

// header page controller
app.controller("headerCtr", function($scope, $state, $window, $rootScope, HttpService) {
	
	$scope.userLogoff = function() {
		HttpService.get('http://localhost:8080/logoff').then(
				function(response) {
					$scope.responseMessage = response.data;

					$scope.respData = angular.fromJson(response.data);
					if ('00' == $scope.respData.responseCode) {
						$window.sessionStorage.removeItem('TOKEN');
						$state.go("app");
					} else {

					}
				},
				function(response) {
					$scope.responseMessage = HttpService.error(response.data,response.status,$scope);
				});
	};
});

// footer page controller
app.controller("footerCtr", function($scope, $location, $state) {
});
