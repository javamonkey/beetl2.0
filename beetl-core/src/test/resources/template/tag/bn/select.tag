<%
//todo，也会多出一行，可能是第5行导致的
for(item in value){%>
${item[name]},${item[id]}
<%} %>
${tagBody}