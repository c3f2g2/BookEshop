window.onload = function (){
    window.alert("Welcome to Black Books, we are having special prices for your favourite books." +
        " Feel free to check the Featured books section");
}

window.onload = function() {
    var featuredBooks = document.getElementById('featured-books');
    featuredBooks.style.opacity = 1;
};

console.log("Hello, Nostr!");

function askQuestion() {
    var question = document.getElementById('question').value;
    fetch('/ask', {
        method: 'POST',
        body: JSON.stringify(question),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById('response').innerText = data;
        })
        .catch(error => console.error('Error:', error));
}
