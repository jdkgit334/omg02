<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」 ユーザー情報詳細</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/layout/app.jsp">
            <c:param name="content">
                <c:choose>
                    <c:when test="${user != null}">
                        <h2>id : ${user.id} のユーザー情報 詳細ページ</h2>

                        <table>
                            <tbody>
                                <tr>
                                    <th>ユーザーID</th>
                                    <td><c:out value="${user.code}" /></td>
                                </tr>
                                <tr>
                                    <th>ユーザー名</th>
                                    <td><c:out value="${user.name}" /></td>
                                </tr>
                                <tr>
                                    <th>権限</th>
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.admin_flag == 1}">管理者</c:when>
                                            <c:otherwise>一般</c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <th>登録日時</th>
                                    <td>
                                        <fmt:formatDate value="${user.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>更新日時</th>
                                    <td>
                                        <fmt:formatDate value="${user.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                        <p><a href="<c:url value='/users/edit?id=${user.id}' />">このユーザー情報を編集する</a></p>
                    </c:when>
                    <c:otherwise>
                        <h2>お探しのデータは見つかりませんでした。</h2>
                    </c:otherwise>
                </c:choose>

                <p><a href="<c:url value='/users/index' />">一覧に戻る</a></p>
            </c:param>
        </c:import>
    </body>
</html>

















