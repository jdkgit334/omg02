<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」 ショップデータ新規登録</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/layout/app.jsp">
            <c:param name="content">
                <h2>ショップデータ 新規登録ページ</h2>

                <form method="POST" action="<c:url value='/shops/create' />">
                    <c:import url="_form.jsp" />
                </form>

                <p><a href="<c:url value='/shops/index' />">ショップデータ一覧に戻る</a></p>
            </c:param>
        </c:import>
    </body>
</html>