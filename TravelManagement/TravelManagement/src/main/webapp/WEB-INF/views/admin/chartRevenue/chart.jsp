<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/7/2022
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" style="margin-top: .5rem">
    <div class="row">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Chọn năm để thống kê tháng....
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach items="${yearCb}" var="yearCbItem" >
                    <a class="dropdown-item" href="<c:url value="/admin/chartRevenue" />?year=${yearCbItem}">${yearCbItem}</a>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-6" style="margin-top: 1rem">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-bar me-1"></i>
                    Số lượng tour theo tháng (năm ${year})
                </div>
                <div class="card-body"><canvas id="myBarChartMonth" width="100%" height="50"></canvas></div>
                <%--<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>--%>
            </div>
            <table class="table table-bordered table-dark">
                <h5 class="text-center">Bảng thống kê doanh thu trong tháng (năm ${year})</h5>
                <thead>
                <tr>
                    <th scope="col">Tháng</th>
                    <th scope="col">Tổng doanh thu</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${revenueStatsByMonth}" var="item">
                    <tr>
                        <th scope="row">${item[0]}</th>
                        <td><fmt:formatNumber
                                type = "number"
                                maxFractionDigits = "3"
                                value = "${Math.round(item[1] / 1000) * 1000 }" /> đ</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-6" style="margin-top: 1rem">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-chart-bar me-1"></i>
                    Doanh thu theo năm
                </div>
                <div class="card-body"><canvas id="myBarChartYear" width="100%" height="50"></canvas></div>
                <%--<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>--%>
            </div>
            <table class="table table-bordered table-dark">
                <h5 class="text-center">Bảng thống kê doanh thu các năm</h5>
                <thead>
                <tr>
                    <th scope="col">Năm</th>
                    <th scope="col">Số lượng tour</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${revenueStatsByYear}" var="item">
                    <tr>
                        <th scope="row">${item[0]}</th>
                        <td><fmt:formatNumber
                                type = "number"
                                maxFractionDigits = "3"
                                value = "${Math.round(item[1] / 1000) * 1000 }" /> đ</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<div>
    <canvas id="myChart"></canvas>
</div>

<script>
    let statLabelsMonth=[], statInfoMonth=[];
    let statLabelsYear=[], statInfoYear=[];
    <c:forEach items="${revenueStatsByMonth}" var="item">
    statLabelsMonth.push("Tháng " + ${item[0]})
    statInfoMonth.push(${item[1]})
    </c:forEach>

    <c:forEach items="${revenueStatsByYear}" var="item">
    statLabelsYear.push("Năm " + ${item[0]})
    statInfoYear.push(${item[1]})
    </c:forEach>
    window.onload = function () {
        drawBarChart("myBarChartMonth", statLabelsMonth, "Thống kê", statInfoMonth)
        drawBarChart("myBarChartYear", statLabelsYear, "Thống kê", statInfoYear)
    }

</script>
