/**
 * 
 */
$(document).ready(function() {
	var imgList = document.getElementById("imgList");
	var imgArr = document.getElementsByTagName("img");
	imgList.style.width = 520 * imgArr.length + "px";
	console.log(imgArr.length);
	var navDiv = document.getElementById("navDiv");
	var outer = document.getElementById("outer");
	navDiv.style.left = (outer.offsetWidth - navDiv.offsetWidth) / 2 + "px";
	var index = 0;
	var allA = navDiv.getElementsByTagName("a");
	allA[index].style.backgroundColor = "black";
	for (var i = 0; i < allA.length; i++) {
		allA[i].num = i;
		allA[i].onclick = function() {
			clearInterval(timer);
			index = this.num;
			setA();
			move(imgList, "left", -520 * index, 60, function() {
				autoChange();
			});
		};
	};
	autoChange();
	function setA() {
		if (index >= imgArr.length - 1) {
			index = 0;
			imgList.style.left = 0;

		};
		for (var i = 0; i < allA.length; i++) {
			allA[i].style.backgroundColor = "";
		}
		allA[index].style.backgroundColor = "black";
	};
	var timer;
	function autoChange() {
		timer = setInterval(function() {
			index++;
			index = index % imgArr.length;
			move(imgList, "left", -520 * index, 30, function() {
				setA();
			});
		}, 3000);
	};
	function move(obj, attr, target, speed, callback) {
		clearInterval(obj.timer);
		var current = parseInt(getStyle(obj, attr));
		if (current > target) {
			speed = -speed;
		}
		obj.timer = setInterval(function() {
			var oldValue = parseInt(getStyle(obj, attr));
			var newValue = oldValue + speed;
			if (speed < 0 && newValue < target || speed > 0 && newValue > target) {
				newValue = target;
			}
			obj.style[attr] = newValue + "px";
			if (newValue === target) {
				clearInterval(obj.timer);
				callback && callback();
			}
		}, 30);
	}

	function getStyle(obj, name) {
		if (window.getComputedStyle) {
			return getComputedStyle(obj, null)[name];
		} else {
			return obj.currentStyle[name];
		}
	}
	
	
})