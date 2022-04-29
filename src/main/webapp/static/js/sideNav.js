function openNav() {
    if (window.innerWidth > 700) {
        document.getElementById("sideNav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
    } else {
        document.getElementById("sideNav").style.width = "100%";
        document.getElementById("sideNav").style.position = "relative";
        document.getElementById("main").style.marginLeft = "0";

    }
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("sideNav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
    document.body.style.backgroundColor = "white";
    document.getElementById("sideNav").style.position = "fixed";
}