<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="webResourceUrl" value="${pageContext.request.contextPath}"/>

<!-- 首页 -->
<c:set var="commonurl_home" value="${ctx}/admin/index.do" />
<!-- 登录 -->
<c:set var="commonurl_login" value="${ctx}/admin/login.do" />
<!-- 退出 -->
<c:set var="commonurl_logout" value="${ctx}/admin/logout.do" />

<!-- 首页 -->
<c:set var="pc_home" value="${ctx}/index.do" />



<script type="text/javascript">

    function AppConfig() {
    }
    AppConfig.ctx = "${ctx}";
    AppConfig.webResourceUrl = "${webResourceUrl}";
  


</script>

