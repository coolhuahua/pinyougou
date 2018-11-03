mt.controller("baseController", function ($scope) {
    $scope.selectIds = [];

    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        }else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    };

    <!--分页控件的配置信息-->
    $scope.paginationConf = {
        currentPage: 1,  				//当前页
        totalItems: 10,					//总记录数
        itemsPerPage: 10,				//每页记录数
        perPageOptions: [10, 20, 30, 40, 50], //分页选项，下拉选择一页多少条记录
        onChange: function () {			//每次页面变更后都会执行该方法
            $scope.reloadList();		//启动就会调用分页组件
        }
    };

    $scope.reloadList = function () {
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
});

