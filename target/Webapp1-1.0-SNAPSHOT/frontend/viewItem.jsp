<jsp:include page="menu.jsp"/>
<%
    String photo = (String)session.getAttribute("photo");
    photo="uploads/"+photo;
    System.out.println(photo);
            %>

<html>
    <body>
        <div class=""main-content">
            <div class="title">Display Item</div>
            <div class="content itemDisplay">
                <img src="<%= photo %>" />
                <h1>Item Name</h1>
                 <h1>Item price</h1>
                  <h1>Item Stock</h1>

                
            
        </div>
    </body>
</html>
