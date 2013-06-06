var $ = function  (id) {
  return document.getElementById(id);
};

var joinList = function () {

};

window.onload = function () {
	$("signIn").onclick = joinList;
	$("Email").focus();
};
