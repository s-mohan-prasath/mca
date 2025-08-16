class cc_ps3{
    public static void main(String[] args){
        LamportClock p1,p2,p3;
        p1 = new LamportClock(1);
        p2 = new LamportClock(2);
        p3 = new LamportClock(3);
        p1.sendMessage();
        p1.sendMessage();
        p1.sendMessage();
        p2.sendMessage();
        p3.sendMessage();
        p2.sendMessage();
        p2.sendMessage();
        // p2.receiveMessage(p1);
        System.out.println(p2.clock);
    }
}

class LamportClock{
    int clock;
    int pid;
    public LamportClock(int pid){
        this.pid = pid;
    }
    public void sendMessage(){
        this.clock++;
    }
    public void internalEvent(){
        this.clock++;
    }
    public void receiveMessage(LamportClock lc){
        clock = max(lc.clock,this.clock)+1;
    }
    public int max(int a,int b){
        return (a>b)?a:b;
    }
}