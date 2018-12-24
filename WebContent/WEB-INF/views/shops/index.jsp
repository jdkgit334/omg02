<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」ショップデータ管理</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/layout/app.jsp">
            <c:param name="content">
                <c:if test="${flush != null}">
                    <div id="flush_success">
                        <c:out value="${flush}"></c:out>
                    </div>
                </c:if>
                <h2>ショップデータ管理</h2>
                あなたが登録済のショップデータの一覧を表示しています。<br />
                未登録または追加登録する場合は<a href="<c:url value='/shops/new' />">「お店の新規登録」</a>から登録してください。<br /><br />
                <table id="shop_list">
                    <tbody>
                        <tr>
                            <th class="shop_name">店名</th>
                            <th class="shop_category2">カテゴリー</th>
                            <th class="shop_open2">営業時間(月～金)</th>
                            <th class="shop_close2">営業時間(土～日)</th>
                            <th class="shop_holiday">定休日</th>
                            <th class="shop_content">備考</th>
                            <th class="shop_action">操作</th>
                        </tr>
                         <c:forEach var="shop" items="${shops}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="shop_name"><c:out value="${shop.name}" /></td>
                                <td class="shop_category2"><c:out value="${shop.category}" /></td>
                                <td><c:out value="${shop.open_at1} ～ ${shop.close_at1}" /></td>
                                <td><c:out value="${shop.open_at2} ～ ${shop.close_at2}" /></td>
                                <td class="shop_holiday"><c:out value="${shop.holiday}" /></td>
                                <td class="shop_content"><c:out value="${shop.content}" /></td>
                                <td class="shop_action"><a href="<c:url value='/shops/show?id=${shop.id}' />">詳細を見る</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

                <div id="pagination">
                （全 ${shops_count} 件）<br />
                <c:forEach var="i" begin="1" end="${((shops_count - 1) / 15) + 1}" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}" />&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/shops/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <p><a href="<c:url value='/shops/new' />">お店の新規登録</a></p>
            <p><a href="<c:url value='/' />">トップページに戻る</a></p>
            </c:param>
        </c:import>
    </body>
</html>








































