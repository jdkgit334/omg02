<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」 ログイン</title>
    </head>
    <body>
    <c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${hasError}">
            <div id="flush_error">
                ユーザーIDまたはパスワードが間違っています。
            </div>
        </c:if>
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <p>「食べに行きたいお店の候補はあるけど、この時間に営業していたっけ？」<br>なんて、考えたことありませんか？<br />飲食店検索アプリ「何食べよっか？」は、そんなシーンの一助になります。</p>
        <p>※初めて利用される方は、<a class="u-line"  href="<c:url value='/users/new' />">新規ユーザーの登録</a>を行ってください。</p>


        <h2>ログイン</h2>
        <form method="POST" action="<c:url value='/login' />">
            <label for="code">ユーザーID</label><br />
            <input type="text" name="code" value="${code}" />
            <br /><br />

            <label for="password">パスワード</label><br />
            <input type="password" name="password" />
            <br /><br />

            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit">ログイン</button>
        </form>
        <p>
        パスワードを万一お忘れになった場合は、下記メールアドレス宛パスワード再発行を依頼してください。</p>
        　termination_gfdm■yahoo.co.jp　※@は■に変えて記載しています。<br />
        　件名：パスワード変更依頼<br />
        　※本文に必ずユーザーID及びユーザー名を記載してください。<br />

    </c:param>
    </c:import>
    </body>
</html>