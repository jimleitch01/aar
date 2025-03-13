document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("abductionForm");

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const formData = new FormData(form);

        fetch("/api/abductions/register", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            alert(data);
            form.reset();
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Failed to register abduction");
        });
    });
});
