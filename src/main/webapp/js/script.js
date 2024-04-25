/**
 * 
 */

var coll = document.getElementsByClassName("note");

var i;

for (i = 0; i < coll.length; i++) {
	coll[i].addEventListener("click", function() {
		this.classList.toggle("active");
		var content = this.nextElementSibling;
		if (content.style.maxHeight) {
			content.style.maxHeight = null;
		} else {
			content.style.maxHeight = content.scrollHeight + "px";
			element.style.Height = content.scrollHeight + "px";

		}
	});
}

function cadastroPoupanca() {
	alert('a');
}

function cadastroEspecial() {
	alert('a');
}