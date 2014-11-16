<%
    /*Esto devuelve la ruta para concatenarla con el nombre de los ficheros .json.jsp
    y asi que en caso de mover o modificar la estructura de carpetas del servidor no 
    se produzcan errores*/
    
    /*Lo importamos en index.html y eso nos permitira coger la variable global 
    "contextPath" en el index.js*/
    String contextPath=request.getContextPath();
%>

var contextPath= "<%=contextPath%>";
