<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  Java server page Standard Tag Library(JSTL)  -->

<!-- Inclu fichier jsp en envoyant des paramètres -->
<jsp:include page="html_header.jsp">
	<jsp:param value="Accueil" name="title"/>
</jsp:include>

<section style="color:${couleurChoisie}" class="col-6">

	<h1>Accueil</h1>
	<form method="post" action="${pageContext.request.contextPath}/ServletAccueil">
	  <label class="mr-sm-2" for="inlineFormCustomSelect">Préférences</label>
	  <div class="form-row align-items-center">
	    <div class="col-auto">
	      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="couleurs">
			<c:forEach var="col" items="${ applicationScope.couleurs}">
				<option ${ col.equals(sessionScope.couleurChoisie) ? "selected" : "" } value="${col}">${col}</option>
			</c:forEach>
	      </select>
	    </div>
	    <div class="col-auto">
	      <button type="submit" class="btn btn-primary">Valider</button>
	    </div>
	  </div>
	</form>

	<p>Vous êtes venus ${requestScope.nbPassage} fois</p>
	

</section>
<jsp:include page="footer.jsp">
	<jsp:param value="Accueil" name="filename"/>
</jsp:include>

