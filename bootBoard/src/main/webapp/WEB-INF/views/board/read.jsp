<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"></jsp:include>
<main>
    <div class="tit">
        <h2>상세보기</h2>
    </div>
    <div class="view">
        <input type="hidden" class="form-control" name="bno" id="exampleFormControlInput1"
               value="${board.bno}" readonly>
        <div class="top">
            <h2>${board.title}</h2>
            <div class="info">
                <p>
                    <span>작성일</span><span><fmt:formatDate value="${board.postdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
</span>
                </p>
                <p>
                    <span>조회수</span><span>${board.readcount}</span>
                </p>
            </div>
        </div>
        <div class="content">
            ${board.content}
            <c:if test="${not empty board.sfile}">
                <div class="imgBox">
                    <img src="/uploads/${board.sfile}">
                </div>
            </c:if>
        </div>
        <c:if test="${not empty board.ofile}">
            <div class="bottom">
                <h3>첨부파일</h3>
                <div>
                    <p>${board.ofile} </p>
                    <a href="/board/download?ofile=${board.ofile}&sfile=${board.sfile}">
                        다운로드</a>
                </div>
            </div>
        </c:if>
    </div>
    <div class="btn-wrap">
        <button type="button" class="btn01">수정하기</button>
        <button type="button" class="btn02">삭제하기</button>
        <button type="button" class="btn03">목록보기</button>
    </div>
    <script>
        document.querySelector(".btn01").addEventListener("click", function (e) {
            self.location = `/board/modify?bno=${board.bno}`
        }, false)
        document.querySelector(".btn02").addEventListener("click", function (e) {
            self.location = `/board/remove?bno=${board.bno}`;
        }, false)
        document.querySelector(".btn03").addEventListener("click", function (e) {
            self.location = "/board/list";
        }, false)
    </script>
</main>
</body>
</html>