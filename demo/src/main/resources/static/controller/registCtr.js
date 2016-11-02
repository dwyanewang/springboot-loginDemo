var registCtr = angular.module('registCtr', [ 'ui.router', 'service' ]);

registCtr.controller("registCtr", function($scope, $state, $http, $window,
		HttpService, $rootScope) {
	$scope.userRegister = function() {
		HttpService.post('http://localhost:8080/regist', $scope.formData).then(
				function(response) {
					$scope.respData = {};

					$scope.responseMessage = response.data;
					$scope.respData = angular.fromJson(response.data);
					if ('00' == $scope.respData.responseCode) {
						$window.sessionStorage.setItem('TOKEN', $scope.respData.userDetail.token);
						$rootScope.userRoles = $scope.respData.roles;
						$rootScope.userDetails = $scope.respData.userDetail;
						$state.go("app.home");
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

	$scope.changeRegister = function(hideId, showId) {
		$(hideId).hide();
		$(showId).show();
	}

	$scope.validPassStrength = function(pass) {
		var myurl = "validPwd?pass=" + pass;
		if (pass == null) {
			$scope.pwdVeryWeak = false;
			$scope.pwdWeak = false;
			$scope.pwdMedium = false;
			$scope.pwdStrong = false;
			$scope.pwdVeryStrong = false;
		} else {

			$.ajax({
				url : "http://localhost:8080/" + myurl,
				type : "POST",
				error : function(data) {
					alert("a problem...");
				},
				success : function(data) {
					if (data == "-1") {
						$scope.pwdVeryWeak = true;
						$scope.pwdWeak = false;
						$scope.pwdMedium = false;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = false;
					}

					if (data == "-2") {
						$scope.pwdVeryWeak = true;
						$scope.pwdWeak = false;
						$scope.pwdMedium = false;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = false;
					}
					if (data == "0") {
						$scope.pwdVeryWeak = true;
						$scope.pwdWeak = false;
						$scope.pwdMedium = false;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = false;
					}
					if (data == "1") {
						$scope.pwdVeryWeak = false;
						$scope.pwdWeak = true;
						$scope.pwdMedium = false;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = false;
					}
					if (data == "2") {
						$scope.pwdVeryWeak = false;
						$scope.pwdWeak = false;
						$scope.pwdMedium = true;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = false;
					}
					if (data == "3") {
						$scope.pwdVeryWeak = false;
						$scope.pwdWeak = false;
						$scope.pwdMedium = false;
						$scope.pwdStrong = true;
						$scope.pwdVeryStrong = false;
					}
					if (data == "4") {
						$scope.pwdVeryWeak = false;
						$scope.pwdWeak = false;
						$scope.pwdMedium = false;
						$scope.pwdStrong = false;
						$scope.pwdVeryStrong = true;
					}
				}
			})
		}
	}
})
