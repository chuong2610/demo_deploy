/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.getElementById("month").addEventListener("change", function() {
    let month = this.value;
    let employeeId = document.getElementById("id").value; // Lấy ID từ input hidden
    console.log(month);
    
    fetch(`http://localhost:8080/QuanLiNhanSu/profileapi?month=${month}&id=${employeeId}`)
    .then(response => response.json())
    .then(data => {
        if (data.exists === true) {
                    console.log(data.totalSalary);
            document.getElementById("totalSalary").textContent = data.totalSalary+" VND";
            
        } else {
                    console.log(data.exists);
            document.getElementById("totalSalary").textContent = "";
           
        }
    })
    .catch(error => console.error("Lỗi:", error));
});