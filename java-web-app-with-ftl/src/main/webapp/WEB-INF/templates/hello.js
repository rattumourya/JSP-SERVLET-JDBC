var addressFeildList = [
    {
        "Address Line 1": "Raigaro ka mohalla , Ward - 09", "Address Line 2": "Nayabas samod", "Address Line 3": "chomu jaipur",
        "Address Line 4": "rajasthan india", "City": "jaipur", "State": "rajasthan", "Country": "india", "ZipCode": "303806"
    },
    {
        "Address Line 1": "Skyview Corporate Park Tower B", "Address Line 2": "Sector 74A", "Address Line 3": "",
        "Address Line 4": "", "City": "Gurugram", "State": "Haryana", "Country": "india", "ZipCode": "122004"
    },
]

window.addEventListener('DOMContentLoaded',function(){
    console.log("Once DOM Loaded");
    addElipsis();
});
window.addEventListener('resize',function(){
    console.log("Resize event");
    addElipsis();
});

function changeAddress(selectedIndex)
{
    selectedIndex = 2;
    var addressFields = document.querySelectorAll(".address-fields");
    if(addressFields.length == 0)   
    {
        // move fields down by 3 rows
        var dropdownField = document.getElementById("drodpown-position");
        var row = dropdownField.style.getPropertyValue("grid-row-start");
        var siblings = Array.from(dropdownField.parentNode.children);
        var bottomFields = siblings.slice(siblings.indexOf(dropdownField) + 1);
        bottomFields.forEach(element => {
            element.style.gridRowStart = parseInt(element.style.gridRowStart) + 3;
        });

        // place new rows in replaced rows
        var documentTableEl = document.getElementById("documentTable");
        var html = ``;
        var addressObject = addressFeildList[selectedIndex-1]
        for (const key in addressObject) {
            if (Object.hasOwnProperty.call(addressObject, key)) {
                console.log(key, addressObject[key]);
                var html = html +  `<tr class="address-fields">
                                        <td>
                                            <span> ` + key + `</span>
                                            <input type="text" class="form-control" value="`+addressObject[key] +`" />
                                        </td>
                                    </tr>`; 
            }
        }
   
        var entireHtml = documentTableEl.innerHTML + html;
        documentTableEl.innerHTML = entireHtml;

        // place new address fields in correct order
        var startRow = parseInt(row) + 1;
        var startCol = 1;
        placeAddressItemsCorrectly(startRow,startCol);
        // select the selectedIndex as previously selected
        var addressDropdown = document.getElementById("address-dropdown");
        addressDropdown.options[0].removeAttribute("selected");
        addressDropdown.options[selectedIndex].setAttribute("selected",true);
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

function addAddressFieldsDynamically(addressItem)
{
    var documentTableEl = document.getElementById("documentTable");
    var trEl = document.createElement('tr');
    trEl.classList.add("address-fields");
    var tdEl = document.createElement('td');
    var spanEl = document.createElement('span');
    spanEl.classList.add("label");
    var inputEl = document.createElement('input');
    inputEl.classList.add("form-control");
    inputEl.type = "text";
    inputEl.value = addressItem;
    inputEl.textContent = addressItem;
    tdEl.appendChild(spanEl);
    tdEl.appendChild(inputEl);
    trEl.appendChild(tdEl);
    documentTableEl.append(trEl);
}

function addElipsis()
{
    var selectEl = document.getElementById("address-dropdown");
    var widthOfSelect = selectEl.clientWidth;
    var addressOptions = selectEl.options;
    var numberOfCharactors = Math.floor(widthOfSelect/8);
    for(var i = 0; i < addressFeildList.length; i++)
    {
        var addressObject = addressFeildList[i]
        for (const key in addressObject) {
            if (Object.hasOwnProperty.call(addressObject, key)) {
                console.log(key, addressObject[key]);
                
            }
        }
        var optionText = addressOptions[i+1].innerText;
        console.log(optionText);
        addressOptions[i+1].innerText = optionText.substring(0,numberOfCharactors) + " ...";
    }
}
