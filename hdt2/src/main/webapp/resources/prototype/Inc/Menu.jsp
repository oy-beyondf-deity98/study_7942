<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<p style='text-align: right;'>
  [My Account]
  &nbsp;
  [Logout]
</p>
<table class="cls100PercentTbl" style="margin-top: 0;">
  <colgroup>
    <col style='width: 15%;' />
    <col style='width: 17%;' />
    <col style='width: 17%;' />
    <col style='width: 17%;' />
    <col style='width: 17%;' />
    <col style='width: 17%;' />
  </colgroup>
  <tbody>
    <tr>
      <td<% if (request.getParameter("menu").equals("메인 화면")) out.print(" class='clsCurrentMenu'"); %>><a href='01-200.jsp' style='font-weight: bold;'>Home</a></td>
      <td<% if (request.getParameter("menu").equals("고객사관리")) out.print(" class='clsCurrentMenu'"); %>><a href='02-100.jsp' style='font-weight: bold;'>고객사관리</a></td>
      <td<% if (request.getParameter("menu").equals("장비이력관리")) out.print(" class='clsCurrentMenu'"); %>><a href='03-100.jsp' style='font-weight: bold;'>장비이력관리</a></td>
      <td<% if (request.getParameter("menu").equals("서비스관리")) out.print(" class='clsCurrentMenu'"); %>><a href='04-100.jsp' style='font-weight: bold;'>서비스관리</a></td>
      <td<% if (request.getParameter("menu").equals("공지관리")) out.print(" class='clsCurrentMenu'"); %>><a href='05-100.jsp' style='font-weight: bold;'>공지관리</a></td>
      <td<% if (request.getParameter("menu").equals("환경설정")) out.print(" class='clsCurrentMenu'"); %>><a href='06-100.jsp' style='font-weight: bold;'>환경설정</a></td>
    </tr>
    <tr style="display: <% out.print (request.getParameter("menu").equals("고객사관리") ? "" : "none"); %>;">
      <td colspan='6' style='text-align: center;'>
        <a href='02-100.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("회사별") ? "orange" : "#cccccc"); %>;">회사별</a>
        &nbsp;
        <a href='02-110.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("점포별") ? "orange" : "#cccccc"); %>;">점포별</a>
      </td>
    </tr>
    <tr style="display: <% out.print (request.getParameter("menu").equals("장비이력관리") ? "" : "none"); %>;">
      <td colspan='6' style='text-align: center;'>
        <a href='03-100.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("이력조회") ? "orange" : "#cccccc"); %>;">이력조회</a>
        &nbsp;
        <a href='03-150.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("납품관리") ? "orange" : "#cccccc"); %>;">납품관리</a>
        &nbsp;
        <a href='03-190.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("입고현황") ? "orange" : "#cccccc"); %>;">입고현황</a>
        &nbsp;
        <a href='03-200.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("장비등록") ? "orange" : "#cccccc"); %>;">장비등록</a>
      </td>
    </tr>
    <tr style="display: <% out.print (request.getParameter("menu").equals("서비스관리") ? "" : "none"); %>;">
      <td colspan='6' style='text-align: center;'>
        <a href='04-100.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("서비스조회") ? "orange" : "#cccccc"); %>;">서비스조회</a>
        &nbsp;
        <a href='04-300.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("서비스접수") ? "orange" : "#cccccc"); %>;">서비스접수</a>
      </td>
    </tr>
    <tr style="display: <% out.print (request.getParameter("menu").equals("공지관리") ? "" : "none"); %>;">
      <td colspan='6' style='text-align: center;'>
        <a href='05-100.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("공지사항") ? "orange" : "#cccccc"); %>;">공지사항</a>
        &nbsp;
        <a href='05-200.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("알림 메시지") ? "orange" : "#cccccc"); %>;">알림 메시지</a>
      </td>
    </tr>
    <tr style="display: <% out.print (request.getParameter("menu").equals("환경설정") ? "" : "none"); %>;">
      <td colspan='6' style='text-align: center;'>
        <a href='06-100.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("공통코드관리") ? "orange" : "#cccccc"); %>;">공통코드관리</a>
        <a href='06-130.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("제조사관리") ? "orange" : "#cccccc"); %>;">제조사관리</a>
        <a href='06-150.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("부서관리") ? "orange" : "#cccccc"); %>;">부서관리</a>
        <a href='06-200.jsp' style="font-weight: bold; color: <% out.print (request.getParameter("menu2").equals("사원관리") ? "orange" : "#cccccc"); %>;">사원관리</a>
      </td>
    </tr>
  </tbody>
</table>