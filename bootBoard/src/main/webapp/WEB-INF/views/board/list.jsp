<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"></jsp:include>
<main>

    <div class="tit">
        <h2>목록보기</h2>

        <div class="searchBox">
            <form action="/board/list" method="get">
                <input type="hidden" name="size" value="${pageRequestDTO.size}">
                <input type="hidden" name="page" value="${pageRequestDTO.page}">
                <select name="searchField">
                    <option value="title" ${pageRequestDTO.searchField=='title'?'selected':''}>제목</option>
                    <option value="content" ${pageRequestDTO.searchField=='content'?'selected':''}>내용</option>
                </select>
                <div class="area">
                    <input type="text" name="keyword" value="${pageRequestDTO.keyword}" placeholder="검색어 입력">
                    <button type="submit"></button>
                </div>
            </form>

        </div>
    </div>
    <div class="btn-wrap">
        <button type="button" class="btn01">글쓰기</button>
    </div>
    <c:choose>
        <c:when test="${empty responseDTO.dtoList}">
            <tr>
                <td colspan="6" style="text-align: center;">게시글이 없습니다.</td>
            </tr>
        </c:when>
        <c:otherwise>
            <ul class="board-list">
                <c:forEach items="${responseDTO.dtoList}" var="board">
                    <div class="item" onclick="location.href='/board/read?bno=${board.bno}'">
                        <div class="top">
                            <span>No.${board.bno}</span> <span><fmt:formatDate value="${board.postdate}"
                                                                               pattern="yyyy-MM-dd"/></span>
                        </div>
                        <p class="title">${board.title}</p>
                        <div class="bottom">
                            <p>
                                <span>조회수</span> <span>${board.readcount }</span>
                            </p>
                            <c:if test="${not empty board.ofile}">
                                <a href="/board/download?ofile=${board.ofile}&sfile=${board.sfile}">첨부파일</a>
                            </c:if>
                                <%-- <c:if test="${empty board.ofile}">-</c:if> --%>
                        </div>
                    </div>
                </c:forEach>
            </ul>

            <nav aria-label="...">
                <ul class="pagination" style="justify-content: center;">
                    <c:if test="${responseDTO.prev}">
                        <li class="page-item">
                            <a class="page-link arrow-left"
                               href="?page=${responseDTO.start - 1}&${pageRequestDTO.link}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                        <li class="page-item ${responseDTO.page == num ? 'active' : ''}">
                            <a class="page-link"
                               href="?page=${num}&${pageRequestDTO.link}">${num}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${responseDTO.next}">
                        <li class="page-item">
                            <a class="page-link arrow-right"
                               href="?page=${responseDTO.end + 1}&${pageRequestDTO.link}">Next</a>
                        </li>
                    </c:if>
                </ul>

            </nav>

        </c:otherwise>
    </c:choose>
    <script>
        document.querySelector(".btn01").addEventListener("click", function (e) {
            self.location = "/board/register";
        }, false);
    </script>
</main>
</body>
</html>