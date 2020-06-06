function loadBook() {
    let content=document.querySelector("div")

    $.get("http://localhost:3000/api/books",function (data) {
        content.innerHTML=''
        for (let i=0;i<data.length;i++){
            let item=`<h1>${data[i].title}</h1>`
            content.insertAdjacentHTML("beforeend",item)

        }
    })


}
