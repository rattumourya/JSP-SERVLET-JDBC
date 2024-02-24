document.getElementById('DOMContentLoaded',function(){
     
});

function changeAddress()
{
    var addressFields = document.querySelectorAll(".address-fields");
    console.log("addressFields",addressFields);
    if(addressFields.length == 0)
    {
        var dropdownField = document.getElementById("drodpown-position");
        var row = dropdownField.style.getPropertyValue("grid-row-start");
        var siblings = Array.from(dropdownField.parentNode.children);
        var bottomFields = siblings.slice(siblings.indexOf(dropdownField) + 1);
        bottomFields.forEach(element => {
            element.style.gridRowStart = parseInt(element.style.gridRowStart) + 3;
        });

        var documentTableEl = document.getElementById("documentTable");
        var startRow = parseInt(row) + 1;
        var startCol = 1;
        var html = ``;
        <#list addressFields as x>
            var html = html +  `<tr class="address-fields">
                            <td>
                                <span class="label">`+ "${x}" + `</span>
                                <input type="text" class="form-control" value="` + '${x}' + `" />
                            </td>
                        </tr>`;  
        </#list>
        var entireHtml = documentTableEl.innerHTML + html;
        documentTableEl.innerHTML = entireHtml;
        placeAddressItemsCorrectly(startRow,startCol);
    }else {

    }

}

function placeAddressItemsCorrectly(startRow,startCol)
{
    var addressFields = document.querySelectorAll(".address-fields");
    addressFields.forEach(element => {
        element.style.gridRowStart = startRow;
        element.style.gridColumnStart = startCol;
        startCol++
        if(startCol > 3)
        {
            startCol = 1;
            startRow = startRow + 1;
        }
    });
}