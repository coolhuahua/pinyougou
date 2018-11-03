mt.service("brandService", function ($http) {
    this.findAll= function () {
        return $http.get("../brand/findAll.do");
    };

    this.findPage = function (pageNum, pageSize) {
        return $http.get("../brand/findPage.do?pageNum=" + pageNum + "&pageSize=" + pageSize);
    };

    this.update = function (entity) {
        return $http.post("../brand/update.do", entity);
    };

    this.add = function (entity) {
        return $http.post("../brand/add.do", entity);
    };

    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id);
    };

    this.dele = function (selectIds) {
        return $http.get("../brand/deleBrands.do?ids=" +selectIds);
    };
});