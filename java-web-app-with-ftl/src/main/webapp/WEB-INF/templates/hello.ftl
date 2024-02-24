<!DOCTYPE html>
<head>
    <title>Hello FreeMarker</title>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
     <style>
        <#include "hello.css"/> 
     </style>
</head>
<body>
    <div class="container mt-5">
      <table class="table table-borderless">
         <tbody id="documentTable">
             <tr  style="grid-row-start: 1; grid-column-start: 1;">
               <td>
                  <span class="label">First Name</span>
                  <input type="text" class="form-control" value="First name" />
               </td>
             </tr>
             <tr style="grid-row-start: 1; grid-column-start: 2;">
               <td>
                  <span class="label">Last Name</span>
                  <input type="text" class="form-control" value="Last name" />
               </td>
             </tr>
             <tr style="grid-row-start: 1; grid-column-start: 3;">
               <td>
                  <span class="label">Gendar</span>
                  <input type="text" class="form-control" value="Gendar" />
               </td>
             </tr>
             <tr style="grid-row-start: 2; grid-column-start: 1;">
               <td>
                  <span class="label">Country Of Birth</span>
                  <input type="text" class="form-control" value="Country Of Birth" />
               </td>
             </tr>
              <tr style="grid-row-start: 2; grid-column-start: 2;">
               <td>
                  <span class="label">State Of Birth</span>
                  <input type="text" class="form-control" value="State Of Birth" />
               </td>
             </tr>
             <tr id="drodpown-position" style="grid-row-start: 3; grid-column-start: 1;">
               <td>
                  <span class="label">Address </span>
                   <select id="address-dropdown" class="form-control" onchange="changeAddress()">
                     <option class="w-100">address item 1</option>
                     <option>address item 2</option>
                     <option>address item 3</option>
                   </select>
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 1;">
               <td>
                  <span class="label">Father's Name</span>
                  <input type="text" class="form-control" value="Father's Name" />
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 2;">
               <td>
                  <span class="label">Mother's Name</span>
                  <input type="text" class="form-control" value="Mother's Name" />
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 3;">
               <td>
                  <span class="label">Spouse Name</span>
                  <input type="text" class="form-control" value="Spouse Name" />
               </td>
             </tr>
         </tbody>
      </table>
    </div>
</body>
</html>

<script>
   <#include "hello.js" />
</script>