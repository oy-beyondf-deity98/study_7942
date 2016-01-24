<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="Inc/Header.jsp" flush='true'>
      <jsp:param value="회사별" name="title" />
    </jsp:include>
  </head>

  <body>
    <div id="content-wrap">
      <jsp:include page="Inc/Top.jsp" flush='true'>
        <jsp:param value="02-100" name="id" />
        <jsp:param value="회사별" name="title" />
        <jsp:param value="Home > 고객사관리 > 회사별" name="Navi" />
      </jsp:include>
      <br />
      <jsp:include page="Inc/Screen.jsp" flush='true' />
    </div>
    <div id='divLeftContent' style='display: none; vertical-align: top;'>
      <jsp:include page="Inc/Menu.jsp" flush='true'>
        <jsp:param value="회사별" name="menu2" />
        <jsp:param value="고객사관리" name="menu" />
      </jsp:include>
      <br />
      <div>
        <div>
          <table class="cls100PercentTbl1px" style="margin-top: 0;">
            <tbody>
              <tr>
                <td style='text-align: left;'>
                  사업자유형
                  <select>
                    <option>법인사업자</option>
                    <option>개인사업자</option>
                    <option>개인</option>
                  </select>
                  &nbsp;
                  사업자번호
                  <input type='text' style='width: 100px;' />
                  &nbsp;
                  상호
                  <input type='text' style='width: 100px;' />
                  &nbsp;
                  관리 브랜드
                  <input type='text' style='width: 100px;' />
                </td>
                <td style='text-align: right;'>
                  <input type='button' value='검색' />
                  <input type='button' value='등록' onclick='document.getElementById("divForm").style.display = "";' />
                </td>
              </tr>
            </tbody>
          </table>
          <br />
          <table class="cls100PercentTbl" style="margin-top: 0;">
            <colgroup>
              <col style='width: 10%;' />
              <col style='width: 15%;' />
              <col style='width: 12%;' />
              <col style='width: 8%;' />
              <col style='width: 15%;' />
              <col style='width: 40%;' />
            </colgroup>
            <thead>
              <tr>
                <th>사업자유형</th>
                <th>상호</th>
                <th>사업자번호</th>
                <th>대표자명</th>
                <th>대표전화</th>
                <th>관리브랜드</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style='text-align: center;'>법인</td>
                <td style='text-align: center;'><strong onclick='document.getElementById("divForm").style.display = "";'>홈플러스</strong></td>
                <td style='text-align: center;'>123-45-67890</td>
                <td style='text-align: center;'>홍길동</td>
                <td style='text-align: center;'>02-123-4567</td>
                <td style='text-align: left;'>홈플러스, 익스프레스</td>
              </tr>
              <tr>
                <td style='text-align: center;'>법인</td>
                <td style='text-align: center;'><strong onclick='document.getElementById("divForm").style.display = "";'>롯데마트</strong></td>
                <td style='text-align: center;'>123-45-67890</td>
                <td style='text-align: center;'>김태희</td>
                <td style='text-align: center;'>02-2345-6789</td>
                <td style='text-align: left;'>롯데마트, 롯데슈퍼</td>
              </tr>
              <tr>
                <td style='text-align: center;'>법인</td>
                <td style='text-align: center;'><strong onclick='document.getElementById("divForm").style.display = "";'>이마트</strong></td>
                <td style='text-align: center;'>123-45-67890</td>
                <td style='text-align: center;'>유이</td>
                <td style='text-align: center;'>02-1010-2020</td>
                <td style='text-align: left;'></td>
              </tr>
            </tbody>
          </table>
          <br />
          <div id='divForm' style='display: none; width: 100%;'>
            <table class="cls100PercentTbl" style="margin-top: 0; width: 60%; margin-left: auto; margin-right: auto;">
              <colgroup>
                <col style='width: 15%;' />
                <col style='width: 85%;' />
              </colgroup>
              <tbody>
                <tr>
                  <td style='text-align: center;' class='clsRed'>사업자 유형</td>
                  <td style='text-align: left;'>
                    <input type='radio' checked='checked' /> 법인사업자
                    &nbsp;
                    <input type='radio' /> 개인사업자
                    &nbsp;
                    <input type='radio' /> 개인
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>사업자 번호</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;' class='clsRed'>상호</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>대표자명</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>업태</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>종목</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>주소</td>
                  <td style='text-align: left;'>
                    <input type='text' size='3' />
                    -
                    <input type='text' size='3' />
                    <input type='button' value='우편번호' />
                    <br />
                    <input type='text' style='width: 400px;' /><br />
                    <input type='text' style='width: 400px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>대표전화</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>팩스번호</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>웹 사이트</td>
                  <td style='text-align: left;'>
                    http:// <input type='text' style='width: 200px;' />
                  </td>
                </tr>
                <tr>
                  <td style='text-align: center;'>관리 브랜드</td>
                  <td style='text-align: left;'>
                    <input type='text' style='width: 200px;' />
                    <select>
                      <option>사용</option>
                      <option>미사용</option>
                    </select>
                    <input type='button' value='삭제' />
                    <br />
                    <input type='text' style='width: 200px;' />
                    <select>
                      <option>사용</option>
                      <option>미사용</option>
                    </select>
                    <input type='button' value='삭제' />
                    <br />
                    <input type='text' style='width: 200px;' />
                    <select>
                      <option>사용</option>
                      <option>미사용</option>
                    </select>
                    <input type='button' value='삭제' />
                    <br />
                    <input type='text' style='width: 200px;' />
                    <select>
                      <option>사용</option>
                      <option>미사용</option>
                    </select>
                    <input type='button' value='삭제' />
                    <br />
                    <input type='text' style='width: 200px;' />
                    <select>
                      <option>사용</option>
                      <option>미사용</option>
                    </select>
                    <input type='button' value='삭제' />
                  </td>
                </tr>
              </tbody>
            </table>
            <p style='width: 100%; text-align: center;'>
              <input type='button' value='확인' />
              <input type='button' value='취소' onclick='document.getElementById("divForm").style.display = "none";' />
            </p>
          </div>
        </div>
      </div>
    </div>
    <div id='divRightContent' style='display: none;'>
      <ul class='clsComment'>
        <li>대상 테이블: tb_customer, tb_customer_brand</li>
        <li>"관리 브랜드" 수정 시에만 "삭제" 버튼 나오게 할 것</li>
        <li>"주소" 입력 시 DB 테이블에 "위치" 자동 입력(예: 서울, 대전, 대구)</li>
      </ul>
    </div>
  </body>
</html>