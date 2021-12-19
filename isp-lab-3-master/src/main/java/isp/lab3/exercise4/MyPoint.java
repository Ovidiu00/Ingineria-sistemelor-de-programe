package isp.lab3.exercise4;

public class MyPoint {
    private  int x;
    private  int y;
    private  int z;

    public  MyPoint()
    {
        x = y = z = 0;
    }
    public  MyPoint(int x, int y , int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    public void SetXYZ(int x , int y , int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)",x,y,z);
    }

    public double distance(int x, int y , int z){
        return  Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x) + (z - this.z) * (z - this.z));
    }

    public double distance(MyPoint secondPont){
        return  Math.sqrt((secondPont.getY() - this.y) * (secondPont.getY() - this.y) + (secondPont.getX() - this.x) * (secondPont.getX() - this.x)
                + (secondPont.getZ() - this.z) * (secondPont.getZ() - this.z));
    }
}
