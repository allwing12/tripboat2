const editor = new toastui.Editor({
    el: document.querySelector("#editor"),
    height: "500px",
    initialEditType: "wysiwyg",
    placeholder: "내용을 입력해주세요",
    hooks: {
      addImageBlobHook: function (blob, callback) {
        const formData = new FormData();
        formData.append("image", blob);
        const imageURL = imageUpload(formData);
        console.log(imageURL);
        callback(imageURL, "image");
      },
    },
    language: 'ko-KR'