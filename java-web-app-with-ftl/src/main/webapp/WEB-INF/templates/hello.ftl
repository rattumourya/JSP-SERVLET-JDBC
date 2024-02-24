<!DOCTYPE html>
<head>
    <title>Hello FreeMarker</title>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->

<!-- Latest compiled and minified JavaScript -->
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
                  <span class=" ">First Name</span>
                  <input type="text" class="form-control" value="First name" />
               </td>
             </tr>
             <tr style="grid-row-start: 1; grid-column-start: 2;">
               <td>
                  <span class=" ">Last Name</span>
                  <input type="text" class="form-control" value="Last name" />
               </td>
             </tr>
             <tr style="grid-row-start: 1; grid-column-start: 3;">
               <td>
                  <span class=" ">Gendar</span>
                  <input type="text" class="form-control" value="Gendar" />
               </td>
             </tr>
             <tr style="grid-row-start: 2; grid-column-start: 1;">
               <td>
                  <span class=" ">Country Of Birth</span>
                  <input type="text" class="form-control" value="Country Of Birth" />
               </td>
             </tr>
              <tr style="grid-row-start: 2; grid-column-start: 2;">
               <td>
                  <span class=" ">State Of Birth</span>
                  <input type="text" class="form-control" value="State Of Birth" />
               </td>
             </tr>
             <tr id="drodpown-position" style="grid-row-start: 3; grid-column-start: 1;">
               <td class="custom-dropdown">
                  <span class=" ">Address </span>
                   <select id="address-dropdown" class="form-control" onchange="changeAddress(this.selectedIndex)">
                     <option value="" disabled selected>please select ...</option>
                     <option value="address item 2">address item 2 address item 2 address item 2</option>
                     <option value="address item 1">address item 1 address item 1 address item 1</option>
                   </select>
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 1;">
               <td>
                  <span class=" ">Father's Name</span>
                  <input type="text" class="form-control" value="Father's Name" />
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 2;">
               <td>
                  <span class=" ">Mother's Name</span>
                  <input type="text" class="form-control" value="Mother's Name" />
               </td>
             </tr>
              <tr style="grid-row-start: 4; grid-column-start: 3;">
               <td>
                  <span class=" ">Spouse Name</span>
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