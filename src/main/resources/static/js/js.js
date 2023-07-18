document.querySelectorAll(".followed").forEach( elm => {
	elm.onclick = (evt)=> {
		// window.alert(evt.target.dataset.userId);
		if(elm.dataset.status==="not-follow") {
			const xhr = new XMLHttpRequest();
			xhr.open("post","/follow", false);
			// post는 body가 있는 요청. body에 담긴 내용의 종류를 설정해야 됨.
			xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			xhr.send("target=" +evt.target.dataset.userId );	// post는 send안에 body 설정을 해야 함.
			const response = JSON.parse(xhr.responseText);
			if(response.result) {
				document.querySelector(".follow").innerHTML = "팔로우취소";
				evt.target.classList.remove("follow");
				evt.target.classList.add("unfollow");
				evt.target.dataset.status="follow";
			}
		}else {
			const xhr = new XMLHttpRequest();
			xhr.open("delete","/follow?target="+evt.target.dataset.userId, false);
			xhr.send();
			const response = JSON.parse(xhr.responseText);
			if(response.result) {
				document.querySelector(".follow").innerHTML = "팔로우하기";
				evt.target.classList.remove("unfollow");
				evt.target.classList.add("follow");
				evt.target.dataset.status="not-follow";
			}
		}
	};
});

document.querySelectorAll(".followed").forEach( elm => {
	elm.onclick = (evt)=> {
		const xhr = new XMLHttpRequest();
		xhr.open("delete","/follow?target="+evt.target.dataset.userId, false);
		xhr.send();
		const response = JSON.parse(xhr.responseText);
		if(response.result) {
			evt.target.classList
		}
	};
});