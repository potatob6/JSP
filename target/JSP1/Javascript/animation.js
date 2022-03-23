/**Author: PB666 */
/**https://github.com/PotatoB6 */
setInterval(()=>{
    vh = document.documentElement.clientHeight
    vw = document.documentElement.clientWidth
},500)
var onLoadCallBack = (e)=>{ }
var onScrollCallBack = (e)=>{ }
var onResizeCallBack = (e)=>{ }
window.onload=(e)=>{
    scrollTop = document.documentElement.scrollTop;
    for(var i=0;i<scroll_KEYFRAME_anis.length;i++){
        scroll_KEYFRAME_anis[i].update(scroll_KEYFRAME_anis[i],scrollTop)
    }
    /*滚动页面动画*/
    window.onscroll = (e)=>{
        scrollTop = document.documentElement.scrollTop;
        for(var i=0;i<scroll_KEYFRAME_anis.length;i++){
            scroll_KEYFRAME_anis[i].update(scroll_KEYFRAME_anis[i],scrollTop)
        }
        onScrollCallBack(e)
    }
    var last = 0
    /*时间流逝动画*/
    var t = setInterval(()=>{
        var delta
        for(var i=0;i<timer_KEYFRAME_anis.length;i++){
            timer_KEYFRAME_anis[i].update(timer_KEYFRAME_anis[i],timer)
            if(timer_KEYFRAME_anis[i].KEYFRAMEs[timer_KEYFRAME_anis[i].KEYFRAMEs.length-1].r<timer){
                timer_KEYFRAME_anis.splice(i,1)
            }
        }
        if(last==0){
            last = new Date().valueOf()
            delta = 6.94
        }else{
            var l = new Date().valueOf()
            delta = l - last
            last = l
        }
        timer+=delta/1000
    },6.94)
    onLoadCallBack(e)
}
window.onresize=(e)=>{
    vh = document.documentElement.clientHeight
    vw = document.documentElement.clientWidth
    scrollTop = document.documentElement.scrollTop;
    for(var i=0;i<scroll_KEYFRAME_anis.length;i++){
        scroll_KEYFRAME_anis[i].update(scroll_KEYFRAME_anis[i],scrollTop)
    }
    console.log('change size:(%d,%d)',vw,vh);
    onResizeCallBack(e)
}
function lerp(a,amax,lerpA,lerpB){
    var t = a/amax
    return (1-t)*lerpA+t*lerpB
}
function clamp(a,min,max){
    return a<min?min:a>max?max:a
}
var timer = 0.0 //s
var scrollTop = 0
function lerpable(item){
    if(typeof(item)=='number'){
        return true
    }
    return false
}
var scroll_KEYFRAME_anis = []
var timer_KEYFRAME_anis = []

var vh = document.documentElement.clientHeight
var vw = document.documentElement.clientWidth
let _rem = vw / 16
console.log(_rem);
function create_LINEAR_ANIMATION(callback,pre='',suf='',keyframs){
    var obj = new Object
    obj.RATION = 0
    obj.KEYFRAMEs = keyframs
    obj.callback = callback
    obj.pre = pre
    obj.suf = suf
    obj.intervalI = 0
    obj.value = 0
    obj.element = null
    obj.get = (o,r)=>{
        var keys_new = new Array()
        for(var keys = 0;keys<o.KEYFRAMEs[0].y.length;keys++){
            if(o.KEYFRAMEs.length==1){
                o.intervalI = 0
                keys_new.push(o.KEYFRAMEs[0].y[keys])
                continue
            }
            if(r<o.KEYFRAMEs[0].r){
                o.intervalI = 0
                keys_new.push(o.KEYFRAMEs[0].y[keys])
                continue
            }
            if(r>=o.KEYFRAMEs[o.KEYFRAMEs.length-1].r){
                o.intervalI = o.KEYFRAMEs.length-1
                keys_new.push(o.KEYFRAMEs[o.KEYFRAMEs.length-1].y[keys])
                continue
            }
            var intervalI = -1
            for(var i = 0;i<o.KEYFRAMEs.length-1;i++){
                if(r>=o.KEYFRAMEs[i].r&&r<o.KEYFRAMEs[i+1].r){
                    intervalI = i
                    break
                }
            }
            o.intervalI = intervalI
            var b
            if(lerpable(o.KEYFRAMEs[intervalI].y[keys])){
                b = lerp(r-o.KEYFRAMEs[intervalI].r,
                    o.KEYFRAMEs[intervalI+1].r-o.KEYFRAMEs[intervalI].r,
                    o.KEYFRAMEs[intervalI].y[keys],
                    o.KEYFRAMEs[intervalI+1].y[keys]
                )
            }else{
                b = o.KEYFRAMEs[intervalI].y[keys]
            }
            keys_new.push(b)
        }
        // o.value = b
        return keys_new
    }
    obj.update = (o,r)=>{
        var a = new Array()
        var b=o.get(o,r)
        for(var i = 0;i<b.length;i++){
            a.push(pre+b[i]+suf)
        }
        o.callback(o.element,a,b,o)
    }
    return obj
}