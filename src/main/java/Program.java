public class Program {



    public static void main(String[] args) {

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0;i<arr.length;i++) {
            arr[i]=1;
        }

//        new Thread(new MyThread("первый поток")).start();
//        new Thread(new MyThread("второй поток")).start();


        /** 1 thread*/
        System.out.println("1 thread");
        long b = System.currentTimeMillis();
        MyThread single = new MyThread(arr);
        single.start();
        try {
            single.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - b);


        /** 2 threads*/
        System.out.println("2 thread");
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        MyThread multiThread1 = new MyThread(a1);
        MyThread multiThread2 = new MyThread(a2);
        multiThread1.start();
        multiThread2.start();
        try {
        multiThread1.join();
        multiThread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.arraycopy(multiThread1.getA(), 0, arr, 0, h);
        System.arraycopy(multiThread2.getA(), 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);


    }





}
