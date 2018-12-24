<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」 ショップデータ詳細</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/layout/app.jsp">
            <c:param name="content">
                <c:choose>
                    <c:when test="${shop != null}">
                        <h2>ショップデータ詳細ページ</h2>

                        <table>
                            <tbody>
                                <tr>
                                    <th>店名</th>
                                    <td><c:out value="${shop.name}" /></td>
                                </tr>
                                <tr>
                                    <th>カテゴリー</th>
                                    <td><c:out value="${shop.category}" /></td>
                                </tr>


                                <tr>
                                    <th>営業時間(月～金)</th>
                                    <td><c:out value="${shop.open_at1} ～ ${shop.close_at1}" /></td>
                                </tr>
                                <tr>
                                    <th>営業時間(土～日)</th>
                                    <td><c:out value="${shop.open_at2} ～ ${shop.close_at2}" /></td>
                                </tr>
                                <tr>
                                    <th>定休日</th>
                                    <td><c:out value="${shop.holiday}" /></td>
                                </tr>
                                <tr>
                                    <th>住所</th>
                                    <td><c:out value="${shop.address}" /></td>
                                </tr>
                                <tr>
                                    <th>電話番号</th>
                                    <td><c:out value="${shop.tel}" /></td>
                                </tr>

                                <tr>
                                    <th>ホームページ</th>
                                    <td><a href="<c:url value='${shop.homepage}' />">${shop.homepage}</a></td>
                                </tr>
                                <tr>
                                    <th>公開設定</th>
                                    <c:choose>
                                        <c:when test="${shop.disclose == 1}">
                                            <td>
                                                公開
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                非公開
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th>備考 ※不規則な営業時間・定休日等</th>
                                    <td>
                                        <pre><c:out value="${shop.content}" /></pre>
                                    </td>
                                </tr>
                                <tr>
                                    <th>データ作成者</th>
                                    <td><c:out value="${shop.user.name}" /></td>
                                </tr>
                                <tr>
                                    <th>登録日時</th>
                                    <td>
                                        <fmt:formatDate value="${shop.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>更新日時</th>
                                    <td>
                                        <fmt:formatDate value="${shop.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <c:if test="${sessionScope.login_user.id == shop.user.id}">
                            <p><a href="<c:url value='/shops/edit?id=${shop.id}' />">このショップデータを編集する</a></p>
                        </c:if>
                        <c:if test="${sessionScope.login_user.admin_flag ==1}">
                            <p><a href="<c:url value='/shops/edit?id=${shop.id}' />">このショップデータを編集する</a></p>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <h2>お探しのデータは見つかりませんでした。</h2>
                    </c:otherwise>
                </c:choose>


                <p><a href="<c:url value='/shops/index' />">ショップデータ一覧に戻る</a></p>
                <p><a href="<c:url value='/' />">トップページに戻る</a></p>
            </c:param>
        </c:import>
    </body>
</html>













