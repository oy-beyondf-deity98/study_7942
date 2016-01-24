<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="cls100PercentTbl">
  <colgroup>
    <col style='width: 20%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
    <col style='width: 10%;' />
  </colgroup>
  <tbody>
    <tr>
      <td rowspan="3" style='font-size: 11pt; font-weight: bold;'>화면설계서/Prototype</td>
      <td class='clsTbGrayHeader'>작성자</td>
      <td>전진기</td>
      <td class='clsTbGrayHeader'>시스템명</td>
      <td colspan='3'>P14-03-01 (주)버텍스아이디 AS／RS 관제 시스템 구축</td>
      <td class='clsTbGrayHeader' rowspan="2">ID</td>
      <td rowspan="2"><%=request.getParameter("id")%></td>
    </tr>
    <tr>
      <td class='clsTbGrayHeader'>작성일</td>
      <td>2014-03-07</td>
      <td class='clsTbGrayHeader'>버전</td>
      <td>1.0</td>
      <td class='clsTbGrayHeader'>작업단계</td>
      <td>설계</td>
    </tr>
    <tr>
      <td class='clsTbGrayHeader'>화면명</td>
      <td colspan="3"><%=request.getParameter("title")%></td>
      <td class='clsTbGrayHeader'>위치</td>
      <td colspan="3"><%=request.getParameter("Navi")%></td>
    </tr>
  </tbody>
</table>