package ps6;
class ThreeDShape extends Shapes {
    double volume;

    protected void dispVolume() {
        System.out.println("Volume of the Shape is " + this.volume);
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.println("Volume of the Shape is " + this.volume);
    }
}