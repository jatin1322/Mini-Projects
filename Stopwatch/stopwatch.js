var min1 = 0;
var hour1 = 0;
var sec1 = 0;

var timer = false;

function start() {
    timer = true;
    stopwatch();
}
function stop1() {
    timer = false;
}
function reset() {
    timer = false;
    min1 = 0;
    hour1 = 0;
    sec1 = 0;
   
    document.getElementById("sec").innerHTML = "00";
  
    document.getElementById("min").innerHTML = "00";
    document.getElementById("hr").innerHTML = "00";
}
function stopwatch() {

    if (timer == true) {

       

        sec1=sec1+1;
        
        if (sec1 == 60) {
            min1=min1+1;
            sec1 = 0;
        }
        if (min1 == 60) {
            hour1=hour1+1;
            min1 = 0;
            sec1=0;
        }

       if(sec1<9){
        document.getElementById("sec").innerHTML = "0"+sec1;
       }
        document.getElementById("sec").innerHTML = sec1;
        
        document.getElementById("min").innerHTML = min1;
        document.getElementById("hr").innerHTML = hour1;
      
        setTimeout("stopwatch()",1000);
    }

}