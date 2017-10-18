<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="userName" scope="session" value="${sessionScope.userName}" />
<script src="${ctx}/js/jquery-2.1.0.min.js"></script>

<script type="text/javascript">
var ctx = "${ctx}";
</script>
