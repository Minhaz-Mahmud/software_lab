interface TV{
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}

class SmartTV implements TV{
    boolean powerOn=false;
    int volume=7;
    int channel=10;
    @Override
    public boolean isEnabled() {
        return powerOn;
    }
    @Override
    public void enable() {
        powerOn=true;
    }
    @Override
    public void disable() {
        powerOn=false;
    }
    @Override
    public int getVolume() {
        return volume;
    }
    @Override
    public void setVolume(int volume) {this.volume=volume;}
    @Override
    public int getChannel() {
        return channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
    public void Youtube(){
        System.out.println("SmartTv--->Youtube");
    }
}

class GeneralTV implements TV{
    boolean powerOn=false;
    int volume=7;
    int channel=10;
    @Override
    public boolean isEnabled() {
        return powerOn;
    }
    @Override
    public void enable() {
        powerOn=true;
    }
    @Override
    public void disable() {
        powerOn=false;
    }
    @Override
    public int getVolume() {
        return volume;
    }
    @Override
    public void setVolume(int volume) {
        this.volume=volume;
    }
    @Override
    public int getChannel() {
        return channel;
    }
    @Override
    public void setChannel(int channel) {
        this.channel=channel;
    }
}

class Remote{
    protected TV tv;
    Remote(){tv=null;}
    Remote(TV tv){
        this.tv=tv;
    }
    public void togglePower() {
        if(tv.isEnabled()){
            tv.disable();
            System.out.println("TV turned off");
        }
        else {
            tv.enable();
            System.out.println("TV turned on");
        }
    }
    public void volumeUp() {
        tv.setVolume(tv.getVolume()+1);
        System.out.println("Volume Up executed");
    }

    public void volumeDown() {
        tv.setVolume(tv.getVolume()-1);
        System.out.println("Volume Down executed");
    }

    public void channelUp() {
        tv.setChannel(tv.getVolume()+1);
        System.out.println("Channel Up executed");
    }

    public void channelDown() {
        tv.setChannel(tv.getVolume()-1);
        System.out.println("Channel Down Executed");
    }
}

class SmartRemote extends Remote{
    SmartRemote(){}
    SmartRemote(TV tv){
        super(tv);
    }
    void Youtube(){
        ((SmartTV)tv).Youtube();
    }
}
public class Main {
    public static void main(String[] args) {
        GeneralTV generalTV=new GeneralTV();
        SmartTV smartTV=new SmartTV();
        Remote remote= new Remote(generalTV);
        remote.togglePower();
        remote.channelUp();
        remote.channelDown();
        remote.volumeUp();
        remote.volumeDown();
        System.out.println(" ");

        SmartRemote smartRemote= new SmartRemote(smartTV);
        smartRemote.togglePower();
        smartRemote.channelUp();
        smartRemote.channelDown();
        smartRemote.volumeUp();
        smartRemote.volumeDown();
        smartRemote.Youtube();
    }
}