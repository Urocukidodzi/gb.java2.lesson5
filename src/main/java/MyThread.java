public class MyThread extends Thread{

    MyThread(float[] a){
        this.a = a;
    }

    private float[] a;

    public float[] getA() {
        return a;
    }

    @Override
    public void run() {
       a = morfing(a);
    }

    public  float[] morfing (float[] a){
        for (int i = 0;i<a.length;i++) {
            a[i] = (float)(a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return a;
    }
}
