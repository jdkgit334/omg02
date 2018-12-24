<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」ショップデータ編集</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/layout/app.jsp">
        <c:param name="content">
            <c:choose>
                <c:when test="${shop != null}">
                <h2>ショップデータ 編集ページ</h2>
                <form method="POST" action="<c:url value='/shops/update' />">
                    <c:import url="_form.jsp" />
                </form>


                 <p><a href="#" onclick="confirmDestroy();">このショップデータを削除する</a></p>
                <form method="POST" action="<c:url value='/shops/destroy' />">
                    <input type="hidden" name="_token" value="${_token}" />
                </form>
                <script>
                    function confirmDestroy() {
                        if(confirm("本当に削除してよろしいですか？")) {
                            document.forms[1].submit();
                        }
                    }
                </script>


            </c:when>

            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/shops/index' />">ショップデータ一覧に戻る</a></p>
        </c:param>
    </c:import>
    </body>
</html>