<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>飲食店検索アプリ「何食べよっか？」 ショップ検索</title>
    </head>
    <body>
        <c:import url="../layout/app.jsp">
            <c:param name="content">
                <c:if test="${flush != null}">
                    <div id="flush_success">
                        <c:out value="${flush}"></c:out>
                    </div>
                </c:if>

                <h2>ショップ検索フォーム</h2>
                任意の条件にマッチする飲食店を検索・表示します。<br />
                フォームに条件を指定のうえ、検索ボタンをクリックしてください。<br />
                なお、実際にお店に行く前に、臨休等ないか念の為お店のホームページやSNSを確認してください。<br />
                検索実行前はあなたが登録済のショップデータの一覧を表示しています。<br />
                ※「他のユーザーのショップデータを含める」を選択すると、<br />
                　他のユーザーの作成したお店も検索に含めることができます。<br />
                　検索条件をうまく組み合わせて活用してください。<br />



                <p class="attention">お店が未登録、または追加登録する場合は<a href="<c:url value='/shops/new' />">「お店の新規登録」</a>から登録してください。</p>

                <form method="GET" action="<c:url value='/shops/search' />">

                訪店曜日:
                <select name="day">
                    <option value="月" selected>月曜日</option>
                    <option value="火">火曜日</option>
                    <option value="水">水曜日</option>
                    <option value="木">木曜日</option>
                    <option value="金">金曜日</option>
                    <option value="土">土曜日</option>
                    <option value="日">日曜日</option>
                </select>&nbsp;&nbsp;

                訪店時間:
                 <select name="hour">
            <option value="00" selected>00</option>
            <option value="01">01</option>
            <option value="02">02</option>
            <option value="03">03</option>
            <option value="04">04</option>
            <option value="05">05</option>
            <option value="06">06</option>
            <option value="07">07</option>
            <option value="08">08</option>
            <option value="09">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
        </select>
        :
        <select name="minute">
            <option value="00" selected>00</option>
            <option value="05">05</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="25">25</option>
            <option value="30">30</option>
            <option value="35">35</option>
            <option value="40">40</option>
            <option value="45">45</option>
            <option value="50">50</option>
            <option value="55">55</option>
        </select>&nbsp;&nbsp;

                カテゴリー:
        <select name="category">
            <option value="指定しない" selected>指定しない</option>
            <option value="日本料理">日本料理</option>
            <option value="寿司">寿司</option>
            <option value="魚介・海鮮料理">魚介・海鮮料理</option>
            <option value="揚げ物">揚げ物</option>
            <option value="ラーメン">ラーメン</option>
            <option value="そば・うどん・その他麺類">そば・うどん・その他麺類</option>
            <option value="鳥料理">鳥料理</option>
            <option value="すき焼き・しゃぶしゃぶ">すき焼き・しゃぶしゃぶ</option>
            <option value="おでん">おでん</option>
            <option value="粉もの">粉もの</option>
            <option value="郷土料理">郷土料理</option>
            <option value="丼もの">丼もの</option>
            <option value="和食その他">和食その他</option>
            <option value="ステーキ・ハンバーグ">ステーキ・ハンバーグ</option>
            <option value="パスタ・ピザ">パスタ・ピザ</option>
            <option value="ハンバーガー">ハンバーガー</option>
            <option value="洋食・欧風料理">洋食・欧風料理</option>
            <option value="フレンチ">フレンチ</option>
            <option value="イタリアン">イタリアン</option>
            <option value="西洋各国料理">その他西洋各国料理</option>
            <option value="中華料理">中華料理</option>
            <option value="韓国料理">韓国料理</option>
            <option value="アジア・エスニック料理">アジア・エスニック料理</option>
            <option value="カレー">カレー</option>
            <option value="焼肉・ホルモン">焼肉・ホルモン</option>
            <option value="鍋">鍋</option>
            <option value="居酒屋・ダイニングバー">居酒屋・ダイニングバー</option>
            <option value="創作料理">創作料理</option>
            <option value="定食・レストラン">定食・レストラン</option>
            <option value="弁当・おにぎり">弁当・おにぎり</option>
            <option value="カフェ・喫茶店">カフェ・喫茶店</option>
            <option value="パン・サンドイッチ">パン・サンドイッチ</option>
            <option value="スイーツ">スイーツ</option>
            <option value="その他">その他</option>
        </select><br />

        <label for="area">住所に</label>
        <input type="text" name="area"  />を含む&nbsp;&nbsp;


                他のユーザーのショップデータを
        <select name="extent">
            <option value="ALL">含める</option>
            <option value="MY" selected>含めない</option>
        </select>&nbsp;&nbsp;





        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">検索</button>

                </form><br />




                <table id="shop_list">
                    <tbody>
                        <tr>
                            <th class="shop_name2">店名</th>
                            <th class="shop_category2">カテゴリー</th>
                            <th class="shop_open2">営業時間(月～金)</th>
                            <th class="shop_close2">営業時間(土～日)</th>
                            <th class="shop_holiday2">定休日</th>
                            <th class="shop_address2">住所</th>
                            <th class="shop_content2">備考</th>
                            <th class="shop_action2">操作</th>
                        </tr>
                        <c:forEach var="shop" items="${shops}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="shop_name2"><c:out value="${shop.name}" /></td>
                                <td class="shop_category2"><c:out value="${shop.category}" /></td>
                                <td class="shop_open2"><c:out value="${shop.open_at1}" />～<c:out value="${shop.close_at1}" /></td>
                                <td class="shop_close2"><c:out value="${shop.open_at2}" />～<c:out value="${shop.close_at2}" /></td>
                                <td class="shop_holiday2"><c:out value="${shop.holiday}" /></td>
                                <td class="shop_address2"><c:out value="${shop.address}" /></td>
                                <td class="shop_content2"><c:out value="${shop.content}" /></td>
                                <td class="shop_action2"><a href="<c:url value='/shops/show?id=${shop.id}' />">詳細を見る</a></td>
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
                            <a href="<c:url value='/?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
            <p><a href="<c:url value='/shops/new' />">お店の新規登録</a></p>
            </c:param>
        </c:import>
    </body>
</html>



