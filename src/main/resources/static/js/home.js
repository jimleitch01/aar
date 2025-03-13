document.addEventListener("DOMContentLoaded", function () {
    const searchForm = document.getElementById("searchForm");
    const searchQuery = document.getElementById("searchQuery");
    const searchResults = document.getElementById("searchResults");
    const recentAbductions = document.getElementById("recentAbductions");
    const abductionForm = document.getElementById("abductionForm");

    // Handle search form submission
    searchForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const query = searchQuery.value.trim();
        if (query) {
            fetch(`/api/abductions/search?query=${query}`)
                .then(response => response.json())
                .then(data => {
                    displaySearchResults(data);
                })
                .catch(error => {
                    console.error("Error:", error);
                    searchResults.innerHTML = "<p>Failed to search abduction records</p>";
                });
        }
    });

    // Display search results
    function displaySearchResults(data) {
        searchResults.innerHTML = "";
        if (data.length > 0) {
            data.forEach(abduction => {
                const card = document.createElement("div");
                card.className = "card mb-3";
                card.innerHTML = `
                    <div class="card-body">
                        <h5 class="card-title">${abduction.name}</h5>
                        <p class="card-text">${abduction.details}</p>
                        <a href="/abductions/${abduction.id}" class="btn btn-primary">View Details</a>
                    </div>
                `;
                searchResults.appendChild(card);
            });
        } else {
            searchResults.innerHTML = "<p>No abduction records found</p>";
        }
    }

    // Fetch and display recent abductions
    fetch("/api/abductions/recent")
        .then(response => response.json())
        .then(data => {
            displayRecentAbductions(data);
        })
        .catch(error => {
            console.error("Error:", error);
            recentAbductions.innerHTML = "<p>Failed to load recent abductions</p>";
        });

    // Display recent abductions
    function displayRecentAbductions(data) {
        recentAbductions.innerHTML = "";
        if (data.length > 0) {
            data.forEach(abduction => {
                const card = document.createElement("div");
                card.className = "list-group-item list-group-item-action";
                card.innerHTML = `
                    <h5 class="mb-1">${abduction.name}</h5>
                    <p class="mb-1">${abduction.details}</p>
                    <a href="/abductions/${abduction.id}" class="btn btn-primary">View Details</a>
                `;
                recentAbductions.appendChild(card);
            });
        } else {
            recentAbductions.innerHTML = "<p>No recent abductions found</p>";
        }
    }

    // Handle abduction form submission
    abductionForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const formData = new FormData(abductionForm);
        fetch("/api/abductions/register", {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                alert(data);
                abductionForm.reset();
                $('#updateDatabaseModal').modal('hide');
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Failed to register abduction");
            });
    });
});
