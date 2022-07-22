setInterval(() => {
    d = new Date();
  var  htime = d.getHours();
  var mtime = d.getMinutes();
  var  stime = d.getSeconds();

    hrotation = 30 * htime + mtime / 2;
    mrotation = 6 * mtime;
    srotation = 6 * stime;
    var session = "AM";
    if (htime == 0) {
        htime = 12;
    }
    if (htime > 12) {
        htime = htime - 12;
        session = "PM"
    }
    if (htime < 10) {
        htime = "0" + htime;
    }
    if (mtime < 10) {
        mtime = "0" + mtime;
    }
    if (stime < 10) {
        stime = "0" + stime;
    }
    var time = " " + htime + ":" + mtime + ":" + stime + " " + session;
    document.getElementById("digital").innerText = time;
    document.getElementById("digital").textContent = time;
    hour.style.transform = `rotate(${hrotation}deg)`;
    minute.style.transform = `rotate(${mrotation}deg)`;
    second.style.transform = `rotate(${srotation}deg)`;
}, 1000);

