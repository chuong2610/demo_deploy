/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.getElementById("workDate").addEventListener("change", function() {
    let workDate = this.value;
    let employeeId = document.getElementById("id").value; // Lấy ID từ input hidden
    
    fetch(`http://localhost:8080/QuanLiNhanSu/attendencedetailapi?workDate=${workDate}&id=${employeeId}`)
    .then(response => response.json())
    .then(data => {
        if (data.exists== true) {
                    console.log(data.checkIn);
            document.getElementById("checkIn").value = data.checkIn;
            document.getElementById("checkOut").value = data.checkOut;
        } else {
                    console.log(data.exists);
            document.getElementById("checkIn").value = "";
            document.getElementById("checkOut").value = "";
        }
    })
    .catch(error => console.error("Lỗi:", error));
});



