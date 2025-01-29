

function def(x,...arg){
    var result = 0;
    if(arguments.length <=1)result = x;
    else{
        result = x
        for(var i = 0;i<arg.length;i++){
            console.log(`arguments ${i} is ${arguments[i]}`)
        }
    }
    return result
}