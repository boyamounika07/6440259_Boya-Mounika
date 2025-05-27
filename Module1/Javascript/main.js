    // 1. Introduction to JavaScript
    console.log("JavaScript Basics");
console.log("Welcome to the Community Portal");
    window.onload = function () {
      alert("Page is fully loaded!");
    };

    // 2. Syntax, Data Types, and Operators
    const eventName = "Local Music Fest";
    const eventDate = "2025-06-15";
    let availableSeats = 50;
    console.log(`Event: ${eventName} on ${eventDate}. Seats left: ${availableSeats}`);
    availableSeats--;
    console.log(`Seats after registration: ${availableSeats}`);

    // 3. Conditionals, Loops, Error Handling
    const events = [
      { name: "Music Fest", date: "2025-06-15", seats: 5, category: "Music" },
      { name: "Yoga Workshop", date: "2024-05-01", seats: 0, category: "Workshop" },
      { name: "Baking Workshop", date: "2025-08-10", seats: 3, category: "Workshop" }
    ];

    events.forEach(event => {
      const eventDate = new Date(event.date);
      const today = new Date();
      if (eventDate > today && event.seats > 0) {
        console.log(`Upcoming Event: ${event.name}`);
      } else {
        console.log(`Event not available: ${event.name}`);
      }
    });

    function registerUser(event) {
      try {
        if (event.seats <= 0) throw new Error("No seats available!");
        event.seats--;
        console.log(`Registered for ${event.name}`);
      } catch (err) {
        console.error(err.message);
      }
    }

    // 4. Functions, Scope, Closures, HOFs
    function addEvent(name, date, seats, category) {
      return { name, date, seats, category };
    }

    function filterEventsByCategory(events, category) {
      return events.filter(e => e.category === category);
    }

    function createCategoryTracker(category) {
      let count = 0;
      return function () {
        count++;
        console.log(`${count} registrations for ${category}`);
      };
    }
    const musicTracker = createCategoryTracker("Music");

    // 5. Objects and Prototypes
    function Event(name, date, seats) {
      this.name = name;
      this.date = date;
      this.seats = seats;
    }

    Event.prototype.checkAvailability = function () {
      return this.seats > 0;
    };

    const yoga = new Event("Yoga Class", "2025-07-01", 10);
    console.log(Object.entries(yoga));

    // 6. Arrays and Methods
    let communityEvents = [...events];
    communityEvents.push({ name: "Art Expo", category: "Exhibition", date: "2025-09-01", seats: 20 });

    const musicEvents = communityEvents.filter(e => e.category === "Music");
    const cards = communityEvents.map(e => `Event: ${e.name}`);
    console.log(cards);

    // 7. DOM Manipulation
    const container = document.querySelector("#eventContainer");
    communityEvents.forEach(event => {
      const card = document.createElement("div");
      card.textContent = `${event.name} - ${event.date} (${event.seats} seats)`;
      container.appendChild(card);
    });

    // 8. Event Handling
    document.querySelector("#registerBtn").onclick = function () {
      alert("Registered!");
    };

    document.querySelector("#categoryFilter").onchange = function (e) {
      const selected = e.target.value;
      const filtered = filterEventsByCategory(communityEvents, selected);
      console.log(`Filtered:`, filtered);
    };

    document.addEventListener("keydown", function (e) {
      if (e.key === "Enter") {
        console.log("Enter key pressed - initiate search...");
      }
    });

    // 9. Async JS, Promises, Async/Await
    function fetchEventsWithPromise() {
      return new Promise(resolve => {
        setTimeout(() => {
          resolve(communityEvents);
        }, 1000);
      });
    }

    fetchEventsWithPromise()
      .then(data => console.log("Promise events:", data))
      .catch(err => console.error(err));

    async function loadEvents() {
      document.getElementById("loading").style.display = "block";
      try {
        const data = await fetchEventsWithPromise();
        console.log("Async/await events:", data);
      } finally {
        document.getElementById("loading").style.display = "none";
      }
    }
    loadEvents();

    // 10. Modern JS Features
    const greetUser = (name = "Guest") => `Welcome, ${name}`;
    const { name: eventN, date: eventD } = yoga;
    const clonedEvents = [...communityEvents];

    // 11. Working with Forms
    document.querySelector("#registerForm").addEventListener("submit", function (e) {
      e.preventDefault();
      const name = this.elements["name"].value;
      const email = this.elements["email"].value;
      if (!name || !email) {
        document.querySelector("#error").textContent = "All fields required!";
      } else {
        document.querySelector("#error").textContent = "";
        console.log("Valid form:", { name, email });
      }
    });

    // 12. AJAX & Fetch API
    function postRegistration(data) {
      console.log("Sending data to mock server...");
      return new Promise(resolve => {
        setTimeout(() => {
          resolve({ success: true });
        }, 1500);
      });
    }

    postRegistration({ name: "Jane", email: "jane@example.com" })
      .then(res => alert("Registration submitted!"))
      .catch(err => alert("Submission failed!"));

    // 13. Debugging and Testing
    function debugFormSubmit() {
      console.log("Debugging form...");
      const testPayload = { name: "Test", email: "test@mail.com" };
      console.log("Payload:", testPayload);
    }
    debugFormSubmit();

    // 14. jQuery and JS Frameworks
    const script = document.createElement("script");
    script.src = "https://code.jquery.com/jquery-3.6.0.min.js";
    script.onload = function () {
      $('#registerBtn').click(function () {
        console.log("jQuery Registered!");
      });

      $('.event-card').fadeIn();

      setTimeout(() => $('.event-card').fadeOut(), 2000);
    };
    document.head.appendChild(script);

 