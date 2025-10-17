<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<jsp:include page="../include/header.jsp"></jsp:include>
<main>
    <div class="tit">
        <h2>수정하기</h2>
    </div>
    <form name="writeFrm" method="post" action="/board/modify"
          enctype="multipart/form-data"
          class="wfrm">
        <div class="frm-box">
            <input type="hidden" name="bno" value="${board.bno}">
            <table class="">
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="${board.title}"></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><textarea style="width: 100%; height: 200px"
                                  name="content">${board.content}</textarea></td>
                </tr>
                <tr>
                    <td>첨부파일</td>
                    <td><input type="file" name="file" value="${board.ofile}"></td>
                </tr>
            </table>
        </div>
        <div class="btn-wrap">
            <button type="submit" class="btn01">작성완료</button>
            <button type="button" class="btn03">목록보기</button>
        </div>
        <script>
            document.querySelector(".btn03").addEventListener("click", function (e){
                self.location="/board/list";
            }, false)

        </script>
    </form>

</main>
</body>
</html>