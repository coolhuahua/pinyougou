mt.controller("myCtrl", function ($scope,$controller,brandService) {

    $controller("baseController",{$scope:$scope});

    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.brandList = response;
        });
    };



    $scope.findPage = function (pageNum, pageSize) {
        brandService.findPage(pageNum, pageSize).success(function (response) {
            $scope.paginationConf.totalItems = response.total;//总记录数
            $scope.brandList = response.rows;//当前页展示的数据结果集
        })
    };



    $scope.save = function () {
        if ($scope.entity.id != null) {
            brandService.update($scope.entity).success(function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            })
        } else {
            brandService.add($scope.entity).success(function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            })
        }
    };

    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (response) {
            $scope.entity = response;
        })
    };



    $scope.dele = function () {
        if (confirm("您确定要删除吗?")) {
            brandService.dele($scope.selectIds).success(function (response) {
                if (response.success) {
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
            });
        }
    };
});
